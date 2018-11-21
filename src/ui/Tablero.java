package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

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
			boxes[i] = new BoxImage(number,r,c);
			c++;
			if(c==6) {
				c=1;
				r++;
			}
			boxes[i].changeBorder(false);
		}
		BoxMouseListener boxListener = new BoxMouseListener(boxes);
		for(int i = 0;i<boxes.length;i++) {
			boxes[i].addMouseListener(boxListener);
		    panel.add(boxes[i]);
		}
		
		/*Timer t = new Timer(200, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count<8) {
					System.out.println("entered");
					Dimension d1 = boxes[5].getPreferredSize();
					boxes[5].setBounds(boxes[5].getX(), boxes[5].getY()+5, d1.width, d1.height);
					count++;
					Dimension d = boxes[0].getPreferredSize();
					boxes[0].setBounds(boxes[0].getX(), boxes[0].getY()+5, d.width, d.height);
					
				}
			}
		});
		t.start();*/
		add(panel);
	}
	

}
