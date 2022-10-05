package com.example.wordfrequency;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WordFrequencyApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Hello, Hello")));
	}

	@Test
	public void postMessage() throws Exception {
		String text = "the bat is in the bag";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("the",2);
		jsonObject.put("in",1);
		jsonObject.put("bat",1);
		jsonObject.put("is",1);
		this.mockMvc.perform(post("/run").content(text)).
				andDo(print()).andExpect(status().isOk())
				.andExpect(content().json(jsonObject.toString()));
	}
}
