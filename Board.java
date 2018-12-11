//import java.util.*;
//import java.io.*;

public class Board {
	private Case board[][] = new Case[5][7];
	private Case start, end;

	public Board() {
		
		for (int i=0; i<= 8; i++) {
			for (int j=0; j<=4; j++) {
				Case c = new Case();
				board[i][j] = c;
				
			}
				
		}
	}
	public Case getStart() {
		return this.start;
	}
	
	public void setStart(int x, int y) {
		Case re = new Case();
		for(int i=0; i<= 8 || i!=x; i++) {
			for(int j=0; j<=4 || j !=y; j++) {
				board[i][j] = re;
			}
	}
		this.start= re;
	}
}