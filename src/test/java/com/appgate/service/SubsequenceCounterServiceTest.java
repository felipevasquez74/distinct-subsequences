package com.appgate.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SubsequenceCounterServiceTest {

	private ISubsequenceCounterService service = new SubsequenceCounterServiceImpl();

	@Test
	void testExample1() {
		assertEquals(3, service.countDistinctSubsequences("rabbbit", "rabbit"));
	}

	@Test
	void testExample2() {
		assertEquals(5, service.countDistinctSubsequences("babgbag", "bag"));
	}

	@Test
	void testEmptyTarget() {
		assertEquals(1, service.countDistinctSubsequences("anystring", ""));
	}

	@Test
	void testEmptySource() {
		assertEquals(0, service.countDistinctSubsequences("", "nonempty"));
	}

	@Test
	void testSourceShorterThanTarget() {
		assertEquals(0, service.countDistinctSubsequences("abc", "abcd"));
	}

	@Test
	void testIdenticalStrings() {
		assertEquals(1, service.countDistinctSubsequences("abc", "abc"));
	}

	@Test
	void testNullInput() {
		assertThrows(IllegalArgumentException.class, () -> service.countDistinctSubsequences(null, "abc"));
		assertThrows(IllegalArgumentException.class, () -> service.countDistinctSubsequences("abc", null));
	}
}