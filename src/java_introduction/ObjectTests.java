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
	}
}