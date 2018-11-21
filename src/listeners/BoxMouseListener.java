package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import ui.BoxImage;
import ui.Tablero;
import util.CustomTimer;

public class BoxMouseListener extends MouseAdapter implements MouseListener{
	private boolean pressed = false;
	private Random rand = new Random();
	private BoxImage[] boxes;
	private static int sum;
	private static BoxImage lastBox;
	private static BoxImage previousBox;
	private CustomTimer timers[] = new CustomTimer[100];
	private final int delay = 200;
	private JPanel panel;
	private int c = 0;
	private int firstValue;
	
	
	public BoxMouseListener(BoxImage[] boxes, JPanel panel) {
		this.boxes = boxes;
		this.panel = panel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(!CustomTimer.isAnimating) {
			BoxImage b = ((BoxImage)(e.getComponent()));
			b.changeBorder(true);
			pressed = true;
			sum+= b.getNumber();
			firstValue = b.getNumber();
			lastBox = b;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		BoxImage b = ((BoxImage)(e.getComponent()));
		pressed = false;
		if(sum == firstValue) {
			b.setAdding(false);
			b.changeBorder(false);
			sum = 0;
		}
		changeAllBoxes();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		BoxImage b = ((BoxImage)(e.getComponent()));
		//System.out.println("b: "+b.getRow()+", "+b.getCol());
		if(lastBox != null)
			//System.out.println("lastb: "+lastBox.getRow()+", "+lastBox.getCol());
		if(b.getNumber() == sum && pressed && !b.isAdding()) {
			if( b.getRow()+1 == lastBox.getRow() || b.getRow()-1 == lastBox.getRow()  || b.getRow() == lastBox.getRow()) {
				if(b.getCol()+1 == lastBox.getCol() || b.getCol()-1 == lastBox.getCol() || b.getCol() == lastBox.getCol()) {
					b.changeBorder(true);
					sum+=b.getNumber();
					System.out.println(sum);
					previousBox = lastBox;
					previousBox.setAdding(true);
					lastBox = b;
				}
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		BoxImage b = ((BoxImage)(e.getComponent()));
		if(previousBox != null) {
			if(b.getRow() == lastBox.getRow() && b.getCol() == lastBox.getCol() && e.isShiftDown()) {
				lastBox.setAdding(false);
				lastBox.changeBorder(false);
				sum-=lastBox.getNumber();
				System.out.println(sum);
				lastBox = previousBox;
				previousBox = b;
			}
		}
	}
	
	private void changeAllBoxes() {
		if(sum!= 0) {
			CustomTimer.isAnimating = true;
			lastBox.setNumber(sum);
			lastBox.setAdding(false);
			lastBox.changeBorder(false);
			sum = 0;
			int col = boxes.length-1;
			for(int i = col;i>col-5;i--) {
				for(int j = i;j>=0;j-=5) {
					if(boxes[j].isAdding()) {
						final int from = j;
						final int c2 = c;
						timers[c] = new CustomTimer(delay, new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								timers[c2].executeTransition(from,boxes,panel,lastBox);
							}
						});
						timers[c].start();
						c++;
					}
				}
			}
		}
		c=0;

	}



}
