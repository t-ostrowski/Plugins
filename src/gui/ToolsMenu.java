package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

import plugin.Convertor;
import plugin.PluginFinder;
import plugin.PluginListener;
import plugins.Plugin;

/**
 * The class ToolsMenu generates each item in the Tools menu, depends of the
 * plugins found.
 * 
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

@SuppressWarnings("serial")
public class ToolsMenu extends JMenu implements PluginListener {

	protected Set<File> plugins;
	protected JTextArea textArea;
	protected PluginFinder finder;
	protected Frame frame;
	protected Map<JMenuItem, String> pluginAlreadyFound;
	protected static final int DELETE_CLASS_EXTENSION = 6;

	public Set<File> getPlugins() {
		return plugins;
	}

	public ToolsMenu(JTextArea textArea, Frame f) {
		super("Tools");
		this.frame = f;
		plugins = new HashSet<File>();
		this.textArea = textArea;
		this.pluginAlreadyFound = new HashMap<JMenuItem, String>();
	}

	/**
	 * The method that transforms the text according to the item that have been
	 * chosen.
	 * 
	 * @param plugin
	 *            plugin that have been chosen.
	 */
	public void transformTextArea(Plugin plugin) {
		System.out.println("Text before transformation : "
				+ this.textArea.getText());
		this.textArea.setText(plugin.transform(this.textArea.getText()));
		System.out.println("Text after transformation : "
				+ this.textArea.getText());
	}

	/**
	 * The method that converts the file into a plugin and then add it as an
	 * item in the Tools menu.
	 * 
	 * @param file
	 *            file that will be added in the menu.
	 */
	public void pluginAdded(File file) {
		JMenuItem item;
		final Convertor convertor = new Convertor();
		this.removeAll();
		item = new JMenuItem(file.getName().substring(0,
				file.getName().length() - DELETE_CLASS_EXTENSION));
		this.frame.getMenu().getToolsMenu().add(item);
		this.pluginAlreadyFound.put(item, file.getName());
		System.out.println("Plugin " + file.getName() + " added");
		final Plugin plug = convertor.convert(file);
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				transformTextArea(plug);
			}
		});
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
				this.frame.getMenu().getToolsMenu().remove(item);
				this.pluginAlreadyFound.remove(item);
				System.out.println("Plugin " + file.getName() + " removed");
			}
		}
	}
}
