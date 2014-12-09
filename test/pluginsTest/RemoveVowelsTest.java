package pluginsTest;

import static org.junit.Assert.*;

import org.junit.Test;

import plugins.RemoveVowels;

public class RemoveVowelsTest {

	@Test
	public void testTransform() {
		RemoveVowels removeVowels = new RemoveVowels();
		String s = "AEIOUYaeiouy";
		assertEquals(removeVowels.transform(s), "");
	}

	@Test
	public void testLabel() {
		RemoveVowels removeVowels = new RemoveVowels();
		assertEquals(removeVowels.getLabel(), "remove vowels");
	}
	
	@Test
	public void testHelpMessage() {
		RemoveVowels removeVowels = new RemoveVowels();
		assertEquals(removeVowels.helpMessage(), "Remove all the vowels");
	}
}
