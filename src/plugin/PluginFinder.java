package plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The class PluginFinder will be the class that takes all files that are
 * conform to filters and launches methods that will create items in the tool
 * and help menu.
 * 
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

public class PluginFinder implements ActionListener {

	protected final File directory;
	protected final MyTimer timer;
	protected PluginFilter filter;
	protected List<PluginListener> listeners;
	protected Set<File> alreadyFoundFiles = new HashSet<File>();
	protected static final int TIME_DELAY = 1000;

	/**
	 * The constructor of PluginFinder
	 * 
	 * @param fileName
	 *            the name of the directory that contains the plugins.
	 * @param filter
	 *            the filter of the plugins.
	 * 
	 */
	public PluginFinder(String fileName, PluginFilter filter) {
		this.directory = new File(fileName);
		this.filter = filter;
		this.timer = new MyTimer(TIME_DELAY, this);
		this.listeners = new ArrayList<PluginListener>();
	}

	/**
	 * The method that launches the research of files in the directory with a
	 * certain filter.
	 * 
	 * @return a Set of the files found
	 */
	public Set<File> selectFile() {
		PluginFilter pluginFilter = new PluginFilter();
		return pluginFilter.select(this.directory);
	}

	/**
	 * The method that adds a plugin listener to the list
	 * 
	 * @param listener
	 *            The listener that will be added to the list
	 * 
	 */
	public void addPluginListener(PluginListener listener) {
		if (!this.listeners.contains(listener)) {
			this.listeners.add(listener);
		}
	}

	/**
	 * The method that removes a plugin listener from the list
	 * 
	 * @param listener
	 *            The listener that will be removed from the list
	 * 
	 */
	public void removePluginListener(PluginListener listener) {
		this.listeners.remove(listener);
	}

	/**
	 * The method that selects the plugins that aren't already added in the
	 * menu, and stores all the plugins already added.
	 * 
	 */
	public void actionPerformed(ActionEvent event) {
		Set<File> currentFiles = selectFile();
		for (File file : currentFiles) {
			if (!this.alreadyFoundFiles.contains(file)) {
				for (PluginListener listener : listeners) {
					listener.pluginAdded(file);
				}
				this.alreadyFoundFiles.add(file);
			}
		}
		this.pluginAlreadyAdded(currentFiles);
	}

	/**
	 * The method that starts the timer used to check plugins in the directory.
	 */
	public void startTimer() {
		this.timer.start();
	}

	/**
	 * The method that adds new plugins to the Set
	 * <code>alreadyFoundFiles</code> that is used to compare each time we check
	 * files.
	 */
	public void pluginAlreadyAdded(Set<File> filesToCheck) {
		Set<File> tmpAlreadyFound = new HashSet<File>();
		for (File file : this.alreadyFoundFiles) {
			tmpAlreadyFound.add(file);
		}
		for (File file : tmpAlreadyFound) {
			if (!filesToCheck.contains(file)) {
				for (PluginListener listener : listeners) {
					listener.pluginRemoved(file);
				}
				this.alreadyFoundFiles.remove(file);
			}
		}
	}

	public List<PluginListener> getListeners() {
		return this.listeners;
	}

	public Set<File> getAlreadyFoundFiles() {
		return this.alreadyFoundFiles;
	}

	public void setAlreadyFoundFiles(Set<File> alreadyFoundFiles) {
		this.alreadyFoundFiles = alreadyFoundFiles;
	}
}
