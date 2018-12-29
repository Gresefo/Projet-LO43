package engine;

public class Weapon extends Item{
	private String name;
	private int id;
	private boolean isOpeningDoor;
	private boolean isSilentDoor;
	private boolean isSilentAttack;
	private int range;
	private int nb_Dice;
	private int result_Dice;
	private int damage;
	private boolean isAmbidextrous;
	
	// Constructor
	public Weapon(int id, String _name, boolean isOD,boolean isSD,boolean isSA,boolean isA,int r,int nbD,int rD,int dmg)
	{
		
		super(id, _name);
		isWeapon=true;
		isOpeningDoor=isOD;
		isSilentDoor=isSD;
		isSilentAttack=isSA;
		isAmbidextrous=isA;
		range=r;
		nb_Dice=nbD;
		result_Dice=rD;
		damage=dmg;
	}
	
	// Getters and Setters
	public boolean getIsOpeningDoor() {
		return isOpeningDoor;
	}

	public void setOpeningDoor(boolean isOpeningDoor) {
		this.isOpeningDoor = isOpeningDoor;
	}

	public boolean getIsSilentDoor() {
		return isSilentDoor;
	}

	public void setSilentDoor(boolean isSilentDoor) {
		this.isSilentDoor = isSilentDoor;
	}

	public boolean getIsSilentAttack() {
		return isSilentAttack;
	}

	public void setSilentAttack(boolean isSilentAttack) {
		this.isSilentAttack = isSilentAttack;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getNb_Dice() {
		return nb_Dice;
	}

	public void setNb_Dice(int nb_Dice) {
		this.nb_Dice = nb_Dice;
	}

	public int getResult_Dice() {
		return result_Dice;
	}

	public void setResult_Dice(int result_Dice) {
		this.result_Dice = result_Dice;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public boolean getIsAmbidextrous() {
		return isAmbidextrous;
	}

	public void setAmbidextrous(boolean isAmbidextrous) {
		this.isAmbidextrous = isAmbidextrous;
	}

	

}