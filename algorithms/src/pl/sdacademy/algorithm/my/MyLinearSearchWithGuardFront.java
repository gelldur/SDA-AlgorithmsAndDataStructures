package pl.sdacademy.algorithm.my;

import pl.sdacademy.algorithm.Search;

//Please don't name classes this way
public class MyLinearSearchWithGuardFront implements Search {

	@Override
	public int find(int[] array, int value) {
		if (array.length < 1) { // 1 compare
			return -1; // edge case
		}

		final int lastIndex = 0;
		if (array[lastIndex] == value) { // 1 compare
			return lastIndex;
		}

		final int lastValue = array[lastIndex];// remember previous value so we
												// can restore it later
		// We could use try - finally! But for now for simplicity we do without
		// it

		int index = array.length;
		array[lastIndex] = value;// insert our guard on the end
		{
			// Solution 1
			while (array[--index] != value) { // n compares + n operation --
			}

			// Solution 2
			// while (array[index++] != value) {
			// }
		}
		array[lastIndex] = lastValue;// restore previous value

		return index == lastIndex ? -1 : index; // 1 compare
	}

	@Override
	public boolean contains(int[] array, int value) {
		return find(array, value) != -1;
	}

}
