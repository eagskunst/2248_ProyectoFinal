package ui;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Jugadores extends JPanel {
	private JLabel titulo;
	public Inicio inicio=new Inicio();
	JLabel[] jugadores=new JLabel[10];

	public Jugadores() {
		setLayout(null);
		setSize(500, 400);
		setVisible(true);
		setBackground(Color.WHITE);
		
		titulo=new JLabel();
		titulo.setText("MEJORES JUGADORES");
		titulo.setBounds(180, 50, 153, 40);
		add(titulo);
		
		
		
		cargarJugadores();
		
		
		
		add(inicio.atras);
		
		
	}

	public void cargarJugadores() {

		for(int y = 0;y<10;y++) {
			if(jugadores[y]!=null) {
				remove(jugadores[y]);
				
			}
		}
		String[] nombre=new String[10];
		String linea;
		int i=0,aux=0;
		try {
			FileReader fr=new FileReader("jugadores.txt");
			BufferedReader out=new BufferedReader(fr);
			
			linea=out.readLine();
			while(linea!=null) {
				nombre[i]=linea;
				

				linea=out.readLine();
				i++;
			}
			
			for(int k= 0;k<10;k++) {
				for(int l = k+1;l<10;l++) {
					if(nombre[l]!=null && nombre[k] != null) {
						int p1 = Integer.parseInt(nombre[l].split("-")[1]);
						int p2 = Integer.parseInt(nombre[k].split("-")[1]);
						if(p1>=p2) {
							String saux = nombre[k];
							nombre[k] = nombre[l];
							nombre[l] = saux;
							System.out.println("k: "+nombre[k]+" l:"+nombre[l]);
						}
					}
				}
			}
			
			for(int j=0;j<10;j++) {
				if(nombre[j]!=null) {
					jugadores[j]=new JLabel();
					jugadores[j].setText(nombre[j]);
					aux=aux+20;
					jugadores[j].setBounds(200,100+aux,90,30);
					add(jugadores[j]);
					
				}
				
			}
			
			
			
		}catch(IOException e) {
			
		}
	}
}
