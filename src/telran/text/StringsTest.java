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
	void ipVTest() {
		assertTrue("255.255.255.255".matches(ipV4()));
		assertTrue("0.0.0.0".matches(ipV4()));
		assertTrue("195.155.1.1".matches(ipV4()));
		assertFalse("256.255.255.256".matches(ipV4()));
		assertFalse("255.255255.255".matches(ipV4()));
		assertFalse("255.255.255.-1".matches(Strings.ipV4()));
		assertFalse("255.255.255".matches(Strings.ipV4()));
		assertFalse("255.255".matches(Strings.ipV4()));
		assertFalse("255".matches(Strings.ipV4()));
	}

}
