package com.inti.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.inti.model.Entreprise;
import com.inti.repository.IEntrepriseRepository;

@WebMvcTest(controllers = EntrepriseController.class)
public class EntrepriseControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IEntrepriseRepository ier;
	
	@Test
	public void readEntrepriseTest() {
		try {
			mockMvc.perform(get("/entreprise/read"))
				.andExpect(status().isOk())
				.andExpect(view().name("readEntreprise"))
				.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void createEntrepriseTest() {
		try {
			mockMvc.perform(get("/entreprise/create"))
				.andExpect(status().isOk())
				.andExpect(view().name("createEntreprise"))
				.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void saveEntrepriseTest() {
		try {
			mockMvc.perform(post("/entreprise/create").sessionAttr("entreprise", new Entreprise("Enterpise", "village")))
					.andExpect(status().is3xxRedirection())
					.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateEntrepriseTest() {
		try {
			mockMvc.perform(get("/entreprise/update/1"))
				.andExpect(status().isOk())
				.andExpect(view().name("updateEntreprise"))
				.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteEntrepriseTest() {
		try {
			mockMvc.perform(get("/entreprise/delete/1"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/entreprise/read"))
				.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
