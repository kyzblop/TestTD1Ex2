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
import org.springframework.web.bind.annotation.RequestParam;

import com.inti.model.Salarie;
import com.inti.repository.ISalarieRepository;

@Controller
@RequestMapping("salarie")
public class SalarieController {

	@Autowired
	ISalarieRepository isr;
	
	@GetMapping("create")
	public String createForm() {
		return "createSalarie";
	}
	@PostMapping("create")
	public String create(@ModelAttribute("salarie") Salarie s) {
		isr.save(s);
		return "redirect:/salarie/create";
	}
	
	@GetMapping("read")
	public String readForm(Model m) {
		List<Salarie> listeS = isr.findAll();
		m.addAttribute("listeS", listeS);
		return "readSalarie";
	}
	
	@GetMapping("update/{id}")
	public String updateForm(@PathVariable int id, Model m) {
		m.addAttribute("salarie", isr.getReferenceById(id));
		return "updateSalarie";
	}
	@PostMapping("update")
	public String update(@ModelAttribute("sal") Salarie s) {
		isr.save(s);
		return "redirect:/salarie/read";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable int id) {
		isr.delete(isr.getReferenceById(id));
		return "redirect:/salarie/read";
	}
}
