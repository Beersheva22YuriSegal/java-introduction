package java_introduction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrimitivesTest {

	@Test
	@Disabled
	void dataTypeTest() {
		int b = 10;
		short a = 20;
		char c = 'd';
		long l = (long) 10.1;
		byte b1 = (byte) 1000;
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
	
	
	void getBitValue() {
		long number = 0x3ab7f5; //001110101011011111110101
		assertEquals(1, BitOperations.getBitValue(number, 5));
		assertEquals(0, BitOperations.getBitValue(number, 11));
		assertEquals(0, BitOperations.getBitValue(number, 1));
		assertEquals(1, BitOperations.getBitValue(number, 2));
	}
	
	void setBitValueTest() {
		long number = 0x3ab7f5;
		assertEquals(0x3ab7e5, BitOperations.setBitValue(number, 5, false));
		assertEquals(0x3ab7f5, BitOperations.setBitValue(number, 5, true));
	}
	
	void revertBitValueTest() {
		long number = 0x3ab7f5;
		assertEquals(0x3ab7e5, BitOperations.revertBit(number, 5));
		assertEquals(0x3ab7f5, BitOperations.revertBit(number, 0));
	}
}
