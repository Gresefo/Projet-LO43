public class Main 
{
	public static void main(String[]argv)
	{
		// Creation of every Items  boolean isOD,boolean isSD,boolean isSA,boolean isA,int r,int nbD,int rD,int dmg)
		//Item listAllItems[] = new Item[11];
		Item.listAllItems[0] = new Weapon(1, "Stylo", true, true, false, true, 2, 1, 4, 2);
		Item.listAllItems[1] = new Weapon(2, "Clé", true, true, false, true, 0, 3, 5, 2);
		Item.listAllItems[2] = new Weapon(3, "Guitare", true, false, false, false, 0, 3, 4, 2);
		Item.listAllItems[3] = new Weapon(4, "Craies", false, false, false, true, 2, 3, 5, 1);
		Item.listAllItems[4] = new Weapon(5, "Craies améliorées", false, false, false, true, 2, 4, 3, 1);
		Item.listAllItems[5] = new Weapon(6, "Fil de souris", false, false, true, false, 1, 2, 4, 1);
		Item.listAllItems[6] = new Weapon(7, "Liste des UV de culture générale", false, false, true, false, 0, 3, 3, 1);
		Item.listAllItems[7] = new Weapon(8, "Dictionnaire français-anglais", false, false, false, false, 2, 1, 1, 3);
		Item.listAllItems[8] = new Consumable(9, "Loupe");
		Item.listAllItems[9] = new Consumable(10, "Dictionnaire partie 1");
		Item.listAllItems[10] = new Consumable(11, "Dictionnaire partie 2");
		int i=Item.listAllItems.length;
		Professor prof=new Professor();
		
		// Creation of the Board
		Board board = new Board();
		
		
		
		
		System.out.println(Item.listAllItems[0].getName() + "    " + Item.listAllItems[1].getName());

		
		System.out.println(Item.listAllItems[2].getName() + "    " + Item.listAllItems[3].getName());
		
		
	}
}