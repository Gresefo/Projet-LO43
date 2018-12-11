abstract class Humanoides {

protected String name;
protected int position_x;
protected int position_y;
protected int action;
protected int health;

	public Humanoides() { // constructor
		this.name = null;
		this.position_x = 0;
		this.position_y = 0;
		this.action = 1;
		this.health = 2;
	}

	public void attack(Humanoides H) {
		int écart=
	}

	public void walk() {
		
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
