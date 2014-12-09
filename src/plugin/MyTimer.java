package plugin;

import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * MyTimer is a personalized Timer
 * @author Thomas OSTROWSKI - Valentin BOMY
 */

@SuppressWarnings("serial")
public class MyTimer extends Timer {

	public MyTimer(int delay, ActionListener listener) {
		super(delay, listener);
	}
}
