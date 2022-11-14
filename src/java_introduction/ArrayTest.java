package java_introduction;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ArrayTest {

	@Test
	void binarySearchLeftTest() {
		int ar0[] = {1, 1, 2, 3, 4};
		int ar1[] = {1, 2, 3, 4, 4};
		int ar2[] = {1, 2, 3, 4, 4, 4, 4, 4, 4, 5, 6};
		int ar3[] = {2, 2, 2, 4, 4, 4};
		assertEquals(0, MyArrays.binarySearchLeft(ar0, 1));
		assertEquals(3, MyArrays.binarySearchLeft(ar1, 4));
		assertEquals(3, MyArrays.binarySearchLeft(ar2, 4));
		assertEquals(-7, MyArrays.binarySearchLeft(ar3, 5));	
	}
	
	@Test
	void bubbleSortTest() {
		int[] arr = new int[] { 2, -1, -3 };
		int[] arr1 = new int[] { 10, 17, -4, 0, -18 };
		int[] arr2 = new int[] { 1, 3, 1, 2, -6, -9 };
		MyArrays.bubbleSort(arr);
		assertArrayEquals(new int[] { -3, -1, 2 }, arr);	
		MyArrays.bubbleSort(arr1);
		assertArrayEquals(new int[] { -18, -4, 0, 10, 17 }, arr1);
		MyArrays.bubbleSort(arr2);
		assertArrayEquals(new int[] { -9, -6, 1, 1, 2, 3 }, arr2);
	}

	@Test
	void isOneSwapTestFalse() {
		int ar1[] = { 1, 2, 3, 10, -1, 5, 6 };
		int ar2[] = { 1, 2, 3, 4, 5, 10 };
		int ar3[] = { 5, 1, 2, 4, 6, 10 };
		int ar4[] = { 1, 5, 2, 4, 3, 10 };
		int ar5[] = { 1, 3, 2, 5, 4, 10, 8 };
		int ar6[] = {1, 3, 20, 4, 5, 6, 10};
		int ar7[] = {1, 3, 20, 4, 5, 11, 2};
		assertFalse(MyArrays.isOneSwapForSorted(ar1));
		assertFalse(MyArrays.isOneSwapForSorted(ar2));
		assertFalse(MyArrays.isOneSwapForSorted(ar3));
		assertFalse(MyArrays.isOneSwapForSorted(ar4));
		assertFalse(MyArrays.isOneSwapForSorted(ar5));
		assertFalse(MyArrays.isOneSwapForSorted(ar6));
		assertFalse(MyArrays.isOneSwapForSorted(ar7));
	}
	
	@Test
	void isOneSwapTestTrue() {
		int ar1[] = { 10, 2, 3, 4, 1 };
		int ar2[] = { 1, 2, 4, 3, 5, 10 };
		int ar3[] = { 1, 2, 3, 10, 5, 4 };
		int ar4[] = { 1, 5, 3, 4, 2, 10 };
		int ar5[] = { 1, 2, 3, 4, 10, 5 };
		int ar6[] = { 2, 1, -3, 4, 5, 10 };
		int ar7[] = { 3, 2, 1, 4, 5, 6 };
		assertTrue(MyArrays.isOneSwapForSorted(ar1));
		assertTrue(MyArrays.isOneSwapForSorted(ar2));
		assertTrue(MyArrays.isOneSwapForSorted(ar3));
		assertTrue(MyArrays.isOneSwapForSorted(ar4));
		assertTrue(MyArrays.isOneSwapForSorted(ar5));
		assertTrue(MyArrays.isOneSwapForSorted(ar6));
		assertTrue(MyArrays.isOneSwapForSorted(ar7));
		}
}