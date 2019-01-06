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
	
	// Puts back the action point of every student
	public abstract void setBackActionPoint();

	// Deal damage to a professor in the same case
	public void attack(Board board) {
		System.out.println( "début atq,current case " + current_case.getX() + " / " + current_case.getY());
		Case target =current_case;
		int profvisible[]=this.checkVision(board),comp;
		boolean vision=false;
		comp=profvisible[0];
		for(int i =0;i<4;i++)
		{
			
			if(profvisible[i] != 10 && i<2 && Math.abs(profvisible[i])<comp)
			{
				
				target= board.getBoard()[current_case.getX()+profvisible[i]][current_case.getY()];
				comp=Math.abs(profvisible[i]);
				vision=true;
			}
			else if(profvisible[i] != 10 && i>1 && Math.abs(profvisible[i])<comp)
			{
				target= board.getBoard()[current_case.getX()][current_case.getY()+profvisible[i]];
				comp=Math.abs(profvisible[i]);
				vision=true;
			}
		}
		System.out.println( " atq,current case " + current_case.getX() + " / " + current_case.getY());
		for(int i=0;i<4;i++)
		{
			System.out.println("la visibilité" + profvisible[i]);
		}
		System.out.println(vision);
		if(vision==false)
		{
			ArrayList<Case> noisy_case= new ArrayList<Case>();
			noisy_case=getBoardNoisiestCase( board);
			if (noisy_case.size()!=0)
			{
				for(int k=0;k<noisy_case.size();k++)
				{
					System.out.println( "case bruit coord: "+ noisy_case.get(k).getX() + " / " + noisy_case.get(k).getY()); 
				}
			}
			else
			{
				System.out.println("noisy case vide");
			}
			if(noisy_case.size()==0 || noisy_case.get(0).getX()==-1)
			{
				System.out.println("Aucun bruit/Aucun visu.");
				return ;
			}
			else if(noisy_case.size()==1)
			{
				target=noisy_case.get(0);
				System.out.println("target coord:" + target.getX() + " / " + target.getY());
			}
			else
			{
				
				int min=getDistance(noisy_case.get(0),board);
				target=noisy_case.get(0);
				for(int k=1;k<noisy_case.size();k++)
				{
					if(getDistance(noisy_case.get(k),board)<min)
					{
						target=noisy_case.get(k);
						min=getDistance(noisy_case.get(k),board);
					}
					
				}
				
			}
			
			
		}
		System.out.println( "début atq 2,current case " + current_case.getX() + " / " + current_case.getY());
		System.out.println( "current case " + current_case.getX() + " / " + current_case.getY());
		System.out.println("target les coord:" + target.getX() + " / " + target.getY());
		ArrayList<Case> path=board.pathFinder(current_case, target);
		System.out.println( "current case " + current_case.getX() + " / " + current_case.getY());
		for(int k=0;k<path.size();k++)
		{
			System.out.println( "Case until target: " + path.get(k).getX() + " / " + path.get(k).getY()); 
		}
		while((current_case != target || path.isEmpty()==false) && action>0  )
		{
			if(action>0)
			{
			current_case.setNbStudent(current_case.getNbStudent()-1);
			current_case = board.board[path.get(0).getX()][path.get(0).getY()];
			current_case.setNbStudent(current_case.getNbStudent()+1);
			path.remove(0);
			action--;
			}
		}
		if(current_case==target)
		{
			target_reached(current_case,board);
		}
		
		
		/*if(action>0)
		{
			attack(board);
		}*/
		
		//prof.health--;
		//action = action - 1;
	}

	public void target_reached(Case c,Board board)
	{
		boolean isSharingCaseWithProf[] = {false, false, false, false};
		int nbProfSharingCase = 0;
		ArrayList<Professor> prof_sharing = new ArrayList<Professor>();
		for (int i = 0; i < 4; i++)
		{
			if (board.listProf[i] != null && /*current_case*/c == board.listProf[i].current_case)
			{
				isSharingCaseWithProf[i] = true;
				nbProfSharingCase++;
				prof_sharing.add(board.listProf[i]);
				
			}
		}
		boolean removed=false;
		int rand = (int)(Math.random() * prof_sharing.size() );
		System.out.println(rand);
		if(prof_sharing.isEmpty()==false)
		{
			Professor prof=prof_sharing.get(rand);
			while(action>0 && prof.getHealth()>0)//prof_sharing.get(rand).getHealth()>0)
			{
				prof_sharing.get(rand).health--;
				
				if(prof_sharing.get(rand).health<=0)
				{
					for(int k=0;k<4;k++)
					{
						if(board.listProf[k].health <= 0 )
						{
							board.listProf[k]=null;
						}
					}
					prof_sharing.remove(rand);
					//Professor prof=prof_sharing.get(rand);
					//prof_sharing.get(rand).finalize();
					//prof_sharing.remove(rand);
				}
				action=action--;
			}
		}
		if(action >0 && prof_sharing.size()>0)
		{
			target_reached(c,board);
		}
	}
	
	// Look around the student and return the distance with each professor in vision site, 10 if not visible
	public int[] checkVision (Board board)
	{
		int isProfVisible[] = {10, 10, 10, 10};
		boolean found=false;
		// See in the Top direction
		Case tmp = current_case;
		while (tmp.getIsLinkedTo(0) && found==false)
		{
			
			for (int i = 0; i < 4; i++)
			{
				if (board.listProf[i] != null && board.listProf[i].current_case == tmp)
				{
					//isProfVisible[i] = tmp.getNoise();
					isProfVisible[i] = tmp.getY()-current_case.getY();
					found = true;
				}
			}	
			tmp = board.getBoard()[tmp.getX()][tmp.getY() + 1];
		}
		found=false;
		// See in the Bottom direction
		tmp = current_case;
		while (tmp.getIsLinkedTo(1) && found==false)
		{
			
			for (int i = 0; i < 4; i++)
			{
				if (board.listProf[i] != null && board.listProf[i].current_case == tmp)
				{
					//isProfVisible[i] = tmp.getNoise();
					isProfVisible[i] = tmp.getY()-current_case.getY();
					System.out.println("la distance visible est"+isProfVisible[i]);
					found = true;
				}
			}
			tmp = board.board[tmp.getX()][tmp.getY() - 1];
		}
		found=false;
		// See in the Right direction
		tmp = current_case;
		while (tmp.getIsLinkedTo(2) && found==false)
		{
			
			for (int i = 0; i < 4; i++)
			{
				if (board.listProf[i] != null && board.listProf[i].current_case == tmp)
				{
					//isProfVisible[i] = tmp.getNoise();
					isProfVisible[i] = tmp.getX()-current_case.getX();
					System.out.println("la distance visible est"+isProfVisible[i]);
					found = true;
				}
				//System.out.println("temp vision coord : " + tmp.getX() + " / " + tmp.getY());
			}
			tmp = board.board[tmp.getX() + 1][tmp.getY()];;
		}
		found=false;
		// See in the Left direction
		tmp = current_case;
		while (tmp.getIsLinkedTo(3) && found==false)
		{
			
			for (int i = 0; i < 4; i++)
			{
				if (board.listProf[i] != null && board.listProf[i].current_case == tmp)
				{
					//isProfVisible[i] = tmp.getNoise();
					isProfVisible[i] = tmp.getX()-current_case.getX();
					found=true;
				}
			}
			tmp = board.board[tmp.getX() - 1][tmp.getY()];
		}
		for(int k=0;k<4;k++)
		{
			System.out.println("le tableau est" + isProfVisible[k]);	
		}
		
		return isProfVisible;
	}
	
	
	
	// Search for the noisiest case in the board
	public ArrayList<Case> getBoardNoisiestCase(Board board)
	{
		ArrayList<Case>  maxNoise = new ArrayList<Case>();
		Case valeur_si_nulle = new Case();
		valeur_si_nulle.setX(-1);
		valeur_si_nulle.setY(-1);
		valeur_si_nulle.setNoise(0);
		maxNoise.add(valeur_si_nulle);
		//maxNoise.add(board.board[0][0]);
		int nbMaxNoise = 1;
		
		// We search the noisiest cases in the board
		for (int j = 0; j < 5; j++)
		{
			if (board.board[0][j].getNoise() > maxNoise.get(0).getNoise())
			{
				//maxNoise = board.board[0][j];
				maxNoise.removeAll(maxNoise);
				maxNoise.add(board.board[0][j]);
				nbMaxNoise = 1;
			}
			if (board.board[0][j].getNoise() == maxNoise.get(0).getNoise() )
			{
				maxNoise.add(board.board[0][j]);
				nbMaxNoise++;
			}
		}
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				if (board.board[i][j].getNoise() > maxNoise.get(0).getNoise())
				{
					//maxNoise = board.board[i][j];
					maxNoise.removeAll(maxNoise);
					maxNoise.add(board.board[i][j]);
					nbMaxNoise = 1;
				}
				if (board.board[i][j].getNoise() == maxNoise.get(0).getNoise() )
				{
					maxNoise.add(board.board[i][j]);
					nbMaxNoise++;
				}
			}
		}		
		return maxNoise;
		// If there is no noise on the board, return null
		/*if (maxNoise.getNoise() == 0)
		{
			return null;
		}*/
		
		// If we have several cases with the same number of noise and it is the maximum noise in the board,
		// then we do a list of all those cases in caseNoise[nbMaxNoise]
		/*if (nbMaxNoise > 1)
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
			return new Case(); //A enlever une fois la fonction terminer je peux pas avancer si je emts pas ça
		}*/
		
		// Now we check the shortest path between all those cases
		/*for (int i = 0; i < nbMaxNoise; i++)
		{
			//caseNoise[i];
		}
		return maxNoise;*/
	
	}

	
	
	// Return the distance from the case in parameter
	public int getDistance(Case c, Board board)
	{
		int distance = 0;
		ArrayList<Case> path = new ArrayList<Case>();
		path=board.pathFinder(current_case, c);
		distance=path.size();
		return distance;
	}
	
	
	
	// Priority order :
	// - if some prof are in the same case, attack them
	// - then check vision
	// - then check noise
	// - then check distance
	// - if there are no  prof visible, no noise at all on the board, then wait
	public void begingRound (Board board)
	{
		// Give back the action points
		Case s=board.board[0][4],t=board.board[2][0];
		//int dist=getDistance();
		System.out.println("case 6 2 islinkedtoo[2]: " + board.board[6][2].getIsLinkedTo(2));
		ArrayList<Case> path=board.pathFinder(s, t) , al=new ArrayList<Case>();
		System.out.println("al taille :" + al.size());
		System.out.println(t.getPred().getX()+" / " +t.getPred().getY());
		System.out.println("path taille" + path.size());
		if(path.size()==0)
		{
			System.out.println("path=vide");
		}
		else
		{
			for(int k=0;k<path.size();k++)
			{
				System.out.println( "Case : " + path.get(k).getX() + " / " + path.get(k).getY()); 
			}
			
		}
		this.setBackActionPoint();
		attack(board);
		
		
		// Check if the student is on the same case as a professor
		/*boolean isSharingCaseWithProf[] = {false, false, false, false};
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
			@SuppressWarnings("unused")
			int distance[] = new int[4];
			for (int i = 0; i < 4; i++)
			{
				if (isProfVisible[i] == maxNoise)
					distance[i] = computeDistance(board, board.listProf[i])
				else
					distance[i] = 50;
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
				@SuppressWarnings("unused")
				Case noisiestCase = this.getBoardNoisiestCase(board);
			}
			
		}*/
		
		
	}
}