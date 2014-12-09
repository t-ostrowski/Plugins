package gui;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import plugin.Convertor;
import plugin.PluginFilter;
import plugin.PluginFinder;
import plugin.PluginListener;
import plugins.Plugin;

/**
 * The class HelpMenu generate each item in the help menu, depends of the
 * plugins found.
 * 
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

@SuppressWarnings("serial")
public class HelpMenu extends JMenu implements PluginListener {

	protected Set<File> plugins;
	protected PluginFinder finder;
	protected Frame frame;
	protected Map<JMenuItem, String> pluginAlreadyFound;

	public HelpMenu(Frame f) {
		super("Help");
		plugins = new HashSet<File>();
		this.finder = new PluginFinder("bin/plugins", new PluginFilter());
		this.frame = f;
		this.pluginAlreadyFound = new HashMap<JMenuItem, String>();
	}

	/**
	 * The method that converts the file into a plugin and then add it as an
	 * item in the Help menu.
	 * 
	 * @param file
	 *            file that will be added in the menu.
	 */
	public void pluginAdded(File file) {
		JMenuItem item;
		final Convertor convertor = new Convertor();
		this.removeAll();
		item = new JMenuItem(file.getName().substring(0,
				file.getName().length() - 6));
		this.frame.getMenu().getHelpMenu().add(item);
		this.pluginAlreadyFound.put(item, file.getName());
		System.out.println("Help " + file.getName() + " added");
		final Plugin plugin = convertor.convert(file);
		item.addActionListener(new HelpItemMenu(plugin));
	}

	/**
	 * The method that removes all the plugins in the Help Menu that aren't in
	 * the Map <code>pluginAlreadyFoundTmp</code>.
	 * 
	 * @param file
	 *            file that will be removed from the menu.
	 */
	public void pluginRemoved(File file) {
		Map<JMenuItem, String> pluginAlreadyFoundTmp = new HashMap<JMenuItem, String>();
		pluginAlreadyFoundTmp.putAll(this.pluginAlreadyFound);
		for (JMenuItem item : pluginAlreadyFoundTmp.keySet()) {
			if (this.pluginAlreadyFound.get(item).equals(file.getName())) {
				this.frame.getMenu().getHelpMenu().remove(item);
				this.pluginAlreadyFound.remove(item);
				System.out.println("Help " + file.getName() + " removed");
			}
		}
	}
}
