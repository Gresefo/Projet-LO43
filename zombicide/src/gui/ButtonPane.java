package gui;

import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import control.GameController;

import engine.Case;
import main.Main;


public class ButtonPane extends JPanel implements ActionListener {
	private static final long serialVersionUID = -5352856784205692008L;
	
	private GameController gc;
	//private ArrayList<Case> allCase;
	private InfoPane infoPane;
	private JButton ouvrirSalle = new JButton("Ouvrir salle");
	private JButton avancerHaut = new JButton("Avancer haut");
	private JButton avancerBas = new JButton("Avancer bas");
	private JButton avancerDroite = new JButton("Avancer droite");
	private JButton avancerGauche = new JButton("Avancer gauche");
	private JButton persoSuivant = new JButton("Personnage suivant");
	private JButton attaquer = new JButton("Attaquer");
	private JButton utiliserEffet = new JButton("Utiliser l'effet");
	private JButton ouvrirCoffre = new JButton("Ouvrir le coffre");
	private JButton fouillerPiece = new JButton("Fouiller la piece");
	private JButton jeterItem = new JButton("Jeter un item");
	private JButton echangerPlaceItem = new JButton("Echanger place item");
	
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
		utiliserEffet.addActionListener(this);
		ouvrirCoffre.addActionListener(this);
		fouillerPiece.addActionListener(this);
		jeterItem.addActionListener(this);
		echangerPlaceItem.addActionListener(this);
		
		this.infoPane = infoPane;
		this.gc = new GameController(gamePane);
		
		this.setLayout(new GridLayout(2, 7));
		
		this.add(ouvrirSalle);
		this.add(avancerHaut);
		this.add(persoSuivant);
		this.add(utiliserEffet);
		this.add(ouvrirCoffre);
		this.add(fouillerPiece);
		this.add(avancerGauche);
		this.add(avancerBas);
		this.add(avancerDroite);
		this.add(attaquer);	
		this.add(jeterItem);
		this.add(echangerPlaceItem);
	}
	
	/*******************  Operations  ********************/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == this.ouvrirSalle) 
		{
			gc.getGamePane().getCurrentProf().openDoor(gc.getGamePane().getBoard(), this);
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
		else if (source == this.attaquer) 
		{
			if (gc.getGamePane().getCurrentProf().getListItem()[0] != null)
			{
				// Check if the first item in hand is a weapon
				if (gc.getGamePane().getCurrentProf().getListItem()[0].getIsWeapon())
				{
					// If he has two weapons
					if (gc.getGamePane().getCurrentProf().getListItem()[1] != null && gc.getGamePane().getCurrentProf().getListItem()[1].getIsWeapon())
					{
						String it1 = gc.getGamePane().getCurrentProf().getListItem()[0].getName();
						String it2 = gc.getGamePane().getCurrentProf().getListItem()[1].getName();
						String[] reponse = {it1, it2}; 
						int rang = JOptionPane.showOptionDialog(null,"Choisir avec quelle arme attaquer","Utiliser quelle arme ?",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,reponse,reponse);
						// Use the Item rang
						chooseCase(rang);
					}
					else
					{
						// Use the Item 0
						chooseCase(0);
						
					}
				}
				else if (gc.getGamePane().getCurrentProf().getListItem()[1] != null && gc.getGamePane().getCurrentProf().getListItem()[1].getIsWeapon())
				{
					// Use the Item 1
					chooseCase(1);
				}
			}
		}
		else if (source == this.persoSuivant) 
		{
			persoSuivant();
		}
		else if (source == this.utiliserEffet) 
		{
			gc.getGamePane().getCurrentProf().effect(gc.getGamePane().getBoard());
		}
		else if (source == this.ouvrirCoffre) 
		{
			gc.getGamePane().getCurrentProf().checkObjective(gc.getGamePane().getBoard());
			if(gc.getGamePane().getBoard().getBoard()[6][1].getIsLinkedTo(1)) {gc.ouvrirSalle8();}
			if(gc.getGamePane().getBoard().getBoard()[0][3].getIsPossibleObjective() == false) {gc.ouvrirCoffre1();}
			if(gc.getGamePane().getBoard().getBoard()[0][0].getIsPossibleObjective() == false) {gc.ouvrirCoffre2();}
			if(gc.getGamePane().getBoard().getBoard()[3][4].getIsPossibleObjective() == false) {gc.ouvrirCoffre3();}
			if(gc.getGamePane().getBoard().getBoard()[4][1].getIsPossibleObjective() == false) {gc.ouvrirCoffre4();}
		}
		else if (source == this.fouillerPiece) 
		{
			gc.getGamePane().getCurrentProf().searchRoom(gc.getGamePane().getBoard());
		}
		else if (source == this.jeterItem) 
		{
			String it1 = "Vide";
			String it2 = "Vide";
			String it3 = "Vide";
			String it4 = "Vide";
			String it5 = "Vide";
			if (gc.getGamePane().getCurrentProf().getListItem()[0] != null) {
				it1 = gc.getGamePane().getCurrentProf().getListItem()[0].getName();
			}
			if (gc.getGamePane().getCurrentProf().getListItem()[1] != null) {
				it2 = gc.getGamePane().getCurrentProf().getListItem()[1].getName();
			}
			if (gc.getGamePane().getCurrentProf().getListItem()[2] != null) {
				it3 = gc.getGamePane().getCurrentProf().getListItem()[2].getName();
			}
			if (gc.getGamePane().getCurrentProf().getListItem()[3] != null) {
				it4 = gc.getGamePane().getCurrentProf().getListItem()[3].getName();
			}
			if (gc.getGamePane().getCurrentProf().getListItem()[4] != null) {
				it5 = gc.getGamePane().getCurrentProf().getListItem()[4].getName();
			}
			
			String[] reponse = {it1, it2, it3, it4, it5};
        	int rang = JOptionPane.showOptionDialog(null,"Choisir quel item jeter","Jeter quel objet ?",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,reponse,reponse);
        	gc.getGamePane().getCurrentProf().throwItem(rang);
		}
		else if (source == this.echangerPlaceItem) 
		{
			String it1 = "Vide";
			String it2 = "Vide";
			String it3 = "Vide";
			String it4 = "Vide";
			String it5 = "Vide";
			if (gc.getGamePane().getCurrentProf().getListItem()[0] != null) {
				it1 = gc.getGamePane().getCurrentProf().getListItem()[0].getName();
			}
			if (gc.getGamePane().getCurrentProf().getListItem()[1] != null) {
				it2 = gc.getGamePane().getCurrentProf().getListItem()[1].getName();
			}
			if (gc.getGamePane().getCurrentProf().getListItem()[2] != null) {
				it3 = gc.getGamePane().getCurrentProf().getListItem()[2].getName();
			}
			if (gc.getGamePane().getCurrentProf().getListItem()[3] != null) {
				it4 = gc.getGamePane().getCurrentProf().getListItem()[3].getName();
			}
			if (gc.getGamePane().getCurrentProf().getListItem()[4] != null) {
				it5 = gc.getGamePane().getCurrentProf().getListItem()[4].getName();
			}
			
			String[] reponse = {it1, it2, it3, it4, it5};
        	int rang = JOptionPane.showOptionDialog(null,"Choisir le premier item a changer de place","Changer la place de quel objet ?",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,reponse,reponse);
        	if (gc.getGamePane().getCurrentProf().getListItem()[rang] != null)
        	{
        		int rang2 = JOptionPane.showOptionDialog(null,"Choisir le deuxieme item a changer de place","Changer avec quel objet ?",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,reponse,reponse);
        		if (gc.getGamePane().getCurrentProf().getListItem()[rang2] != null && rang != rang2)
        		{
        			gc.getGamePane().getCurrentProf().switchingItem(rang, rang2);
        		}
        	}
		}
		
		if(gc.getGamePane().getCurrentProf() == null || gc.getGamePane().getCurrentProf().stillHasAction() == false)
			persoSuivant();
		gc.getGamePane().repaint();
		infoPane.repaint();
	}
	
	// Take the next professor in the list and check if the professor is alive. Put back the action points
	public void persoSuivant()
	{
		// Reset action points and stillHasEffect
		gc.getGamePane().getCurrentProf().setAction(4);
		gc.getGamePane().getCurrentProf().setStillHasEffect(true);
		
		int i = 1;
		while(gc.getGamePane().getCurrentProf().getId() + i < 4 && gc.getGamePane().getBoard().getListProf()[gc.getGamePane().getCurrentProf().getId() + i] == null)
		{
			i++;
		}
		// If one of the professors haven't play, start his turn 
		if (gc.getGamePane().getCurrentProf().getId() + i < 4)
		{
			gc.getGamePane().setCurrentProf(gc.getGamePane().getBoard().getListProf()[gc.getGamePane().getCurrentProf().getId() + i]);
		}
		else
		{
			testWin();
			// Students' round
			gc.getGamePane().getBoard().startRoundStudent();
			// Test loose
			int j = 0;
			while (j < 4 && gc.getGamePane().getBoard().getListProf()[j] == null) 
			{
				j++;
			}
			if(j < 4) // If not loose, start with the first professor alive
				gc.getGamePane().setCurrentProf(gc.getGamePane().getBoard().getListProf()[j]);
			else
				gameover();
		}
		infoPane.repaint();
	}
	
	// Choose a case to attack
	public void chooseCase (int nWeapon)
	{
		switch(gc.getGamePane().getCurrentProf().getListItem()[nWeapon].getRange())
		{
		case 0:
			chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX(), gc.getGamePane().getCurrentProf().getCurrent_case().getY());
			break;
		case 1:
			String[] reponse = {"Annuler", "Annuler", "Annuler", "Annuler", "Votre case"};
			if (gc.getGamePane().getCurrentProf().getCurrent_case().getIsLinkedTo(0))
				reponse[0] = "Une case au dessus";
			if (gc.getGamePane().getCurrentProf().getCurrent_case().getIsLinkedTo(1))
				reponse[1] = "Une case en dessous";
			if (gc.getGamePane().getCurrentProf().getCurrent_case().getIsLinkedTo(2))
				reponse[2] = "Une case a droite";	
			if (gc.getGamePane().getCurrentProf().getCurrent_case().getIsLinkedTo(3))
				reponse[3] = "Une case a gauche";
	    	int rang = JOptionPane.showOptionDialog(null,"Choisir quelle case attaquer","Quelle case attaquer ?",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,reponse,reponse);
			if (gc.getGamePane().getCurrentProf().getCurrent_case().getIsLinkedTo(rang))
			{
				switch(rang)
				{
				case 0:
					if (reponse[rang] != "Annuler")
						chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX(), gc.getGamePane().getCurrentProf().getCurrent_case().getY() + 1);
					break;
				case 1:
					if (reponse[rang] != "Annuler")
						chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX(), gc.getGamePane().getCurrentProf().getCurrent_case().getY() - 1);
					break;
				case 2:
					if (reponse[rang] != "Annuler")
						chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX() + 1, gc.getGamePane().getCurrentProf().getCurrent_case().getY());
					break;
				case 3:
					if (reponse[rang] != "Annuler")
						chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX() - 1, gc.getGamePane().getCurrentProf().getCurrent_case().getY());
					break;
				case 4:
					chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX(), gc.getGamePane().getCurrentProf().getCurrent_case().getY());
					break;
				}
			}
	    	break;
		case 2:
			String[] reponse2 = {"Annuler", "Annuler", "Annuler", "Annuler", "Annuler", "Annuler", "Annuler", "Annuler", "Votre case"};
			if (gc.getGamePane().getCurrentProf().getCurrent_case().getIsLinkedTo(0))
				reponse2[0] = "Une case au dessus";
			if (gc.getGamePane().getCurrentProf().getCurrent_case().getIsLinkedTo(1))
				reponse2[1] = "Une case en dessous";
			if (gc.getGamePane().getCurrentProf().getCurrent_case().getIsLinkedTo(2))
				reponse2[2] = "Une case a droite";	
			if (gc.getGamePane().getCurrentProf().getCurrent_case().getIsLinkedTo(3))
				reponse2[3] = "Une case a gauche";
			if (gc.getGamePane().getCurrentProf().getCurrent_case().getIsLinkedTo(0) &&
					gc.getGamePane().getBoard().getBoard()[gc.getGamePane().getCurrentProf().getCurrent_case().getX()][gc.getGamePane().getCurrentProf().getCurrent_case().getY() + 1].getIsLinkedTo(0))
				reponse2[4] = "Deux cases au dessus";
			if (gc.getGamePane().getCurrentProf().getCurrent_case().getIsLinkedTo(1) &&
					gc.getGamePane().getBoard().getBoard()[gc.getGamePane().getCurrentProf().getCurrent_case().getX()][gc.getGamePane().getCurrentProf().getCurrent_case().getY() - 1].getIsLinkedTo(1))
				reponse2[5] = "Deux cases en dessous";
			if (gc.getGamePane().getCurrentProf().getCurrent_case().getIsLinkedTo(2) &&
					gc.getGamePane().getBoard().getBoard()[gc.getGamePane().getCurrentProf().getCurrent_case().getX() + 1][gc.getGamePane().getCurrentProf().getCurrent_case().getY()].getIsLinkedTo(2))
				reponse2[6] = "Deux cases a droite";	
			if (gc.getGamePane().getCurrentProf().getCurrent_case().getIsLinkedTo(3) &&
					gc.getGamePane().getBoard().getBoard()[gc.getGamePane().getCurrentProf().getCurrent_case().getX() - 1][gc.getGamePane().getCurrentProf().getCurrent_case().getY()].getIsLinkedTo(3))
				reponse2[7] = "Deux cases a gauche";
	    	int rang2 = JOptionPane.showOptionDialog(null,"Choisir quelle case attaquer","Quelle case attaquer ?",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,reponse2,reponse2);
			switch(rang2)
			{
			case 0:
				if(reponse2[rang2] != "Annuler")
					chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX(), gc.getGamePane().getCurrentProf().getCurrent_case().getY() + 1);
				break;
			case 1:
				if(reponse2[rang2] != "Annuler")
					chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX(), gc.getGamePane().getCurrentProf().getCurrent_case().getY() - 1);
				break;
			case 2:
				if(reponse2[rang2] != "Annuler")
					chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX() + 1, gc.getGamePane().getCurrentProf().getCurrent_case().getY());
				break;
			case 3:
				if(reponse2[rang2] != "Annuler")
					chooseTarget(nWeapon,gc.getGamePane().getCurrentProf().getCurrent_case().getX() - 1, gc.getGamePane().getCurrentProf().getCurrent_case().getY());
				break;
			case 4:
				if(reponse2[rang2] != "Annuler")
					chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX(), gc.getGamePane().getCurrentProf().getCurrent_case().getY() + 2);
				break;
			case 5:
				if(reponse2[rang2] != "Annuler")
					chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX(), gc.getGamePane().getCurrentProf().getCurrent_case().getY() - 2);
				break;
			case 6:
				if(reponse2[rang2] != "Annuler")
					chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX() + 2, gc.getGamePane().getCurrentProf().getCurrent_case().getY());
				break;
			case 7:
				if(reponse2[rang2] != "Annuler")
					chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX() - 2, gc.getGamePane().getCurrentProf().getCurrent_case().getY());
				break;	
			case 8:
				chooseTarget(nWeapon, gc.getGamePane().getCurrentProf().getCurrent_case().getX(), gc.getGamePane().getCurrentProf().getCurrent_case().getY());
				break;
			}
			break;
		}
	}
	
	// Choose a target to attack
	public void chooseTarget (int nWeapon, int x, int y)
	{
		String reponse[] = {"TC", "BDS", "IUT", "Etranger"};
		int rang = JOptionPane.showOptionDialog(null,"Choisir quel type d'eleve a attaquer sur cette case","Quel type d'eleve attaquer ?",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,reponse,reponse);
		int size = gc.getGamePane().getBoard().getListStudent().size();
		int i = 0;
		while (i < size && (gc.getGamePane().getBoard().getListStudent().get(i).getStudentType() != rang ||
				gc.getGamePane().getBoard().getListStudent().get(i).getCurrent_case().getX() != x ||
				gc.getGamePane().getBoard().getListStudent().get(i).getCurrent_case().getY() != y))
		{
			i++;
		}
		if (i < size)
		{
			gc.getGamePane().getCurrentProf().attackStudent(gc.getGamePane().getBoard(), i, nWeapon, this); 
		}
		else
		{
			JOptionPane.showMessageDialog(gc.getGamePane().getTopLevelFrame(), "                             Il n'y a aucun etudiant de ce type ici.                                 ", "Les lunettes de soleil n'etaient pas une si bonne idee...", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	// Print a message if the attack failed
	public void printFailedAttack()
	{
		JOptionPane.showMessageDialog(gc.getGamePane().getTopLevelFrame(), "L'attaque a echoue", "Echec de l'attaque", JOptionPane.WARNING_MESSAGE);
	}
	
	// Print a message if the weapon cannot kill this type of student
	public void printWeaponTooWeak()
	{
		JOptionPane.showMessageDialog(gc.getGamePane().getTopLevelFrame(), "L'arme utilisee ne peut vous débarasser de cet eleve", "Choisissez une autre arme", JOptionPane.WARNING_MESSAGE);
	}
	
	// Print a message if the weapon cannot open a door
	public void printCantOpenDoor()
	{
		JOptionPane.showMessageDialog(gc.getGamePane().getTopLevelFrame(), "L'arme utilisee ne peut ouvrir de porte", "Choisissez une autre arme", JOptionPane.WARNING_MESSAGE);
	}
	
	// Function that test if the game is won
	public void testWin()
	{
		int counter = 0;
		for (int i = 0; i < 4; i++)
		{
			if(gc.getGamePane().getBoard().getListProf()[i] == null || gc.getGamePane().getBoard().getListProf()[i].getCurrent_case().getX() == 6 
					&& gc.getGamePane().getBoard().getListProf()[i].getCurrent_case().getY() == 0)
			{
				counter++;
			}
		}
		if (counter == 4)
			gameWon();
	}
	
	// Function that end the game in case of loose
	public void gameover()
	{
		JOptionPane.showMessageDialog(gc.getGamePane().getTopLevelFrame(), "Malheureusement, nos valeureux professeurs n'ont pas ete capable "
				+ "de surmonter le defi. Les eleves ont triomphes, ne sont toujours pas inscrit et ce sont plaint. Nos "
				+ "heros ont eu droit a une petite visite du directeur\nqui leur annonca qu'ils devront retourner s'exercer "
				+ "dans une ecole primaire. Peut etre que dans quelques annees l'experience qu'ils y auront acquis "
				+ "leur permettra de faire face a des situations aussi extremes\nune seconde fois ? Personne ne sait"
				+ " de quoi l'avenir sera fait.", "Perdu...", JOptionPane.WARNING_MESSAGE);
		gc.getGamePane().getTopLevelFrame().dispose();
		Main.startGame();
	}
	
	// Function that end the game in case of win
	public void gameWon()
	{
		JOptionPane.showMessageDialog(gc.getGamePane().getTopLevelFrame(), "Alors la ... ils ont vaincu la mort. Pire qu'une armee de zombie ? Une "
				+ "armee d'etudiants aux consoles ! Mais il en faudra plus pour faire grincer des dents nos heros ! "
				+ "Ils sont parvenu a rentrer chez eux, mais en plus,\nIls ont recu un appel pour une petite augmentation ! "
				+ "Bon, ce n'est certes qu'un bon de 10 euros pour la boutique UTBM, mais, c'est deja  un bon debut. ", 
				"Felicitation !", JOptionPane.PLAIN_MESSAGE);
		gc.getGamePane().getTopLevelFrame().dispose();
		Main.startGame();
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
	public JButton getutiliserEffet() {
		return utiliserEffet;
	}
	public void setutiliserEffet(JButton utiliserEffet) {
		this.utiliserEffet = utiliserEffet;
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
