package pl.sdacademy.algorithm.impl;

import java.util.Arrays;

import pl.sdacademy.algorithm.Sort;

public class SortAscending implements Sort {

	// Checkout documentation for Arrays ->
	// https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html

	@Override
	public void sort(int[] array) {
		Arrays.sort(array);
	}
}
