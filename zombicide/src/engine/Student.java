package engine;
import java.util.ArrayList;

public abstract class Student extends Humanoides{
	int studentType; //0 TC, 1 BDS, 2 IUT, 3 Foreigners

	/*******************  Constructor  ********************/
	
	public Student() {
		super();
		action = 1; 
	}
	
	/*******************  Getters and Setters  ********************/

	public int getStudentType() {
		return studentType;
	}

	public void setStudentType(int studentType) {
		this.studentType = studentType;
	}
	
	/*******************  Operations  ********************/
	
	// Priority order :
	// - if some professors are in the same case, attack them
	// - then check vision
	// - then check noise
	// - then check distance
	// - if there is no professor visible, no noise at all on the board, then wait
	public void begingRound (Board board)
	{
		// Give back the action points
		this.setBackActionPoint();
		
		while (action > 0)
		{
			// Check if the student is on the same case as a professor
			boolean isSharingCaseWithProf[] = {false, false, false, false};
			int nbProfSharingCase = 0;
			for (int i = 0; i < 4; i++)
			{
				if (board.listProf[i] != null && this.current_case == board.listProf[i].current_case)
				{
					isSharingCaseWithProf[i] = true;
					nbProfSharingCase++;
				}
			}
			// Attack this prof. If here is more than one professor on this case, choose it randomly
			if (nbProfSharingCase >= 1)
			{
				int rand = (int)(Math.random() * nbProfSharingCase + 1);
				int tmp = 0;
				int i = 0;
				while (i < 4 && tmp != rand)
				{
					if (isSharingCaseWithProf[i] == true)
						tmp++;
					if (tmp == rand)
						break;
					i++;
				}
				this.attack(board, i);
			}
		
			// There is no professor on the same case as the student, the student is going to walk
			else
			{
				action--;
				ArrayList<Case> possibleDestinations = lookAround(board);
				// There is no professor visible
				if(possibleDestinations.isEmpty())
				{
					possibleDestinations = listenToNoise(board);
					if(possibleDestinations.isEmpty())
					{
						// If there is no noise, the student don't do any thing
					}
					else
					{
						possibleDestinations = compareDistance(board, possibleDestinations);
						Case destination = chooseFinalDestination(possibleDestinations);
						goTo(board, destination);
					}
				}
					
				
				// The student sees at least one case with a prof
				else
				{
					// We only keep the cases with the maximum noise
					possibleDestinations = compareNoise(possibleDestinations);
					// We only keep the cases the closest
					possibleDestinations = compareDistance(board, possibleDestinations);
					Case destination = chooseFinalDestination(possibleDestinations);
					goTo(board, destination);
				}
			}
		}
		
	}
	
	// Puts back the action point of every student
	public abstract void setBackActionPoint();
	
	// Deal damage to a professor in the same case
	public void attack(Board board, int i) 
	{
		// If it is a BDS student, then only attack if he haven't move before
		if (studentType == 1)
		{
			if (action == 2)
			{
				board.getListProf()[i].health--;
				if (board.getListProf()[i].health == 0)
				{
					board.getListProf()[i] = null;
				}
			}
		}
		else
		{
			board.getListProf()[i].health--;
			if (board.getListProf()[i].health == 0)
			{
				board.getListProf()[i] = null;
			}
		}
		action--;
	}
	
	// Return every case that has at least a professor visible by the student in it
	public ArrayList<Case> lookAround(Board board)
	{
		ArrayList<Case> listCase = new ArrayList<Case>();
		// See in the Top direction
		Case tmp = current_case;
		while (tmp.getIsLinkedTo(0))
		{
			tmp = board.board[tmp.getX()][tmp.getY() + 1];
			if (thereIsProf(board, tmp))
				listCase.add(tmp);	
		}
		// See in the Bottom direction
		tmp = current_case;
		while (tmp.getIsLinkedTo(1))
		{
			tmp = board.board[tmp.getX()][tmp.getY() - 1];
			if (thereIsProf(board, tmp))
				listCase.add(tmp);	
		}
		// See in the Right direction
		tmp = current_case;
		while (tmp.getIsLinkedTo(2))
		{
			tmp = board.board[tmp.getX() + 1][tmp.getY()];
			if (thereIsProf(board, tmp))
				listCase.add(tmp);	
		}
		// See in the Left direction
		tmp = current_case;
		while (tmp.getIsLinkedTo(3))
		{
			tmp = board.board[tmp.getX() - 1][tmp.getY()];
			if (thereIsProf(board, tmp))
				listCase.add(tmp);	
		}
		return listCase;
	}
	
	// Return true if there is a professor on this case
	public boolean thereIsProf(Board board, Case tmp)
	{
		int i = 0;
		while (i < 4 && (board.getListProf()[i] == null || board.getListProf()[i].current_case != tmp))
		{
			i++;
		}
		if (i < 4 && board.getListProf()[i] != null)
			return true;
		else
			return false;
	}
	
	// Only keep the cases with the higher noise
	public ArrayList<Case> compareNoise(ArrayList<Case> possibleDestinations)
	{
		ArrayList<Case> result = new ArrayList<Case>();
		int size = possibleDestinations.size(), max = possibleDestinations.get(0).getNoise();
		for (int i = 0; i < size; i++)
		{
			if (max < possibleDestinations.get(i).getNoise())
			{
				max = possibleDestinations.get(i).getNoise();
				result.clear();
			}
			if (possibleDestinations.get(i).getNoise() == max)
				result.add(possibleDestinations.get(i));
		}
		return result;
	}
	
	// Return a list with all the cases with the highest noise of the board
	public ArrayList<Case> listenToNoise(Board board)
	{
		ArrayList<Case> result = new ArrayList<Case>();
		int max = 1;
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (max < board.getBoard()[i][j].getNoise())
				{
					max = board.getBoard()[i][j].getNoise();
					result.clear();
				}
				if (board.getBoard()[i][j].getNoise() == max)
					result.add(board.getBoard()[i][j]);
			}
		}
		return result;
	}

	// Choose randomly the final destination
	public Case chooseFinalDestination (ArrayList<Case> list)
	{
		return list.get((int)(Math.random() * list.size()));
	}
	
	// Return a list with only the cases that are the closest
	public ArrayList<Case> compareDistance(Board board, ArrayList<Case> list)
	{
		ArrayList<Case> result = new ArrayList<Case>();
		int size = list.size();
		int min = getDistance(board, list.get(0));
		for (int i = 0; i < size; i++)
		{
			if (min > getDistance(board, list.get(i)))
			{
				min = getDistance(board, list.get(i));
				result.clear();
			}
			if (min == getDistance(board, list.get(i)))
				result.add(list.get(i));
		}
		return result;
	}
	
	// Return the distance from the current case
	public int getDistance(Board board, Case destination)
	{
		ArrayList<Case> path = board.pathFinder(current_case, destination);
		return path.size();
	}
	
	// Makes the student move towards its destination
	public void goTo(Board board, Case destination)
	{
		ArrayList<Case> path = board.pathFinder(current_case, destination);
		current_case.setNbStudent(current_case.getNbStudent() - 1);
		current_case = path.get(0);
		current_case.setNbStudent(current_case.getNbStudent() + 1);
	}
}
	