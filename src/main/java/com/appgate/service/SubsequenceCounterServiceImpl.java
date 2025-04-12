package com.appgate.service;

import org.springframework.stereotype.Service;

/**
 * Service for counting the number of distinct subsequences in a given source
 * string that equals a target string.
 */
@Service
public class SubsequenceCounterServiceImpl implements ISubsequenceCounterService {

	public int countDistinctSubsequences(String source, String target) {
		validateInput(source, target);

		int sourceLength = source.length();
		int targetLength = target.length();

		if (targetLength > sourceLength) {
			return 0;
		}

		int[][] subsequenceCounts = new int[sourceLength + 1][targetLength + 1];

		for (int sourceIndex = 0; sourceIndex <= sourceLength; sourceIndex++) {
			subsequenceCounts[sourceIndex][0] = 1;
		}

		for (int sourceIndex = 1; sourceIndex <= sourceLength; sourceIndex++) {
			for (int targetIndex = 1; targetIndex <= targetLength; targetIndex++) {
				if (source.charAt(sourceIndex - 1) == target.charAt(targetIndex - 1)) {
					subsequenceCounts[sourceIndex][targetIndex] = subsequenceCounts[sourceIndex - 1][targetIndex - 1]
							+ subsequenceCounts[sourceIndex - 1][targetIndex];
				} else {
					subsequenceCounts[sourceIndex][targetIndex] = subsequenceCounts[sourceIndex - 1][targetIndex];
				}
			}
		}

		return subsequenceCounts[sourceLength][targetLength];
	}

	private void validateInput(String source, String target) {
		if (source == null || target == null) {
			throw new IllegalArgumentException("Source and target strings must not be null.");
		}
	}
}