package java_introduction;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ObjectTests {

	@Test
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
	void stringTest() {
		String hello = "hello";
		char[] helloAr = hello.toCharArray();
		assertEquals('e', helloAr[1]);
		System.out.println((byte)helloAr[4]);
		assertEquals(5, hello.length());
	}
	@Test
	void isAnagramTest() {
		assertTrue(Strings.isAnagram("javacode", "cedovaja"));
		assertTrue(Strings.isAnagram("javacode", "aajveocde"));
		assertTrue(Strings.isAnagram("javacode", "edocavaj"));
		assertFalse(Strings.isAnagram("javacode", "aaaveocde"));
		assertFalse(Strings.isAnagram("javacode", "vavavava"));
	}
	
}