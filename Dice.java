public class Dice {

	// Constructor
	public Dice(){
		
	}
	
	public int rollDice() {
		  int MAX = 6;
	      int roll = (int) (Math.random() * MAX) + 1;
	      //System.out.println(roll);
	      return roll;
	}
	
}
