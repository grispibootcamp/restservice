package com.grispi.bootcamp.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void mathTest() throws Exception {
		int x = 5;
		int y = 8;

		int sum = x+y;

		//assertTrue(sum==12);

		assertEquals(13, sum);
	}


	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc
				.perform(get("/").param("xyz", "zaaa"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World: zaaa"));
	}

	@Test
	public void shouldRemoveEmptySpaces() throws Exception {
		this.mockMvc
				.perform(get("/").param("xyz", "this is a sentence with empty spaces"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World: thisisasentencewithemptyspaces"));
	}

	@Test
	public void shouldRemoveMultipleEmptySpaces() throws Exception {
		this.mockMvc
				.perform(get("/").param("xyz", "this          is a      sentence           with empty       spaces"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World: thisisasentencewithemptyspaces"));
	}

	@Test
	public void shouldLowercase() throws Exception {
		this.mockMvc
				.perform(get("/").param("xyz", "UPPERCASE"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World: uppercase"));
	}

	@Test
	public void shouldRemoveEmptySpacesAndConvertToLowercase() throws Exception {
		this.mockMvc
				.perform(get("/").param("xyz", "This          is a      SenTence           WiTH EMPTY       spaces"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World: thisisasentencewithemptyspaces"));
	}

	@Test
	public void checkTurkishCharacters() throws Exception {
		this.mockMvc
				.perform(get("/").param("xyz", "DÜNYA ÇOK GÜZEL DEĞİL Mİ"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World: dünyaçokgüzeldeği̇lmi̇"));
	}


	@Test
	public void shouldReturnBadRequest() throws Exception {
		this.mockMvc
				.perform(get("/"))
				.andDo(print())
				.andExpect(status().isBadRequest());
	}

}