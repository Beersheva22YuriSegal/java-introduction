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
		assertEquals(0x3ab7d5, BitOperations.setBitValue(num, 5, false));  //0x3ab6_(f -> d)_5	 001110101011011111_0_10101
		assertEquals(0x3ab7f5, BitOperations.setBitValue(num, 5, true));   //0x3ab6_f_5			 001110101011011111_1_10101
		assertEquals(0x3ab7f7, BitOperations.setBitValue(num, 1, true));   //0x3ab6f_(5 -> 7)_ 	 0011101010100111111101_1_1
		assertEquals(0x3ab6f5, BitOperations.setBitValue(num, 8, false));  //0x3ab_(7 -> 6)_f5 	 001110101010011_0_11110101
		assertEquals(0x3eb7f5, BitOperations.setBitValue(num, 18, true));  //0x3_(a -> e)_b7f5   00111_1_101010011011110101
		assertEquals(0x1ab7f5, BitOperations.setBitValue(num, 21, false)); //0x_(3 -> 1)_ab7f5   00_0_110101010011111110101
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
	void digitsNumberTest() {
		//TODO
		assertEquals(5, Number.getNdigits(13579));
		assertEquals(7, Number.getNdigits(1234567));
		assertEquals(3, Number.getNdigits(456));
		assertEquals(1, Number.getNdigits(0));
		assertEquals(3, Number.getNdigits(-100));
	}
//	@Test
	void leadingZerosTest() {
		//TODO
		assertEquals(, BitOperations.leadingZeros(0))
	}
//	@Test
	void onesInNumberTest() {
		//TODO
	}
//	@Test
	void isHappyNumberTest() {
		//TODO
	}
}