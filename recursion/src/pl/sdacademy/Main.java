package pl.sdacademy;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		minus(5);
	}

	private static void minus(int count) {
		if (count < 0) {
			return;
		}
		System.out.println("Count: " + count);
		minus(count - 1);
	}

}
