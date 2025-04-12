package com.appgate;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import com.appgate.service.ISubsequenceCounterService;
import com.appgate.service.SubsequenceCounterServiceImpl;

class LoadTest {

	@Test
	void testLoad() throws InterruptedException {
		ISubsequenceCounterService service = new SubsequenceCounterServiceImpl();

		int numberOfThreads = 50;
		int requestsPerThread = 1000;

		ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
		List<Future<Integer>> futures = new ArrayList<>();

		long startTime = System.currentTimeMillis();

		for (int i = 0; i < numberOfThreads; i++) {
			futures.add(executorService.submit(() -> {
				int localCount = 0;
				for (int j = 0; j < requestsPerThread; j++) {
					int result = service.countDistinctSubsequences("babgbag", "bag");
					localCount += result;
				}
				return localCount;
			}));
		}

		int total = 0;
		for (Future<Integer> future : futures) {
			try {
				total += future.get();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);

		long endTime = System.currentTimeMillis();
		long duration = endTime - startTime;

		System.out.println("Total requests processed: " + (numberOfThreads * requestsPerThread));
		System.out.println("Total successful results: " + total);
		System.out.println("Total time: " + duration + " ms");
		System.out.println("Throughput: " + ((numberOfThreads * requestsPerThread * 1000L) / duration) + " ops/sec");

		assertTrue(total > 0, "Total successful results should be greater than 0.");
		assertTrue(duration < 5000, "The load test should complete within 5000ms.");
	}
}