public class Case {
private int x,y;
private int cost;
private double heuristic;
private int noise;
private int nbStudent;
private int hasDoor;
private boolean isLinkedTo[] = new boolean[4];//Top bottom right left 
private boolean isPossibleObjective;
private boolean isTrueObjective;
private boolean isSearchable;
private boolean isStudentSpawn;
private Case pred;

	// Constructors
	public Case(int i, int j) {
		this.x=i;
		this.y=j;
		cost=0;
		for(int k=0;k<4;k++)
		{
			isLinkedTo[k]=true;
		}
		if(i==0)
		{
			isLinkedTo[3]=false;
		}
		if(j==0)
		{
			isLinkedTo[0]=false;
		}
		if(i==4)
		{
			isLinkedTo[2]=false;
		}
		if(j==6)
		{
			isLinkedTo[1]=false;
		}
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
	public void setIsStudentSpown(boolean a) {
		this.isStudentSpawn = a;
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
	public int getHasDoor() {
		return hasDoor;
	}
	public void setHasDoor(int hasDoor) {
		this.hasDoor = hasDoor;
	}

	
	// Operations
	public void affiche() { 
		System.out.println(noise+nbStudent);
		System.out.println("is Possible Objectif (bool) = " + isPossibleObjective);
		System.out.println("is true ojectif(bool) = "+ isTrueObjective);
		System.out.println("Position = "+x+y);
		
	}

}