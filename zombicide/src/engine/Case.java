package engine;

public class Case {
	private int x,y;
	private int cost;
	private double heuristic;
	private int noise;
	private int nbStudent;
	private int hasDoor;
	private boolean isLinkedTo[] = new boolean[4]; //Top bottom right left 
	private boolean isPossibleObjective;
	private boolean isTrueObjective;
	private boolean isSearchable;
	private boolean isStudentSpawn;
	private Case pred;

	// Constructors

	public Case(int i, int j, int _noise, int _nbStudent, int _hasDoor, boolean _isPossibleObjective, boolean _isTrueObjective, 
			boolean _isSearchable, boolean _isStudentSpawn) 
	{
		x = i;
		y = j;
		noise = _noise;
		nbStudent = _nbStudent;
		hasDoor = _hasDoor;
		isPossibleObjective = _isPossibleObjective;
		isTrueObjective = _isTrueObjective;
		isSearchable = _isSearchable;
		isStudentSpawn = _isStudentSpawn;
		for (int a = 0; a < 4; a++)
		{
			isLinkedTo[a] = false;
		}

	}
	
	public Case() {
		this.x = 0;
		this.y = 0;
		noise = 0;
		nbStudent = 0;
		hasDoor = 0;
		isPossibleObjective = false;
		isTrueObjective =false;
		isSearchable = false;
		isStudentSpawn = false;
	}
	
	// Getters and Setters
	public double getHeuristic()
	{
		return heuristic;
	}
	public void setHeuristic(double h)
	{
		heuristic=h;
	}
	public int getCost()
	{
		return cost;
	}
	public void setCost(int i)
	{
		cost=i;
	}
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
	public void setIsLinkedTo(boolean bool, int i) {
		this.isLinkedTo[i] = bool;
	}
	public void setIsStudentSpown(boolean a) {
		this.isStudentSpawn = a;
	}
	public boolean isStudentSpawn() {
		return isStudentSpawn;
	}
	public void setPosition(int a, int b/*,Board board*/) {
		this.x = a;
		this.y = b;
		//this=board.getBoard()[x][y];
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
	public boolean isSearchable() {
		return isSearchable;
	}
	public void setSearchable(boolean isSearchable) {
		this.isSearchable = isSearchable;
	}

	// Operations
	public void affiche() { 
		System.out.println(noise+nbStudent);
		System.out.println("is Possible Objectif (bool) = " + isPossibleObjective);
		System.out.println("is true ojectif(bool) = "+ isTrueObjective);
		System.out.println("Position = "+x+y);
		
	}

}