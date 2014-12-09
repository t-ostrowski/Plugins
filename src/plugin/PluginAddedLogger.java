package plugin;

import java.io.File;

/**
 * The class PluginAddedLogger will only be a class that prints in the console
 * 
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

public class PluginAddedLogger implements PluginListener {

	/**
	 * The method that prints in the console the name of the plugin after it has
	 * been added.
	 */
	public void pluginAdded(File file) {
		System.out.println("Plugin " + file.getName() + " added");
	}

	/**
	 * The method that prints in the console the name of the plugin after it has
	 * been removed.
	 */
	public void pluginRemoved(File file) {
		System.out.println("Plugin " + file.getName() + " removed");
	}
}
