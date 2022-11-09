package java_introduction;

import java.util.Arrays;

public class MyArrays {
	/**
	 * 
	 * @param array
	 * @param number
	 * @return new array with added at end a given number
	 */
	public static int[] addsNumber(int[] array, int number) {
		int[] newArray = Arrays.copyOf(array, array.length + 1);
		newArray[array.length] = number;
		return newArray;
	}

	/**
	 * 
	 * @param array
	 * @param index
	 * @return new array with no number at a given index in a given array if index
	 *         doesn't exist in a given array it returns the same array
	 */
	public static int[] removeNumber(int array[], int index) {
		// TODO
		int[] newArray = array;
		if (index >= 0 && index < array.length) {
			newArray = new int[array.length - 1];
			System.arraycopy(array, 0, newArray, 0, index);
			System.arraycopy(array, index + 1, newArray, index, newArray.length - index);
		}
		return newArray;
	}

	/**
	 * 
	 * @param arraySorted - sorted array
	 * @param number
	 * @return new array with inserted number at an index for keeping array sorted
	 */
	public static int[] insertSorted(int arraySorted[], int number) {
		int tempIndex = Arrays.binarySearch(arraySorted, number);
		int insIndex = 0;
		if (tempIndex < 0) {
			insIndex = -(tempIndex + 1);
		} else {
			insIndex = tempIndex;
		}
		int[] res = new int[arraySorted.length + 1];
		System.arraycopy(arraySorted, 0, res, 0, insIndex);
		res[insIndex] = number;
		System.arraycopy(arraySorted, insIndex, res, insIndex + 1, arraySorted.length - insIndex);

		return res;
	}
}
