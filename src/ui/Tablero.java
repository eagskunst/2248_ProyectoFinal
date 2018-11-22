package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import listeners.BoxMouseListener;
import util.CustomTimer;

public class Tablero extends JPanel implements KeyListener{
	
	static int count = 0;
	private Timer t;
	private BoxImage boxes[];
	
	
	public static final String PUNTAJE = "Puntaje: ";
	public static final String TIEMPO = "00:00";
	
	private JLabel puntajeLabel;
	private JLabel tiempoDeJuego;
	
	public Tablero() {
		addKeyListener(this);
		configurate();
		setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
		setOpaque(true);
		setBackground(Color.WHITE.brighter());

	}
	
	private void configurate() {
		JPanel panel = new JPanel();
		puntajeLabel = new JLabel(PUNTAJE+"0");
		tiempoDeJuego = new JLabel(TIEMPO);
		JPanel pointsAndTime = new JPanel();	
		pointsAndTime.setLayout(new GridLayout(1,2,200,50));
		GridLayout layout = new GridLayout(7,5);
        layout.setHgap(10);
        layout.setVgap(10);
        panel.setLayout(layout);
		setBorder(BorderFactory.createEmptyBorder(5,50,0,50));
		BoxImage[] boxes = new BoxImage[35];
		int r = 1;
		int c = 1;
		for(int i = 0;i<boxes.length;i++) {
			String number;
			if(i%2 == 0)
				number = "2";
			else
				number = "4";
			boxes[i] = new BoxImage(number,r,c,i);
			c++;
			if(c==6) {
				c=1;
				r++;
			}
			boxes[i].changeBorder(false);
		}
		BoxMouseListener boxListener = new BoxMouseListener(boxes,panel,puntajeLabel);
		for(int i = 0;i<boxes.length;i++) {
			boxes[i].addMouseListener(boxListener);
		    panel.add(boxes[i]);
		}
		pointsAndTime.add(puntajeLabel);
		pointsAndTime.add(tiempoDeJuego);
		pointsAndTime.setOpaque(true);
		pointsAndTime.setBackground(Color.WHITE.brighter());
		add(pointsAndTime);
		this.boxes = boxes;
		panel.setOpaque(true);
		panel.setBackground(Color.WHITE.brighter());
		add(panel);
		startTimer(tiempoDeJuego);
		System.out.println();
	}

	private void startTimer(final JLabel tiempoDeJuego) {
		final StringBuilder tiempo = new StringBuilder();
		t = new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] splitter = tiempoDeJuego.getText().split(":");
				int min = Integer.parseInt(splitter[0]);
				int seg = Integer.parseInt(splitter[1]);
				seg++;
				if(seg == 60) {
					seg = 0;
					min++;
				}
				if(min<10) {
					tiempo.append("0");
					tiempo.append(min);
				}
				else {
					tiempo.append(min);
				}
				tiempo.append(":");
				if(seg<10) {
					tiempo.append("0");
					tiempo.append(seg);
				}
				else {
					tiempo.append(seg);
				}
				if(!CustomTimer.isAnimating)
					tiempoDeJuego.setText(tiempo.toString());
				tiempo.setLength(0);
			}
		});
	}

	public Timer getT() {
		return t;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {

	}
	
	@Override
	public void keyReleased(KeyEvent e) {

	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if(t != null && puntajeLabel != null && tiempoDeJuego != null) {
				t.stop();
				puntajeLabel.setText(PUNTAJE+"0");
				tiempoDeJuego.setText(TIEMPO);
				Game2248.regresar();	
			}
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			if(!CustomTimer.isAnimating && boxes != null) {
				for(int i = 0;i<boxes.length;i++) {
					String number;
					if(i%2 == 0)
						number = "2";
					else
						number = "4";
					boxes[i].setText(number);
				}
				puntajeLabel.setText(PUNTAJE+"0");
				tiempoDeJuego.setText(TIEMPO);
			}
		}
	}
	
}
