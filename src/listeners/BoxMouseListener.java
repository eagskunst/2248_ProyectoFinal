package listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ui.BoxImage;
import ui.Tablero;

public class BoxMouseListener extends MouseAdapter implements MouseListener {
	private boolean pressed = false;
	private BoxImage[] boxes;
	private static int sum;
	private static BoxImage lastBox;
	private static BoxImage previousBox;
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
		System.out.println(sum);
		lastBox = b;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		((BoxImage)(e.getComponent())).changeBorder(false);
		pressed = false;
		changeAllBoxes();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		BoxImage b = ((BoxImage)(e.getComponent()));
		System.out.println("b: "+b.getRow()+", "+b.getCol());
		if(lastBox != null)
			System.out.println("lastb: "+lastBox.getRow()+", "+lastBox.getCol());
		if(b.getNumber() == sum && pressed) {
			if( b.getRow()+1 == lastBox.getRow() || b.getRow()-1 == lastBox.getRow()  || b.getRow() == lastBox.getRow()) {
				if(b.getCol()+1 == lastBox.getCol() || b.getCol()-1 == lastBox.getCol() || b.getCol() == lastBox.getCol()) {
					b.changeBorder(true);
					sum+=b.getNumber();
					System.out.println(sum);
					previousBox = lastBox;
					lastBox = b;
				}
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//TODO: Validaciones para regresar el movimiento
	}
	
	private void changeAllBoxes() {
		lastBox.setNumber(sum);
		sum = 0;
		for(BoxImage b:boxes) {
			b.changeBorder(false);
		}
	}


}
