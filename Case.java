public class Case {

private int noise;
private int nbStudent;
private int nbProfessor;
private boolean isPossibleObjective;
private boolean isTrueObjective;

public void splitting() {

	}
public Case() {
	
}
public int getNoise() {
	return noise;
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
public void affiche() 
	Systeme.out.println(noise,nbStudent,nbProfessor);
	Systeme.out.println("is Possible Objectif (bool) = " + isPossibleObjective);
	Systeme.out.println("is true ojectif(bool) = "+ isTrueObjective;)
}
