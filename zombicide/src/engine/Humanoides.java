package engine;

public abstract class Humanoides {

protected int id;
protected Case current_case;
protected int action;
protected int health;

	// Constructor
	public Humanoides() {
		this.id = 0;
		this.action = 1;
		this.health = 2;
		this.current_case = null;
	}
	
	//Destructor
	public void finalize()
	{
	    System.out.println("Objet nettoyé de la mémoire");   
	}

	/*******************  Operations  ********************/
	
	
	
	// Set back the number of action points at each beginning of round
	public abstract void setBackActionPoint();

	
	
	// Walk function depending of the direction
	public void walkTop() {
		if (current_case.getIsLinkedTo(0))
		{
			this.current_case.setY(this.current_case.getY() + 1);
			this.action--;
		}
	}
	
	public void walkBottom() {
		if (current_case.getIsLinkedTo(1))
		{
			this.current_case.setY(this.current_case.getY() - 1);
			this.action--;
		}
	}
	
	public void walkRight() {
		if (current_case.getIsLinkedTo(2))
		{
			this.current_case.setX(this.current_case.getX() + 1);
			this.action--;
		}
	}
	
	public void walkLeft() {
		if (current_case.getIsLinkedTo(3))
		{
			this.current_case.setX(this.current_case.getX() - 1);
			this.action--;
		}
	}
	

	// Getters and Setters
	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public Case getCase() {
		return current_case;
	}

}
