package edu.nd.se2018.homework.hwk1;

import java.util.*;

public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		final Set<Integer> usedNumbers = new HashSet<>();
		int sum = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (!usedNumbers.contains(numbers[i])) { // if not a duplicate
				sum += numbers[i];
				usedNumbers.add(numbers[i]);
			}
		}

		return sum;
	}
}
