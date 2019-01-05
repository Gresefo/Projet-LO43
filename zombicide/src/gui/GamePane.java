package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import engine.Professor;
import engine.Student;
import engine.Student_BDS;
import engine.Student_IUT;
import engine.Student_TC;
import engine.Student_foreigners;
import engine.Board;
import engine.Case;
import engine.Flesch;
import engine.Gechter;
import engine.Lacaille;
import engine.Zullo;



public class GamePane extends JPanel {
	private static final long serialVersionUID = -5201433530107117026L;
	
	private JFrame topLevelFrame;
	
	private BufferedImage GRILLE, GRILLE_FERME, S1, S2, S3, S4, S5, S6, S7, S8, COFFRE_OP;
	private BufferedImage GECHTER, FLESCH, LACAILLE, ZULLO;
	private BufferedImage BRUIT1, BRUIT2, BRUIT3, BRUIT4;
	private BufferedImage TC, BDS, IUT, FOREIGN;
	private boolean salle1 = false, salle2 = false, salle3 = false, salle4 = false, salle5 = false, salle6 = false, salle7 = false, salle8 = false;
	private boolean coffre1 = false, coffre2 = false, coffre3 = false, coffre4 = false;
	private Board board;
	private Professor currentProf;
	
	/*******************  Constructor  ********************/
	
	public GamePane(JFrame topLevelFrame) {
		super();
		this.topLevelFrame = topLevelFrame;
		this.setPreferredSize(new Dimension(1120, 800));
		try {
			//GECHTER_IMG = ImageIO.read(new File("img/gechter.png"));
			GRILLE = ImageIO.read(new File("img/grille_couloirs.png"));
			GRILLE_FERME = ImageIO.read(new File("img/grille_couloirs_ferme.png"));
			S1 = ImageIO.read(new File("img/salle1.png"));
			S2 = ImageIO.read(new File("img/salle2.png"));
			S3 = ImageIO.read(new File("img/salle3.png"));
			S4 = ImageIO.read(new File("img/salle4.png"));
			S5 = ImageIO.read(new File("img/salle5.png"));
			S6 = ImageIO.read(new File("img/salle6.png"));
			S7 = ImageIO.read(new File("img/salle7.png"));
			S8 = ImageIO.read(new File("img/salle8.png"));
			COFFRE_OP = ImageIO.read(new File("img/coffre_ouvert.png"));
			
			GECHTER = ImageIO.read(new File("img/tete_gechter_t.png"));
			FLESCH = ImageIO.read(new File("img/tete_flesch_t.png"));
			LACAILLE = ImageIO.read(new File("img/tete_lacaille_t.png"));
			ZULLO = ImageIO.read(new File("img/tete_zullo_t.png"));
			
			BRUIT1 = ImageIO.read(new File("img/bruit1.png"));
			BRUIT2 = ImageIO.read(new File("img/bruit2.png"));
			BRUIT3 = ImageIO.read(new File("img/bruit3.png"));
			BRUIT4 = ImageIO.read(new File("img/bruit4.png"));
			
			TC = ImageIO.read(new File("img/student_TC.png"));
			BDS = ImageIO.read(new File("img/student_BDS.png"));
			IUT = ImageIO.read(new File("img/student_IUT.png"));
			FOREIGN = ImageIO.read(new File("img/student_for.png"));
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		

		// Initialization of the board
		this.board = new Board();
		
		board.getBoard()[0][0] = new Case(0, 0, 0, 0, 0, true, false, true, false);
		board.getBoard()[0][0].setIsLinkedTo(true, 0);
		
		board.getBoard()[1][0] = new Case(1, 0, 0, 0, 0, false, false, true, false);
		
		board.getBoard()[2][0] = new Case(2, 0, 0, 0, 0, false, false, false, false);
		board.getBoard()[2][0].setIsLinkedTo(true, 0);
		board.getBoard()[2][0].setIsLinkedTo(true, 2);
		
		board.getBoard()[3][0] = new Case(3, 0, 0, 0, 1, false, false, false, true);
		board.getBoard()[3][0].setIsLinkedTo(true, 2);
		board.getBoard()[3][0].setIsLinkedTo(true, 3);
		
		board.getBoard()[4][0] = new Case(4, 0, 0, 0, 0, false, false, false, false);
		board.getBoard()[4][0].setIsLinkedTo(true, 2);
		board.getBoard()[4][0].setIsLinkedTo(true, 3);

		board.getBoard()[5][0] = new Case(5, 0, 0, 0, 0, false, false, false, false);
		board.getBoard()[5][0].setIsLinkedTo(true, 0);
		board.getBoard()[5][0].setIsLinkedTo(true, 3);
		
		board.getBoard()[6][0] = new Case(6, 0, 0, 0, 0, false, false, true, false);

		board.getBoard()[0][1] = new Case(0, 1, 0, 0, 0, false, false, true, false);
		board.getBoard()[0][1].setIsLinkedTo(true, 1);
		
		board.getBoard()[1][1] = new Case(1, 1, 0, 0, 2, false, false, false, false);
		board.getBoard()[1][1].setIsLinkedTo(true, 0);
		board.getBoard()[1][1].setIsLinkedTo(true, 2);
		
		board.getBoard()[2][1] = new Case(2, 1, 0, 0, 0, false, false, false, false);
		board.getBoard()[2][1].setIsLinkedTo(true, 1);
		board.getBoard()[2][1].setIsLinkedTo(true, 3);
		
		board.getBoard()[3][1] = new Case(3, 1, 0, 0, 0, false, false, true, false);
		board.getBoard()[3][1].setIsLinkedTo(true, 2);
		
		board.getBoard()[4][1] = new Case(4, 1, 0, 0, 0, true, true, true, false);
		board.getBoard()[4][1].setIsLinkedTo(true, 3);
		
		board.getBoard()[5][1] = new Case(5, 1, 0, 0, 0, false, false, false, false);
		board.getBoard()[5][1].setIsLinkedTo(true, 0);
		board.getBoard()[5][1].setIsLinkedTo(true, 1);
		board.getBoard()[5][1].setIsLinkedTo(true, 2);
	
		board.getBoard()[6][1] = new Case(6, 1, 0, 0, 0, false, false, false, false);
		board.getBoard()[6][1].setIsLinkedTo(true, 3);
		
		board.getBoard()[0][2] = new Case(0, 2, 0, 0, 2, false, false, false, true);
		board.getBoard()[0][2].setIsLinkedTo(true, 2);
		
		board.getBoard()[1][2] = new Case(1, 2, 0, 0, 0, false, false, false, false);
		board.getBoard()[1][2].setIsLinkedTo(true, 0);
		board.getBoard()[1][2].setIsLinkedTo(true, 1);
		board.getBoard()[1][2].setIsLinkedTo(true, 3);
		
		board.getBoard()[2][2] = new Case(2, 2, 0, 0, 0, false, false, true, false);
		board.getBoard()[2][2].setIsLinkedTo(true, 2);
	
		board.getBoard()[3][2] = new Case(3, 2, 0, 0, 0, false, false, true, false);
		board.getBoard()[3][2].setIsLinkedTo(true, 3);
		
		board.getBoard()[4][2] = new Case(4, 2, 0, 0, 0, false, false, false, true);
		board.getBoard()[4][2].setIsLinkedTo(true, 0);
		board.getBoard()[4][2].setIsLinkedTo(true, 2);
		
		board.getBoard()[5][2] = new Case(5, 2, 0, 0, 0, false, false, false, false);
		board.getBoard()[5][2].setIsLinkedTo(true, 1);
		board.getBoard()[5][2].setIsLinkedTo(true, 3);
		
		board.getBoard()[6][2] = new Case(6, 2, 0, 0, 0, false, false, true, false);
		board.getBoard()[6][2].setIsLinkedTo(true, 0);
		
		board.getBoard()[0][3] = new Case(0, 3, 0, 0, 0, true, false, true, false);
		
		board.getBoard()[1][3] = new Case(1, 3, 0, 0, 4, false, false, false, false);
		board.getBoard()[1][3].setIsLinkedTo(true, 0);
		board.getBoard()[1][3].setIsLinkedTo(true, 1);
		board.getBoard()[1][3].setIsLinkedTo(true, 2);
		
		board.getBoard()[2][3] = new Case(2, 3, 0, 0, 1, false, false, false, false);
		board.getBoard()[2][3].setIsLinkedTo(true, 2);
		board.getBoard()[2][3].setIsLinkedTo(true, 3);
		
		board.getBoard()[3][3] = new Case(3, 3, 0, 0, 2, false, false, false, false);
		board.getBoard()[3][3].setIsLinkedTo(true, 2);
		board.getBoard()[3][3].setIsLinkedTo(true, 3);
		
		board.getBoard()[4][3] = new Case(4, 3, 0, 0, 0, false, false, false, false);
		board.getBoard()[4][3].setIsLinkedTo(true, 0);
		board.getBoard()[4][3].setIsLinkedTo(true, 1);
		board.getBoard()[4][3].setIsLinkedTo(true, 3);
		
		board.getBoard()[5][3] = new Case(5, 3, 0, 0, 0, false, false, true, false);
		board.getBoard()[5][3].setIsLinkedTo(true, 2);
		
		board.getBoard()[6][3] = new Case(6, 3, 0, 0, 0, false, false, true, false);
		board.getBoard()[6][3].setIsLinkedTo(true, 1);
		board.getBoard()[6][3].setIsLinkedTo(true, 3);
		
		board.getBoard()[0][4] = new Case(0, 4, 0, 0, 0, false, false, false, false);
		board.getBoard()[0][4].setIsLinkedTo(true, 2);
		
		board.getBoard()[1][4] = new Case(1, 4, 0, 0, 0, false, false, false, false);
		board.getBoard()[1][4].setIsLinkedTo(true, 1);
		board.getBoard()[1][4].setIsLinkedTo(true, 3);
		
		board.getBoard()[2][4] = new Case(2, 4, 0, 0, 0, false, false, true, false);
		board.getBoard()[2][4].setIsLinkedTo(true, 2);
		
		board.getBoard()[3][4] = new Case(3, 4, 0, 0, 0, true, false, true, false);
		board.getBoard()[3][4].setIsLinkedTo(true, 3);
		
		board.getBoard()[4][4] = new Case(4, 4, 0, 0, 0, false, false, false, false);
		board.getBoard()[4][4].setIsLinkedTo(true, 1);
		board.getBoard()[4][4].setIsLinkedTo(true, 2);
		
		board.getBoard()[5][4] = new Case(5, 4, 0, 0, 2, false, false, false, false);
		board.getBoard()[5][4].setIsLinkedTo(true, 2);
		board.getBoard()[5][4].setIsLinkedTo(true, 3);
		
		board.getBoard()[6][4] = new Case(6, 4, 0, 0, 0, false, false, false, true);
		board.getBoard()[6][4].setIsLinkedTo(true, 3);
		
		
		// Apparition of the professors
		Gechter gechter = new Gechter();
		Lacaille lacaille = new Lacaille();
		Flesch flesch = new Flesch();
		Zullo zullo = new Zullo();
		gechter.setId(0);
		lacaille.setId(1);
		flesch.setId(2);
		zullo.setId(3);
		board.setListProf(gechter, 0);
		board.setListProf(lacaille, 1);
		board.setListProf(flesch, 2);
		board.setListProf(zullo, 3);
		for (int i = 0; i < 4; i++)
		{
			board.getListProf()[i].setCurrent_case(board.getBoard()[0][4]);
		}
		
		// First weapon for every professor
		board.getListProf()[0].setListItem(board.getListAllItems()[2], 0);
		board.getListProf()[1].setListItem(board.getListAllItems()[0], 0);
		board.getListProf()[2].setListItem(board.getListAllItems()[5], 0);
		board.getListProf()[3].setListItem(board.getListAllItems()[1], 0);
		
		currentProf = board.getListProf()[0];
	}

	/*******************  Operations  ********************/
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(GRILLE, 0, 0, this);
		g.drawImage(GRILLE_FERME, 0, 0, this);
		if (salle1)
			g.drawImage(S1, 0, 0, this);
		if (salle2)
			g.drawImage(S2, 0, 0, this);
		if (salle3)
			g.drawImage(S3, 0, 0, this);
		if (salle4)
			g.drawImage(S4, 0, 0, this);
		if (salle5)
			g.drawImage(S5, 0, 0, this);
		if (salle6)
			g.drawImage(S6, 0, 0, this);
		if (salle7)
			g.drawImage(S7, 0, 0, this);
		if (salle8)
			g.drawImage(S8, 0, 0, this);
		if (coffre1)
			g.drawImage(COFFRE_OP, 105, 265, this);
		if (coffre2)
			g.drawImage(COFFRE_OP, 16, 680, this);
		if (coffre3)
			g.drawImage(COFFRE_OP, 522, 103, this);
		if (coffre4)
			g.drawImage(COFFRE_OP, 666, 574, this);
		
		if(board.getListProf()[0] != null)
		{
			g.drawImage(GECHTER, 160 * (board.getListProf()[0].getCurrent_case().getX()) + 5, 800 - 160 * (board.getListProf()[0].getCurrent_case().getY() + 1) + 5, this);
		}
		if(board.getListProf()[1] != null)	
		{
			g.drawImage(LACAILLE, 160 * (board.getListProf()[1].getCurrent_case().getX()) + 75, 800 - 160 * (board.getListProf()[1].getCurrent_case().getY() + 1) + 5, this);
		}
		if(board.getListProf()[2] != null)
		{
			g.drawImage(FLESCH, 160 * (board.getListProf()[2].getCurrent_case().getX()) + 40, 800 - 160 * (board.getListProf()[2].getCurrent_case().getY() + 1) + 5, this);
		}
		if(board.getListProf()[3] != null)	
		{
			g.drawImage(ZULLO, 160 * (board.getListProf()[3].getCurrent_case().getX()) + 100, 800 - 160 * (board.getListProf()[3].getCurrent_case().getY() + 1) + 5, this);
		}
	
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				if (board.getBoard()[i][j].getNoise() == 1) {
					g.drawImage(BRUIT1, 160 * board.getBoard()[i][j].getX() + 115, 800 - 160 * (board.getBoard()[i][j].getY() + 1) + 115, this);
				}
				else if (board.getBoard()[i][j].getNoise() == 2) {
					g.drawImage(BRUIT2, 160 * board.getBoard()[i][j].getX() + 115, 800 - 160 * (board.getBoard()[i][j].getY() + 1) + 115, this);
				}
				else if (board.getBoard()[i][j].getNoise() == 3) {
					g.drawImage(BRUIT3, 160 * board.getBoard()[i][j].getX() + 115, 800 - 160 * (board.getBoard()[i][j].getY() + 1) + 115, this);
				}
				else if (board.getBoard()[i][j].getNoise() >= 4) {
					g.drawImage(BRUIT4, 160 * board.getBoard()[i][j].getX() + 115, 800 - 160 * (board.getBoard()[i][j].getY() + 1) + 115, this);
				}
			}
		}
		ArrayList<Student> list = board.getListStudent();
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				int u = 0;
				for (Student stud : list) {
					if (stud.getCurrent_case().getX() == i && stud.getCurrent_case().getY() == j) {
						if (stud instanceof Student_TC)
						{
							if (u == 0)
								g.drawImage(TC, 160 * stud.getCurrent_case().getX() + 5, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 1)
								g.drawImage(TC, 160 * stud.getCurrent_case().getX() + 40, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 2)
								g.drawImage(TC, 160 * stud.getCurrent_case().getX() + 75, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 3)
								g.drawImage(TC, 160 * stud.getCurrent_case().getX() + 100, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 4)
								g.drawImage(TC, 160 * stud.getCurrent_case().getX() + 5, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							else if (u == 5)
								g.drawImage(TC, 160 * stud.getCurrent_case().getX() + 40, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							else if (u == 6)
								g.drawImage(TC, 160 * stud.getCurrent_case().getX() + 75, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							else if (u == 7)
								g.drawImage(TC, 160 * stud.getCurrent_case().getX() + 100, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							u++;
							
						}
						else if (stud instanceof Student_BDS) {
							if (u == 0) 
								g.drawImage(BDS, 160 * stud.getCurrent_case().getX() + 5, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 1)
								g.drawImage(BDS, 160 * stud.getCurrent_case().getX() + 40, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 2)
								g.drawImage(BDS, 160 * stud.getCurrent_case().getX() + 75, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 3)
								g.drawImage(BDS, 160 * stud.getCurrent_case().getX() + 100, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 4)
								g.drawImage(BDS, 160 * stud.getCurrent_case().getX() + 5, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							else if (u == 5)
								g.drawImage(BDS, 160 * stud.getCurrent_case().getX() + 40, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							else if (u == 6)
								g.drawImage(BDS, 160 * stud.getCurrent_case().getX() + 75, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							else if (u == 7)
								g.drawImage(BDS, 160 * stud.getCurrent_case().getX() + 100, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							u++;
						}
						else if (stud instanceof Student_IUT) {
							if (u == 0)
								g.drawImage(IUT, 160 * stud.getCurrent_case().getX() + 5, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 1)
								g.drawImage(IUT, 160 * stud.getCurrent_case().getX() + 40, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 2)
								g.drawImage(IUT, 160 * stud.getCurrent_case().getX() + 75, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 3)
								g.drawImage(IUT, 160 * stud.getCurrent_case().getX() + 100, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 4)
								g.drawImage(IUT, 160 * stud.getCurrent_case().getX() + 5, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							else if (u == 5)
								g.drawImage(IUT, 160 * stud.getCurrent_case().getX() + 40, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							else if (u == 6)
								g.drawImage(IUT, 160 * stud.getCurrent_case().getX() + 75, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							else if (u == 7)
								g.drawImage(IUT, 160 * stud.getCurrent_case().getX() + 100, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							u++;
						}
						else if (stud instanceof Student_foreigners) {
							if (u == 0)
								g.drawImage(FOREIGN, 160 * stud.getCurrent_case().getX() + 5, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 1)
								g.drawImage(FOREIGN, 160 * stud.getCurrent_case().getX() + 40, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 2)
								g.drawImage(FOREIGN, 160 * stud.getCurrent_case().getX() + 75, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 3)
								g.drawImage(FOREIGN, 160 * stud.getCurrent_case().getX() + 100, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 40, this);
							else if (u == 4)
								g.drawImage(FOREIGN, 160 * stud.getCurrent_case().getX() + 5, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							else if (u == 5)
								g.drawImage(FOREIGN, 160 * stud.getCurrent_case().getX() + 40, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							else if (u == 6)
								g.drawImage(FOREIGN, 160 * stud.getCurrent_case().getX() + 75, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							else if (u == 7)
								g.drawImage(FOREIGN, 160 * stud.getCurrent_case().getX() + 100, 800 - 160 * (stud.getCurrent_case().getY() + 1) + 80, this);
							u++;
						}
					}
				}
			}
		}
	}

	/*******************  Getters and Setters  ********************/
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public Professor getCurrentProf() {
		return currentProf;
	}

	public void setCurrentProf(Professor currentProf) {
		this.currentProf = currentProf;
	}

	public boolean getSalle1() {
		return salle1;
	}

	public void setSalle1(boolean salle1) {
		this.salle1 = salle1;
	}

	public boolean getSalle2() {
		return salle2;
	}

	public void setSalle2(boolean salle2) {
		this.salle2 = salle2;
	}

	public boolean getSalle3() {
		return salle3;
	}

	public void setSalle3(boolean salle3) {
		this.salle3 = salle3;
	}

	public boolean getSalle4() {
		return salle4;
	}

	public void setSalle4(boolean salle4) {
		this.salle4 = salle4;
	}

	public boolean getSalle5() {
		return salle5;
	}

	public void setSalle5(boolean salle5) {
		this.salle5 = salle5;
	}

	public boolean getSalle6() {
		return salle6;
	}

	public void setSalle6(boolean salle6) {
		this.salle6 = salle6;
	}

	public boolean getSalle7() {
		return salle7;
	}

	public void setSalle7(boolean salle7) {
		this.salle7 = salle7;
	}

	public boolean getSalle8() {
		return salle8;
	}

	public void setSalle8(boolean salle8) {
		this.salle8 = salle8;
	}
	public boolean getCoffre1() {
		return coffre1;
	}

	public void setCoffre1(boolean coffre1) {
		this.coffre1 = coffre1;
	}

	public boolean getCoffre2() {
		return coffre2;
	}

	public void setCoffre2(boolean coffre2) {
		this.coffre2 = coffre2;
	}

	public boolean getCoffre3() {
		return coffre3;
	}

	public void setCoffre3(boolean coffre3) {
		this.coffre3 = coffre3;
	}

	public boolean getCoffre4() {
		return coffre4;
	}

	public void setCoffre4(boolean coffre4) {
		this.coffre4 = coffre4;
	}
	public JFrame getTopLevelFrame() {
		return this.topLevelFrame;
	}
}
