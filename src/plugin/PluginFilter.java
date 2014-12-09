package plugin;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

/**
 * The class PluginFilter will be the class that checks if a file is well made
 * and can be added to the application as a plugin.
 * 
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

public class PluginFilter implements FilenameFilter {

	protected final static String PACKAGE_NAME = "plugins";

	/**
	 * The method that takes all the files in the directory passed in parameter
	 * and launches the method that will check filters.
	 * 
	 * @param directory
	 *            the directory where the files we check come from.
	 * 
	 * @return a Set of Files <code>acceptedFilesFound</code>
	 */
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

	/**
	 * The method that launches all other methods known as filters on all the
	 * files in the directory passed in parameter.
	 * 
	 * @param file
	 *            the file that will be tested.
	 * @param name
	 *            the name of the file, useless in this case.
	 * 
	 */
	public boolean accept(File file, String name) {
		return isClass(file) && implementsPlugin(file)
				&& isInPluginsPackage(file) && hasAVoidConstructor(file);
	}

	/**
	 * The method that tests if the file passed in parameter is a ".class".
	 * 
	 * @param file
	 *            the file that will be tested.
	 * 
	 * @return true only if the file is conform
	 */
	public boolean isClass(File file) {
		String lowercaseName = file.getName().toLowerCase();
		return lowercaseName.endsWith(".class");
	}

	/**
	 * The method that tests if the file passed in parameter implements Plugin.
	 * 
	 * @param file
	 *            the file that will be tested.
	 * 
	 * @return true only if the file is conform
	 */
	public boolean implementsPlugin(File file) {
		try {
			Class<?> c = Class.forName(PACKAGE_NAME + "."
					+ file.getName().substring(0, file.getName().length() - 6));
			for (Class<?> cl : c.getInterfaces()) {
				if (cl.getName().equals(PACKAGE_NAME + "." + "Plugin")) {
					return true;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * The method that tests if the file passed in parameter is in the plugins
	 * package.
	 * 
	 * @param file
	 *            the file that will be tested.
	 * 
	 * @return true only if the file is conform
	 */
	public boolean isInPluginsPackage(File file) {
		try {
			Class<?> c = Class.forName(PACKAGE_NAME + "."
					+ file.getName().substring(0, file.getName().length() - 6));
			if (c.getPackage().getName().equals(PACKAGE_NAME)) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * The method that tests if the file passed in parameter has a void
	 * constructor.
	 * 
	 * @param file
	 *            the file that will be tested.
	 * 
	 * @return true only if the file is conform
	 */
	public boolean hasAVoidConstructor(File file) {
		try {
			Class<?> c = Class.forName(PACKAGE_NAME + "."
					+ file.getName().substring(0, file.getName().length() - 6));
			if (c.getConstructors().length != 0) {
				for (Constructor<?> cons : c.getConstructors()) {
					if (cons.getParameterTypes().length == 0) {
						return true;
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}
}
