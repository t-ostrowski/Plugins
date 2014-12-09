package gui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import plugin.PluginFilter;
import plugin.PluginFinder;

/**
 * The class Frame generate all components in the graphic user interface.
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

@SuppressWarnings("serial")
public class Frame extends JFrame {
	
	protected Menu menu;
	protected JTextArea textArea;
	protected JPanel panel;
	protected PluginFinder finder;
	protected static final int WIDTH = 500;
	protected static final int HEIGHT = 350;
	
	public Frame() {
		super("Extendable Editor");
		this.finder = new PluginFinder("bin/plugins", new PluginFilter());
		this.textArea = new JTextArea();
		this.menu = new Menu(textArea, this);
		
		this.panel = new JPanel();
		this.panel.setLayout(new GridLayout());
		this.add(panel);
		this.panel.add(textArea);
		this.panel.add(new JScrollPane(textArea));
			
		this.setSize(WIDTH,HEIGHT);
		this.setJMenuBar(getMenu());
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Menu getMenu() {
		return menu;
	}
	
	public JTextArea getTextArea() {
		return this.textArea;
	}
}
