package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inti.model.Entreprise;
import com.inti.repository.IEntrepriseRepository;

@Controller
@RequestMapping("entreprise")
public class EntrepriseController {

	@Autowired
	IEntrepriseRepository ier;
	
	@GetMapping("create")
	public String createForm() {
		return "createEntreprise";
	}
	@PostMapping("create")
	public String create(@ModelAttribute("entreprise") Entreprise e) {
		ier.save(e);
		return "redirect:/entreprise/create";
	}
	 
	@GetMapping("read")
	public String readForm(Model m) {
		List<Entreprise> listeE = ier.findAll();
		m.addAttribute("listeE", listeE);
		return "readEntreprise";
	}
	
	@GetMapping("update/{id}")
	public String updateForm(@PathVariable int id, Model m) {
		m.addAttribute("entreprise", ier.getReferenceById(id));
		return "updateEntreprise";
	}
	@PostMapping("update")
	public String update(@ModelAttribute("ent") Entreprise e) {
		ier.save(e);
		return "redirect:/entreprise/read";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		ier.delete(ier.getReferenceById(id));
		return "redirect:/entreprise/read";
	}
}
