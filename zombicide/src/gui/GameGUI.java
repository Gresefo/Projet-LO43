package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GameGUI extends JFrame {
	private static final long serialVersionUID = -5841256047843668485L;
	
	private GamePane gamePane;
	private ButtonPane buttonPane;

	public GameGUI() {
		gamePane = new GamePane();
		buttonPane = new ButtonPane(gamePane);
	}
	
	public void createWindows() {
		this.setTitle("LE JEU SANS NOM");
		this.setSize(1600, 1000);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().add(gamePane, BorderLayout.CENTER);
		this.getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
}
