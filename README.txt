Project 4: Plugins
=============
Names:
BOMY Valentin
OSTROWSKI Thomas
(Team number 3) 

10.12.2014

Summary:
1) Description of the application
2) Code Structure
3) Code Samples
4) Known bugs

1)
	The application is a text editor, you can use several plugins on a
	text area(ToUpperCase, ToLowerCase, RemoveVowels, CesarCode) to modify the content.
	There is a graphical user interface (GUI) and plugins can be added end removed
	while the application is running.

2)
	You can see the code structure clearly thanks to the UML.jpeg file
	
3)
	PluginFinder:
	
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
	
	PluginFilter:
	
	public Set<File> select(File directory) {
		Set<File> acceptedFilesFound = new HashSet<File>();
		if (directory.isDirectory()) {
			for (File f : directory.listFiles()) {
				if (accept(f, f.getName())) {
					acceptedFilesFound.add(f);
				}
			}
		}
		return acceptedFilesFound;
	}
	
4)
	There is no specific known bug.