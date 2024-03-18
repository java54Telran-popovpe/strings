package relran.strings.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import relran.strings.RegularExpressions;

class RegularExpressionsTests {

	@Test
	void javaVariableTrueTest() {
		String regex = RegularExpressions.javaVariable();
		assertTrue( "abc".matches(regex));
		assertTrue( "a".matches(regex));
		assertTrue( "$".matches(regex));
		assertTrue( "$123".matches(regex));
		assertTrue( "$1_23".matches(regex));
		assertTrue( "abs_".matches(regex));
		assertTrue( "__".matches(regex));
		assertTrue( "Abs_".matches(regex));
	}
	
	@Test
	void javaVariableFalseTest() {
		String regex = RegularExpressions.javaVariable();
		assertFalse("1abc".matches(regex));
		assertFalse("_".matches(regex));
		assertFalse("a-2".matches(regex));
		assertFalse("a 2".matches(regex));
		assertFalse("i*nt".matches(regex));
	}
	

	@Test
	void zero_300TrueTest() {
		String regex = RegularExpressions.zero_300();
		assertTrue( "0".matches(regex));
		assertTrue( "1".matches(regex));
		assertTrue( "19".matches(regex));
		assertTrue( "99".matches(regex));
		assertTrue( "198".matches(regex));
		assertTrue( "300".matches(regex));
		assertTrue( "30".matches(regex));
		assertTrue( "33".matches(regex));
		assertTrue( "299".matches(regex));
	}
	@Test
	void zero_300FalseTest() {
		String regex = RegularExpressions.zero_300();
		assertFalse( "00".matches(regex));
		assertFalse( "01".matches(regex));
		assertFalse( "19s".matches(regex));
		assertFalse( "398".matches(regex));
		assertFalse( "2990".matches(regex));
		assertFalse( "300 ".matches(regex));
		assertFalse( "-30".matches(regex));
		assertFalse( "330".matches(regex));
		assertFalse( "301".matches(regex));
	}
	
	@Test
	void ipOctetTest() {
		String regex = RegularExpressions.ipOctet();
		assertTrue("0".matches(regex));
		assertTrue("7".matches(regex));
		assertTrue("00".matches(regex));
		assertTrue("000".matches(regex));
		assertTrue("10".matches(regex));
		assertTrue("19".matches(regex));
		assertTrue("199".matches(regex));
		assertTrue("009".matches(regex));
		assertTrue("255".matches(regex));
		assertTrue("250".matches(regex));
		assertTrue("249".matches(regex));
		assertFalse("-0".matches(regex));
		assertFalse("00 ".matches(regex));
		assertFalse("0000".matches(regex));
		assertFalse("10?".matches(regex));
		assertFalse("1900".matches(regex));
		assertFalse("299".matches(regex));
		assertFalse("00a".matches(regex));
		assertFalse("256".matches(regex));
		assertFalse("260".matches(regex));
		assertFalse("300".matches(regex));
	}
	
	@Test
	void ipIsraelMobileNumberTest() {
		String regex = RegularExpressions.mobileIsraelNumber();
		assertTrue("+972533736033".matches(regex));
			assertFalse("+97253373633".matches(regex)); // //wrong length ( less )
			assertFalse("+9725337536033".matches(regex)); //wrong length (greater)
			assertFalse("972533736033".matches(regex)); //absence of a plus
			assertFalse("+725337360337".matches(regex)); //wrong prefix
		assertTrue("+972-53-37-36-0-33".matches(regex));
			assertFalse("+9-7253-37-36-033".matches(regex)); //hyphen in the wrong place
			assertFalse("+972-53-37--36-0-33".matches(regex)); //double hyphen
		assertTrue("0533736033".matches(regex));
			assertFalse("0533t36033".matches(regex)); //use a character instead of digit
			assertFalse("053736033".matches(regex)); //wrong length ( less 
			assertFalse("05337360833".matches(regex)); //wrong length (greater)
			assertFalse("533736033".matches(regex)); //absence of a zero in prefix 
			assertFalse("0433736033".matches(regex)); //wrong prefix
		assertTrue("053-37-36-0-3-3".matches(regex));
			assertFalse("0-53-37-36-0-33".matches(regex)); //hyphen in the wrong place
			assertFalse("053--37-36-0-3-3".matches(regex)); //double hyphen
			assertFalse("053--37-36-0--3-3".matches(regex)); //double hyphen
	}
	
}
