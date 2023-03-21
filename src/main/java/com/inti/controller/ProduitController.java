package com.inti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.inti.repository.IProduitRepository;
// truc
@Controller
public class ProduitController {
	
	@Autowired
	IProduitRepository ipr;
	
	@GetMapping("products")
	public String getAllProduct(Model m) {
		m.addAttribute("listeP", ipr.findAll());
		return "products";
	}

}
