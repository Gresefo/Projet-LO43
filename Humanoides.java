public class Humanoides {

protected String name;
protected Case actual_case;
protected int action;
protected int health;

	public Humanoides() { // constructor
		this.name = null;
		this.action = 1;
		this.health = 2;
		this.actual_case = this.actual_case.getStart();
	}

	public void attack() {
		
		
		
	}

	public void walkTop() {
		if (actual_case.getIsLinkedTo(0))
		{
			this.actual_case.setY(this.actual_case.getY() + 1);
			this.action--;
		}
	}
	
	public void walkBottom() {
		if (actual_case.getIsLinkedTo(1))
		{
			this.actual_case.setY(this.actual_case.getY() - 1);
			this.action--;
		}
	}
	
	public void walkRight() {
		if (actual_case.getIsLinkedTo(2))
		{
			this.actual_case.setY(this.actual_case.getX() + 1);
			this.action--;
		}
	}
	
	public void walkLeft() {
		if (actual_case.getIsLinkedTo(3))
		{
			this.actual_case.setY(this.actual_case.getY() - 1);
			this.action--;
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition_x() {
		return position_x;
	}

	public void setPosition_x(int position_x) {
		this.position_x = position_x;
	}

	public int getPosition_y() {
		return position_y;
	}

	public void setPosition_y(int position_y) {
		this.position_y = position_y;
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
