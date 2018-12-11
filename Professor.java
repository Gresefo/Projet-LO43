public class Professor extends Humanoides {

protected int level;
protected Weapon listWeapon[]=new Weapon[2];
//protected Consummable listConsummable[]=new Consummable[3];

public Professor() {
	super();
	this.health = 2;
	this.action = 4;
	
}

public void attack(Humanoides S)
{
	int pos
}

public int getLevel() {
	return level;
}

public void setLevel(int level) {
	this.level = level;
}

public Item getList() {
	return list;
}

public void setList(Item list) {
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

public void attack(Humanoides S)
{
	
}

public void setAction(int action) {
	this.action = action;
}
}