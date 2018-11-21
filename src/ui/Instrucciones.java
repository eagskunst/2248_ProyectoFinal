package ui;

import java.awt.Color;

import javax.swing.*;

public class Instrucciones extends JPanel {
	private JLabel instrucciones;
	public Inicio inicio=new Inicio();
	
	public Instrucciones() {
		setLayout(null);
		setSize(500, 400);
		setVisible(true);
		setBackground(Color.WHITE);
		
		instrucciones=new JLabel();
		instrucciones.setBounds(115,28, 300 , 300);
		instrucciones.setIcon(new ImageIcon("imagenes/instrucciones2.png") );
		add(instrucciones);
		add(inicio.atras);
		
		
	}

}
