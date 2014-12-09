package pluginsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.CesarCode;

public class CesarCodeTest {

	@Test
	public void testTransformClassicCesarCode() {
		CesarCode cesarCode = new CesarCode();
		String s = "abcd";
		assertEquals(cesarCode.transform(s), "bcde");
	}

	@Test
	public void testTransformCesarCodeWithShiftOfTwoCharacters() {
		CesarCode cesarCode = new CesarCode(2);
		String s = "abcd";
		assertEquals(cesarCode.transform(s), "cdef");
	}
	
	@Test
	public void testLabelClassicCesarCode() {
		CesarCode cesarCode = new CesarCode();
		assertEquals(cesarCode.getLabel(), "Cesar Code 1");
	}

	@Test
	public void testLabelCesarCodeWithShiftOfTwoCharacters() {
		CesarCode cesarCode = new CesarCode(2);
		assertEquals(cesarCode.getLabel(), "Cesar Code 2");
	}
	
	@Test
	public void testHelpMessage() {
		CesarCode cesarCode = new CesarCode();
		assertEquals(cesarCode.helpMessage(), "Apply a Cesar code to the text (ie. a shift by 1 character)");
	}
}
