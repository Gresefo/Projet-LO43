public class Case {
private int x,y;
private int noise;
private int nbStudent;
private int nbProfessor;
private boolean isPossibleObjective;
private boolean isTrueObjective;

public Case(int i, int j) {
	this.x=i;
	this.y=j;
}
public Case() {
	this.x = 0;
	this.y = 0;
	
}
public int[] getPosition() {
	int tab[]={x,y};
	return tab;
	// 
}
public void setPosition(int a, int b) {
	this.x = a;
	this.y = b;
	
}
public int getX() {
	return x;
	
}
public int getY() {
	return y;
	
}
public void setX(int x){
	this.x = x;
}
public void setY(int y) {
	this.y = y;
}
public void setNoise(int noise) {
	this.noise = noise;
}
public int getNbStudent() {
	return nbStudent;
}
public void setNbStudent(int nbStudent) {
	this.nbStudent = nbStudent;
}
public int getNbProfessor() {
	return nbProfessor;
}
public void setNbProfessor(int nbProfessor) {
	this.nbProfessor = nbProfessor;
}
public boolean isPossibleObjective() {
	return isPossibleObjective;
}
public void setPossibleObjective(boolean isPossibleObjective) {
	this.isPossibleObjective = isPossibleObjective;
}
public boolean isTrueObjective() {
	return isTrueObjective;
}
public void setTrueObjective(boolean isTrueObjective) {
	this.isTrueObjective = isTrueObjective;
}
public void affiche() {
	System.out.println(noise+nbStudent+nbProfessor);
	System.out.println("is Possible Objectif (bool) = " + isPossibleObjective);
	System.out.println("is true ojectif(bool) = "+ isTrueObjective);
	System.out.println("Position = "+x+y);
}}
