package com.example.postgres_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
class PostgresDemoApplicationTests {
	@Autowired
    private MockMvc mockMvc;


	@Test
	void contextLoads() {
	}

	@Test 
	void helloEndpointReturnsMessage() throws Exception {
		mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(content().string("Hello, World!"));
	}

	@Test 
	void invalidStudentDataReturnsBadRequest() throws Exception {
		mockMvc.perform(post("/students")
			.contentType(MediaType.APPLICATION_JSON)
			.content("{\"id\": 10, \"name\": \"\", \"email\": \"invalid-email\"}"))
			.andExpect(status().isBadRequest())
			.andExpect(jsonPath("$.name").value("Name is required"))
			.andExpect(jsonPath("$.email").value("Email should be valid"));
	}
}
