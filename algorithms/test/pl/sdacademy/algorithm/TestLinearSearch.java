package pl.sdacademy.algorithm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pl.sdacademy.algorithm.impl.LinearSearch;

public class TestLinearSearch {

	private final Search _searchAlgorithm = new LinearSearch();

	@Test
	public void doesContains() {
		int[] data = { 1, 2, 2, 3, 6, 8, 10, 31 };
		assertTrue(_searchAlgorithm.contains(data, 1));
		assertTrue(_searchAlgorithm.contains(data, 31));
		assertFalse(_searchAlgorithm.contains(data, 11));
	}

	@Test
	public void checkFind() {
		int[] data = { 1, 2, 2, 3, 6, 8, 10, 31 };
		assertEquals(0, _searchAlgorithm.find(data, 1));
		assertEquals(7, _searchAlgorithm.find(data, 31));
		assertEquals(-1, _searchAlgorithm.find(data, 11));
		assertEquals(1, _searchAlgorithm.find(data, 2));
	}

	@BeforeClass
	public static void onSetup() {
		Random random = new Random(12);// Constant seed
		_bigDataSet = new int[1000000];// 1 000 000 elements
		for (int i = 0; i < _bigDataSet.length; ++i) {
			_bigDataSet[i] = random.nextInt();
		}
	}

	@AfterClass
	public static void onDie() {
		_bigDataSet = null;// Rly ?
	}

	private static int[] _bigDataSet;

	@Test
	public void checkFindPerformanceOnTheEnd() {
		Random random = new Random(33);// Constant seed

		double average = 0;

		for (int i = 1; i <= 10000; ++i) {
			long endTime, startTime = System.nanoTime();
			int indexFromEnd = _bigDataSet.length - random.nextInt(120) - 1;
			assertTrue(indexFromEnd >= 0);
			assertTrue(indexFromEnd < _bigDataSet.length);

			assertEquals(indexFromEnd, _searchAlgorithm.find(_bigDataSet, _bigDataSet[indexFromEnd]));
			endTime = System.nanoTime();

			average -= average / i;
			average += (endTime - startTime) / i;
		}
		System.out.println(this.getClass().getSimpleName() + " average find time: " + average + " nanoseconds");
	}
}
