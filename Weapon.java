
public class Weapon {
	private String name;
	private int id;
	private boolean isOpeningDoor;
	private boolean isSilentDoor;
	private boolean isSilentAttack;
	private int range;
	private int nb_Dice;
	private int result_Dice;
	private int damage;
	private boolean isAmbidextrous;
	
	public Weapon(boolean isOD,boolean isSD,boolean isSA,boolean isA,int r,int nbD,int rD,int dmg,int iD,String Name)
	{
		id=iD;
		name=Name;
		isOpeningDoor=isOD;
		isSilentDoor=isSD;
		isSilentAttack=isSA;
		isAmbidextrous=isA;
		range=r;
		nb_Dice=nbD;
		result_Dice=rD;
		damage=dmg;
	}
	
	
}
