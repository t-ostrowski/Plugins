package main;

import plugin.PluginAddedLogger;
import plugin.PluginFilter;
import plugin.PluginFinder;

public class PluginAddedLoggerMain {

	public static void main(String[] args) {
		PluginFinder plug = new PluginFinder("bin/plugins", new PluginFilter());
		plug.addPluginListener(new PluginAddedLogger());
		plug.startTimer();
		while (true);
	}
}
