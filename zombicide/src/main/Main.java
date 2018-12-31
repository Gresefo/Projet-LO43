package main;

import gui.MenuGUI;
import engine.AttackException;
import engine.Board;
import engine.Case;
import engine.Consumable;
import engine.Dice;
import engine.Flesch;
import engine.Gechter;
import engine.Lacaille;
import engine.Student_foreigners;
import engine.Student_IUT;
import engine.Student_TC;
import engine.Student_BDS;
import engine.Weapon;
import engine.Zullo;

public class Main {

	public static void main(String[] args) {
		
		// Initialization of the board
		Board board = new Board();
		
		board.getBoard()[0][0] = new Case(0, 0, 0, 0, 0, true, false, true, false);
		board.getBoard()[0][0].setIsLinkedTo(true, 0);
		
		board.getBoard()[0][1] = new Case(0, 1, 0, 0, 1, false, false, true, false);
		
		board.getBoard()[0][2] = new Case(0, 2, 0, 0, 0, false, false, false, false);
		board.getBoard()[0][2].setIsLinkedTo(true, 0);
		board.getBoard()[0][2].setIsLinkedTo(true, 2);
		
		board.getBoard()[0][3] = new Case(0, 3, 0, 0, 1, false, false, false, true);
		board.getBoard()[0][3].setIsLinkedTo(true, 2);
		board.getBoard()[0][3].setIsLinkedTo(true, 3);
		
		board.getBoard()[0][4] = new Case(0, 4, 0, 0, 0, false, false, false, false);
		board.getBoard()[0][4].setIsLinkedTo(true, 2);
		board.getBoard()[0][4].setIsLinkedTo(true, 3);
		
		board.getBoard()[0][5] = new Case(0, 5, 0, 0, 0, false, false, false, false);
		board.getBoard()[0][5].setIsLinkedTo(true, 0);
		board.getBoard()[0][5].setIsLinkedTo(true, 3);
		
		board.getBoard()[0][6] = new Case(0, 6, 0, 0, 1, false, false, true, false);
		board.getBoard()[0][6].setIsLinkedTo(true, 0);

		board.getBoard()[1][0] = new Case(1, 0, 0, 0, 1, false, false, true, false);
		
		board.getBoard()[1][1] = new Case(1, 1, 0, 0, 2, false, false, false, false);
		board.getBoard()[1][1].setIsLinkedTo(true, 0);
		board.getBoard()[1][1].setIsLinkedTo(true, 2);
		
		board.getBoard()[1][2] = new Case(1, 2, 0, 0, 0, false, false, false, false);
		board.getBoard()[1][2].setIsLinkedTo(true, 1);
		board.getBoard()[1][2].setIsLinkedTo(true, 3);
		
		board.getBoard()[1][3] = new Case(1, 3, 0, 0, 2, false, false, true, false);
		board.getBoard()[1][3].setIsLinkedTo(true, 2);
		
		board.getBoard()[1][4] = new Case(1, 4, 0, 0, 0, true, true, true, false);
		board.getBoard()[1][4].setIsLinkedTo(true, 3);
		
		board.getBoard()[1][5] = new Case(1, 5, 0, 0, 0, false, false, false, false);
		board.getBoard()[1][5].setIsLinkedTo(true, 0);
		board.getBoard()[1][5].setIsLinkedTo(true, 1);
		board.getBoard()[1][5].setIsLinkedTo(true, 2);
		
		board.getBoard()[1][6] = new Case(1, 6, 0, 0, 2, false, false, false, false);
		board.getBoard()[1][6].setIsLinkedTo(true, 3);
		
		board.getBoard()[2][0] = new Case(2, 0, 0, 0, 0, false, false, false, true);
		board.getBoard()[2][0].setIsLinkedTo(true, 2);
		
		board.getBoard()[2][1] = new Case(2, 1, 0, 0, 0, false, false, false, false);
		board.getBoard()[2][1].setIsLinkedTo(true, 0);
		board.getBoard()[2][1].setIsLinkedTo(true, 1);
		board.getBoard()[2][1].setIsLinkedTo(true, 3);
		
		board.getBoard()[2][2] = new Case(2, 2, 0, 0, 0, false, false, true, false);
		board.getBoard()[2][2].setIsLinkedTo(true, 2);
		
		board.getBoard()[2][3] = new Case(2, 3, 0, 0, 1, false, false, true, false);
		board.getBoard()[2][3].setIsLinkedTo(true, 3);
		
		board.getBoard()[2][4] = new Case(2, 4, 0, 0, 0, false, false, false, true);
		board.getBoard()[2][4].setIsLinkedTo(true, 0);
		board.getBoard()[2][4].setIsLinkedTo(true, 2);
		
		board.getBoard()[2][5] = new Case(2, 5, 0, 0, 0, false, false, false, false);
		board.getBoard()[2][5].setIsLinkedTo(true, 1);
		board.getBoard()[2][5].setIsLinkedTo(true, 3);
		
		board.getBoard()[2][6] = new Case(2, 6, 0, 0, 0, false, false, true, false);
		board.getBoard()[2][6].setIsLinkedTo(true, 0);
		
		board.getBoard()[3][0] = new Case(3, 0, 0, 0, 3, true, false, true, false);
		
		board.getBoard()[3][1] = new Case(3, 1, 0, 0, 4, false, false, false, false);
		board.getBoard()[3][1].setIsLinkedTo(true, 0);
		board.getBoard()[3][1].setIsLinkedTo(true, 1);
		board.getBoard()[3][1].setIsLinkedTo(true, 2);
		
		board.getBoard()[3][2] = new Case(3, 2, 0, 0, 1, false, false, false, false);
		board.getBoard()[3][2].setIsLinkedTo(true, 2);
		board.getBoard()[3][2].setIsLinkedTo(true, 3);
		
		board.getBoard()[3][3] = new Case(3, 3, 0, 0, 2, false, false, false, false);
		board.getBoard()[3][3].setIsLinkedTo(true, 2);
		board.getBoard()[3][3].setIsLinkedTo(true, 3);
		
		board.getBoard()[3][4] = new Case(3, 4, 0, 0, 0, false, false, false, false);
		board.getBoard()[3][4].setIsLinkedTo(true, 0);
		board.getBoard()[3][4].setIsLinkedTo(true, 1);
		board.getBoard()[3][4].setIsLinkedTo(true, 3);
		
		board.getBoard()[3][5] = new Case(3, 5, 0, 0, 1, false, false, true, false);
		board.getBoard()[3][5].setIsLinkedTo(true, 2);
		
		board.getBoard()[3][6] = new Case(3, 6, 0, 0, 0, false, false, true, false);
		board.getBoard()[3][6].setIsLinkedTo(true, 1);
		board.getBoard()[3][6].setIsLinkedTo(true, 3);
		
		board.getBoard()[4][0] = new Case(4, 0, 0, 0, 0, false, false, false, false);
		board.getBoard()[4][0].setIsLinkedTo(true, 2);
		
		board.getBoard()[4][1] = new Case(4, 1, 0, 0, 0, false, false, false, false);
		board.getBoard()[4][1].setIsLinkedTo(true, 1);
		board.getBoard()[4][1].setIsLinkedTo(true, 3);
		
		board.getBoard()[4][2] = new Case(4, 2, 0, 0, 2, false, false, true, false);
		board.getBoard()[4][2].setIsLinkedTo(true, 2);
		
		board.getBoard()[4][3] = new Case(4, 3, 0, 0, 0, true, false, true, false);
		board.getBoard()[4][3].setIsLinkedTo(true, 3);
		
		board.getBoard()[4][4] = new Case(4, 4, 0, 0, 0, false, false, false, false);
		board.getBoard()[4][4].setIsLinkedTo(true, 1);
		board.getBoard()[4][4].setIsLinkedTo(true, 2);
		
		board.getBoard()[4][5] = new Case(4, 5, 0, 0, 2, false, false, false, false);
		board.getBoard()[4][5].setIsLinkedTo(true, 2);
		board.getBoard()[4][5].setIsLinkedTo(true, 3);
		
		board.getBoard()[4][6] = new Case(4, 6, 0, 0, 0, false, false, false, true);
		board.getBoard()[4][6].setIsLinkedTo(true, 3);
		
		// Creation of the window
		MenuGUI fen = new MenuGUI();
		fen.createWindow();
		
		// Apparition of the humanoides
		Gechter gechter = new Gechter();
		Lacaille lacaille = new Lacaille();
		Flesch flesch = new Flesch();
		Zullo zullo = new Zullo();
		gechter.setId(0);
		lacaille.setId(1);
		flesch.setId(2);
		zullo.setId(3);
		board.setListHumanoides(gechter, 0);
		board.setListHumanoides(lacaille, 1);
		board.setListHumanoides(flesch, 2);
		board.setListHumanoides(zullo, 3);
		for (int i = 0; i < 4; i++)
		{
			board.getListHumanoides()[i].setCurrent_case(board.getBoard()[4][0]);
		}
		
		// Rounds
		while(board.getListHumanoides()[0].getCurrent_case() != board.getBoard()[0][6] &&
				board.getListHumanoides()[1].getCurrent_case() != board.getBoard()[0][6] &&
				board.getListHumanoides()[2].getCurrent_case() != board.getBoard()[0][6] &&
				board.getListHumanoides()[3].getCurrent_case() != board.getBoard()[0][6])
		{
			// Apparition of the Student
			int nbNewStudent = nbNewStudent();
			for (int i = 0; i < nbNewStudent; i++)
			{
				int j = 4;
				while(board.getListHumanoides()[j] != null)
				{
					j++;
				}
				board.addHumanoide(j);
				board.getListHumanoides()[j].setCurrent_case(board.getBoard()[][]);
			}
			
			
			// Professor' turn
			
			
			// Student's turn
			
			
		}
		printInTerminal("GG WP you won !!!");
	}

	public static void printInTerminal(String str) {
		System.out.println(str);
	}
}
