package ui;



import java.awt.Point;

import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import interfaces.Bordes;

public class BoxImage extends JLabel implements Bordes{
	
	private CompoundBorder compoundBorder;
	private Point p;
	private int number;
	private int col;
	private int row;
		
	public BoxImage(String number,int row, int col) {
		super(number);
		p = getLocation();
		this.number = Integer.parseInt(number);
		this.row = row;
		this.col = col;
	}
	
	public void changeBorder(boolean touched) {
		if(!touched) {
			compoundBorder = new CompoundBorder(untouchedBorder,margin);
		}
		else
			compoundBorder = new CompoundBorder(touchedBorder,margin);
		
		setBorder(compoundBorder);
	}
	
	
	public void setNumber(int number) {
		this.number = number;
		setText(Integer.toString(number));
	}
	
	public int getNumber() {
		return number;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	

}
