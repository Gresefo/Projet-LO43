package engine;

import java.util.Scanner; 
import java.util.InputMismatchException;

public class Professor extends Humanoides {
	int level;
	protected Item listItem[] = new Item[5];
	protected Dice dice = new Dice();

	/*******************  Constructor  ********************/

	public Professor() {
		super();
		this.health = 2;
		this.action = 4;
		this.level = 1;
	}
	
	/*******************  Operations  ********************/
	
	public boolean attack(Humanoides huma, Board board) throws AttackException
	{
		if(action>0)
		{
			boolean saisie=false;
			int id;
			double distance=Math.sqrt(Math.pow(current_case.getX()-huma.getCase().getX(),2)+Math.pow(current_case.getY()-huma.getCase().getY(),2));//pythagore et calcul distance
			int dist=(int)distance;
			if(listItem[0]==null && listItem[1]==null)
				throw new AttackException("Aucune Arme en main");
			if(listItem[0].getIsWeapon()==false && listItem[1].getIsWeapon()==false)
				throw new AttackException("Aucune Arme en main");
			if(listItem[0]!=null && listItem[0].getIsWeapon())
			{
				id=0;
			}
			else
			{
				id=1;
			}
			if(listItem[0]!=listItem[1] && listItem[1]!=null && listItem[1].getIsWeapon() && listItem[0]!=null && listItem[0].getIsWeapon() )
			{
				while(!saisie)
				{
				try {
					String newLine = System.getProperty("line.separator");
					Scanner sc = new Scanner(System.in);
					System.out.println("Quelle arme utiliser? "+newLine+"1: "+listItem[0].getName()+ "|dégats :"+listItem[0].getDamage()+newLine+"2: "+listItem[1].getName()+"|dégats :"+listItem[1].getDamage());
					id = sc.nextInt()-1;
					System.out.println("Vous avez saisi  : " + id);
					sc.close();
					if(id!=1 && id!=0)
						throw new AttackException("mauvaise saisie");
					saisie=true;
				}catch(InputMismatchException IME)
				{System.out.println("mauvaise saisie");
				saisie=false;}
				catch(AttackException e)
						{System.out.println("mauvaise saisie");
						saisie=false;}
				}
			}
			/*else 
			{
				if(listItem[0]!=null && listItem[0].getIsWeapon())
				{
					id=0;
				}
				else
				{
					id=1;
				}
			}*/
			if(dist==0)
			{
				return attaqueCac(id,board, huma);
			}
			else
			{
				return attaqueDistance(id,board,huma,dist);
			}
		}
		return false;
	}
	
	public boolean attaqueCac(int id,Board board,Humanoides huma)
	{
		int id2;
		if(id==0) {id2=1;}else {id2=0;}
		if(reachTarget(huma,board))
		{
		int res = 0;
		boolean boucle=true;
		if(listItem[id].getIsAmbidextrous()==false && listItem[0]==listItem[1] && listItem[id2]!=null)
		{
			System.out.println("Bonus ambidextre");
			for(int i = 0; boucle && i < listItem[id].getNb_Dice()*2; i++)
			{
				res = dice.rollDice();
				if(res >= listItem[id].getResult_Dice())
				{
					if(huma.health <= listItem[id].getDamage())
					{
						huma.finalize();// tuer le student, le faire disparaitre de la list dans board
						huma=null;
						boucle=false;
					}
				}
			}
		}
		else
		{
			for(int i = 0; boucle && i < listItem[id].getNb_Dice(); i++)
			{
				res = dice.rollDice();
				if(res >= listItem[id].getResult_Dice())
				{
					if(huma.health <= listItem[id].getDamage())
					{
						huma.finalize();// tuer le student, le faire disparaitre de la list dans board
						huma=null;
						boucle=false;
					}
				}
				
			}
		}
		action--;
		}
		else {return false;}
		return true;
	}
	
	public boolean attaqueDistance(int id,Board board,Humanoides huma,int dist)
	{
		int id2;
		if(id==0) {id2=1;}else {id2=0;}
		int range=listItem[0].getRange();
		if(reachTarget(huma,board) && dist<=range)
		{
			int res = 0;
			boolean boucle=true;
			if(listItem[id].getIsAmbidextrous()==false && listItem[0]==listItem[1] && listItem[id2]!=null)
			{
				System.out.println("Bonus ambidextre");
				for(int i = 0; boucle && i < listItem[id].getNb_Dice()*2; i++)
				{
					res = dice.rollDice();
					if(res >= listItem[id].getResult_Dice())
					{
						if(huma.health <= listItem[id].getDamage())
						{
							huma.finalize();// tuer le student, le faire disparaitre de la list dans board
							huma=null;
							boucle=false;
						}
					}
				}
			}
			else
			{
				for(int i = 0; boucle && i < listItem[id].getNb_Dice(); i++)
				{
					res = dice.rollDice();
					if(res >= listItem[id].getResult_Dice())
					{
						if(huma.health <= listItem[id].getDamage())
						{
							huma.finalize();// tuer le student, le faire disparaitre de la list dans board
							huma=null;
							boucle=false;
						}
					}
					
				}
			}
			action--;
		}
		else {return false;}
		return true;
		
	}
	
	protected boolean reachTarget(Humanoides cible, Board board) 
	{
		int ecartX=current_case.getX()-cible.getCase().getX(),ecartY=current_case.getX()-cible.getCase().getX();
		if(walkPathX(cible,board) && walkPathY(cible,board) && ecartX==0 || ecartY==0)
		{
			return true;
		}
		else if(ecartX==0 && ecartY==0)
		{
			System.out.println("erreur, attaque en diagonale impossible");
		}
		return false;
	}

	protected boolean walkPathX(Humanoides cible,Board board)
	{
		int ecart=current_case.getX()-cible.getCase().getX();
		Case pointer=current_case;
		if(ecart==0)
		{
			return true;
		}
		if(ecart<0)
		{
			while(pointer != cible.getCase())
			{
				if(pointer.getIsLinkedTo(3)==false)
				{
					return false;
				}
				pointer=board.board[pointer.getX()-1][pointer.getY()];
			}
			return true;
					
		}
		else
		{
			while(pointer != cible.getCase())
			{
				if(pointer.getIsLinkedTo(2)==false)
				{
					return false;
				}
				pointer=board.board[pointer.getX()+1][pointer.getY()];
			}
			return true;
		}
		
	}
	
	protected boolean walkPathY(Humanoides cible,Board board)
	{
		int ecart=current_case.getX()-cible.getCase().getX();
		Case pointer=current_case;
		if(ecart==0)
		{
			return true;
		}
		if(ecart<0)
		{
			while(pointer != cible.getCase())
			{
				if(pointer.getIsLinkedTo(1)==false)
				{
					return false;
				}
				pointer=board.board[pointer.getX()][pointer.getY()-1];
			}
			return true;
		}
		else
		{
			while(pointer != cible.getCase())
			{
				if(pointer.getIsLinkedTo(0)==false)
				{
					return false;
				}
				pointer=board.board[pointer.getX()][pointer.getY()+1];
			}
			return true;
		}
	}
	
	// Search the room to find an Item
	public void searchRoom(Board board)
	{
		if(current_case.isSearchable() && listItem[4] == null)
		{
			action--;
			int rand = (int)(Math.random() * 11);
			int i = 0;
			while(listItem[i] != null)
			{
				i++;
			}
			listItem[i] = board.getListAllItems()[rand];
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
		for (int j = i; j < 4; j++)
		{
			listItem[j] = listItem[j+1];
		}
		listItem[4] = null;
	}
	
	// Transform an Item into a better one after a successful search
	public void improveItem (int i,Board board)
	{
		if (i >= 0 && i <= 4)
		{
			int j = 0;
			if (listItem[i].ID == 4) // if he owns a magnifying glass, then we delete it and change the chalks into an upgraded one
			{
				while (listItem[j].ID != 9 && j < 5) 
				{
					j++;
				}
				if (listItem[j].ID == 9) 
				{
					listItem[j] = null;
					listItem[i] = board.listAllItems[5]; //giveItem(5);
					
				}
			}
			if (listItem[i].ID == 10) // if he owns a dictionary part 1 and a part 2, we change it into a dictionary and delete the part 2
			{
				while (listItem[j].ID != 11 && j < 5) 
				{
					j++;
				}
				if (listItem[j].ID == 11) 
				{
					listItem[j] = null;
					listItem[i] = board.listAllItems[8]; //giveItem(8);
				}
			}	
			if (listItem[i].ID == 11) // if he owns a dictionary part 1 and a part 2, we change it into a dictionary and delete the part 2
			{
				while (listItem[j].ID != 10 && j < 5) 
				{
					j++;
				}
				if (listItem[j].ID == 10) 
				{
					listItem[j] = null;
					listItem[i] = board.listAllItems[8]; //giveItem(8);
				}
			}
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
			}
			level = level + 5;
			action--;
		}
	}
	
	// Function call by a professor to open a door and when opening the out
	public void openDoor (Board board)
	{
		openDoor2 (board, current_case.getX(), current_case.getY());
	}
	
	// Open the door of the case[x][y] if there is a door to open
	public void openDoor2 (Board board, int x, int y)
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
			if ((listItem[0] != null && listItem[0].getIsSilentDoor() == false) || (listItem[1] != null && listItem[1].getIsSilentDoor() ==  false))
			{
				board.board[x][y].setNoise(board.board[x][y].getNoise() + 1);
			}
		}
	}
	
	/*******************  Getters and Setters  ********************/
	
	public int getLevel() {
		return level;
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