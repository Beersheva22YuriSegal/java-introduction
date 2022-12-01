package telran.digital.numbers.tests;

import org.junit.jupiter.api.Disabled;
import static telran.digital.numbers.DigitalNumbersPrinting.*;
import org.junit.jupiter.api.Test;

public class DigitalPrintingTest {
	@Test
	@Disabled
	void lineTest() {
		System.out.println(line(30, 30));
	}

	@Test
	@Disabled
	void rightVerticalLineTest() {
		displayStrings(verticalLine(30, 5, 5));
	}
	
	@Test
	@Disabled
	void twoVerticalLinesTest() {
		displayStrings(twoVerticalLines(30, 10, 5));
	}

	@Test
	@Disabled
	void zeroTest() {
		displayStrings(zero(30, 5, 4));
	}

	@Test
	@Disabled
	void oneTest() {
		displayStrings(one(30, 5, 5));
	}

	@Test
	@Disabled
	void twoTest() {
		displayStrings(two(30, 7, 7));
	}
	
	@Test
	@Disabled
	void threeTest() {
		displayStrings(three(30, 5, 5));
	}
	
	@Test
	@Disabled
	void fourTest() {
		displayStrings(four(30, 5, 5));
	}
	
	@Test
	@Disabled
	void fiveTest() {
		displayStrings(five(30, 7, 7));
	}
	@Test
	@Disabled
	void sixTest() {
		displayStrings(six(30, 7, 7));
	}
	@Test
	@Disabled
	void sevenTest() {
		displayStrings(seven(30, 7, 7));
	}
	@Test
	@Disabled
	void eightTest() {
		displayStrings(eight(30, 7, 7));
	}
	@Test
	@Disabled
	void nineTest() {
		displayStrings(nine(30, 7, 7));
	}
	@Test
	@Disabled
	void displayDigitalNumberTest() {
	displayDigitalNumber(1234567890, 10, 6, 8);
	}
}