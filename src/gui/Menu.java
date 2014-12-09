package gui;

import javax.swing.JMenuBar;
import javax.swing.JTextArea;

/**
 * The class Menu generates the bar that will contains each menu.
 * @author Thomas OSTROWSKI - Valentin BOMY 
 */

@SuppressWarnings("serial")
public class Menu extends JMenuBar {

	protected JTextArea textArea;
	protected FileMenu fileMenu;
	protected ToolsMenu toolsMenu;
	protected HelpMenu helpMenu;
	protected Frame frame;

	public Menu(JTextArea textArea, Frame f) {
		super();
		this.frame = f;
		this.fileMenu = new FileMenu();
		this.add(fileMenu);
		this.toolsMenu = new ToolsMenu(textArea, this.frame);
		this.add(toolsMenu);
		this.helpMenu = new HelpMenu(this.frame);
		this.add(helpMenu);
	}

	public ToolsMenu getToolsMenu() {
		return this.toolsMenu;
	}

	public HelpMenu getHelpMenu() {
		return this.helpMenu;
	}
}
