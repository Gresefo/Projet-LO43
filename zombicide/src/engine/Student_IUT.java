package engine;

public class Student_IUT extends Student {

	// Constructor
	public Student_IUT(Case c) {
		super();
		health = 2;
		this.setCurrent_case(c);
		studentType = 2;
	}
	
	/*******************  Operations  ********************/
	
	// Set back the number of action points at each beginning of round
	public void setBackActionPoint()
	{
		this.action = 1;
	}

}