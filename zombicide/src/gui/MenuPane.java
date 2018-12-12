package gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import control.MenuControl;

public class MenuPane extends JPanel {
	private static final long serialVersionUID = 3118281347857860277L;
	
	private MenuControl menuControl;
	private BufferedImage BG_IMG, BTN_UNSELECTED, BTN_PLAY, BTN_INFO, BTN_QUIT;
	
	public MenuPane(MenuControl menuControl) {
		super();
		this.menuControl = menuControl;
		try {
			BG_IMG = ImageIO.read(new File("img/menuImg.png"));
			BTN_UNSELECTED = ImageIO.read(new File("img/button_unselect.png"));
			BTN_PLAY = ImageIO.read(new File("img/button_play.png"));
			BTN_INFO = ImageIO.read(new File("img/button_info.png"));
			BTN_QUIT = ImageIO.read(new File("img/button_quit.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		int i = menuControl.getSelectedButton();
		g.drawImage(BG_IMG, 0, 0, this);
		if (i == 1) {
			g.drawImage(BTN_PLAY, 510, 400, this);
			g.drawImage(BTN_UNSELECTED, 510, 500, this);
			g.drawImage(BTN_UNSELECTED, 510, 600, this);
		}
		else if (i == 2) {
			g.drawImage(BTN_UNSELECTED, 510, 400, this);
			g.drawImage(BTN_INFO, 510, 500, this);
			g.drawImage(BTN_UNSELECTED, 510, 600, this);
		}
		else {
			g.drawImage(BTN_UNSELECTED, 510, 400, this);
			g.drawImage(BTN_UNSELECTED, 510, 500, this);
			g.drawImage(BTN_QUIT, 510, 600, this);
		}
	}
}
