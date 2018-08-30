package edu.nd.se2018.homework.hwk1;

import java.util.*;

public class Question2 {
	private static final String DELIMITER = " ";

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		final Map<String, Integer> wordCounts = new HashMap<>();
		final Set<String> stopWordsSet = new HashSet<>(Arrays.asList(stopwords.split(DELIMITER)));
		final List<String> inputSet = new ArrayList<>(Arrays.asList(input.split(DELIMITER)));
		inputSet.removeAll(stopWordsSet); // remove any stop words from input

		// get word counts
		for (final String word : inputSet) {
			final int count = (wordCounts.containsKey(word)) ? wordCounts.get(word) + 1 : 1;
			wordCounts.put(word, count);
		}

		int maxCount = 0;
		String maxWord = null;

		// find word with max word count
		for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
			if (entry.getValue() > maxCount) {
				maxWord = entry.getKey();
				maxCount = entry.getValue();
			} else if (entry.getValue() == maxCount) {
				maxWord = null;
			}
		}

		return maxWord;
	}
}
