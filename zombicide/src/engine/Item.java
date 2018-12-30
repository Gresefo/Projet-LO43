package engine;

public class Item {
	boolean isWeapon;
	int ID;
	String name;
	public Item(int id, String _name) {
		ID = id;
		name = _name;
		isWeapon=false;
	}
	
	
	//Getter dynamique //overriden, utilis�e pour la r�solution des liens lorsque l'on appelle la m�thode range des armes en main
	
	public int getRange() {return 0;}
	public boolean getIsAmbidextrous() {return false;}
	public int getNb_Dice() {return 0;}
	public int getResult_Dice() {return 0;}
	public int getDamage() {return 0;}
	
	
	// Getters and Setters
	public int getID()
	{
		return ID;
	}
	public boolean getIsWeapon()
	{
		return isWeapon;
	}
	
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
	
	// From the ID of an Item, return the Item itself
	/*public Item giveItem(int id)
	{
		Item item;
		
		return item;
	}*/
	
}