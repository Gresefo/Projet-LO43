package engine;

public abstract class Student extends Humanoides{

	/*******************  Constructor  ********************/
	
	public Student() {
		super();
		action = 1; 
	}
	
	/*******************  Operations  ********************/
	
	// Puts bakc the action point of every student
	public abstract void setBackActionPoint();
	
	// Deal damage to a professor in the same case
	public void attack(Humanoides prof) {
		prof.health--;
		action = action - 2;	
	}
	
	// Look around the student and return the distance with each professor in vision site, 10 if not visible
	public int[] checkVision (Board board)
	{
		int isProfVisible[] = {10, 10, 10, 10};
		
		// See in the Top direction
		Case tmp = current_case;
		while (tmp.getIsLinkedTo(0))
		{
			tmp = board.getBoard()[tmp.getX()][tmp.getY() + 1];
			for (int i = 0; i < 4; i++)
			{
				if (board.listProf[i].current_case == tmp)
				{
					isProfVisible[i] = tmp.getNoise();
				}
			}	
		}
		
		// See in the Bottom direction
		tmp = current_case;
		while (tmp.getIsLinkedTo(1))
		{
			tmp = board.board[tmp.getX()][tmp.getY() - 1];
			for (int i = 0; i < 4; i++)
			{
				if (board.listProf[i].current_case == tmp)
				{
					isProfVisible[i] = tmp.getNoise();		
				}
			}
		}
		
		// See in the Right direction
		tmp = current_case;
		while (tmp.getIsLinkedTo(2))
		{
			tmp = board.board[tmp.getX() + 1][tmp.getY()];
			for (int i = 0; i < 4; i++)
			{
				if (board.listProf[i].current_case == tmp)
				{
					isProfVisible[i] = tmp.getNoise();
				}
			}
		}
		
		// See in the Left direction
		tmp = current_case;
		while (tmp.getIsLinkedTo(3))
		{
			tmp = board.board[tmp.getX() - 1][tmp.getY()];
			for (int i = 0; i < 4; i++)
			{
				if (board.listProf[i].current_case == tmp)
				{
					isProfVisible[i] = tmp.getNoise();		
				}
			}
		}
		return isProfVisible;
	}
	
	
	
	// Search for the noisiest case in the board
	public Case getBoardNoisiestCase(Board board)
	{
		Case maxNoise = board.board[0][0];
		int nbMaxNoise = 1;
		
		// We search the noisiest cases in the board
		for (int j = 1; j < 7; j++)
		{
			if (board.board[0][j].getNoise() > maxNoise.getNoise())
			{
				maxNoise = board.board[0][j];
				nbMaxNoise = 1;
			}
			if (board.board[0][j].getNoise() == maxNoise.getNoise())
			{
				nbMaxNoise++;
			}
		}
		for (int i = 1; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if (board.board[i][j].getNoise() > maxNoise.getNoise())
				{
					maxNoise = board.board[i][j];
					nbMaxNoise = 1;
				}
				if (board.board[i][j].getNoise() == maxNoise.getNoise())
				{
					nbMaxNoise++;
				}
			}
		}
		
		// If there is no noise on the board, return null
		if (maxNoise.getNoise() == 0)
		{
			return null;
		}
		
		// If we have several cases with the same number of noise and it is the maximum noise in the board,
		// then we do a list of all those cases in caseNoise[nbMaxNoise]
		if (nbMaxNoise > 1)
		{
			Case caseNoise[] = new Case[nbMaxNoise];
			int nb = 0;
			
			for (int i = 0; i < 5; i++)
			{
				for (int j = 0; j < 7; j++)
				{
					if (board.board[i][j].getNoise() == maxNoise.getNoise())
					{
						caseNoise[nb] = board.board[i][j];
						nb++;
					}
				}
			}
		}
		
		// Now we check the shortest path between all those cases
		for (int i = 0; i < nbMaxNoise; i++)
		{
			//caseNoise[i];
		}
	
	}

	
	
	// Return the distance from the case in parameter
	public int getDistance(Case c, Board board)
	{
		int distance = 0;
		
		
		return distance;
	}
	
	
	
	// Priority order :
	// - if some prof are in the same case, attack them
	// - then check vision
	// - then check noise
	// - then check distance
	// - if there are no  prof visible, no noise at all on the board, then wait
	public void beginningRound (Board board)
	{
		// Give back the action points
		this.setBackActionPoint();
		
		// Check if the student is on the same case as a professor
		boolean isSharingCaseWithProf[] = {false, false, false, false};
		int nbProfSharingCase = 0;
		for (int i = 0; i < 4; i++)
		{
			if (board.listProf[i] != null && current_case == board.listProf[i].current_case)
			{
				isSharingCaseWithProf[i] = true;
				nbProfSharingCase++;
			}
		}
		// Attack this prof. If here is more than one professor on this case, choose it randomly
		if (nbProfSharingCase >= 1)
		{
			int rand = (int)(Math.random() * nbProfSharingCase) + 1;
			int tmp = 0;
			for (int i = 0; i < 4; i++)
			{
				if (isSharingCaseWithProf[i] == true)
				{
					tmp++;
				}
				if (tmp == rand)
				{
					this.attack(board.listProf[i]);
				}
			}
		}
		
		
		
		// There is no prof on the same case as the student
		else
		{
			// Check if their is/are some prof visible
			// isProfVisible[] store the noise on the case of every prof visible
			// nbMaxNoise the nb of prof doing the same noise
			int isProfVisible[] = {0, 0, 0, 0};
			isProfVisible = this.checkVision(board);
			int maxNoise = 0, nbMaxNoise = 0;
			for (int i = 0; i < 4; i++)
			{
				if (isProfVisible[i] == maxNoise)
				{
					nbMaxNoise++;
				}
				if (isProfVisible[i] > maxNoise)
				{
					maxNoise = isProfVisible[i];
					nbMaxNoise = 1;
				}
			}
			// if there is at least one prof visible
			int distance[] = new int[4];
			for (int i = 0; i < 4; i++)
			{
				/*if (isProfVisible[i] == maxNoise)
					distance[i] = computeDistance(board, board.listProf[i])
				else
					distance[i] = 50;*/
			}
			if (nbMaxNoise >= 1) 
			{
				int rand = (int)(Math.random() * nbMaxNoise) + 1;
				int tmp = 0;
				for (int i = 0; i < 4; i++)
				{
					if (isProfVisible[i] == maxNoise)
					{
						tmp++;
					}
					if (tmp == rand)
					{
						//this.goTo(board.listProf[i].getCase());
					}
				}
			}
			
			
			
			
			// there is no prof visible, search for noise
			else
			{		
				Case noisiestCase = this.getBoardNoisiestCase(board);
			}
			
		}
		
		
	}
}