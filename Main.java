public class Main 
{
	public static void main(String[]argv){
		System.out.println("charline");
		
		// Phase de test des armes
		Professor nom = new Professor();
		Weapon w[] = new Weapon[7];
		w[0] = new Weapon(1,"pen",false,false,true,true,1,3,4,1);
		w[1] = new Weapon(2,"key",true,true,true,false,1,2,4,1);
		nom.listWeapon[0] = w[0];
		nom.listWeapon[1] = w[1];
		
		System.out.println(nom.listWeapon[0].getName() + "    " + nom.listWeapon[1].getName());
		
		nom.switchingWeapon();
		
		System.out.println(nom.listWeapon[0].getName() + "    " + nom.listWeapon[1].getName());
		
		
	}
}