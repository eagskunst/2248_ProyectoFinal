package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import listeners.BoxMouseListener;

public class Tablero extends JPanel{
	
	static int count = 0;
	
	public Tablero() {
		setFocusable(true);
		configurate();
		setLayout(new FlowLayout());
	}
	
	private void configurate() {
		JPanel panel = new JPanel();

        GridLayout layout = new GridLayout(7,5);
        layout.setHgap(10);
        layout.setVgap(10);
        panel.setLayout(layout);
		setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		BoxImage[] boxes = new BoxImage[35];
		int r = 1;
		int c = 1;
		for(int i = 0;i<boxes.length;i++) {
			String number;
			if(i%2 == 0)
				number = "2";
			else
				number = "4";
			boxes[i] = new BoxImage(number,r,c,i);
			c++;
			if(c==6) {
				c=1;
				r++;
			}
			boxes[i].changeBorder(false);
		}
		BoxMouseListener boxListener = new BoxMouseListener(boxes,panel);
		for(int i = 0;i<boxes.length;i++) {
			boxes[i].addMouseListener(boxListener);
		    panel.add(boxes[i]);
		}
		add(panel);
	}
	

}
