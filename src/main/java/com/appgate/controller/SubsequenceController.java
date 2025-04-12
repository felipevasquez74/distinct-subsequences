package com.appgate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.dto.ApiResponse;
import com.appgate.service.ISubsequenceCounterService;

@RestController
@RequestMapping("/api/subsequence")
public class SubsequenceController {

	private final ISubsequenceCounterService service;

	public SubsequenceController(ISubsequenceCounterService service) {
		this.service = service;
	}

	@GetMapping("/count")
	public ApiResponse<Integer> countSubsequencesFromParams(@RequestParam String source, @RequestParam String target) {
		try {
			int result = service.countDistinctSubsequences(source, target);
			return new ApiResponse<>("success", "Subsequences counted successfully", result);
		} catch (IllegalArgumentException ex) {
			return new ApiResponse<>("error", ex.getMessage());
		}
	}
}