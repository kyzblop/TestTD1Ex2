package com.inti.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.inti.repository.IProduitRepository;

@WebMvcTest(ProduitController.class)
public class ProduitControllerTest {

	@Autowired
	private MockMvc mock;
	
	@MockBean
	private  IProduitRepository ipr;
	
	@Test
	public void allProducts() {
		try {
			mock.perform(get("/products"))
				.andExpect(status().isOk())
				.andExpect(view().name("products"))
//				.andExpect(content().string(containsString("Produit")))
				.andDo(print());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
