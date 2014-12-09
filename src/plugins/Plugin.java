package plugins;

/**
 * represents a pluginTest that can be dynamiccaly added to the extendable editor.
 * A pluginTest can perform a transformation on a String.
 * A menu item corresponds to a a pluginTest in the editor. The label of this item is given by the <code>getLabel</code> methid.
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

public interface Plugin {
	
	/** performs a transformation on a string 
	 * @param s the string to be transformed
	 * @return the transformed string
	 */
	public String transform(String s) ;

	/** returns a label associated to this pluginTest.
	 * @return a label associated to this pluginTest.
	 */
	public String getLabel() ;
	
	/** a help message describing the pluginTest tranformation operation
	 * @return a help message describing the pluginTest tranformation operation
	 */
	public String helpMessage();
}
