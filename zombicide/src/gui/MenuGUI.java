package gui;

import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import control.MenuControl;

public class MenuGUI extends JFrame implements KeyListener, MouseListener, MouseMotionListener {
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
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		this.setContentPane(menuPan);
		
		this.setVisible(true);
	}
	
	private void actionPlay() {
		this.dispose();
		GameGUI fen = new GameGUI();
		fen.createWindows();
	}
	private void actionInfo() {System.out.println("INFO !");}
	private void actionQuit() {
		this.dispose();
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
					actionPlay();
				}
				else if (menuControl.getSelectedButton() == 2) {
					actionInfo();
				}
				else {
					actionQuit();
				}
			}
		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getX() > 510 && e.getX() < 690 && e.getY() > 425 && e.getY() < 490) {
			actionPlay();
		}
		if (e.getX() > 510 && e.getX() < 690 && e.getY() > 525 && e.getY() < 590) {
			actionInfo();
		}
		if (e.getX() > 510 && e.getX() < 690 && e.getY() > 625 && e.getY() < 690) {
			actionQuit();
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseMoved(MouseEvent e) {
		if (e.getX() > 510 && e.getX() < 690 && e.getY() > 425 && e.getY() < 490 && menuControl.getSelectedButton() != 1) {
			menuControl.setSelectedButton(1);
			menuPan.repaint();
		}
		if (e.getX() > 510 && e.getX() < 690 && e.getY() > 525 && e.getY() < 590 && menuControl.getSelectedButton() != 2) {
			menuControl.setSelectedButton(2);
			menuPan.repaint();
		}
		if (e.getX() > 510 && e.getX() < 690 && e.getY() > 625 && e.getY() < 690 && menuControl.getSelectedButton() != 3) {
			menuControl.setSelectedButton(3);
			menuPan.repaint();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {}
}
