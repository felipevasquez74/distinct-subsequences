package com.appgate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appgate.service.ISubsequenceCounterService;

@RestController
@RequestMapping("/api/subsequence")
public class SubsequenceController {

	@Autowired
	private ISubsequenceCounterService iSubsequenceCounterService;

	@GetMapping("/count")
	public int countSubsequencesFromParams(@RequestParam String source, @RequestParam String target) {
		return iSubsequenceCounterService.countDistinctSubsequences(source, target);
	}
}