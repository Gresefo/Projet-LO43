package engine;

import gui.ButtonPane;

public abstract class Professor extends Humanoides {
	protected int level;
	protected Item listItem[] = new Item[5];
	protected Dice dice = new Dice();
	protected boolean stillHasEffect;

	/*******************  Constructor  ********************/

	public Professor() {
		super();
		this.health = 2;
		this.action = 4;
		this.level = 1;
		stillHasEffect = true;
	}
	
	/*******************  Operations  ********************/
	
	// Makes a professor attack a student
	public void attackStudent(Board board, int idStudent, int nWeapon, ButtonPane bp)
	{
		// Check if the weapon is ambidextrous and the professor get two of them
		if(listItem[nWeapon].getIsAmbidextrous())
		{
			if (nWeapon == 0 && listItem[1] != null && listItem[1] == listItem[0]) 
			{
				attackStudent2(board, idStudent, nWeapon, 2, bp);
			}
			else if (nWeapon == 1 && listItem[1] == listItem[0])
			{
				attackStudent2(board, idStudent, nWeapon, 2, bp);
			}
			// Don't have two same weapons
			else
			{
				attackStudent2(board, idStudent, nWeapon, 1, bp);
			}
		}
		else // Non ambidextrous attack
		{
			attackStudent2(board, idStudent, nWeapon, 1, bp);
		}
	}
	
	//Makes a professor attack a student
	public void attackStudent2(Board board, int idStudent, int nWeapon, int amb, ButtonPane bp)
	{
		if (board.getListStudent().get(idStudent).getHealth() <= listItem[nWeapon].getDamage())
		{
			int i = 0, nbThrow = listItem[nWeapon].getNb_Dice() * amb, res = 0;
			boolean success = false;
			while (i < nbThrow && success == false)
			{
				res = dice.rollDice();
				i++;
				if(res >= listItem[nWeapon].getResult_Dice())
				{
					board.getListStudent().remove(idStudent);
					success = true;
					current_case.setNbStudent(current_case.getNbStudent() - 1);
					level++;
				}
			}
			action--;
			if(id != 2 && listItem[nWeapon].getIsSilentAttack() == false) // M. Flesch doesn't make noise when attacking
				current_case.setNoise(current_case.getNoise() + 1);
			if (success == false)
			{
				bp.printFailedAttack();
			}
		}
		else
			bp.printWeaponTooWeak();
	}
	
	//The super power of each professor
	public abstract void effect(Board board);
	
	// Search the room to find an Item
	public void searchRoom(Board board)
	{
		if(current_case.isSearchable() && listItem[4] == null)
		{
			action--;
			int rand = (int)(Math.random() * 11);
			while (rand == 4 || rand == 7)
			{
				rand = (int)(Math.random() * 11);
			}
			int i = 0;
			while(listItem[i] != null)
			{
				i++;
			}
			listItem[i] = board.getListAllItems()[rand];
			this.improveItem(board);
			current_case.setSearchable(false);
		}
	}
	
	// Switch 2 items' places
	public void switchingItem(int i, int j) {
		if(i != j && i >= 0 && i <= 4 && j >= 0 && j <= 4)
		{
			Item tmp = listItem[i];
			listItem[i] = listItem[j];
			listItem[j] = tmp;
			action--;
		}
	}
	
	// Remove an Item from the inventory without creating a void between two items in the inventory
	public void throwItem (int i)
	{
		if(listItem[i] != null)
		{
			for (int j = i; j < 4; j++)
			{
				listItem[j] = listItem[j+1];
			}
			listItem[4] = null;
		}
	}
	
	// Transform an Item into a better one after a successful search
	public void improveItem (Board board)
	{
		int i = 0;
		while(i < 5 && listItem[i] != null)
		{
			int j = 0;
			if (listItem[i].ID == 3) // if he owns a magnifying glass, then we delete it and change the chalks into an upgraded one
			{
				while (j < 5 && listItem[j] != null && listItem[j].ID != 8) 
				{ 
					j++;
				}
				if (j < 5 && listItem[j] != null && listItem[j].ID == 8) 
				{
					throwItem(j);
					listItem[i] = board.listAllItems[4]; //giveItem(4);
				}
				j = 0;
			}
			if (listItem[i].ID == 9) // if he owns a dictionary part 1 and a part 2, we change it into a dictionary and delete the part 2
			{
				while (j < 5 && listItem[j] != null && listItem[j].ID != 10) 
				{
					j++;
				}
				if (j < 5 && listItem[j] != null && listItem[j].ID == 10) 
				{
					throwItem(j);
					listItem[i] = board.listAllItems[7]; //giveItem(7);
				}
				j = 0;
			}	
			if (listItem[i].ID == 10) // if he owns a dictionary part 1 and a part 2, we change it into a dictionary and delete the part 1
			{
				while (j < 5 && listItem[j] != null && listItem[j].ID != 9) 
				{
					j++;
				}
				if (j < 5 && listItem[j] != null && listItem[j].ID == 9) 
				{
					throwItem(j);
					listItem[i] = board.listAllItems[7]; //giveItem(7);
				}
			}
			i++;
		}
	}
	
	// Check if the objective is the true one that will open the door to win
	public void checkObjective (Board board)
	{
		if (current_case.getIsPossibleObjective())
		{
			if (current_case.getIsTrueObjective())
			{
				board.board[6][1].setIsLinkedTo(true, 1);
				board.board[6][0].setIsLinkedTo(true, 0);
				current_case.setTrueObjective(false);
			}
			level = level + 5;
			action--;
			current_case.setPossibleObjective(false);
		}
	}
	
	// Function call by a professor to open a door and when opening the out
	public void openDoor (Board board, ButtonPane bp)
	{
		openDoor2 (board, current_case.getX(), current_case.getY(), bp);
	}
	
	// Open the door of the case[x][y] if there is a door to open
	public void openDoor2 (Board board, int x, int y, ButtonPane bp)
	{
		if (board.board[x][y].getHasDoor() != 0 && ((listItem[0]!= null && listItem[0].getIsOpeningDoor()) || (listItem[1] != null && listItem[1].getIsOpeningDoor())))
		{
			switch(board.board[x][y].getHasDoor())
			{
			case 1 : // Top
				board.board[x][y].setIsLinkedTo(true, 0);
				board.board[x][y+1].setIsLinkedTo(true, 1);
				break;
			case 2 : // Bottom
				board.board[x][y].setIsLinkedTo(true, 1);
				board.board[x][y-1].setIsLinkedTo(true, 0);
				break;
			case 3 : // Right
				board.board[x][y].setIsLinkedTo(true, 2);
				board.board[x+1][y].setIsLinkedTo(true, 3);
				break;
			case 4 : // Left
				board.board[x][y].setIsLinkedTo(true, 3);
				board.board[x-1][y].setIsLinkedTo(true, 2);
				break;
			}
			board.board[x][y].setHasDoor(0);
			action--;
			// If it makes noise
			if (listItem[1] != null)
			{
				if (listItem[0].getIsSilentDoor() == false && listItem[1].getIsSilentDoor() == false)
					board.board[x][y].setNoise(board.board[x][y].getNoise() + 1);
			}
			else
			{
				if (listItem[0].getIsSilentDoor() == false)
					board.board[x][y].setNoise(board.board[x][y].getNoise() + 1);
			}
		}
		else if (board.board[x][y].getHasDoor() != 0)
			bp.printCantOpenDoor();
	}
	
	/*******************  Getters and Setters  ********************/
	
	public int getLevel() {
		return level;
	}
	
	public boolean isStillHasEffect() {
		return stillHasEffect;
	}

	public void setStillHasEffect(boolean stillHasEffect) {
		this.stillHasEffect = stillHasEffect;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public Item[] getListItem() {
		return listItem;
	}

	public void setListItem(Item item, int i) {
		this.listItem[i] = item;
	}

}