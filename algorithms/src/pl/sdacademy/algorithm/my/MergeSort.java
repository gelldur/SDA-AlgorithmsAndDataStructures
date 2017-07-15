package pl.sdacademy.algorithm.my;

import pl.sdacademy.algorithm.Sort;

public class MergeSort implements Sort {

	@Override
	public void sort(int[] array) {
		this.numbers = array;
		count = array.length;
		this.helper = new int[count];
		mergesort(0, count - 1);
	}

	private int[] numbers;
	private int[] helper;

	private int count;

	private void mergesort(final int leftIndex, final int rightIndex) {
		// check if leftIndex is smaller than rightIndex, if not then the array is sorted
		if (leftIndex >= rightIndex) {
			return;
		}

		// Get the index of the element which is in the middle
		int middle = leftIndex + (rightIndex - leftIndex) / 2;
		// Sort the left side of the array
		mergesort(leftIndex, middle);
		// Sort the right side of the array
		mergesort(middle + 1, rightIndex);
		// Combine them both
		merge(leftIndex, middle, rightIndex);
	}

	private void merge(int leftIndex, int middle, int rightIndex) {
		// Copy both parts into the helper array
		for (int i = leftIndex; i <= rightIndex; ++i) {
			helper[i] = numbers[i];
		}

		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= rightIndex) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				++i;
			} else {
				numbers[k] = helper[j];
				++j;
			}
			++k;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			++k;
			++i;
		}
	}
}
