package pl.sdacademy.algorithm;

import org.junit.Assert;
import org.junit.Test;

import pl.sdacademy.algorithm.impl.SortAscending;
import pl.sdacademy.algorithm.impl.SortDescending;

public class TestSort {

	private final Sort _sortAlgorithmAsc = new SortAscending();
	private final Sort _sortAlgorithmDesc = new SortDescending();

	@Test
	public void asc() {
		int[] data = { 1, 2, 2, 3, 6, 8, 10, 31 };

		_sortAlgorithmAsc.sort(data);

		Assert.assertArrayEquals(new int[] { 1, 2, 2, 3, 6, 8, 10, 31 }, data);
	}

	@Test
	public void desc() {
		int[] data = { 1, 2, 2, 3, 6, 8, 10, 31 };

		_sortAlgorithmDesc.sort(data);

		Assert.assertArrayEquals(new int[] { 31, 10, 8, 6, 3, 2, 2, 1 }, data);
	}

	@Test
	public void oneElement() {
		int[] data = { 1 };

		_sortAlgorithmDesc.sort(data);
		Assert.assertArrayEquals(new int[] { 1 }, data);

		_sortAlgorithmAsc.sort(data);
		Assert.assertArrayEquals(new int[] { 1 }, data);
	}

	@Test
	public void empty() {
		int[] data = {};

		_sortAlgorithmDesc.sort(data);
		Assert.assertArrayEquals(new int[] {}, data);

		_sortAlgorithmAsc.sort(data);
		Assert.assertArrayEquals(new int[] {}, data);
	}

	@Test
	public void asc2() {
		int[] data = { 3, 7, 1, 8, 3, 2, 6, 27, 3736, 1 };

		_sortAlgorithmAsc.sort(data);

		Assert.assertArrayEquals(new int[] { 1,1,2,3,3,6,7,8,27,3736 }, data);// TODO FIXME
	}

	@Test
	public void desc2() {
		int[] data = { 99, 11, 2, 3, 4, 5, 61, 123, 1 };

		_sortAlgorithmDesc.sort(data);

		Assert.assertArrayEquals(new int[] { 0 }, data);// TODO FIXME
	}

	@Test
	public void sortEqual() {
		int[] data = { 2, 2 };

		_sortAlgorithmAsc.sort(data);
		Assert.assertArrayEquals(new int[] { 2, 2 }, data);

		_sortAlgorithmDesc.sort(data);
		Assert.assertArrayEquals(new int[] { 2, 2 }, data);
	}
}
