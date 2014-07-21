package main.java.com.sebastientessot.sorting;

public class InsertionSort implements SortingAlgorithm {

	@Override
	public void sort(int[] input) {
		if(input == null || input.length <= 1) {
			return;
		}
		
		for(int i = 1; i < input.length; i++) {
			int key = input[i];
			
			int focus = i-1;
			while(focus >= 0 && key < input[focus]) {
				input[focus+1] = input[focus];
				input[focus] = key;
				focus--;
			}
		}
	}

	@Override
	public void sortDecreasing(int[] input) {
		if(input == null || input.length <= 1) {
			return;
		}
		
		for(int i = 1; i < input.length; i++) {
			int key = input[i];
			
			int focus = i-1;
			while(focus >= 0 && key > input[focus]) {
				input[focus+1] = input[focus];
				input[focus] = key;
				focus--;
			}
		}
	}

}
