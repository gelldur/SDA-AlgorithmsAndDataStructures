package pl.sdacademy.algorithm.my;

import pl.sdacademy.algorithm.Search;

//Please don't name classes this way
public class MyLinearSearch implements Search {

	@Override
	public int find(int[] array, int value) {
		for (int i = 0; i < array.length; ++i) { // n compares + n operations ++
			if (array[i] == value) { // n compares
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean contains(int[] array, int value) {
		return find(array, value) != -1;
	}

}
