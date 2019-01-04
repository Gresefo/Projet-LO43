package engine;

public class Student_BDS extends Student{
	
	// Constructor
	public Student_BDS(Case c) {
		super();
		action = 2;
		health = 1;
		this.setCurrent_case(c);
	}

	/*******************  Operations  ********************/
	
	// Set back the number of action points at each beginning of round
	public void setBackActionPoint()
	{
		this.action = 2;
	}
}