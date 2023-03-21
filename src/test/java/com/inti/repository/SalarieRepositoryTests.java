package com.inti.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inti.model.Salarie;

@ExtendWith(SpringExtension.class) // etendre les proprietes de junit à spring
@DataJpaTest // annuler les requetes apres utilisation
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // config une BDD
public class SalarieRepositoryTests {

	@Autowired
	ISalarieRepository isr;

	Salarie s;

	@BeforeEach
	public void setUp() {
		s = new Salarie("Martin", "Michel", "email.com");
	}

	@Test
	public void saveTest() {
		// Given

		// When
		Salarie savedSalarie = isr.save(s);
		// Then
		assertThat(savedSalarie).isNotNull();
		assertThat(savedSalarie.getId()).isGreaterThan(0);
	}

	@Test
	public void getSalarieTest() {
		// Given
		Salarie savedSalarie = isr.save(s);
		// When
		Salarie s2 = isr.getReferenceById(savedSalarie.getId());
		// Then
		assertThat(s2).isNotNull();
		assertThat(s2.getId()).isEqualTo(savedSalarie.getId());
		assertThat(s2.getNom()).isEqualTo(savedSalarie.getNom());
		assertThat(s2.getPrenom()).isEqualTo("Michel");
		assertThat(s2.getEmail()).isEqualTo(savedSalarie.getEmail());
		assertThat(s2).isEqualTo(savedSalarie); // on peut juste faire cette ligne
	}

	@Test
	public void getAllSalarie() {
		// Given
		Salarie savedSalarie = isr.save(s);
		Salarie s3 = isr.save(new Salarie("Papin", "Marie", "test@test.fr")); 
		Salarie s4 = isr.save(new Salarie("Dupont", "Sophie", "test@test.fr")); 
		// When
		List<Salarie> listeS = isr.findAll();
		
		// Then
		assertThat(listeS).isNotEmpty();
		assertThat(listeS).hasSize(4);
		assertThat(listeS.get(0).getClass()).hasSameClassAs(Salarie.class);
		assertThat(listeS.get(2).toString()).hasToString(s3.toString());
	}

	@Test
	public void updateTest() {
		// Given
		Salarie savedSalarie = isr.save(s);
//		Salarie s1 = new Salarie(savedSalarie.getId(), "Martin", "Mickael", "email.com");
		// When
//		Salarie s2 = isr.save(s1);

		savedSalarie.setNom("Durand");
		savedSalarie.setPrenom("Jean");
		savedSalarie.setEmail("info@info.fr");
		Salarie salarieModif = isr.save(savedSalarie);

		// Then
//		assertThat(s2).isNotNull();
//		assertThat(s2.getId()).isEqualTo(savedSalarie.getId());

		assertThat(salarieModif).isNotNull();
		assertThat(salarieModif.getNom()).isEqualTo("Durand");
		assertThat(salarieModif.getPrenom()).isEqualTo("Jean");
		assertThat(salarieModif.getEmail()).isEqualTo("info@info.fr");
	}

	@Test
	public void deleteTest() {
		// Given
		Salarie savedSalarie = isr.save(s);
		// When
		isr.deleteById(savedSalarie.getId());
		// Then
		Assertions.assertThrows(Exception.class, () -> isr.getReferenceById(savedSalarie.getId()));
	}
	
	@Test
	public void getSalarieByNom() {
		// Given
		Salarie s3 = isr.save(new Salarie("Papin", "Marie", "test@test.fr")); 
		Salarie s4 = isr.save(new Salarie("Papin", "Sophie", "test@test.fr"));
		
		// When
		List<Salarie> listeS = isr.findByNom("Papin");
		// Then
		assertThat(listeS).isNotEmpty();
		assertThat(listeS.get(0).getNom()).isEqualTo("Papin");
		assertThat(listeS.get(1).getNom()).isEqualTo("Papin");
	}
}
