package pl.sdacademy.algorithm.my;

import pl.sdacademy.algorithm.Sort;

public class BubbleSort implements Sort {

	@Override
	public void sort(int[] array) {
		for (int i = 0; i < array.length; ++i) {
			for (int j = 1; j < (array.length - i); ++j) {
				if (array[j - 1] <= array[j]) {
					continue;
				}

				// swap elements
				int temp = array[j - 1];
				array[j - 1] = array[j];
				array[j] = temp;
			}
		}
	}
}
