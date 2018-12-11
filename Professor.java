public class Professor extends Humanoides {

protected int level;
protected Object list;

public Professor() {
	super();
	this.health = 2;
	this.action = 4;
	
}

public int getLevel() {
	return level;
}

public void setLevel(int level) {
	this.level = level;
}

public Object getList() {
	return list;
}

public void setList(Object list) {
	this.list = list;
}

public int getHealth() {
	return health;
}

public void setHealth(int health) {
	this.health = health;
}

public int getAction() {
	return action;
}

public void setAction(int action) {
	this.action = action;
}
}