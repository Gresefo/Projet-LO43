package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class InfoGUI extends JFrame {
	private static final long serialVersionUID = 7771726176056519223L;
	public InfoGUI() {
		
	}
	public void createWindow() {
		this.setTitle("La course aux UVs");
		this.setSize(1200, 850);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.getContentPane().add(new MenuInfoPane(), BorderLayout.CENTER);
		this.getContentPane().add(new InfoButtonPane(this), BorderLayout.SOUTH);
		
		this.setVisible(true);
	}	
}
