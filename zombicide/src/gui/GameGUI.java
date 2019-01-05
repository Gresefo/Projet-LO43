package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameGUI extends JFrame {
	private static final long serialVersionUID = -5841256047843668485L;
	
	private GamePane gamePane;
	private ButtonPane buttonPane;
	private InfoPane infoPane;

	public GameGUI() {
		gamePane = new GamePane(this);
		infoPane = new InfoPane();
		buttonPane = new ButtonPane(gamePane, infoPane);
		infoPane.setButtonPane(buttonPane);
		infoPane.setGamePane(gamePane);
	}
	
	public void createWindows() {
		this.setTitle("La course aux UVs");
		this.setSize(1600, 900);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel upPane = new JPanel();
		
		upPane.setLayout(new FlowLayout());
		this.getContentPane().add(upPane, BorderLayout.CENTER);
		
		upPane.add(gamePane);
		upPane.add(infoPane);
		
		this.getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
}
