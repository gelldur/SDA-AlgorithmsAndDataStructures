package pl.sdacademy.algorithm.impl;

import java.util.Arrays;

import pl.sdacademy.algorithm.Sort;

public class SortDescending implements Sort {

	@Override
	public void sort(int[] array) {
		// Arrays.sort(array, Collections.reverseOrder()); not available :(
		// Ugly solution for now!
		// Remember first it need to work!
		Arrays.sort(array);

		// Extra task to use Arrays.asList

		for (int i = 0; i < array.length / 2; ++i) {
			int temp = array[i];
			array[i] = array[array.length - i - 1];
			array[array.length - i - 1] = temp;
		}
	}

}
