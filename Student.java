
public class Student extends Humanoides{

	// Constructor
	public Student() {
		super();
		action = 1; 
	}
	
	// Operations
	public void attack(Professor prof) {
		prof.health--;
		action--;	
	}
	
	public Case noticeNoise(Board board)
	{
		Case maxNoise = board.getBoard()[0][0];
		int nbMaxNoise = 1;
		
		// We search the noisiest case in the board
		for (int j = 1; j < 7; j++)
		{
			if (board.getBoard()[0][j].getNoise() > maxNoise.getNoise())
			{
				maxNoise = board.getBoard()[0][j];
				nbMaxNoise = 1;
			}
			if (board.getBoard()[0][j].getNoise() == maxNoise.getNoise())
			{
				nbMaxNoise++;
			}
		}
		for (int i = 1; i < 5; i++)
		{
			for (int j = 0; j < 7; j++)
			{
				if (board.getBoard()[i][j].getNoise() > maxNoise.getNoise())
				{
					maxNoise = board.getBoard()[i][j];
					nbMaxNoise = 1;
				}
				if (board.getBoard()[i][j].getNoise() == maxNoise.getNoise())
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
					if (board.getBoard()[i][j].getNoise() == maxNoise.getNoise())
					{
						caseNoise[nb] = board.getBoard()[i][j];
						nb++;
					}
				}
			}
		}
		
		// Now we check the shortest path between all those cases
		for (int i = 0; i < nbMaxNoise; i++)
		{
			
		}
	}
	
	public void beginningRound (Board board)
	{
		
	}
}
