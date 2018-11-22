package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;

import sounds.Sounds;

import javax.swing.*;

public class Game2248 extends JFrame{
	private static JPanel panel=new JPanel();
	private static CardLayout card=new CardLayout();
	static Inicio inicio= new Inicio();
	static Tablero tablero=new Tablero();
	static Instrucciones inst=new Instrucciones();
	static Creditos creditos=new Creditos();
	public static Timer t;

	static Jugadores jugador=new Jugadores();
	public static String aux,nombre;

	
	public static void main (String args[]) {
		Game2248 game = new Game2248();
		
	
		panel.setLayout(card);
		panel.setSize(500,400);
		panel.add(inicio,"1");
		panel.add(tablero,"2"); 
		panel.add(inst, "3");
		panel.add(creditos, "4");
		panel.add(jugador, "5");
		
		
		card.show(panel, "1");
		
		botones();
		
		game.add(panel);
		game.setLocationRelativeTo(null);

        game.setVisible(true);
		Sounds.initializePop(Sounds.AMBIENCE);
        startAmbience();
	}


	public Game2248() {
		setTitle("2248");
		setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setResizable(false);
        Container c=getContentPane();
        c.setBackground(Color.white);
        
        
        
	}
	
	public static void botones() {
		
		inicio.jugar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				card.show(panel, "2");
				tablero.requestFocusInWindow();
				tablero.getT().start();
				Nombre();
				
			}
		});
		
		inicio.instrucciones.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "3");
				inst.inicio.atras.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						card.show(panel, "1");
						
					}
				});
				
			}
		});
		
		inicio.creditos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "4");
				creditos.inicio.atras.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						card.show(panel, "1");
						
					}
				});
				
			}
		});
		
		inicio.jugadores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.show(panel, "5");
				
				
				jugador.inicio.atras.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						card.show(panel, "1");
					}
				});
				
			}
		});
		
		inicio.salir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
	}
	
	public static void regresar() {
		card.show(panel, "1");
	}
	
	
	private static void startAmbience() {
		t =new Timer(32000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Sounds.initializePop(Sounds.AMBIENCE);
			}
		});
		t.start();
	}
	public static void Nombre() {
		aux=(String)JOptionPane.showInputDialog(inicio,"Introducir Nombre: \n","Nombre.",JOptionPane.PLAIN_MESSAGE);
		if(aux.length()>8) {
			nombre=aux.substring(0, 8);
		}else {
			nombre=aux;
		}
		System.out.println(nombre);
		crearjugadores();
		
	}


	public static void crearjugadores() {
		// TODO Auto-generated method stub
		
		File archivo=new File("jugadores.txt");
		try {
			
			
				FileWriter fw=new FileWriter("jugadores.txt",true);
				BufferedWriter bw=new BufferedWriter(fw);
				PrintWriter selarch=new PrintWriter(bw);
				
				selarch.print(nombre+"\n");
			
				selarch.close();
	
			
			
		}catch(IOException e) {
			
		}
	}


}
