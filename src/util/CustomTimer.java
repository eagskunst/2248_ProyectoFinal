package util;

import java.awt.event.ActionListener;

import javax.swing.Timer;

public class CustomTimer extends Timer{
	private int repetition;
	public CustomTimer(int delay, ActionListener listener) {
		super(delay, listener);
		
	}
	

}
