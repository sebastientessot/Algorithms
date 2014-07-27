package test.java.com.sebastientessot.sorting;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Random;

import main.java.com.sebastientessot.sorting.InsertionSort;
import main.java.com.sebastientessot.sorting.MergeSort;
import main.java.com.sebastientessot.sorting.SortingAlgorithm;

import org.junit.Test;

public class TestSortingAlgorithms {

	private static final int arraySize = 11;
	
	private int[] createArray() {
		int[] array = new int[arraySize];

		Random random = new Random(42l);
		for (int i = 0; i < arraySize; i++) {
			array[i] = random.nextInt();
		}
		return array;
	}
	
	private void checkAsc(int[] input) {
		for(int i=1; i<input.length; i++) {
			assertTrue(Arrays.toString(input), input[i-1] <= input[i]);
		}
	}
	
	private void checkDesc(int[] input) {
		for(int i=1; i<input.length; i++) {
			assertTrue(Arrays.toString(input), input[i-1] >= input[i]);
		}
	}
	
	private void checkAlgo(SortingAlgorithm sorter) {
		sorter.sort(null);
		int[] singleElement = new int[]{3};
		sorter.sort(singleElement);
		assertEquals(3, singleElement[0]);
		
		int[] input = new int[] {5,2,4,7,1,3,2,6};
		sorter.sort(input);
		checkAsc(input);
		
		input = new int[] {5,2,4,7,1,3,2,6};
		sorter.sortDecreasing(input);
		checkDesc(input);
		
		input = createArray();
		sorter.sort(input);
		assertEquals(arraySize, input.length);
		checkAsc(input);
		
		input = createArray();
		sorter.sortDecreasing(input);
		assertEquals(arraySize, input.length);
		checkDesc(input);
	}
	
	@Test
	public void testInsertionSort() {
		checkAlgo(new InsertionSort());
	}
	
	@Test
	public void testMergeSort() {
		checkAlgo(new MergeSort());
	}
}
