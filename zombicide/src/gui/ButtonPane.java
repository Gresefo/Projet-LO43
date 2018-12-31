package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.GameController;

public class ButtonPane extends JPanel implements ActionListener {
	private static final long serialVersionUID = -5352856784205692008L;
	
	private GameController gc;
	private InfoPane infoPane;
	private JButton ouvrirSalle = new JButton("Ouvrir salle");
	private JButton avancerHaut = new JButton("Avancer haut");
	private JButton avancerBas = new JButton("Avancer bas");
	private JButton avancerDroite = new JButton("Avancer droite");
	private JButton avancerGauche = new JButton("Avancer gauche");
	private JButton persoSuivant = new JButton("Personnage suivant");
	private JButton attaquer = new JButton("Attaquer");
	private JButton faireBruit = new JButton("Faire du bruit");
	
	public ButtonPane(GamePane gamePane, InfoPane infoPane) {
		super();
		ouvrirSalle.addActionListener(this);
		avancerHaut.addActionListener(this);
		avancerBas.addActionListener(this);
		avancerDroite.addActionListener(this);
		avancerGauche.addActionListener(this);
		persoSuivant.addActionListener(this);
		attaquer.addActionListener(this);
		faireBruit.addActionListener(this);
		
		this.infoPane = infoPane;
		this.gc = new GameController(gamePane);
		
		this.setLayout(new GridLayout(2, 5));
		
		this.add(ouvrirSalle);
		this.add(avancerHaut);
		this.add(persoSuivant);
		this.add(faireBruit);
		this.add(avancerGauche);
		this.add(avancerBas);
		this.add(avancerDroite);
		this.add(attaquer);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == this.ouvrirSalle) {
			gc.ouvrirSalle1();
			gc.ouvrirSalle2();
			gc.ouvrirSalle3();
			gc.ouvrirSalle4();
			gc.ouvrirSalle5();
			gc.ouvrirSalle6();
			gc.ouvrirSalle7();
			gc.ouvrirSalle8();
		}
		else if (source == this.avancerHaut) {
			infoPane.decrementerAction();
			infoPane.repaint();
		}
		else if (source == this.avancerBas) {
			infoPane.decrementerAction();
			infoPane.repaint();
		}
		else if (source == this.avancerGauche) {
			infoPane.decrementerAction();
			infoPane.repaint();
		}
		else if (source == this.avancerDroite) {
			infoPane.decrementerAction();
			infoPane.repaint();
		}
		else if (source == this.attaquer) {
			infoPane.decrementerAction();
			infoPane.repaint();
		}
		else if (source == this.persoSuivant) {
			infoPane.persoSuivant();
		}
		else if (source == this.faireBruit) {
			infoPane.decrementerAction();
			infoPane.repaint();
		}
	}
	public JButton getAvancerBas() {
		return avancerBas;
	}
	public void setAvancerBas(JButton avancerBas) {
		this.avancerBas = avancerBas;
	}
	public JButton getAvancerDroite() {
		return avancerDroite;
	}
	public void setAvancerDroite(JButton avancerDroite) {
		this.avancerDroite = avancerDroite;
	}
	public JButton getAvancerGauche() {
		return avancerGauche;
	}
	public void setAvancerGauche(JButton avancerGauche) {
		this.avancerGauche = avancerGauche;
	}
	public JButton getAttaquer() {
		return attaquer;
	}
	public void setAttaquer(JButton attaquer) {
		this.attaquer = attaquer;
	}
	public JButton getFaireBruit() {
		return faireBruit;
	}
	public void setFaireBruit(JButton faireBruit) {
		this.faireBruit = faireBruit;
	}
	public JButton getOuvrirSalle() {
		return ouvrirSalle;
	}
	public void setOuvrirSalle(JButton ouvrirSalle) {
		this.ouvrirSalle = ouvrirSalle;
	}
	public JButton getAvancerHaut() {
		return avancerHaut;
	}
	public void setAvancerHaut(JButton avancerHaut) {
		this.avancerHaut = avancerHaut;
	}
	public JButton getPersoSuivant() {
		return persoSuivant;
	}
	public void setPersoSuivant(JButton persoSuivant) {
		this.persoSuivant = persoSuivant;
	}
	
}
