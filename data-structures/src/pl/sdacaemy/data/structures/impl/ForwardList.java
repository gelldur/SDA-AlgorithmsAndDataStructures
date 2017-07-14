package pl.sdacaemy.data.structures.impl;

import pl.sdacademy.data.structures.List;

public class ForwardList implements List {

	@Override
	public boolean insert(int index, int value) throws IndexOutOfBoundsException {
		if (index > getSize() + 1) {
			throw new IndexOutOfBoundsException();
		}

		Node newElement = new Node(value);

		if (node == null) {
			node = newElement;
			return true;
		}

		Node previous = getItemNode(index - 1);
		newElement.next = previous.next;
		previous.next = newElement;

		return true;
	}

	@Override
	public boolean remove(int index) {

		Node previous = getItemNode(index - 1);
		Node removedNode = previous.next;
		previous.next = removedNode.next;

		return false;
	}

	@Override
	public int getItem(int index) throws IndexOutOfBoundsException {
		return getItemNode(index).value;
	}

	private Node getItemNode(int index) throws IndexOutOfBoundsException {
		int currentIndex = 0;
		Node currentNode = node;

		while (currentNode.next != null && currentIndex < index) {
			++currentIndex;
			currentNode = currentNode.next;
		}

		if (currentNode == null) {
			throw new IndexOutOfBoundsException("Sorry no such element: " + index);
		}

		return currentNode;
	}

	public int getSize() {
		if (node == null) {
			return 0;
		}

		return 10000;
	}

	private Node node;

	public static class Node {
		public Node(int value) {
			this.value = value;
		}

		int value;
		Node next;
	}
}
