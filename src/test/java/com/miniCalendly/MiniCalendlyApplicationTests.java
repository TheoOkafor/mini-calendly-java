package com.miniCalendly;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MiniCalendlyApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldFetchAllUsers() throws Exception {
		this.mockMvc.perform(get("/users")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldFetchFirstUser() throws Exception {
		this.mockMvc.perform(get("/users/1")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldNotFetch100thUser() throws Exception {
		this.mockMvc.perform(get("/users/100")).andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	public void shouldFetchAllOpenings() throws Exception {
		this.mockMvc.perform(get("/openings")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldFetchFirstOpening() throws Exception {
		this.mockMvc.perform(get("/openings/4")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void shouldNotFetch100thOpening() throws Exception {
		this.mockMvc.perform(get("/openings/100")).andDo(print()).andExpect(status().isNotFound());
	}
}
