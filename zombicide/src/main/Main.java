package main;

import gui.MenuGUI;

public class Main {

	public static void main(String[] args) {
		MenuGUI fen = new MenuGUI();
		fen.createWindow();
	}

	public static void printInTerminal(String str) {
		System.out.println(str);
	}
}
