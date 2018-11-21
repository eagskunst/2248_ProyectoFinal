package util;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import ui.BoxImage;

public class CustomTimer extends Timer{
	private int repetition = 0;
	private int col;
	private Random rand = new Random();
	public static boolean isAnimating = false;

	public CustomTimer(int delay, ActionListener listener) {
		super(delay, listener);
	}
	public int getRepetition() {
		return repetition;
	}
	public void setRepetition(int repetition) {
		this.repetition = repetition;
	}
	public void executeTransition(int j, BoxImage boxes[], JPanel panel, BoxImage lastBox) {
		isAnimating = true;
		boolean isLastBox = false;
		this.col = j;
		boxes[j].setVisible(false);
		boxes[j].setAdding(false);
		boxes[j].changeBorder(false);
		if(repetition<8) {
			int d = j-5;
			while(d>=0) {
				Dimension d1 = boxes[d].getPreferredSize();
				boxes[d].setBounds(boxes[d].getX(), boxes[d].getY()+5, d1.width, d1.height);
				d-=5;
			}
			repetition++;
		}
		else {
			for(int k = j;k>=0;k-=5) {
				if(boxes[k].getId() == lastBox.getId()) {
					System.out.println("entered is lastbox");
					isLastBox = true;
					col = boxes[k].getNumber();
				}
				boxes[k].setAdding(false);
				boxes[k].changeBorder(false);

				if(k-5>=0) {
					if(boxes[k-5].isAdding()) {
						if(k-10>=0) {
							boxes[k].setNumber(boxes[k-10].getNumber());
						}
					}
					else {
						boxes[k].setNumber(boxes[k-5].getNumber());
					}
				}
				else {
					int r = rand.nextInt(3);
					boxes[k].setNumber(r == 1 ? 2:4);
				}
			}
			if(isLastBox)
				boxes[j].setNumber(col);
			boxes[j].setVisible(true);
			panel.repaint();
			isAnimating = false;
			this.stop();
		}
	}
	
}
