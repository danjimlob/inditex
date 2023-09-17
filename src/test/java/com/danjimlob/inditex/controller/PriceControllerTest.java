package com.danjimlob.inditex.controller;

import static org.assertj.core.api.Assertions.assertThat;
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

import com.danjimlob.inditex.controller.PriceController;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

	@Autowired
	private PriceController controller;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	public void tenTest() throws Exception {
		this.mockMvc.perform(get("/prices/1/35455/2020-06-14T10:00:00")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("35.50")));
	}

	@Test
	public void sixteenTest() throws Exception {
		this.mockMvc.perform(get("/prices/1/35455/2020-06-14T16:00:00")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("25.45")));
	}

	@Test
	public void twentyOneTest() throws Exception {
		this.mockMvc.perform(get("/prices/1/35455/2020-06-14T21:00:00")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("35.50")));
	}

	@Test
	public void tenOnFifteenTest() throws Exception {
		this.mockMvc.perform(get("/prices/1/35455/2020-06-15T10:00:00")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("30.50")));
	}

	@Test
	public void twentyOneOnSixteenTest() throws Exception {
		this.mockMvc.perform(get("/prices/1/35455/2020-06-15T21:00:00")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("38.95")));
	}

}
