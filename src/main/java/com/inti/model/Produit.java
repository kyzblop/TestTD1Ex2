package com.inti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity @Table
@Entity @Table
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String ref;
	private double prix;
	private double poids;
	
	public Produit(String nom, String ref, double prix, double poids) {
		super();
		this.nom = nom;
		this.ref = ref;
		this.prix = prix;
		this.poids = poids;
	}
	
	
}
