package main;

import gui.MenuGUI;
import engine.Professor;
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
import engine.ProfessorName;

public class Main {

	public static void main(String[] args) 
	{
		// Creation of the window
		MenuGUI fen = new MenuGUI();
		fen.createWindow();
		
		

		/*
		// Rounds
		while(board.getListHumanoides()[0].getCurrent_case() != board.getBoard()[0][6] &&
				board.getListHumanoides()[1].getCurrent_case() != board.getBoard()[0][6] &&
				board.getListHumanoides()[2].getCurrent_case() != board.getBoard()[0][6] &&
				board.getListHumanoides()[3].getCurrent_case() != board.getBoard()[0][6])
		{
			// Student apparition
			int nbNewStudent = board.nbNewStudent();
			for (int i = 0; i < nbNewStudent; i++)
			{
				int j = 4;
				while(board.getListHumanoides()[j] != null)
				{
					j++;
				}
				board.addHumanoide(j);
				//board.getListHumanoides()[j].setCurrent_case(board.getBoard()[][]);
			}
			
			
			// Professor' turn
			
			
			// Student's turn
			
			
		}
		System.out.println("GG WP you won !!!");*/
	}
	
	public static void printInTerminal(String str) 
	{
		System.out.println(str);
	}
}
