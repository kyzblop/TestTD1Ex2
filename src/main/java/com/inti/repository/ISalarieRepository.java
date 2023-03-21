package com.inti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Salarie;

@Repository
public interface ISalarieRepository extends JpaRepository<Salarie, Integer> {

	List<Salarie> findByNom(String nom);
}
