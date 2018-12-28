
public abstract class Student extends Humanoides{

	// Constructor
	public Student() {
		super();
		action = 1; 
	}
	
	
	/*******************  Operations  ********************/
	
	// Deal damage to a professor in the same case
	public void attack(Humanoides prof) {
		prof.health--;
		action = action - 2;	
	}
	
	
	
	// Set back the number of action points at each beginning of round
	public abstract void setBackActionPoint();
	
	
	
	// Look around the student and return the distance with each professor in vision site, 10 if not visible
	public int[] checkVision (Board board)
	{
		int isProfVisible[] = {10, 10, 10, 10};
		
		// See in the Top direction
		Case tmp = current_case;
		int distance = 0;
		while (tmp.getIsLinkedTo(0))
		{
			tmp = board.board[tmp.getX()][tmp.getY() + 1];
			distance++;
			for (int i = 0; i < 4; i++)
			{
				if (board.listHumanoides[i].current_case == tmp)
				{
					isProfVisible[i] = distance;
				}
			}	
		}
		
		// See in the Bottom direction
		tmp = current_case;
		distance = 0;
		while (tmp.getIsLinkedTo(1))
		{
			tmp = board.board[tmp.getX()][tmp.getY() - 1];
			distance++;
			for (int i = 0; i < 4; i++)
			{
				if (board.listHumanoides[i].current_case == tmp)
				{
					isProfVisible[i] = distance;		
				}
			}
		}
		
		// See in the Right direction
		tmp = current_case;
		distance = 0;
		while (tmp.getIsLinkedTo(2))
		{
			tmp = board.board[tmp.getX() + 1][tmp.getY()];
			distance++;
			for (int i = 0; i < 4; i++)
			{
				if (board.listHumanoides[i].current_case == tmp)
				{
					isProfVisible[i] = distance;		
				}
			}
		}
		
		// See in the Left direction
		tmp = current_case;
		distance = 0;
		while (tmp.getIsLinkedTo(3))
		{
			tmp = board.board[tmp.getX() - 1][tmp.getY()];
			distance++;
			for (int i = 0; i < 4; i++)
			{
				if (board.listHumanoides[i].current_case == tmp)
				{
					isProfVisible[i] = distance;		
				}
			}
		}
		
		return isProfVisible;
	}
	
	
	
	// Search for the noisiest case in the board
	public Case noticeNoise(Board board)
	{
		Case maxNoise = board.board[0][0];
		int nbMaxNoise = 1;
		
		// We search the noisiest case in the board
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
			//caseNoise[i]
		}
	}

	
	
	
	// Priority order :
	// - if some prof are in the same case, attack
	// - check vision, if 2 groups same distance, go to noisiest, if same, go random
	// - check noise, go to noisiest, if 2 groups same distance, go random
	// - if no vision nor noise, stay in waiting mode
	public void beginningRound (Board board)
	{
		// Give back the action points
		this.setBackActionPoint();
		
		// Check if the student is on the same case as a professor
		boolean isSharingCaseWithProf[] = {false, false, false, false};
		int nbProfSharingCase = 0;
		for (int i = 0; i < 4; i++)
		{
			if (board.listHumanoides[i] != null && current_case == board.listHumanoides[i].current_case)
			{
				isSharingCaseWithProf[i] = true;
				nbProfSharingCase++;
			}
		}
		// There is more than one professor on this case, attack this prof. Chose it randomly
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
					this.attack(board.listHumanoides[i]);
				}
			}
		}
		
		
		
		// There is no prof on the same case as the student
		else
		{
			int isProfVisible[] = {10, 10, 10, 10};
			isProfVisible = this.checkVision(board);
			int min = 10 ;
			for (int i = 0; i < 4; i++)
			{
				//if (isProfVisible[i] < )
			}
		}
		
		
	}
}
