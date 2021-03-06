package com.example.rmispringbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTestsWithAutowiredMvcMock {

	@Autowired
	private MockMvc mockMvc;

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
