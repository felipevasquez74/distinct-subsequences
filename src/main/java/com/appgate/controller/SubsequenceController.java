package com.appgate.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.dto.ApiResponse;
import com.appgate.model.SubsequenceRequest;
import com.appgate.service.ISubsequenceCounterService;
import com.appgate.util.MDCLoggingFilter;
import com.appgate.util.ResponseBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/subsequence")
@Slf4j
@Tag(name = "Subsequence Analyzer", description = "API for analyzing distinct subsequences")
@Validated
public class SubsequenceController {

	private final ISubsequenceCounterService service;

	public SubsequenceController(ISubsequenceCounterService service) {
		this.service = service;
	}

	@PostMapping("/count")
	@Operation(summary = "Count distinct subsequences", description = "Calculates the number of distinct subsequences of 'source' that equal 'target'.")
	public ResponseEntity<ApiResponse<Map<String, Integer>>> countSubsequences(
			@Valid @RequestBody SubsequenceRequest request, HttpServletRequest httpRequest) {

		MDCLoggingFilter.builderMDC();
		log.info("Request received for subsequence counting: {}", request);

		int count = service.countDistinctSubsequences(request.getSource(), request.getTarget());
		Map<String, Integer> data = Map.of("subsequenceCount", count);

		return ResponseEntity.ok(
				ResponseBuilder.buildResponse(data, "Subsequences counted successfully", HttpStatus.OK, httpRequest));
	}
}