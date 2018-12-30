package main;

import gui.MenuGUI;
import engine.Board;
import engine.Case;

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
		board.getBoard()[2][3].setIsLinkedTo(true, 4);
		
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
	}

	public static void printInTerminal(String str) {
		System.out.println(str);
	}
}
