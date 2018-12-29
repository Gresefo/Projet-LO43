public class Case {
private int x,y;
private int cost;
private double heuristic;
private int noise;
private int nbStudent;
private int nbProfessor;
private boolean isLinkedTo[] = new boolean[4];
private boolean isPossibleObjective;
private boolean isTrueObjective;
private boolean isClassroom;
private boolean isCorridor;
private boolean isStudentSpawn;
private Case pred;

	// Constructors
	public Case(int i, int j) {
		this.x=i;
		this.y=j;
		cost=0;
	}
	public Case() {
		this.x = 0;
		this.y = 0;
		cost=0;
	}
	
	// Getters and Setters
	public Case getPred()
	{
		return pred;
	}
	public void setPred(Case p)
	{
		pred=p;
	}
	public boolean getIsPossibleObjective()
	{
		return isPossibleObjective;
	}
	public boolean getIsTrueObjective()
	{
		return isTrueObjective;
	}
	public boolean getIsLinkedTo(int i) {
		return isLinkedTo[i];
	}
	public int getCost()
	{
		return cost;
	}
	public void setCost(int i)
	{
		cost=i;
	}
	public double getHeuristic()
	{
		return heuristic;
	}
	public void setHeuristic(double h)
	{
		heuristic=h;
	}
	public void setIsLinkedTo(boolean bool, int i) {
		this.isLinkedTo[i] = bool;
	}
	public void setIsClassroom(boolean a) {
		this.isClassroom = a;
	}
	public void setIsCorridor(boolean a) {
		this.isCorridor = a;
	}
	public void setIsStudentSpown(boolean a) {
		this.isStudentSpawn = a;
	}
	public boolean getIsClassroom() {
		return isClassroom;
	}
	public boolean getIsCorridor() {
		return isCorridor;
	}
	public boolean isStudentSpawn() {
		return isStudentSpawn;
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
	
	// Operations
	public void affiche() { 
		System.out.println(noise+nbStudent+nbProfessor);
		System.out.println("is Possible Objectif (bool) = " + isPossibleObjective);
		System.out.println("is true ojectif(bool) = "+ isTrueObjective);
		System.out.println("Position = "+x+y);
		
	}

}