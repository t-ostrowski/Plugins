package pluginsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.ToUpperCase;

public class ToUpperCaseTest {

	@Test
	public void testTransform() {
		ToUpperCase toUpperCase = new ToUpperCase();
		String s = "Bonjour";
		assertEquals(toUpperCase.transform(s), "BONJOUR");
	}

	@Test
	public void testLabel() {
		ToUpperCase toUpperCase = new ToUpperCase();
		assertEquals(toUpperCase.getLabel(), "to upper case");
	}

	@Test
	public void testHelpMessage() {
		ToUpperCase toUpperCase = new ToUpperCase();
		assertEquals(toUpperCase.helpMessage(), "Transform all the letters to upper case");
	}
}
