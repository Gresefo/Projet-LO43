
public class Student_foreigners extends Student{

	// Constructor
	public Student_foreigners() {
		super();
		health = 3;
	}
	
	/*******************  Operations  ********************/
	
	// Set back the number of action points at each beginning of round
	public void setBackActionPoint()
	{
		this.action = 1;
	}

}
