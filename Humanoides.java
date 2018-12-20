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

	// Operations
	public abstract void attack(Humanoides huma);

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
			this.current_case.setY(this.current_case.getX() + 1);
			this.action--;
		}
	}
	
	public void walkLeft() {
		if (current_case.getIsLinkedTo(3))
		{
			this.current_case.setY(this.current_case.getY() - 1);
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
