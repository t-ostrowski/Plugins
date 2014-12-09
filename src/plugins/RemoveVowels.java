package plugins;


/** This pluginTest removes all the vowels
 * 
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

public class RemoveVowels implements Plugin {

	/** removes all the vowels
	 * @see plugins.Plugin#transform(java.lang.String)
	 */
	public String transform(String s) {
		return s.replaceAll("[AEIOUYaeiouy]", "");
	}

	/**
	 * @see plugins.Plugin#getLabel()
	 */
	public String getLabel() {
		return "remove vowels";
	}

	/**
	 * @see plugins.Plugin#helpMessage()
	 */
	public String helpMessage() {
		return "Remove all the vowels";
	}
}
