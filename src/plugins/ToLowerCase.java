package plugins;


/** This pluginTest transforms all the letters to lower case
 * 
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

public class ToLowerCase implements Plugin {
	
	/** transform all the letters to lower case
	 * @see plugins.Plugin#transform(java.lang.String)
	 */
	public String transform(String s) {
		return s.toLowerCase();
	}

	/**
	 * @see plugins.Plugin#getLabel()
	 */
	public String getLabel() {
		return "to lower case";
	}

	/**
	 * @see plugins.Plugin#helpMessage()
	 */
	public String helpMessage() {
		return "Transform all the letters to lower case";
	}
}

