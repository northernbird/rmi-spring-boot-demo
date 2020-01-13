package com.example.rmispringbootdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
class ApplicationTestsWithoutAutowiredMvcMock {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	/**
	 * Initialize the components used in test.
	 */
	@BeforeEach
	public void init() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.apply(SecurityMockMvcConfigurers.springSecurity())
				.build();
	}

	@Test
	public void shouldMatchServletPath() throws Exception {
		this.mockMvc.perform(get("/api/servletpath").servletPath("/api/servletpath")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello CustomGenericFilter World")));
	}

	@Test
	public void shouldSkipFilterForEmptyServletPath() throws Exception {
		this.mockMvc.perform(get("/api/servletpath")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello RestController World")));
	}
}
