package pl.sdacademy.algorithm;

public interface Search {

	/**
	 * Finds value in array and returns it index in array
	 * 
	 * @param array
	 *            a array that will be searched
	 * @param value
	 *            a value to find
	 * 
	 * @return index of found value or -1 if value isn't present
	 * 
	 * @see pl.sdacademy.algorithm.Search#find(int[], int)
	 */
	public int find(int[] array, int value);

	public boolean contains(int[] array, int value);
}
