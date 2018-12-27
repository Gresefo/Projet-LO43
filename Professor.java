import java.util.Scanner; 
public class Professor extends Humanoides {

protected int level;
protected Item listItem[] = new Item[5];
//protected Weapon listWeapon[] = new Weapon[2] ;
protected Dice dice = new Dice();


	// Constructor
	public Professor() {
		super();
		this.health = 2;
		this.action = 4;
		this.level = 1;
	}
	
	
	
	// Operations
	public void attack(Humanoides huma) { //et comment faire pour les armes ambidextres
		boolean boucle=true;
		if(action > 0)
		{ // afficher quelque chose dans le cas contraire
			double distance=Math.sqrt(Math.pow(current_case.getX()-huma.getCase().getX(),2)+Math.pow(current_case.getY()-huma.getCase().getY(),2));//pythagore et calcul distance
			int dist=(int)distance;
			String newLine = System.getProperty("line.separator");
			//pour demain je dois m'occuper des cas d'erreur ou listitem[1 et 0] sont pas forcément des armes 
			if(listItem[0] != null && listItem[0].getIsWeapon()==true ) //same
			{
				if(listItem[0]!=listItem[1] && listItem[1]!=null)
				{
					Scanner sc = new Scanner(System.in);
					System.out.println("Quelle arme utiliser? "+newLine+"1: "+listItem[0].getName()+ "|dégats :"+listItem[0].getDamage()+newLine+"2: "+listItem[1].getName()+"|dégats :"+listItem[1].getDamage());
					int id = sc.nextInt();
					System.out.println("Vous avez saisi le nombre : " + id);
					sc.close();
				}
				int range=listItem[0].getRange();
				if(range==0 )
				{
					if(dist==0)
					{
						int res = 0;
						if(listItem[0].getIsAmbidextrous()==false || listItem[0]!=listItem[1] || listItem[1]==null)
						{
						for(int i = 0; boucle && i < listItem[0].getNb_Dice(); i++)
						{
							res = dice.rollDice();
							if(res >= listItem[0].getResult_Dice())
							{
								if(huma.health <= listItem[0].getDamage())
								{
									huma=null;
									huma.finalize();// tuer le student, le faire disparaitre de la list dans board
									boucle=false;
								}
							}
							
						}
						}
						else
						{
							System.out.println("Bonus ambidextre");
							for(int i = 0; boucle && i < listItem[0].getNb_Dice()*2; i++)
							{
								res = dice.rollDice();
								if(res >= listItem[0].getResult_Dice())
								{
									if(huma.health <= listItem[0].getDamage())
									{
										huma=null;
										huma.finalize();// tuer le student, le faire disparaitre de la list dans board
										boucle=false;
									}
								}
								
							}
						}
					}
					else
					{
						System.out.println("votre arme en main ne permet pas d'attaquer à distance");
					}
				}
				else
				{
					
					boolean attackable=reachTarget(huma);
					if(attackable && dist <= range)
					{
						
						int res = 0;
						if(listWeapon[0].getIsAmbidextrous()==false || listItem[0]!=listItem[1] || listItem[1]==null)
						{
						for(int i = 0; boucle && i < listItem[0].getNb_Dice(); i++)
						{
							res = dice.rollDice();
							if(res >= listItem[0].getResult_Dice())
							{
								if(huma.health <= listItem[0].getDamage())
								{
									huma=null;
									huma.finalize();// tuer le student, le faire disparaitre de la list dans board
									boucle=false;
								}
							}
							
						}
						}
						else
						{
							System.out.println("Bonus ambidextre");
							for(int i = 0; boucle && i < listItem[0].getNb_Dice()*2; i++)
							{
								res = dice.rollDice();
								if(res >= listItem[0].getResult_Dice())
								{
									if(huma.health <= listItem[0].getDamage())
									{
										huma=null;
										huma.finalize();// tuer le student, le faire disparaitre de la list dans board
										boucle=false;
									}
								}
								
							}
						}
					}
					else
					{
						System.out.println("cette cible n'est pas atteignable");
					}
				}
				
				action--;
			}
			else
			{
				System.out.println("Aucune arme disponible");
			}
			}
		else
		{
			System.out.println("Aucun point d'action disponible.");
		}
		}
	
	protected boolean reachTarget(Humanoides cible) 
	{
		if(walkPathX(cible) && walkPathY(cible))
		{
			return true;
		}
		return false;
	}
	

	protected boolean walkPathX(Humanoides cible)
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
				pointer.setX(pointer.getX()-1);
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
				pointer.setX(pointer.getX()+1);
			}
			return true;
		}
		
	}
	
	protected boolean walkPathY(Humanoides cible)
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
				pointer.setY(pointer.getY()-1);
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
				pointer.setY(pointer.getY()+1);
			}
			return true;
		}
	}
	
	public void switchingItem(int i, int j) {
		if(i != j && i >= 0 && i <= 4 && j >= 0 && j <= 4)
		{
			Item tmp = listItem[i];
			listItem[i] = listItem[j];
			listItem[j] = tmp;
			action--;
		}
	}
	
	public void throwItem (int i)
	{
		if (i >= 0 && i <= 4)
		{
			listItem[i] = null;
		}
	}
	
	public void improveItem (int i)
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
					listItem[i].giveItem(5);
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
					listItem[i].giveItem(8);
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
					listItem[i].giveItem(8);
				}
			}
		}
	}
	
	public void checkObjective ()
	{
		if (current_case.getIsPossibleObjective())
		{
			if (current_case.getIsTrueObjective())

			{
				
				// faire la methode qui modifie isLinkedTo des deux cases concernées
			}
			level = level + 5;
			action--;
		}
	}
	
	// Getters and Setters
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

}