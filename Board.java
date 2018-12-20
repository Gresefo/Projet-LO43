//import java.util.*;
//import java.io.*;

public class Board {
	private Case board[][] = new Case[5][7];//à mettre en static
	private Case start, end;
	Humanoides listHumanoides[];

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
	public Board() {
		for (int i=0; i<=7; i++) {
			for (int j=0; j<=5; j++) {
				Case c = new Case();
				board [j][i] = c;
				System.out.print("-");
			}
				System.out.println(" ");
		}
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