public class Professor extends Humanoides {

protected int level;
protected Weapon listWeapon[]=new Weapon[2];
//protected Consummable listConsummable[]=new Consummable[3];


// Constructor
public Professor() {
	super();
	this.health = 2;
	this.action = 4;
	
}

// Functions
public void attack() {
	
}

// Getters and Setters
public int getLevel() {
	return level;
}

public void setLevel(int level) {
	this.level = level;
}

public Object getListWeapon() {
	return listWeapon;
}

public void setListWeapon(Weapon[] listWeapon) {
	this.listWeapon = listWeapon;
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