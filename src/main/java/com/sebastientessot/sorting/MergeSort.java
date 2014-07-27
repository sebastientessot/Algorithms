package main.java.com.sebastientessot.sorting;

public class MergeSort implements SortingAlgorithm {

	private void mergeSort(int[] array, int low, int high, boolean asc) {
		if (low < high) {
			int splitIndex = (low + high) / 2;
			mergeSort(array, low, splitIndex, asc);
			mergeSort(array, splitIndex + 1, high, asc);
			merge(array, low, splitIndex, high, asc);
		}
	}

	private void merge(int[] array, int low, int splitIndex, int high,
			boolean asc) {
		int leftSize = splitIndex - low + 1;
		int rightSize = high - splitIndex;
		int[] leftArray = new int[leftSize];
		int[] rightArray = new int[rightSize];

		// Copy Arrays
		for (int i = 0; i < leftSize; i++) {
			leftArray[i] = array[low + i];
		}
		for (int i = 0; i < rightSize; i++) {
			rightArray[i] = array[splitIndex + 1 + i];
		}

		// Merge
		int leftIndex = 0;
		int rightIndex = 0;
		if (asc) {
			for (int i = low; i <= high; i++) {
				if (leftIndex != leftSize
						&& (rightIndex == rightSize || leftArray[leftIndex] <= rightArray[rightIndex])) {
					array[i] = leftArray[leftIndex];
					leftIndex++;
				} else {
					array[i] = rightArray[rightIndex];
					rightIndex++;
				}
			}
		} else {
			for (int i = low; i <= high; i++) {
				if (leftIndex != leftSize
						&& (rightIndex == rightSize || leftArray[leftIndex] >= rightArray[rightIndex])) {
					array[i] = leftArray[leftIndex];
					leftIndex++;
				} else {
					array[i] = rightArray[rightIndex];
					rightIndex++;
				}
			}
		}
	}

	@Override
	public void sort(int[] input) {
		if (input == null || input.length <= 1) {
			return;
		}

		mergeSort(input, 0, input.length - 1, true);
	}

	@Override
	public void sortDecreasing(int[] input) {
		if (input == null || input.length <= 1) {
			return;
		}

		mergeSort(input, 0, input.length - 1, false);
	}

}
