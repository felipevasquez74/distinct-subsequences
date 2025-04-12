package com.appgate.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.appgate.model.SubsequenceRequest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SubsequenceControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void countSubsequences_ShouldReturn200_WhenValidRequest() {
		SubsequenceRequest request = new SubsequenceRequest("rabbbit", "rabbit");

		ResponseEntity<String> response = restTemplate.postForEntity("/api/v1/subsequence/count", request,
				String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void countSubsequences_ShouldReturn400_WhenInvalidRequest() {
		SubsequenceRequest invalidRequest = new SubsequenceRequest(null, "bag");

		ResponseEntity<String> response = restTemplate.postForEntity("/api/v1/subsequence/count", invalidRequest,
				String.class);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
}