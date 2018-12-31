package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import engine.ProfessorName;

public class InfoPane extends JPanel {
	private static final long serialVersionUID = 2789573699771064929L;
	
	private ButtonPane buttonPane;
	
	private BufferedImage CARTE_GECHTER, CARTE_FLESCH, CARTE_LACAILLE, CARTE_ZULLO;
	private ProfessorName persoActuel;
	private int actionRestantes;

	public InfoPane() {
		super();
		this.actionRestantes = 3;
		this.persoActuel = ProfessorName.GECHTER;
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
	
	public void decrementerAction() {
		this.actionRestantes --;
		if (this.actionRestantes == 0) {
			this.buttonPane.getOuvrirSalle().setEnabled(false);
			this.buttonPane.getAvancerHaut().setEnabled(false);
			this.buttonPane.getAvancerBas().setEnabled(false);
			this.buttonPane.getAvancerGauche().setEnabled(false);
			this.buttonPane.getAvancerDroite().setEnabled(false);
			this.buttonPane.getAttaquer().setEnabled(false);
			this.buttonPane.getFaireBruit().setEnabled(false);
		}
	}
	
	public void setPersoActuel(ProfessorName pr) {
		this.persoActuel = pr;
	}
	
	public void persoSuivant() {
		this.buttonPane.getAvancerHaut().setEnabled(true);
		this.buttonPane.getOuvrirSalle().setEnabled(true);
		this.buttonPane.getAvancerBas().setEnabled(true);
		this.buttonPane.getAvancerGauche().setEnabled(true);
		this.buttonPane.getAvancerDroite().setEnabled(true);
		this.buttonPane.getAttaquer().setEnabled(true);
		this.buttonPane.getFaireBruit().setEnabled(true);
		this.setAction(3);
		if (this.persoActuel == ProfessorName.GECHTER) {
			this.persoActuel = ProfessorName.FLESCH;
		}
		else if (this.persoActuel == ProfessorName.FLESCH) {
			this.persoActuel = ProfessorName.LACAILLE;
		}
		else if (this.persoActuel == ProfessorName.LACAILLE) {
			this.persoActuel = ProfessorName.ZULLO;
		}
		this.repaint();
	}
	
	public void setAction(int action) {
		this.actionRestantes = action;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (this.persoActuel == ProfessorName.GECHTER) {
			g.drawImage(CARTE_GECHTER, 0, 0, this);
		}
		else if (this.persoActuel == ProfessorName.FLESCH) {
			g.drawImage(CARTE_FLESCH, 0, 0, this);
		}
		else if (this.persoActuel == ProfessorName.LACAILLE) {
			g.drawImage(CARTE_LACAILLE, 0, 0, this);
		}
		else if (this.persoActuel == ProfessorName.ZULLO) {
			g.drawImage(CARTE_ZULLO, 0, 0, this);
		}
		g.drawString("Action(s) disponible(s) : " + this.actionRestantes, 10, 750);
	}
	
	public void setButtonPane(ButtonPane bp) {
		this.buttonPane = bp;
	}
	
}
