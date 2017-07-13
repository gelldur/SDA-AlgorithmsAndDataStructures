package pl.sdacademy.algorithm.my;

import pl.sdacademy.algorithm.Sort;

public class QuickSort implements Sort {

	@Override
	public void sort(int[] array) {
		if (array == null || array.length < 1) { // why not == 0 ? Please ask i will explain :)
			return;
		}
		quickSort(array, 0, array.length - 1);
	}

	private void quickSort(int[] array, final int leftIndex, final int rightIndex) {
		if (leftIndex >= rightIndex) {
			return;
		}

		int l = leftIndex;
		int p = rightIndex;
		// calculate pivot number, I am taking pivot as middle index number
		final int pivot = array[leftIndex + (rightIndex - leftIndex) / 2];
		// Divide into two arrays
		while (l <= p) {
			/**
			 * In each iteration, we will identify a number from left side which is greater
			 * then the pivot value, and also we will identify a number from right side
			 * which is less then the pivot value. Once the search is done, then we exchange
			 * both numbers.
			 */
			while (array[l] < pivot) {
				++l;
			}
			while (array[p] > pivot) {
				--p;
			}
			if (l <= p) {
				exchangeNumbers(array, l, p);
				// move index to next position on both sides
				++l;
				--p;
			}
		}
		// call quickSort() method recursively
		quickSort(array, leftIndex, p);
		quickSort(array, l, rightIndex);
	}

	private void exchangeNumbers(int[] array, final int i, final int j) {
		// Boring way
		// int temp = array[i];
		// array[i] = array[j];
		// array[j] = temp;

		// Fun way!
		// Google for: How to swap two numbers without using a temporary variable
		// http://www.geeksforgeeks.org/swap-two-numbers-without-using-temporary-variable/

		if (array[i] == array[j]) { // Very very important
			return;
		}

		array[i] = array[i] ^ array[j];
		array[j] = array[i] ^ array[j];
		array[i] = array[i] ^ array[j];
	}

}
