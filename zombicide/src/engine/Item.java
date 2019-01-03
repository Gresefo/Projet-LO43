package engine;

public abstract class Item {
	int ID;
	String name;
	boolean isWeapon;
	
	
	public Item(int id, String _name) {
		ID = id;
		name = _name;
	}
	
	// Getters and Setters
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return ID;
	}

	public void setId(int id) {
		this.ID = id;
	}
	
	public boolean getIsWeapon()
	{
		return isWeapon;
	}
	
	// Abstract
	public abstract boolean getIsOpeningDoor();
	public abstract void setOpeningDoor(boolean isOpeningDoor);
	public abstract boolean getIsSilentDoor();
	public abstract void setSilentDoor(boolean isSilentDoor);
	public abstract boolean getIsSilentAttack();
	public abstract void setSilentAttack(boolean isSilentAttack);
	public abstract int getRange();
	public abstract void setRange(int range);
	public abstract int getNb_Dice();
	public abstract void setNb_Dice(int nb_Dice);
	public abstract int getResult_Dice();
	public abstract void setResult_Dice(int result_Dice);
	public abstract int getDamage();
	public abstract void setDamage(int damage);
	public abstract boolean getIsAmbidextrous();
	public abstract void setAmbidextrous(boolean isAmbidextrous);
}