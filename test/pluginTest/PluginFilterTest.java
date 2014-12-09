package pluginTest;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

import plugin.PluginFilter;

public class PluginFilterTest {

	@Test
	public void testSelectFilesFound() {
		PluginFilter filter = new PluginFilter();
		File file = new File("bin/plugins"); 
		assertNotNull(filter.select(file));
	}

	@Test
	public void testIsAClassFile() {
		PluginFilter filter = new PluginFilter();
		File file = new File("bin/plugins/ToUpperCase.class"); 
		assertTrue(filter.isClass(file));
	}

	@Test
	public void testIsNotAClassFile() {
		PluginFilter filter = new PluginFilter();
		File file = new File("src/plugins/ToUpperCase.java"); 
		assertFalse(filter.isClass(file));
	}

	@Test
	public void testIsImplementingPlugin() {
		PluginFilter filter = new PluginFilter();
		File file = new File("bin/plugins/ToUpperCase.class"); 
		assertTrue(filter.implementsPlugin(file));
	}
	
	@Test
	public void testIsNotImplementingPlugin() {
		PluginFilter filter = new PluginFilter();
		File file = new File("src/plugin/PluginFinder.java"); 
		assertFalse(filter.implementsPlugin(file));
	}
	
	@Test
	public void testIsInPluginsPackage() {
		PluginFilter filter = new PluginFilter();
		File file = new File("bin/plugins/ToUpperCase.class"); 
		assertTrue(filter.isInPluginsPackage(file));
	}
	
	@Test
	public void testIsNotInPluginsPackage() {
		PluginFilter filter = new PluginFilter();
		File file = new File("src/plugin/PluginFinder.java"); 
		assertFalse(filter.isInPluginsPackage(file));
	}
	
	@Test
	public void testHasAVoidConstructor() {
		PluginFilter filter = new PluginFilter();
		File file = new File("bin/plugins/ToUpperCase.class");
		assertTrue(filter.hasAVoidConstructor(file));
	}
	
	@Test
	public void testHasntAVoidConstructor() {
		PluginFilter filter = new PluginFilter();
		File file = new File("src/plugin/PluginFinder.java");
		assertFalse(filter.hasAVoidConstructor(file));
	}

	@Test
	public void testIsAccepted() {
		PluginFilter filter = new PluginFilter();
		File file = new File("bin/plugins/ToUpperCase.class"); 
		assertTrue(filter.isClass(file));
		assertTrue(filter.implementsPlugin(file));
		assertTrue(filter.isInPluginsPackage(file));
		assertTrue(filter.hasAVoidConstructor(file));
		assertTrue(filter.accept(file, file.getName()));
	}

	@Test
	public void testIsNotAccepted() {
		PluginFilter filter = new PluginFilter();
		File file = new File("bin/plugin/PluginFinder.class");
		assertTrue(filter.isClass(file));
		assertFalse(filter.implementsPlugin(file));
		assertFalse(filter.isInPluginsPackage(file));
		assertFalse(filter.hasAVoidConstructor(file));
		assertFalse(filter.accept(file, file.getName()));
	}
}
