package engine;

public class Consumable extends Item{
	boolean isWeapon;
	
	public Consumable(int id, String _name)
	{
		super(id, _name);
		isWeapon = false;
	}
	
	//Getter dynamique //overriden, utilisée pour la résolution des liens lorsque l'on appelle la méthode range des armes en main
	
	public int getRange() {return 0;}
	public boolean getIsAmbidextrous() {return false;}
	public int getNb_Dice() {return 0;}
	public int getResult_Dice() {return 0;}
	public int getDamage() {return 0;}
	public boolean getIsOpeningDoor() {return false;}
	public void setOpeningDoor(boolean isOpeningDoor) {}
	public boolean getIsSilentDoor() {return false;}
	public void setSilentDoor(boolean isSilentDoor) {}
	public boolean getIsSilentAttack() {return false;}
	public void setSilentAttack(boolean isSilentAttack) {}
	public void setRange(int range) {}
	public void setNb_Dice(int nb_Dice) {}
	public void setResult_Dice(int result_Dice) {}
	public void setDamage(int damage) {}
	public void setAmbidextrous(boolean isAmbidextrous) {}
}
