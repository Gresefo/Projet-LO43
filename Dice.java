public class Dice {
	private String name;
	
	
	public Dice(String name) {
		this.name = name;
	}
	public int rollDice() {
		  int MAX = 6;
	      int roll = (int) (Math.random() * MAX) + 1;
	      //System.out.println(roll);
	      return roll;
	}
	
}
