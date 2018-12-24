
abstract class Item {
	boolean isWeapon;
	int ID;
	String name;
	public static Item listAllItems[]=new Item[11] ;
	public Item(int id, String _name) {
		ID = id;
		name = _name;
		isWeapon=false;
	}
	
	
	//Getter dynamique //overriden, utilisée pour la résolution des liens lorsque l'on appelle la méthode range des armes en main
	
	public int getRange() {return 0;}
	public boolean getIsAmbidextrous() {return false;}
	public int getNb_Dice() {return 0;}
	public int getResult_Dice() {return 0;}
	public int getDamage() {return 0;}
	
	
	// Getters and Setters
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
	public Item giveItem(int id)
	{
		int i=0;
		//le if ne marche pas car sinon y'aurais des cas où la méthode ne renvoie pas d'item, mieux vaus mettre la verif au moment ou on appelle la méthode
		//if(id<=Item.listAllItems.length && id<=0)
		//{
		return Item.listAllItems[i-1];
		//}
		// faire un moyen d''initialiser les objets
	}
	
}
