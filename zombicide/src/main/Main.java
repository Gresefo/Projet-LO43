package main;

import gui.MenuGUI;

public class Main {

	public static void main(String[] args) 
	{
		startGame();
	}
	
	public static void printInTerminal(String str) 
	{
		System.out.println(str);
	}
	public static void startGame() {
		// Creation of the window
		MenuGUI fen = new MenuGUI();
		fen.createWindow();
	}
}
