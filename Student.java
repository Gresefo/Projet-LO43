
public class Student extends Humanoides{

	// Constructor
	public Student() {
		super();
		action = 1; 
	}
	
	// Operations
	public void attack(Professor prof) {
		prof.health--;
		action--;	
	}
	
	
}
