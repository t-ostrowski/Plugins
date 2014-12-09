package plugin;

import java.io.File;
import java.util.EventListener;

/**
 * The interface PluginListener that defines the methods that have to be used by
 * all the plugin listeners
 * 
 * @author Thomas OSTROWSKI - Valentin BOMY
 * 
 */

public interface PluginListener extends EventListener {

	/**
	 * The action that will be done when a plugin is added.
	 * 
	 * @param file
	 *            the file that will be used as a plugin
	 */
	public abstract void pluginAdded(File file);

	/**
	 * The action that will be done when a plugin is removed.
	 * 
	 * @param file
	 *            the file that will be used as a plugin
	 */
	public abstract void pluginRemoved(File file);
}
