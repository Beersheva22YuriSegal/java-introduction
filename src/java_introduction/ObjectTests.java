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
	
}