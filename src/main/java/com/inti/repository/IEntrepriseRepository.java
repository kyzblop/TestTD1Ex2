package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.model.Entreprise;

@Repository
public interface IEntrepriseRepository extends JpaRepository<Entreprise, Integer> {

}
