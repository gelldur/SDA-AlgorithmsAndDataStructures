package pl.sdacademy.algorithm.my;

import pl.sdacademy.algorithm.Search;

public class BinarySearch implements Search {

	@Override
	public int find(int[] array, int value) {
		if (array.length == 0) {
			return -1;
		}

		int leftIndex = 0;
		int rightIndex = array.length - 1;

		while (leftIndex <= rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;
			if (value > array[middle]) {
				leftIndex = middle + 1;
			} else if (value < array[middle]) {
				rightIndex = middle - 1;
			} else { // The element has been found
				return middle;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(int[] array, int value) {
		return find(array, value) != -1;
	}

}
