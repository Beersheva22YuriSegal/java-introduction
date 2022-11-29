package telran.text;

import static org.junit.jupiter.api.Assertions.*;
import static telran.text.Strings.*;

import org.junit.jupiter.api.*;

public class StringsTest {
	@Test
	@Disabled
	void javaVariableTest() {
		assertTrue("java".matches(javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));
	}
	@Test
	void ipV4OctetTest() {
		assertTrue("089".matches(ipV4Octet()));
		assertTrue("010".matches(ipV4Octet()));
		assertTrue("001".matches(Strings.ipV4Octet()));
		assertTrue("255".matches(ipV4Octet()));
		assertTrue("0".matches(Strings.ipV4Octet()));
		assertTrue("1".matches(ipV4Octet()));
		assertTrue("12".matches(Strings.ipV4Octet()));
		assertFalse("".matches(ipV4Octet()));
		assertFalse("0000".matches(Strings.ipV4Octet()));
		assertFalse("326".matches(ipV4Octet()));
		assertFalse("256".matches(Strings.ipV4Octet()));
		assertFalse("-1".matches(ipV4Octet()));
	}
	@Test
	void ipV4TestTrue() {
		assertTrue("089.045.120.230".matches(Strings.ipV4()));
		assertTrue("0.0.0.0".matches(Strings.ipV4()));
		assertTrue("123.245.213.224".matches(Strings.ipV4()));
		assertTrue("255.255.255.255".matches(Strings.ipV4()));
		assertTrue("1.4.4.6".matches(Strings.ipV4()));
	}

	@Test
	void ipV4TestFalse() {
		assertFalse("123.345.1234.123".matches(Strings.ipV4()));
		assertFalse("*.345.1234.123".matches(Strings.ipV4()));
		assertFalse("123.".matches(Strings.ipV4()));
		assertFalse("_/".matches(Strings.ipV4()));
	}
	
	@Test
	void isArithmeticExpressionTest() {
		assertTrue(isArithmeticExpression("10 * (2) + 3 "));
		assertTrue(isArithmeticExpression("10 * 2 + 3))"));
		assertTrue(isArithmeticExpression("((((4 + ((.135)"));
		assertFalse(isArithmeticExpression("10 * 2( + 3)"));
		assertFalse(isArithmeticExpression("10 * )2) + 3"));
		assertFalse(isArithmeticExpression("7 / ))2) + 3"));
		assertTrue(isArithmeticExpression("a + b + c * 4 + (( .5"));
		assertFalse(isArithmeticExpression("a + b + c * 4 + (( -.135"));
		assertFalse(isArithmeticExpression("java + * 4 + (( .135"));
		assertFalse(isArithmeticExpression("1a * 4 + (( .5"));
	}
	
	@Test
	void computeExpressionTest() {
		assertEquals(10.5, computeArithmeticExpression("2 + 2 + 1 * 2 + 0.5", null, null));
		assertTrue(Double.isNaN(computeArithmeticExpression("2 # 2 ++ 10", null, null)));
		assertEquals(10.5, computeArithmeticExpression("i + 1 + j * 2 + 0.5", new double[] { 1, 2 }, new String[] { "i", "j" }));
		assertTrue(Double.isNaN(computeArithmeticExpression("i + 1 + j * 2 + c11", new double[] { 1, 2 }, new String[] { "i", "j" })));
		assertFalse(Double.isNaN(computeArithmeticExpression("i + 1 + j * 2 + cass11", new double[] { 1, 2 }, new String[] { "i", "j" })));
	}
	
	@Test
	void checkBracesTest() {
		assertTrue(checkBraces("()"));
		assertTrue(checkBraces("((()))"));
		assertFalse(checkBraces("(()"));
		assertFalse(checkBraces(")"));
		assertFalse(checkBraces("("));
	}

}
