package pl.sdacademy.data.structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pl.sdacaemy.data.structures.impl.ForwardList;

public class ListTest {

	@Before
	public void setUp() {
		_list = new ForwardList();
	}

	@Test
	public void testSample() {
		_list.remove(0);// should not fail
		_list.insert(0, 100);
		assertEquals(100, _list.getItem(0));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsertFail() {
		_list.insert(1, 100);// should fail
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetItemFail() {
		_list.getItem(0);// should fail
	}

	public void testList() {
		for (int i = 0; i < 10; ++i) {
			_list.insert(i, i + 1);

			assertEquals(i + 1, _list.getItem(i));
		}

		for (int i = 0; i < 10; ++i) {
			assertEquals(i + 1, _list.getItem(i));
		}

		for (int i = 9; i > -1; --i) {
			assertEquals(i + 1, _list.getItem(i));
			_list.remove(i);
			_list.remove(i);
		}
	}

	private List _list;
}
