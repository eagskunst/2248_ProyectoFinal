package ui;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Creditos extends JPanel {
	
	private JLabel creditos;
	public Inicio inicio=new Inicio();
	
	public Creditos() {
		setLayout(null);
		setSize(500, 400);
		setVisible(true);
		setBackground(Color.WHITE);
		
		creditos=new JLabel();
		creditos.setBounds(170,130, 150 , 65);
		creditos.setIcon(new ImageIcon("imagenes/colaboradores.png"));
		add(creditos);
		add(inicio.atras);
		
		
	}

}
