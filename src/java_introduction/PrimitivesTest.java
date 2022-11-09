package java_introduction;

import static org.junit.jupiter.api.Assertions.*;

import java.io.LineNumberInputStream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void dataTypeTest() {
		int b = 10;
		short a = 20000;
		char c = 'd';
		long l = (long) 10.1;
		byte b1 = (byte) 1011;
		a = (short) l;
		float f = 10.2f;
		int b2 = 0xfffffff1;
		assertEquals(-15, b2);
	}

	@Test
	@Disabled
	void operatorsTest() {
		int a = 10;
		assertEquals(13, a + 3);
		assertEquals(1, a % 3);
		int number = 123;
		assertEquals(3, getThirdDigit(number));
		assertEquals(2, getSecondDigit(number));
		assertEquals(1, getFirstDigit(number));

//Assumption: all three methods take number comprising of three digits
	}

	@Test
	@Disabled
	private int getFirstDigit(int number) {
		return number / 100 % 10;
	}

	@Test
	@Disabled
	private int getSecondDigit(int number) {
		return number / 10 % 10;
	}

	@Test
	@Disabled
	private int getThirdDigit(int number) {
		return number % 10;
	}

	@Test
	@Disabled
	void getBitValueTest() {
		long num = 0x3ab7f5; // 001110101011_0_11111_1_10_1_0_1
		assertEquals(1, BitOperations.getBitValue(num, 5));
		assertEquals(0, BitOperations.getBitValue(num, 11));
		assertEquals(0, BitOperations.getBitValue(num, 1));
		assertEquals(1, BitOperations.getBitValue(num, 2));
		assertEquals(-1, BitOperations.getBitValue(num, 100));
		assertEquals(-1, BitOperations.getBitValue(num, -2));
	}

	@Test
	@Disabled
	void setBitValueTest() {
		long num = 0x3ab7f5; // 001110101011011111_1_10101
		assertEquals(0x3ab7d5, BitOperations.setBitValue(num, 5, false)); // 0x3ab6_(f -> d)_5
																			// 001110101011011111_0_10101
		assertEquals(0x3ab7f5, BitOperations.setBitValue(num, 5, true)); // 0x3ab6_f_5 001110101011011111_1_10101
		assertEquals(0x3ab7f7, BitOperations.setBitValue(num, 1, true)); // 0x3ab6f_(5 -> 7)_ 0011101010100111111101_1_1
		assertEquals(0x3ab6f5, BitOperations.setBitValue(num, 8, false)); // 0x3ab_(7 -> 6)_f5
																			// 001110101010011_0_11110101
		assertEquals(0x3eb7f5, BitOperations.setBitValue(num, 18, true)); // 0x3_(a -> e)_b7f5
																			// 00111_1_101010011011110101
		assertEquals(0x1ab7f5, BitOperations.setBitValue(num, 21, false)); // 0x_(3 -> 1)_ab7f5
																			// 00_0_110101010011111110101
	}

	@Test
	@Disabled
	void invertBitValueTest() {
		long num = 0x3ab7f5;
		assertEquals(0x3ab7d5, BitOperations.invertBitValue(num, 5));
		assertEquals(0x3ab7f4, BitOperations.invertBitValue(num, 0));
		assertEquals(0x3ab3f5, BitOperations.invertBitValue(num, 10));
		assertEquals(0x3a37f5, BitOperations.invertBitValue(num, 15));
		num = -1;
		assertEquals(1, BitOperations.getBitValue(num, 63));
		num = BitOperations.invertBitValue(num, 63);
		assertEquals(0, BitOperations.getBitValue(num, 63));
	}

	@Test
	@Disabled
	void digitsNumberTest() {
		// TODO
		assertEquals(5, Numbers.getNdigits(13579));
		assertEquals(7, Numbers.getNdigits(1234567));
		assertEquals(3, Numbers.getNdigits(456));
		assertEquals(1, Numbers.getNdigits(0));
		assertEquals(3, Numbers.getNdigits(-100));
	}

	@Test
	@Disabled
	void leadingZerosTest() {
		// TODO
		assertEquals(64, BitOperations.leadingZeros(0));
		assertEquals(63, BitOperations.leadingZeros(1));
		assertEquals(0, BitOperations.leadingZeros(-17));
		assertEquals(59, BitOperations.leadingZeros(25));
		assertEquals(42, BitOperations.leadingZeros(0x3ab7f5)); // 001110101011011111_1_10101
	}

	@Test
	@Disabled
	void onesInNumberTest() {
		// TODO
		assertEquals(0, BitOperations.onesInNumber(0));
		assertEquals(2, BitOperations.onesInNumber(3));
		assertEquals(16, BitOperations.onesInNumber(0x3ab7f5));
		assertEquals(49, BitOperations.onesInNumber(-0x3ab7f5));
	}

	@Test
	@Disabled
	void isHappyNumberTest() {
		// TODO
		assertEquals(true, Numbers.isHappyNumber(234432));
		assertEquals(false, Numbers.isHappyNumber(987456));
		assertEquals(true, Numbers.isHappyNumber(715904));
		assertEquals(true, Numbers.isHappyNumber(100001));
	}

	@Test
	@Disabled
	void getDigitsTest() {
		int expected[] = {1, 2, 3, 4};
		assertArrayEquals(expected, Numbers.getDigits(1234));
	}
	@Test
	@Disabled
	void getNumberFromDigitsTest() {
		int expectedNumber = 1234;
		assertEquals(expectedNumber, Numbers.getNumberFromDigits(new int[]{1, 2, 3, 4}));
	}
	@Test
	void arraysAddsNumberTest() {
		int[] initialArray = {2, 4, 6};
		int[] expected = {2, 4, 6, 8};
		assertArrayEquals(expected, MyArrays.addsNumber(initialArray, 8));
	}
	@Test
	void arraysRemoveNumberTest() {
		int[] initialArray = {2,4,6,8};
		int[] expected = {2,4,6};
		assertArrayEquals(expected, MyArrays.removeNumber(initialArray, 3));
		assertArrayEquals(new int[] {}, MyArrays.removeNumber(new int[] {1}, 0));
	}
	@Test
	void insertSortedTest() {
		int[] expected0 = {1,2,3,4,8};
		assertArrayEquals(expected0, MyArrays.insertSorted(new int[] {1,2,3,4}, 8));
		int[] expected1 = {2,4,5,6,8};
		assertArrayEquals(expected1, MyArrays.insertSorted(new int[] {2,4,6,8}, 5));
		int[] expected2 = {3,5,5,7,9};
		assertArrayEquals(expected2, MyArrays.insertSorted(new int[] {3,5,7,9}, 5));
		int[] expected3 = {0,1,2,3};
		assertArrayEquals(expected3, MyArrays.insertSorted(new int[] {1,2,3}, 0));

	}
}