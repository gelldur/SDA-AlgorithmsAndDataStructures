package pl.sdacademy.data.structures;

public interface List {
	/**
	 * Insert value at given index
	 * 
	 * @param index
	 * @param value
	 * @return true if success, false otherwise
	 */
	boolean insert(int index, int value) throws IndexOutOfBoundsException;

	/**
	 * Remove element at given index. If we can't remove false will be returned. I
	 * is safe to call remove on empty list
	 * 
	 * @param index
	 * @return true if success, false otherwise
	 */
	boolean remove(int index);

	/**
	 * Getter for value at given index. If such index doesn't work exception should
	 * be thrown
	 * 
	 * @param index
	 * @return value at given index
	 */
	int getItem(int index) throws IndexOutOfBoundsException;
}
