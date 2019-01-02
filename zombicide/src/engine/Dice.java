package engine;

import java.util.Random;

public class Dice {
	private Random rd;
	public Dice() {
		this.rd = new Random();
	}
	
	public int rollDice() {
		return rd.nextInt(6) + 1;
	}
}
