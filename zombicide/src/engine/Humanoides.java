package engine;

public abstract class Humanoides {

protected int id;
protected Case current_case;
protected int action;
protected int health;

	// Constructor
	public Humanoides() {
		this.id = 4;
		this.action = 1;
		this.health = 2;
		this.current_case = null;
	}

	/*******************  Operations  ********************/

	// Walk function depending of the direction
	public void walkTop(Board board) {
		if (current_case.getIsLinkedTo(0))
		{
			current_case = board.getBoard()[current_case.getX()][current_case.getY() + 1];
			action--;
		}
	}
	
	public void walkBottom(Board board) {
		if (current_case.getIsLinkedTo(1))
		{
			current_case = board.getBoard()[current_case.getX()][current_case.getY() - 1];
			action--;
		}
	}
	
	public void walkRight(Board board) {
		if (current_case.getIsLinkedTo(2))
		{
			current_case = board.getBoard()[current_case.getX() + 1][current_case.getY()];
			action--;
		}
	}
	
	public void walkLeft(Board board) {
		if (current_case.getIsLinkedTo(3))
		{
			current_case = board.getBoard()[current_case.getX() - 1][current_case.getY()];
			action--;
		}
	}
	
	// Verify if the number of action point is equal to 0
	public boolean stillHasAction()
	{
		if (action == 0)
			return false;
		else
			return true;
	}

	/*******************  Getters and Setters  ********************/
	
	
	public int getAction() {
		return action;
	}

	public void setAction(int action) {
		this.action = action;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
	public Case getCase() {
		return current_case;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Case getCurrent_case() {
		return current_case;
	}

	public void setCurrent_case(Case current_case) {
		this.current_case = current_case;
	}
	

}

