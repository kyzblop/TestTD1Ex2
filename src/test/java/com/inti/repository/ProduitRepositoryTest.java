package com.inti.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.inti.model.Produit;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProduitRepositoryTest {

	@Autowired
	IProduitRepository ipr;
	
	Produit p, p1;
	
	@BeforeEach
	public void setUp() {
		p = new Produit("Samsung", "S23", 1099, 1.2);
		
	}
	
	@Test
	public void saveTest() {
		// Given
		
		// When
		Produit savedProduct = ipr.save(p);
		
		// Then
		assertThat(savedProduct).isNotNull();
		assertThat(savedProduct.getId()).isGreaterThan(0);
		assertThat(savedProduct.getNom()).isEqualTo("Samsung");
	}
	
	@Test
	public void delete() {
		// Given (deja dans le setUp)
		Produit p2 = ipr.save(p);
		 
		// When
		ipr.deleteById(p2.getId());
		
		// Then
		Assertions.assertThrows(Exception.class, () -> ipr.getReferenceById(p2.getId()));

	}
}
