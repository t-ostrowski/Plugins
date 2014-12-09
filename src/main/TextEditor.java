package main;

import gui.Frame;
import gui.HelpMenu;
import gui.ToolsMenu;
import plugin.PluginFilter;
import plugin.PluginFinder;

public class TextEditor {

	public static void main(String[] args) throws InterruptedException {
		PluginFinder pluginFinder = new PluginFinder("bin/plugins",
				new PluginFilter());
		Frame f = new Frame();
		pluginFinder.addPluginListener(new ToolsMenu(f.getTextArea(), f));
		pluginFinder.addPluginListener(new HelpMenu(f));
		pluginFinder.startTimer();
	}
}
