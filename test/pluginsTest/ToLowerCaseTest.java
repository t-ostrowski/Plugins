package pluginsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.ToLowerCase;

public class ToLowerCaseTest {

	@Test
	public void testTransform() {
		ToLowerCase toLowerCase = new ToLowerCase();
		String s = "Bonjour";
		assertEquals(toLowerCase.transform(s), "bonjour");
	}

	@Test
	public void testLabel() {
		ToLowerCase toUpperCase = new ToLowerCase();
		assertEquals(toUpperCase.getLabel(), "to lower case");
	}

	@Test
	public void testHelpMessage() {
		ToLowerCase toUpperCase = new ToLowerCase();
		assertEquals(toUpperCase.helpMessage(), "Transform all the letters to lower case");
	}
}
