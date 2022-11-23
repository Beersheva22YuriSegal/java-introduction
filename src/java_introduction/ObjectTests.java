package java_introduction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class ObjectTests {

	@Test
	@Disabled
	void wrapperTest() {
		Integer a = 11;
		Integer b = 11;
		assertEquals(a, b);
		Integer c = 201;
		Integer d = 201;
		assertEquals(c, d);
		assertTrue(a == b);
		assertFalse(c == d);
		assertTrue(c.equals(d));
	}
	@Test
	@Disabled
	void stringTest() {
		String hello = "hello";
		char[] helloAr = hello.toCharArray();
		assertEquals('e', helloAr[1]);
		System.out.println((byte)helloAr[4]);
		assertEquals(5, hello.length());
	}
	@Test
	@Disabled
	void isAnagramTest() {
		String word = "java code";
		assertTrue(Strings.isAnagram(word, "ced ovaja"));
		assertTrue(Strings.isAnagram(word, "aajvo cde"));
		assertTrue(Strings.isAnagram(word, "ed ocavaj"));
		assertFalse(Strings.isAnagram(word, "a a a veocde"));
		assertFalse(Strings.isAnagram(word, "vavavava"));
		
		String word1 = "hello Israel";
		assertTrue(Strings.isAnagram(word1, "olIelle hars"));
		assertFalse(Strings.isAnagram(word1, "olielle hars"));
	}
	
	@Test
	@Disabled
	void sortStringNumbersTest() {
		String[] array = { "37", "7", "-3", "41", "0", "-128", "7", "7", "-10", "-10", "127" };
		String[] expected = { "-128", "-10", "-10", "-3", "0", "7", "7", "7", "37", "41", "127" };
		Strings.sortStringNumbers(array);
		assertArrayEquals(expected, array);
	}
	@Test
	void javaVariableTest() {
		assertTrue("java".matches(Strings.javaNameExp()));
		assertFalse("1java".matches(Strings.javaNameExp()));
		assertFalse("_".matches(Strings.javaNameExp()));
		assertTrue("__".matches(Strings.javaNameExp()));
		assertTrue("java_1_2".matches(Strings.javaNameExp()));
		assertTrue("$".matches(Strings.javaNameExp()));
		assertFalse("$ _".matches(Strings.javaNameExp()));
	}
	@Test
	void ipV4Octet() {
		assertTrue("089".matches(Strings.ipV4Octet()));
		assertTrue("010".matches(Strings.ipV4Octet()));
		assertTrue("001".matches(Strings.ipV4Octet()));
		assertTrue("255".matches(Strings.ipV4Octet()));
		assertTrue("0".matches(Strings.ipV4Octet()));
		assertTrue("1".matches(Strings.ipV4Octet()));
		assertTrue("12".matches(Strings.ipV4Octet()));
		assertFalse("".matches(Strings.ipV4Octet()));
		assertFalse("0000".matches(Strings.ipV4Octet()));
		assertFalse("326".matches(Strings.ipV4Octet()));
		assertFalse("256".matches(Strings.ipV4Octet()));
		assertFalse("-1".matches(Strings.ipV4Octet()));
	}
	@Test
	void ipV4() {
		assertTrue("255.255.255.255".matches(Strings.ipV4()));
		assertTrue("0.0.0.0".matches(Strings.ipV4()));
		assertTrue("195.155.1.1".matches(Strings.ipV4()));
		assertFalse("256.255.255.256".matches(Strings.ipV4()));
		assertFalse("255.255255.255".matches(Strings.ipV4()));
		assertFalse("255.255.255.-1".matches(Strings.ipV4()));
		assertFalse("255.255.255".matches(Strings.ipV4()));
		assertFalse("255.255".matches(Strings.ipV4()));
		assertFalse("255".matches(Strings.ipV4()));
	}
	
}