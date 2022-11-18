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
		int l = 0;
		int r = arraySorted.length - 1;
		int mid = arraySorted.length / 2;
		while (l <= r && arraySorted[l] != number) {
			if (number <= arraySorted[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
			mid = (l + r) / 2;
		}
		return l < arraySorted.length && arraySorted[l] == number ? l : -l - 1;
	}

	public static void bubbleSort(int[] arr) {
		int uncheckedLength = arr.length;
		do {
			uncheckedLength = moveGreaterRight(arr, uncheckedLength - 1);
		} while (uncheckedLength != 0);
	}

	private static int moveGreaterRight(int[] arr, int length) {
		int res = 0;
		for (int i = 0; i < length; i++) {
			if (arr[i] > arr[i + 1]) {
				res = i + 1;
				swap(arr, i, i + 1);
			}
		}
		return res;
	}

	public static boolean isOneSwapForSorted(int[] arr) {
		int index1 = -1;
		int index2 = -1;
		int length = arr.length - 1;
		int equaledCount = 0;
		boolean res = true;
		int i = 0;
		while (i < length && res) {
			if (arr[i] > arr[i + 1]) {
				if (index1 == -1) {
					index1 = i - equaledCount;
					if (equaledCount > 0) {
						index2 = i + 1;
					}
				} else if (index2 != -1) {
					res = false;
				} else {
					index2 = i + 1;
				}
			} else if (arr[i] == arr[i + 1]) {
				equaledCount++;
			} else if (arr[i] < arr[i + 1]) {
				if (equaledCount != 0 && index1 != -1 && index2 == -1 && arr[i] < arr[index1]) {
					index2 = i;
				}
				equaledCount = 0;
			}
			i++;
		}
		return index1 != -1 && res ? checkIndexes(arr, index1, index2) : false;
	}

	private static boolean checkIndexes(int[] arr, int index1, int index2) {
		return index2 == -1 ? checkOneIndex(arr, index1) : checkTwoIndexes(arr, index1, index2);
	}

	private static boolean checkTwoIndexes(int[] arr, int index1, int index2) {
		return (index2 == arr.length - 1 || arr[index1] <= arr[index2 + 1]) 
				&& arr[index2] <= arr[index1 + 1]
				&& (index1 == 0 || arr[index2] >= arr[index1 - 1]);
	}

	private static boolean checkOneIndex(int[] arr, int index) {
		return (index == arr.length - 2 || arr[index] <= arr[index + 2])
				&& (index == 0 || arr[index + 1] >= arr[index - 1]);
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	/**
	 * 
	 * @param array of short positive numbers
	 * @param sum
	 * @return true if array contains two numbers, sum of which equals a given sum
	 */
	public static boolean isSum2(short[] arr, short sum) {
		return false;
	}
}