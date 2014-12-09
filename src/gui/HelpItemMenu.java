package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JOptionPane;

import plugins.Plugin;

/**
 * The class HelpItemMenu generates the content of the action of each item in
 * the Help Menu
 * 
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

@SuppressWarnings("serial")
public class HelpItemMenu extends JMenu implements ActionListener {

	protected Plugin plugin;

	public HelpItemMenu(Plugin plugin) {
		super(plugin.getLabel());
		this.plugin = plugin;
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, plugin.helpMessage(),
				plugin.getLabel(), JOptionPane.INFORMATION_MESSAGE);
	}
}
