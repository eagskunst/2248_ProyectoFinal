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
	private boolean adding = false;
	private int id;
		
	public boolean isAdding() {
		return adding;
	}

	public void setAdding(boolean isAdding) {
		this.adding = isAdding;
	}

	public BoxImage(String number,int row, int col,int id) {
		super(number);
		p = getLocation();
		this.number = Integer.parseInt(number);
		this.row = row;
		this.col = col;
		this.id = id;
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
	
	public Point getP() {
		return p;
	}

	public void setP(Point p) {
		this.p = p;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "BoxImage [compoundBorder=" + compoundBorder + ", p=" + p + ", number=" + number + ", col=" + col
				+ ", row=" + row + ", adding=" + adding + "]";
	}
	
	

}
