public class Humanoides {

protected String name;
protected Case current_case;
protected int action;
protected int health;

	public Humanoides() { // constructor
		this.name = null;
		this.action = 1;
		this.health = 2;
		this.current_case = null;
	}

	public void attack() {
		
		
		
	}

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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

}
