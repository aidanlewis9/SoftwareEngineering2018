package edu.nd.se2018.homework.hwk1;

public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
		int maxMirrorCount = 0;

		// loop through every subarray of numbers
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j <= numbers.length; j++) {
			    int mirrorCount = 0;

			    for (int k = i; k < j; k++) {
			        if (numbers[k] == numbers[numbers.length - 1 - k]) {
			            mirrorCount += 1;
                    } else { // if not symmetric
			            break;
                    }
                }

                // if greater mirror count than previous max
				if (mirrorCount > maxMirrorCount) {
				    maxMirrorCount = mirrorCount;
                }
			}
		}

		return maxMirrorCount;
	}
}
