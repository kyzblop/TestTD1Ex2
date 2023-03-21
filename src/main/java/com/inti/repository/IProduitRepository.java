package com.inti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.model.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Integer> {

}
