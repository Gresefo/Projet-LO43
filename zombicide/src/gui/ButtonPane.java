package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.GameController;
import engine.Case;


public class ButtonPane extends JPanel implements ActionListener {
	private static final long serialVersionUID = -5352856784205692008L;
	
	private GameController gc;
	private ArrayList<Case> allCase;
	private InfoPane infoPane;
	private JButton ouvrirSalle = new JButton("Ouvrir salle");
	private JButton avancerHaut = new JButton("Avancer haut");
	private JButton avancerBas = new JButton("Avancer bas");
	private JButton avancerDroite = new JButton("Avancer droite");
	private JButton avancerGauche = new JButton("Avancer gauche");
	private JButton persoSuivant = new JButton("Personnage suivant");
	private JButton attaquer = new JButton("Attaquer");
	private JButton faireBruit = new JButton("Faire du bruit");
	
	/*******************  Constructor  ********************/
	
	public ButtonPane(GamePane gamePane, InfoPane infoPane) 
	{
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
	
	/*******************  Operations  ********************/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == this.ouvrirSalle) {
			gc.getGamePane().getCurrentProf().openDoor(gc.getGamePane().getBoard());
			// Repaint the right room
			if(gc.getGamePane().getBoard().getBoard()[2][3].getHasDoor() == 0) {gc.ouvrirSalle1();}
			if(gc.getGamePane().getBoard().getBoard()[1][3].getHasDoor() == 0) {gc.ouvrirSalle2();}
			if(gc.getGamePane().getBoard().getBoard()[3][3].getHasDoor() == 0) {gc.ouvrirSalle3();}
			if(gc.getGamePane().getBoard().getBoard()[3][0].getHasDoor() == 0) {gc.ouvrirSalle4();}
			if(gc.getGamePane().getBoard().getBoard()[0][2].getHasDoor() == 0) {gc.ouvrirSalle5();}
			if(gc.getGamePane().getBoard().getBoard()[1][1].getHasDoor() == 0) {gc.ouvrirSalle6();}
			if(gc.getGamePane().getBoard().getBoard()[5][4].getHasDoor() == 0) {gc.ouvrirSalle7();}
		}
		else if (source == this.avancerHaut) 
		{
			if(gc.getGamePane().getCurrentProf().getCurrent_case().getNbStudent() < gc.getGamePane().getCurrentProf().getAction())
			{
				gc.getGamePane().getCurrentProf().setAction(gc.getGamePane().getCurrentProf().getAction() - gc.getGamePane().getCurrentProf().getCurrent_case().getNbStudent());
				gc.getGamePane().getCurrentProf().walkTop(gc.getGamePane().getBoard());
			}
		}
		else if (source == this.avancerBas) 
		{
			if(gc.getGamePane().getCurrentProf().getCurrent_case().getNbStudent() < gc.getGamePane().getCurrentProf().getAction())
			{
				gc.getGamePane().getCurrentProf().setAction(gc.getGamePane().getCurrentProf().getAction() - gc.getGamePane().getCurrentProf().getCurrent_case().getNbStudent());
				gc.getGamePane().getCurrentProf().walkBottom(gc.getGamePane().getBoard());
			}
		}
		else if (source == this.avancerGauche) 
		{
			if(gc.getGamePane().getCurrentProf().getCurrent_case().getNbStudent() < gc.getGamePane().getCurrentProf().getAction())
			{
				gc.getGamePane().getCurrentProf().setAction(gc.getGamePane().getCurrentProf().getAction() - gc.getGamePane().getCurrentProf().getCurrent_case().getNbStudent());
				gc.getGamePane().getCurrentProf().walkLeft(gc.getGamePane().getBoard());
		
			}
		}
		else if (source == this.avancerDroite) 
		{
			if(gc.getGamePane().getCurrentProf().getCurrent_case().getNbStudent() < gc.getGamePane().getCurrentProf().getAction())
			{
				gc.getGamePane().getCurrentProf().setAction(gc.getGamePane().getCurrentProf().getAction() - gc.getGamePane().getCurrentProf().getCurrent_case().getNbStudent());
				gc.getGamePane().getCurrentProf().walkRight(gc.getGamePane().getBoard());
			}
		}
		else if (source == this.attaquer) {
		}
		else if (source == this.persoSuivant) {
			persoSuivant();
		}
		else if (source == this.faireBruit) {
			gc.getGamePane().getCurrentProf().setAction(gc.getGamePane().getCurrentProf().getAction() - 1);
			gc.getGamePane().getCurrentProf().getCurrent_case().setNoise(gc.getGamePane().getCurrentProf().getCurrent_case().getNoise() + 1);
		}
		
		if(gc.getGamePane().getCurrentProf().stillHasAction() == false)
			persoSuivant();
		gc.getGamePane().repaint();
		infoPane.repaint();
	}
	
	// Take the next professor in the list and check if the professor is alive. Put back the action points
	public void persoSuivant()
	{
		gc.getGamePane().getCurrentProf().setAction(4);
		if (gc.getGamePane().getCurrentProf().getId() == 3) {
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 5; j++) {
					gc.getGamePane().getBoard().getBoard()[i][j].setNoise(0);
				}
			}
		}
		int i = 1;
		while(gc.getGamePane().getBoard().getListProf()[(gc.getGamePane().getCurrentProf().getId() + i) % 4] == null)
		{
			i++;
		}
		gc.getGamePane().setCurrentProf(gc.getGamePane().getBoard().getListProf()[(gc.getGamePane().getCurrentProf().getId() + i) % 4]);
		infoPane.repaint();
	}
	
	/*******************  Getters and Setters  ********************/
	
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
