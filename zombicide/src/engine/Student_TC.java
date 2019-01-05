package engine;

public class Student_TC extends Student{

	// Constructor
	public Student_TC(Case c) {
		super();
		health = 1;
		this.setCurrent_case(c);
		studentType = 0;
	}

	/*******************  Operations  ********************/
	
	// Set back the number of action points at each beginning of round
	public void setBackActionPoint()
	{
		this.action = 1;
	}
}