public class Main 
{
	public static void main(String[]argv)
	{
		// Creation of every Items  boolean isOD,boolean isSD,boolean isSA,boolean isA,int r,int nbD,int rD,int dmg)
		Item listAllItems[] = new Item[11];
		listAllItems[0] = new Weapon(1, "Stylo", true, true, false, true, 2, 1, 4, 2);
		listAllItems[1] = new Weapon(2, "Cl�", true, true, false, true, 0, 3, 5, 2);
		listAllItems[2] = new Weapon(3, "Guitare", true, false, false, false, 0, 3, 4, 2);
		listAllItems[3] = new Weapon(4, "Craies", false, false, false, true, 2, 3, 5, 1);
		listAllItems[4] = new Weapon(5, "Craies am�lior�es", false, false, false, true, 2, 4, 3, 1);
		listAllItems[5] = new Weapon(6, "Fil de souris", false, false, true, false, 1, 2, 4, 1);
		listAllItems[6] = new Weapon(7, "Liste des UV de culture g�n�rale", false, false, true, false, 0, 3, 3, 1);
		listAllItems[7] = new Weapon(8, "Dictionnaire fran�ais-anglais", false, false, false, false, 2, 1, 1, 3);
		listAllItems[8] = new Item(9, "Loupe");
		listAllItems[9] = new Item(10, "Dictionnaire partie 1");
		listAllItems[10] = new Item(11, "Dictionnaire partie 2");
		
		// Creation of the Board
		Board board = new Board();
		
		
		
		System.out.println(listAllItems[0].getName() + "    " + listAllItems[1].getName());

		
		System.out.println(listAllItems[0].getName() + "    " + listAllItems[1].getName());
		
		
	}
}