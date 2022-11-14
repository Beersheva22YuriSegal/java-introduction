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
		int res[] = array;
		if (index >= 0 && index < array.length) {
			res = new int[array.length - 1];
			System.arraycopy(array, 0, res, 0, index);
			System.arraycopy(array, index + 1, res, index, res.length - index);
		}
		return res;
	}

	/**
	 * 
	 * @param arraySorted - sorted array
	 * @param number
	 * @return new array with inserted number at an index for keeping array sorted
	 */
	public static int[] insertSorted(int arraySorted[], int number) {
		int index = Arrays.binarySearch(arraySorted, number);
		if (index < 0) {
			index = -(index + 1);
		}
		return insertAtIndex(arraySorted, number, index);
	}

	private static int[] insertAtIndex(int[] array, int number, int index) {
		int res[] = new int[array.length + 1];
		System.arraycopy(array, 0, res, 0, index);
		res[index] = number;
		System.arraycopy(array, index, res, index + 1, array.length - index);
		return res;
	}

	/**
	 * 
	 * @param arraySorted
	 * @param number
	 * @return index value if number exists otherwise -1 O[N] - search number in
	 *         unsorted array O[Log(N)] - search number in sorted (binary search)
	 */
	public static int binarySearch(int arraySorted[], int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;
		while (left <= right && arraySorted[middle] != number) {
			if (number < arraySorted[middle]) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return left > right ? -1 : middle;
	}

	public static int binarySearchLeft(int[] arraySorted, int number) {
		int left = 0;
		int right = arraySorted.length - 1;
		int middle = right / 2;
		int res = -1;
		while (left <= right) {
			if (number < arraySorted[middle]) {
				right = middle - 1;
			} else if (number > arraySorted[middle]) {
				left = middle + 1;
			} else {
				res = middle;
				right = middle - 1;
			}
			middle = (left + right) / 2;
		}
		if (res == -1) {
			res = -left - 1;
		}
		return res;
	}

	public static void bubbleSort(int[] arr) {
		while (moveGreaterRight(arr))
			;
	}

	private static boolean moveGreaterRight(int[] arr) {
		boolean res = false;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
				res = true;
			}
		}
		return res;
	}

	public static boolean isOneSwapForSorted(int[] arr) {
		int firstNum = 0;
		int secondNum = 0;
		int count = 0;
		for (int k = 1; k < arr.length; k++) {
			if (arr[k] < arr[k - 1]) {
				count++;
				if (firstNum == 0) {
					firstNum = k;
				} else {
					secondNum = k;
				}
			}
		}
		if (count == 0) {
			return false;
		}
		if (count > 2) {
			return false;
		}
		if (count == 1) {
			swap(arr, firstNum - 1, firstNum);
		}
		if (count == 2) {
			swap(arr, firstNum - 1, secondNum);
		}
		return sorted(arr);
	}

	public static boolean sorted(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}

	private static void swap(int[] arr, int n, int m) {
		int temp = arr[n];
		arr[n] = arr[m];
		arr[m] = temp;
	}
}