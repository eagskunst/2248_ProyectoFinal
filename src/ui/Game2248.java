package ui;

import javax.swing.JFrame;

public class Game2248 extends JFrame{
	
	public static void main (String args[]) {
		Game2248 game = new Game2248();
		Tablero t = new Tablero();
		game.setLocationRelativeTo(null);
		game.add(t);
        game.setVisible(true);
        
	}
	
	public Game2248() {
		setTitle("2248");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setResizable(false);
	}

}
