package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class InfoPane extends JPanel {
	private static final long serialVersionUID = 2789573699771064929L;
	
	@SuppressWarnings("unused")
	private ButtonPane buttonPane;
	private GamePane gamePane;
	
	
	private BufferedImage CARTE_GECHTER, CARTE_FLESCH, CARTE_LACAILLE, CARTE_ZULLO;

	/*******************  Constructor  ********************/
	
	public InfoPane() {
		super();
		this.setPreferredSize(new Dimension(464, 800));
		try {
			CARTE_GECHTER = ImageIO.read(new File("img/carte_gechter.png"));
			CARTE_FLESCH = ImageIO.read(new File("img/carte_flesch.png"));
			CARTE_LACAILLE = ImageIO.read(new File("img/carte_lacaille.png"));
			CARTE_ZULLO = ImageIO.read(new File("img/carte_zullo.png"));
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*******************  Operations  ********************/
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		String it3 = "Vide", it4 = "Vide", it5 = "Vide";
		if (gamePane.getCurrentProf().getId() == 0) {
			g.drawImage(CARTE_GECHTER, 0, 0, this);
		}
		else if (gamePane.getCurrentProf().getId() == 2) {
			g.drawImage(CARTE_FLESCH, 0, 0, this);
		}
		else if (gamePane.getCurrentProf().getId() == 1) {
			g.drawImage(CARTE_LACAILLE, 0, 0, this);
		}
		else if (gamePane.getCurrentProf().getId() == 3) {
			g.drawImage(CARTE_ZULLO, 0, 0, this);
		}
		g.drawString("Action(s) disponible(s) : " + gamePane.getCurrentProf().getAction(), 10, 720);
		g.drawString("Plainte(s) auprès du directeur avant mutation : " + gamePane.getCurrentProf().getHealth(), 10, 735);
		if (gamePane.getCurrentProf().getListItem()[0] != null) {
			g.drawImage(gamePane.getCurrentProf().getListItem()[0].getImg(), 100, 520, this);
		}
		if (gamePane.getCurrentProf().getListItem()[1] != null) {
			g.drawImage(gamePane.getCurrentProf().getListItem()[1].getImg(), 260, 520, this);
		}
		if (gamePane.getCurrentProf().getListItem()[2] != null) {
			it3 = gamePane.getCurrentProf().getListItem()[2].getName();
		}
		if (gamePane.getCurrentProf().getListItem()[3] != null) {
			it4 = gamePane.getCurrentProf().getListItem()[3].getName();
		}
		if (gamePane.getCurrentProf().getListItem()[4] != null) {
			it5 = gamePane.getCurrentProf().getListItem()[4].getName();
		}
		g.drawString("Emplacement sac 1 : " + it3, 10, 750);
		g.drawString("Emplacement sac 2 : " + it4, 10, 765);
		g.drawString("Emplacement sac 3 : " + it5, 10, 780);
	}
	
	/*******************  Getters and Setters  ********************/
	
	public void setButtonPane(ButtonPane bp) {
		this.buttonPane = bp;
	}
	public void setGamePane(GamePane gp) {
		this.gamePane = gp;
	}
}