
public class Item {
	int ID;
	String name;

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
	
	// From the ID of an Item, return the Item itself
	public Item giveItem(int id)
	{
		// faire un moyen d''initialiser les objets
	}

}
