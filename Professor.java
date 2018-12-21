
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
		boolean boucle=true;
		if(action > 0)
		{ // afficher quelque chose dans le cas contraire
			double distance=Math.sqrt(Math.pow(current_case.getX()-huma.getCase().getX(),2)+Math.pow(current_case.getY()-huma.getCase().getY(),2));//pythagore et calcul distance
			int dist=(int)distance;
			if(listWeapon[0] != null) //same
			{

				
				int range=listWeapon[0].getRange();
				if(range==0 )
				{
					if(dist==0)
					{
						int res = 0;
						if(listWeapon[0].getIsAmbidextrous()==false || listWeapon[0]!=listWeapon[1] || listWeapon[1]==null)
						{
						for(int i = 0; boucle && i < listWeapon[0].getNb_Dice(); i++)
						{
							res = dice.rollDice();
							if(res >= listWeapon[0].getResult_Dice())
							{
								if(huma.health <= listWeapon[0].getDamage())
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
							for(int i = 0; boucle && i < listWeapon[0].getNb_Dice()*2; i++)
							{
								res = dice.rollDice();
								if(res >= listWeapon[0].getResult_Dice())
								{
									if(huma.health <= listWeapon[0].getDamage())
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
						System.out.println("votre arme en main ne permet pas d'attaquer � distance");
					}
				}
				else
				{
					
					boolean attackable=reachTarget(huma);
					if(attackable && dist <= range)
					{
						
						int res = 0;
						if(listWeapon[0].getIsAmbidextrous()==false || listWeapon[0]!=listWeapon[1] || listWeapon[1]==null)
						{
						for(int i = 0; boucle && i < listWeapon[0].getNb_Dice(); i++)
						{
							res = dice.rollDice();
							if(res >= listWeapon[0].getResult_Dice())
							{
								if(huma.health <= listWeapon[0].getDamage())
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
							for(int i = 0; boucle && i < listWeapon[0].getNb_Dice()*2; i++)
							{
								res = dice.rollDice();
								if(res >= listWeapon[0].getResult_Dice())
								{
									if(huma.health <= listWeapon[0].getDamage())
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