package gui;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * The class FileMenu generate the menu File in the frame.
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

@SuppressWarnings("serial")
public class FileMenu extends JMenu {

	public FileMenu() {
		super("File");
		this.add(new JMenuItem("New"));
		this.add(new JMenuItem("Open"));
		this.addSeparator();
		this.add(new JMenuItem("Save"));
		this.add(new JMenuItem("Save as"));
		this.addSeparator();
		this.add(new JMenuItem("Exit"));
	}
}
