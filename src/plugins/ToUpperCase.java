package plugins;


/** This pluginTest transforms all the letters to upper case
 * 
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

public class ToUpperCase implements Plugin {
	
	/** transform all the letters to upper case
	 * @see plugins.Plugin#transform(java.lang.String)
	 */
	public String transform(String s) {
		return s.toUpperCase();
	}

	/**
	 * @see plugins.Plugin#getLabel()
	 */
	public String getLabel() {
		return "to upper case";
	}

	/**
	 * @see plugins.Plugin#helpMessage()
	 */
	public String helpMessage() {
		return "Transform all the letters to upper case";
	}
}
