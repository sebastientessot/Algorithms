package main.java.com.sebastientessot.sorting;


public class MergeSort implements SortingAlgorithm {

	private void mergeSort(int[] array, int low, int high) {
		if(low < high) {
			int splitIndex = (low + high) / 2;
			mergeSort(array, low, splitIndex);
			mergeSort(array, splitIndex+1, high);
			merge(array, low, splitIndex, high);
		}
	}
	
	private void merge(int[] array, int low, int splitIndex, int high) {
		int leftSize = splitIndex - low + 1;
		int rightSize = high - splitIndex;
		int[] leftArray = new int[leftSize + 1];
		int[] rightArray = new int[rightSize + 1];
		
		leftArray[leftSize] = Integer.MAX_VALUE;
		rightArray[rightSize] = Integer.MAX_VALUE;
		
		// Copy Arrays
		for(int i = 0; i<leftSize; i++) {
			leftArray[i] = array[low+i];
		} 
		for(int i = 0; i<rightSize; i++) {
			rightArray[i] = array[splitIndex+i];
		}
		
		// Merge
		int leftIndex = 0;
		int rightIndex = 0;
		for(int i = low; i<=high; i++) {
			if(leftArray[leftIndex] <= rightArray[rightIndex]) {
				array[i] = leftArray[leftIndex];
				leftIndex++;
			} else {
				array[i] = rightArray[rightIndex];
				rightIndex++;
			}
		}
	}

	@Override
	public void sort(int[] input) {
		if(input == null || input.length <= 1) {
			return;
		}
		
		mergeSort(input, 0, input.length - 1);
	}

	@Override
	public void sortDecreasing(int[] input) {
		if(input == null || input.length <= 1) {
			return;
		}
		
		// TODO to implement
	}

}
