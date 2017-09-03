package pl.sdacademy.data.structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HanoiTowerTest {

	@Before
	public void setUp() throws Exception {
		_hanoi = new HanoiTowers(4);
	}

	@Test
	public void testInitialState() {
		assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, _hanoi.getStateOfPile('A').toArray());
		assertArrayEquals(new Integer[] {}, _hanoi.getStateOfPile('B').toArray());
		assertArrayEquals(new Integer[] {}, _hanoi.getStateOfPile('C').toArray());
	}

	@Test
	public void test() {
		assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, _hanoi.getStateOfPile('A').toArray());
		_hanoi.makeStep();
		assertArrayEquals(new Integer[] { 4, 3, 2 }, _hanoi.getStateOfPile('A').toArray());
		assertArrayEquals(new Integer[] { 1 }, _hanoi.getStateOfPile('B').toArray());
		_hanoi.makeStep();
		assertArrayEquals(new Integer[] { 4, 3 }, _hanoi.getStateOfPile('A').toArray());
		assertArrayEquals(new Integer[] { 1 }, _hanoi.getStateOfPile('B').toArray());
		assertArrayEquals(new Integer[] { 2 }, _hanoi.getStateOfPile('C').toArray());
		while (_hanoi.makeStep()) {
		}

		assertArrayEquals(new Integer[] {}, _hanoi.getStateOfPile('A').toArray());
		assertArrayEquals(new Integer[] {}, _hanoi.getStateOfPile('B').toArray());
		assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, _hanoi.getStateOfPile('C').toArray());
	}

	private HanoiTowers _hanoi;
}
