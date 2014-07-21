package test.java.com.sebastientessot.sorting;

import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;
import main.java.com.sebastientessot.sorting.InsertionSort;

public class TestSortingAlgorithms {

	private static final int arraySize = 5;
	
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
			assertTrue(input[i-1] <= input[i]);
		}
	}
	
	private void checkDesc(int[] input) {
		for(int i=1; i<input.length; i++) {
			assertTrue(input[i-1] >= input[i]);
		}
	}
	
	@Test
	public void testInsertionSort() {
		int[] input = createArray();
		new InsertionSort().sort(input);
		checkAsc(input);
		
		input = createArray();
		new InsertionSort().sortDecreasing(input);
		checkDesc(input);
	}
}
