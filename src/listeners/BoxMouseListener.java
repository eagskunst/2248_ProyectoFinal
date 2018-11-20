package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Timer;

import ui.BoxImage;
import ui.Tablero;

public class BoxMouseListener extends MouseAdapter implements MouseListener{
	private boolean pressed = false;
	private Random rand = new Random();
	private BoxImage[] boxes;
	private static int sum;
	private static BoxImage lastBox;
	private static BoxImage previousBox;
	private Timer timers[] = new Timer[5];
	
	public BoxMouseListener(BoxImage[] boxes) {
		this.boxes = boxes;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		BoxImage b = ((BoxImage)(e.getComponent()));
		b.changeBorder(true);
		pressed = true;
		sum+= b.getNumber();
		lastBox = b;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pressed = false;
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
			lastBox.setNumber(sum);
			lastBox.setAdding(false);
			lastBox.changeBorder(false);
			sum = 0;
			int col = boxes.length-1;
			
			for(int i = col;i>col-5;i--) {
				for(int j = i;j>=0;j-=5) {
					if(boxes[j].isAdding()) {
						for(int k = j;k>=0;k-=5) {
							boxes[k].setAdding(false);
							boxes[k].changeBorder(false);
							if(k-5>=0)
								boxes[k].setNumber(boxes[k-5].getNumber());
							else {
								int r = rand.nextInt(3);
								System.out.println(r);
								boxes[k].setNumber(r == 1 ? 2:4);
							}
								
						}
					}
				}
			}
		}
		/*while(!checkedAllCols) {
			boolean finded = false;
			for(int i = col;i<=0 &&!finded;i-=10) {
				if(boxes[i].isAdding()) {
					startAnimation(i,8);
					finded = true;
				}
			}
			finded = false;
			col--;
		}*/
/*		for(BoxImage b:boxes) {
			b.changeBorder(false);
			if(b.isAdding()) {
				b.setAdding(false);
				int num = (int) (Math.random()*3);
				switch(num) {
					case 0:
						b.setNumber(2);
						break;
					case 1:
						b.setNumber(4);
						break;
					case 2:
						b.setNumber(8);
						break;
					case 3:
						b.setNumber(16);
						break;
				}
			}
		}*/

	}



}
