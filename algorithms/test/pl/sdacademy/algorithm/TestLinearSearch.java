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

	@Test
	public void testEmpty() {
		int[] data = {};//empty array
		assertEquals(-1, _searchAlgorithm.find(data, 1));
		assertFalse(_searchAlgorithm.contains(data, 11));
	}
}
