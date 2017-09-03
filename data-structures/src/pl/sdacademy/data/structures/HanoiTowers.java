package pl.sdacademy.data.structures;

import java.util.ArrayList;
import java.util.Stack;

//@formatter:off

//hanoi(int n, char A, char B, char C)
//	if (n > 0)
//		hanoi(n-1, A, C, B);
//		print "Moving Disk $value from $A to $C"
//		hanoi(n-1, B, A, C);

// More information: https://en.wikipedia.org/wiki/Tower_of_Hanoi
//@formatter:on

public class HanoiTowers {

	private static class Pile {
		char name;
		public Stack<Integer> state = new Stack<>();
	}

	public HanoiTowers(int countOfDisks) {
		_totalCountOfMoves = countOfDisks;
		for (int i = 0; i < countOfDisks; ++i) {
			_pileA.state.push(countOfDisks - i);
		}
		_pileA.name = 'A';
		_pileB.name = 'B';
		_pileC.name = 'C';

		_totalCountOfMoves = (int) (Math.pow(2, getInitialCount()) - 1);
		_currentStep = 1;

		// If number of disks is even, then interchange
		// destination pole and auxiliary pole
		if (getInitialCount() % 2 == 0) {
			_pileB.name = 'C';
			_pileC.name = 'B';
		}
	}

	/**
	 * @return true if game doesn't end
	 */
	public boolean makeStep() {
		if (_pileA.state.isEmpty() && _pileB.state.isEmpty() && _pileC.state.isEmpty() == false) {
			return true;
		}

		hanoi(_pileA, _pileB, _pileC);
		++_currentStep;

		return _currentStep <= _totalCountOfMoves;
	}

	private void hanoi(Pile pileA, Pile pileB, Pile pileC) {
		if (_currentStep % 3 == 1) {
			moveDisksBetweenPiles(_pileA, _pileC);
		} else if (_currentStep % 3 == 2) {
			moveDisksBetweenPiles(_pileA, _pileB);
		} else if (_currentStep % 3 == 0) {
			moveDisksBetweenPiles(_pileB, _pileC);
		}
	}

	private void hanoiOld(int count, Pile pileA, Pile pileB, Pile pileC) {

		if (count <= 0) {
			return;
		}

		hanoiOld(count - 1, pileA, pileC, pileB);

		////
		Integer top = pileA.state.peek();
		System.out.println("" + top + " from " + pileA.name + " -> " + pileC.name);
		pileA.state.pop();
		pileC.state.push(top);
		/////

		hanoiOld(count - 1, pileB, pileA, pileC);
	}

	public Stack<Integer> getStateOfPile(char pileTag) {
		if (pileTag == _pileA.name) {
			return _pileA.state;
		} else if (pileTag == _pileB.name) {
			return _pileB.state;
		} else if (pileTag == _pileC.name) {
			return _pileC.state;
		}

		throw new IndexOutOfBoundsException("Missing pile:" + pileTag);
	}

	public int getInitialCount() {
		return _pileA.state.size() + _pileB.state.size() + _pileC.state.size();
	}

	private int _totalCountOfMoves;
	private int _currentStep;

	private Pile _pileA = new Pile();
	private Pile _pileB = new Pile();
	private Pile _pileC = new Pile();

	private void moveDisksBetweenPiles(Pile source, Pile destination) {
		char from;
		char to;
		int value;

		if (source.state.isEmpty()) {
			from = destination.name;
			value = destination.state.peek();
			to = source.name;

			source.state.push(destination.state.peek());
			destination.state.pop();
		} else if (destination.state.isEmpty()) {
			from = source.name;
			value = source.state.peek();
			to = destination.name;

			destination.state.push(source.state.peek());
			source.state.pop();
		} else if (source.state.peek() > destination.state.peek()) {
			from = destination.name;
			value = destination.state.peek();
			to = source.name;

			source.state.push(destination.state.peek());
			destination.state.pop();
		} else {
			from = source.name;
			value = source.state.peek();
			to = destination.name;

			destination.state.push(source.state.peek());
			source.state.pop();
		}

		System.out.println("From: " + from + "[" + value + "] to:" + to);
	}
}
