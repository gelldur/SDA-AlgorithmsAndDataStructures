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
		_bigDataSet = new int[10000000];// 10 000 000 elements
		for (int i = 0; i < _bigDataSet.length; ++i) {
			_bigDataSet[i] = i;
		}
	}

	@AfterClass
	public static void onDie() {
		_bigDataSet = null;// Rly ?
	}

	private static int[] _bigDataSet;

	// @formatter:off
	/**
	 * On my Laptop (Intel i7-4720HQ CPU @ 2.60GHz, 16 GB RAM)
	 * 
	 * LinearSearch:
	 * 		checkFindPerformanceOnTheEnd(28.142s)
	 * 		checkFindPerformanceOnTheEnd(28.232s)
	 * 
	 * 		LinearSearch average find time: 2813452.8150999974 nanoseconds
	 * 		LinearSearch average find time: 2822564.125599989 nanoseconds
	 * 
	 * LinearSearchWithGuard:
	 * 		checkFindPerformanceOnTheEnd(28.666s)
	 * 		checkFindPerformanceOnTheEnd(28.601s)
	 * 
	 * 		MyLinearSearchWithGuard average find time: 2873863.009399999 nanoseconds
	 * 		MyLinearSearchWithGuard average find time: 2859368.5756999855 nanoseconds
	 */
	// @formatter:on
	@Test
	public void checkFindPerformanceOnTheEnd() {
		Random random = new Random(34);// Constant seed

		double average = 0;

		for (int i = 1; i <= 10000; ++i) { // 10 000 iterations
			long endTime, startTime = System.nanoTime();
			int indexFromEnd = _bigDataSet.length - random.nextInt(340) - 1;
			assertTrue(indexFromEnd >= 0);
			assertTrue(indexFromEnd < _bigDataSet.length);

			assertEquals(indexFromEnd, _searchAlgorithm.find(_bigDataSet, _bigDataSet[indexFromEnd]));
			endTime = System.nanoTime();

			average -= average / (double) i;
			average += (endTime - startTime) / (double) i;
		}
		System.out.println(this.getClass().getSimpleName() + " average find time: " + average + " nanoseconds");
	}

	@Test
	public void checkFindPerformanceOnTheEnd2() {
		Random random = new Random(341);// Constant seed
		int[] data = new int[512];
		for (int i = 0; i < data.length; ++i) {
			data[i] = i;
		}

		double average = 0;

		for (int i = 1; i <= 100000000; ++i) { // 100 000 000 iterations
			long endTime, startTime = System.nanoTime();
			int indexFromEnd = data.length - random.nextInt(127) - 1;
			assertTrue(indexFromEnd >= 0);
			assertTrue(indexFromEnd < data.length);

			assertEquals(indexFromEnd, _searchAlgorithm.find(data, data[indexFromEnd]));
			endTime = System.nanoTime();

			average -= average / (double) i;
			average += (endTime - startTime) / (double) i;
		}
		System.out.println(this.getClass().getSimpleName() + "2 average find time: " + average + " nanoseconds");
	}
}
