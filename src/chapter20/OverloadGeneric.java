//20.5
package chapter20;

public class OverloadGeneric {

	public static void main(String[] args) throws InvalidSubscriptException {
		// create arrays of Integer, Double and Character
		Integer[] integerArray = { 1, 2, 3, 4, 5, 6 };
		Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 };
		Character[] characterArray = { 'H', 'E', 'L', 'L', 'O' };

		System.out.printf("Array integerArray contains:%n");
		printArray(integerArray);
		System.out.printf("%nArray doubleArray contains:%n");
		printArray(doubleArray);
		System.out.printf("%nArray characterArray contains:%n");
		printArray(characterArray);
		
		System.out.printf("%nPortion of Array integerArray contains:%n");
		printArray(integerArray,2,5);
		System.out.printf("%nPortion of Array doubleArray contains:%n");
		printArray(doubleArray,0,3);
		System.out.printf("%nPortion of Array characterArray contains:%n");
		printArray(characterArray,3,3);
	}

	// generic method printArray
	public static <T> void printArray(T[] inputArray) {
		for (T element : inputArray)
			System.out.printf("%s ", element);

		System.out.println();
	}

	public static <T> void printArray(T[] inputArray, int lowSubscript, int highSubscript) throws InvalidSubscriptException {
		
		int count=0;
		if (lowSubscript < 0 || lowSubscript > inputArray.length - 1) {
			throw new InvalidSubscriptException ("Value of lowSubscript is out of range");
		}
		if (highSubscript < 0 || highSubscript > inputArray.length - 1) {
			throw new InvalidSubscriptException ("Value of highSubscript is out of range");
		}
		
		for (int i=lowSubscript; i<highSubscript; i++) {
			System.out.printf("%s ", inputArray[i]);
			count++;
		}
		System.out.printf("%nElements: %d%n",count);
	}
}

class InvalidSubscriptException extends Exception{
	
	public InvalidSubscriptException() {
		super("Value is out of range");
	}
	
	public InvalidSubscriptException(String message) {
		super(message);
	}
} 