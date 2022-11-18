package java_introduction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ArrayTest {

	@Test
	@Disabled
	void binarySearchLeftTest() {
		int ar[] = { 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 20, 40 };
		assertEquals(-14, MyArrays.binarySearchLeft(ar, 3));
		assertEquals(3, MyArrays.binarySearchLeft(ar, 2));
		assertEquals(-1, MyArrays.binarySearchLeft(ar, 0));
		assertEquals(13, MyArrays.binarySearch(ar, 4));
		assertEquals(0, MyArrays.binarySearchLeft(ar, 1));
		assertEquals(-16, MyArrays.binarySearchLeft(ar, 25));
		assertEquals(-17, MyArrays.binarySearchLeft(ar, 45));
	}
	
	@Test
	@Disabled
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
	@Disabled
	void isOneSwapTestFalse() {
		int ar1[] = { 1, 2, 3, 10, -1, 5, 6 };
		int ar2[] = { 1, 2, 3, 4, 5, 10 };
		int ar3[] = { 5, 1, 2, 4, 6, 10 };
		int ar4[] = { 1, 5, 2, 4, 3, 10 };
		int ar5[] = { 1, 3, 2, 5, 4, 10, 8 };
		int ar6[] = { 1, 3, 20, 4, 5, 6, 10 };
		int ar7[] = { 1, 3, 20, 4, 5, 11, 2 };
		assertFalse(MyArrays.isOneSwapForSorted(ar1));
		assertFalse(MyArrays.isOneSwapForSorted(ar2));
		assertFalse(MyArrays.isOneSwapForSorted(ar3));
		assertFalse(MyArrays.isOneSwapForSorted(ar4));
		assertFalse(MyArrays.isOneSwapForSorted(ar5));
		assertFalse(MyArrays.isOneSwapForSorted(ar6));
		assertFalse(MyArrays.isOneSwapForSorted(ar7));
	}

	@Test
	@Disabled
	void isOneSwapTestTrue() {
		int ar1[] = { 10, 2, 3, 4, 1 };
		int ar2[] = { 1, 2, 4, 3, 5, 10 };
		int ar3[] = { 1, 2, 3, 10, 5, 4 };
		int ar4[] = { 1, 5, 3, 4, 2, 10 };
		int ar5[] = { 1, 2, 3, 4, 10, 5 };
		int ar6[] = { 2, 1, -3, 4, 5, 10 };
		int ar7[] = { 3, 2, 1, 4, 5, 6 };
		int ar8[] = { 1, 2, 2, 3, 3, 4, 4, 4, 3, 5 };
		int ar9[] = { 1, 2, 4, 3, 3, 3, 5 };
		assertTrue(MyArrays.isOneSwapForSorted(ar1));
		assertTrue(MyArrays.isOneSwapForSorted(ar2));
		assertTrue(MyArrays.isOneSwapForSorted(ar3));
		assertTrue(MyArrays.isOneSwapForSorted(ar4));
		assertTrue(MyArrays.isOneSwapForSorted(ar5));
		assertTrue(MyArrays.isOneSwapForSorted(ar6));
		assertTrue(MyArrays.isOneSwapForSorted(ar7));
		assertTrue(MyArrays.isOneSwapForSorted(ar8));
		assertTrue(MyArrays.isOneSwapForSorted(ar9));
	}
	@Test
	void isSum2Test() {
		assertTrue(MyArrays.isSum2(new short[] {1, 2, 3, 15, 35}, (short) 3));
		assertTrue(MyArrays.isSum2(new short[] {1, 2, 3, 15, 35}, (short) 50));
		assertTrue(MyArrays.isSum2(new short[] {1, 2, 3, 15, 35}, (short) 38));
		assertTrue(MyArrays.isSum2(new short[] {1, 2, 3, 15, 35}, (short) 4));
		assertTrue(MyArrays.isSum2(new short[] {1, 2, 2, 2, 35}, (short) 4));
		
		assertFalse(MyArrays.isSum2(new short[] {1, 2, 3, 15, 35}, (short) 10));
		assertFalse(MyArrays.isSum2(new short[] {1, 2, 3, 15, 35}, (short) 20));
		assertFalse(MyArrays.isSum2(new short[] {1, 2, 3, 15, 35}, (short) 30));
		assertFalse(MyArrays.isSum2(new short[] {1, 2, 2, 2, 35}, (short) 6));
	}
}