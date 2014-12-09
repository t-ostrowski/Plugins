package pluginTest;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import plugin.PluginAddedLogger;
import plugin.PluginFilter;
import plugin.PluginFinder;

public class PluginFinderTest {

	@Test
	public void testSelectFiles() {
		String path = "bin/plugins"; 
		PluginFilter filter = new PluginFilter();
		PluginFinder finder = new PluginFinder(path, filter);
		assertNotNull(finder.selectFile());
	}
	
	@Test
	public void testAddingListener() {
		String path = "bin/plugins"; 
		PluginFilter filter = new PluginFilter();
		PluginFinder finder = new PluginFinder(path, filter);
		int nbListeners = finder.getListeners().size();
		finder.addPluginListener(new PluginAddedLogger());
		assertEquals(finder.getListeners().size(), nbListeners+1);
	}

	@Test
	public void testRemovingListener() {
		String path = "bin/plugins"; 
		PluginFilter filter = new PluginFilter();
		PluginFinder finder = new PluginFinder(path, filter);
		PluginAddedLogger pal = new PluginAddedLogger();
		finder.addPluginListener(new PluginAddedLogger());
		finder.addPluginListener(pal);
		int nbListeners = finder.getListeners().size();
		finder.removePluginListener(pal);
		assertEquals(finder.getListeners().size(), nbListeners-1);
	}
	
	@Test
	public void testFilesAlreadyAdded() {
		String path = "bin/plugins"; 
		PluginFilter filter = new PluginFilter();
		PluginFinder finder = new PluginFinder(path, filter);
		
		Set<File> alreadyAdded = new HashSet<File> ();
		Set<File> toCheck = new HashSet<File> ();
		
		File file1 = new File("bin/plugins/ToUpperCase.class");
		File file2 = new File("bin/plugins/CesarCode.class");
		alreadyAdded.add(file1);
		
		finder.setAlreadyFoundFiles(alreadyAdded);
		
		toCheck.add(new File("bin/plugins/ToUpperCase.class"));
		toCheck.add(new File("bin/plugins/CesarCode.class"));
		
		assertTrue(finder.getAlreadyFoundFiles().contains(file1));
		assertFalse(finder.getAlreadyFoundFiles().contains(file2));
		
		finder.pluginAlreadyAdded(toCheck);
		
		assertTrue(finder.getAlreadyFoundFiles().contains(file1));
	}
}
