
public class Die {
	private String name;
	
	
	public Die(String name) {
		this.name = name;
	}
	public int rollDie() {
		  int MAX = 6;
	      int roll = (int) (Math.random() * MAX) + 1;
	      //System.out.println(roll);
	      return roll;
	}
	
}
