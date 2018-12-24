//import java.util.*;
//import java.io.*;

public class Board {
	Case board[][] = new Case[5][7];//à mettre en static
	private Case start, end;
	// All class from the package can access those 2 attributs
	Humanoides listHumanoides[]; 
	Item listAllItems[] = new Item[11];
	
	/*public Case[] neighbour(int x, int y) {
	Case neigh[] = null;
	Case n = new Case();
	Case e = new Case();
	Case s = new Case();
	Case o = new Case();
	  board[y+1][x]=n;
	  board[y][x+1]=e;
	  board[y-1][x]=s;
	  board[y][x-1]=o;
	  neigh[0] = n;
	  neigh[1] = e;
	  neigh[2] = s;
	  neigh[3] = o;
	  
	  return neigh;
	  } */
	
	// Constructors
	public Board() 
	{
		for (int i=0; i<7; i++) 
		{
			for (int j=0; j<5; j++) 
			{
				Case c = new Case();
				board [j][i] = c;
				System.out.print("-");
			}
			System.out.println(" ");
		}
		// Initialize a list of all Items
		listAllItems[0] = new Weapon(1, "Stylo", true, true, false, true, 2, 1, 4, 2);
		listAllItems[1] = new Weapon(2, "Clé", true, true, false, true, 0, 3, 5, 2);
		listAllItems[2] = new Weapon(3, "Guitare", true, false, false, false, 0, 3, 4, 2);
		listAllItems[3] = new Weapon(4, "Craies", false, false, false, true, 2, 3, 5, 1);
		listAllItems[4] = new Weapon(5, "Craies améliorées", false, false, false, true, 2, 4, 3, 1);
		listAllItems[5] = new Weapon(6, "Fil de souris", false, false, true, false, 1, 2, 4, 1);
		listAllItems[6] = new Weapon(7, "Liste des UV de culture générale", false, false, true, false, 0, 3, 3, 1);
		listAllItems[7] = new Weapon(8, "Dictionnaire français-anglais", false, false, false, false, 2, 1, 1, 3);
		listAllItems[8] = new Item(9, "Loupe");
		listAllItems[9] = new Item(10, "Dictionnaire partie 1");
		listAllItems[10] = new Item(11, "Dictionnaire partie 2");
	}
	
	// Getters and Setters
	
	public Case getEnd() {
		return this.end;
	}
	
	public Case getStart() {
		return this.start;
	}
	
	public void setStart(int x, int y) {
		Case re = new Case();
		for(int i=0; i<= 7|| i!=y; i++) {
			for(int j=0; j<=5 || j !=x; j++) {
				board[j][i] = re;
			}
		}
		this.start= re;
	}
	
	public void setEnd(int x, int y) {
		Case re = new Case();
		for(int i=0; i<= 8 || i!=y; i++) {
			for(int j=0; j<=4 || j !=x; j++) {
				board[j][i] = re;
			}
		}
		this.end= re;
	}
	
}