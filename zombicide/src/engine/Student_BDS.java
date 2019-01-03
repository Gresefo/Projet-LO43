package engine;

public class Student_BDS extends Student{
	
	// Constructor
	public Student_BDS() {
		super();
		action = 2;
		health = 1;
	}

	/*******************  Operations  ********************/
	
	// Set back the number of action points at each beginning of round
	public void setBackActionPoint()
	{
		this.action = 2;
	}
}