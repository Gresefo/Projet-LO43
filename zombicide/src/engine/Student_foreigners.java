package engine;

public class Student_foreigners extends Student{

	// Constructor
	public Student_foreigners(Case c) {
		super();
		health = 3;
		this.setCurrent_case(c);
	}
	
	/*******************  Operations  ********************/
	
	// Set back the number of action points at each beginning of round
	public void setBackActionPoint()
	{
		this.action = 1;
	}

}