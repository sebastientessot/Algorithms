package main.java.com.sebastientessot.sorting;

public interface SortingAlgorithm {

	/**
	 * 
	 * Sort the array pass as input in an ascending order
	 * 
	 * @param input the array to sort
	 */
	public void sort(int[] input);
	
	/**
	 * 
	 * Sort the array pass as input in a decreasing order
	 * 
	 * @param input the array to sort
	 */
	public void sortDecreasing(int[] input);
}
