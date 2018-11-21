package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Inicio extends JPanel {
	
	private JLabel logo;
	public JButton jugar,instrucciones,creditos,jugadores,salir,atras;
	
	public Inicio() {
		
		setLayout(null);
		setSize(500, 400);
		
		
		
		Inicializar();
		Acciones();
		
		
		
		setVisible(true);
		setBackground(Color.WHITE);
		
	}
	
	

	public void Inicializar() {
		
		logo=new JLabel();
		logo.setBounds(165,25,176,84);
		logo.setIcon(new ImageIcon("imagenes/logo.png"));
		add(logo);
		
		jugar=new JButton();
		jugar.setBounds(200, 165, 85, 28);
		jugar.setIcon(new ImageIcon("imagenes/jugar.png"));
		jugar.setBorder(null);
		add(jugar);
		
		instrucciones=new JButton();
		instrucciones.setBounds(192, 207, 104, 28);
		instrucciones.setIcon(new ImageIcon("imagenes/instrucciones.png"));
		instrucciones.setBorder(null);
		add(instrucciones);
		
		jugadores=new JButton();
		jugadores.setBounds(202, 245, 85, 36);
		jugadores.setIcon(new ImageIcon("imagenes/mejores.png"));
		jugadores.setBorder(null);
		add(jugadores);
		
		creditos=new JButton();
		creditos.setBounds(200, 290, 90, 30);
		creditos.setIcon(new ImageIcon("imagenes/creditos.png"));
		creditos.setBorder(null);
		add(creditos);
		
		salir=new JButton();
		salir.setBounds(204, 330, 80, 30);
		salir.setIcon(new ImageIcon("imagenes/salir.png"));
		salir.setBorder(null);
		add(salir);
		
		atras=new JButton();
		atras.setBounds(50, 50, 30, 20);
		atras.setIcon(new ImageIcon("imagenes/atras.png"));
		atras.setBorder(null);
		
		
	}
	
	public void Acciones() {
		
		/*jugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});*/
		
	}
}
