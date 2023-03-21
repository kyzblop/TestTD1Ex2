package com.inti.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.inti.model.Salarie;
import com.inti.repository.ISalarieRepository;

@WebMvcTest(controllers = SalarieController.class)
public class SalarieControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ISalarieRepository isr;
	
	@Test
	public void getAllSalarieTest() {
		try {
			mockMvc.perform(get("/salarie/read"))
				.andExpect(status().isOk())
				.andExpect(view().name("readSalarie"))
//			.andExpect(forwardedUrl("WEB-INF/jsp/salarie.jsp"))
//			.andExpect(content().string(containsString("Email")));
				.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("Test d'inscription d'un salarie")
	public void createSalarieTest() {
		try {
			mockMvc.perform(get("/salarie/create"))
				.andExpect(status().isOk())
				.andExpect(view().name("createSalarie"))
				.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("Test d'enregistrement d'un salarie")
	public void enregistrementSalarieTest() {
		try {
			mockMvc.perform(post("/salarie/create").sessionAttr("salarie", new Salarie("Dupont", "jean", "mail")))
				.andExpect(status().is3xxRedirection())
				.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateSalarieTest() {
		try {
			mockMvc.perform(get("/salarie/update/1"))
				.andExpect(status().isOk())
				.andExpect(view().name("updateSalarie"))
				.andDo(print());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteSalarieTest() {
		try {
			mockMvc.perform(get("/salarie/delete/1"))
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/salarie/read"))
				.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
