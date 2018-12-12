package gui;

import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import control.MenuControl;

public class MenuGUI extends JFrame implements KeyListener {
	private static final long serialVersionUID = 47890864641587L;
	
	private MenuPane menuPan;
	private MenuControl menuControl;
	
	public MenuGUI() {
		menuControl = new MenuControl();
		menuPan = new MenuPane(menuControl);
	}
	
	public void createWindow() {
		this.setTitle("LE JEU SANS NOM");
		this.setSize(1200, 811);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addKeyListener(this);
		
		this.setContentPane(menuPan);
		
		this.setVisible(true);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Touche ECHAP
		if (e.getKeyCode() == 27) {
			this.dispose();
		}
		else {
			//Touche FLECHE HAUT
			if (e.getKeyCode() == 38) {
				
				menuControl.changeSelectedButton(-1);
			}
			//Touche FLECHE BAS
			else if (e.getKeyCode() == 40) 
				menuControl.changeSelectedButton(1);
			menuPan.repaint();
			//Touche ENTREE
			if (e.getKeyCode() == 10) {
				if (menuControl.getSelectedButton() == 1) {
					
				}
				else if (menuControl.getSelectedButton() == 2) {
					
				}
				else {
					this.dispose();
				}
			}
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
}
