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
	
	private ButtonPane buttonPane;
	private GamePane gamePane;
	
	
	private BufferedImage CARTE_GECHTER, CARTE_FLESCH, CARTE_LACAILLE, CARTE_ZULLO;
	@SuppressWarnings("unused") //A ENLEVER
	private BufferedImage STYLO, CLE, GUITARE, CRAIE, CRAIE_AM, FIL, LISTE, DICTIO_ANG, DICTIO_FRA, DICTIONNAIRE, LOUPE;

	/*******************  Constructor  ********************/
	
	public InfoPane() {
		super();
		this.setPreferredSize(new Dimension(464, 800));
		try {
			CARTE_GECHTER = ImageIO.read(new File("img/carte_gechter.png"));
			CARTE_FLESCH = ImageIO.read(new File("img/carte_flesch.png"));
			CARTE_LACAILLE = ImageIO.read(new File("img/carte_lacaille.png"));
			CARTE_ZULLO = ImageIO.read(new File("img/carte_zullo.png"));
			
			STYLO = ImageIO.read(new File("img/stylo.png"));
			CLE = ImageIO.read(new File("img/cle.png"));
			GUITARE = ImageIO.read(new File("img/guitare.png"));
			CRAIE = ImageIO.read(new File("img/craie.png"));
			CRAIE_AM = ImageIO.read(new File("img/craie_am.png"));
			FIL = ImageIO.read(new File("img/fil.png"));
			LISTE = ImageIO.read(new File("img/liste.png"));
			DICTIO_ANG = ImageIO.read(new File("img/dictionnaire1.png"));
			DICTIO_FRA = ImageIO.read(new File("img/dictionnaire2.png"));
			DICTIONNAIRE = ImageIO.read(new File("img/dictionnaire.png"));
			LOUPE = ImageIO.read(new File("img/loupe.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*******************  Operations  ********************/
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
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
		g.drawString("Action(s) disponible(s) : " + gamePane.getCurrentProf().getAction(), 10, 750);
		g.drawImage(STYLO, 100, 520, this);
		g.drawImage(GUITARE, 260, 520, this);
	}
	
	/*******************  Getters and Setters  ********************/
	
	public void setButtonPane(ButtonPane bp) {
		this.buttonPane = bp;
	}
	public void setGamePane(GamePane gp) {
		this.gamePane = gp;
	}
}