package plugin;

import java.io.File;

import plugins.Plugin;

/**
 * The class Convertor is used to convert a File into a Plugin.
 * 
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

public class Convertor {

	public Convertor() {
	}

	/**
	 * Converts a file into a plugin, it's the same effect as a cast.
	 * 
	 * @param filePlugin
	 *            the file that will be casted as a plugin
	 * 
	 * @return the plugin obtained after the cast.
	 */
	public Plugin convert(File filePlugin) {

		ClassLoader loader = new PluginLoader();
		Class<?> pluginClass = null;
		int index = filePlugin.getName().indexOf(".");

		try {
			pluginClass = loader.loadClass("plugins."
					+ filePlugin.getName().substring(0, index));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Plugin plugin = null;

		try {
			plugin = (Plugin) pluginClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return plugin;
	}
}