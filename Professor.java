public class Professor extends Humanoides {

protected int level;
protected Weapon listWeapon[] = new Weapon[2];
protected Consumable listConsumable[] = new Consumable[3];
protected Dice dice = new Dice();


	// Constructor
	public Professor() {
		super();
		this.health = 2;
		this.action = 4;
		this.level = 1;
	}
	
	// Operations
	public void attack(Humanoides huma) { //trouver un moyen de differencier les attaques cac et distance, la il s'agit que des attaques cac
		//sur student et non prof, et comment faire pour les armes ambidextres
		if(action > 0)
		{ // afficher quelque chose dans le cas contraire
			if(listWeapon[0] != null) //same
			{
				int res = 0;
				for(int i = 0; i < listWeapon[0].getNb_Dice(); i++)
				{
					res = dice.rollDice();
					if(res >= listWeapon[0].getResult_Dice())
					{
						if(huma.health <= listWeapon[0].getDamage())
						{
							// tuer le student, le faire disparaitre de la list dans board
						}
					}
				}
				action--;
			}
		}
	}
	
	public void switchingWeapon() {
		if(listWeapon[0] != null && listWeapon[1] != null)
		{
			Weapon tmp = listWeapon[0];
			listWeapon[0] = listWeapon[1];
			listWeapon[1] = tmp;
		}
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