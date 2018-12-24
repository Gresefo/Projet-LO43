
public class Student_TC extends Student{

	// Constructor
	public Student_TC() {
		super();
		health = 1;
	}

	/*******************  Operations  ********************/
	
	// Set back the number of action points at each beginning of round
	public void setBackActionPoint()
	{
		this.action = 1;
	}
}
