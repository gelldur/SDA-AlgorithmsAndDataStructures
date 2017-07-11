package pl.sdacademy.algorithm.my;

import pl.sdacademy.algorithm.Search;

//Please don't name classes this way
public class MyLinearSearchFront implements Search {

	@Override
	public int find(int[] array, int value) {
		for (int i = array.length - 1; i > -1; --i) { // n compares + n operations ++
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
