package telran.text;

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

	
}