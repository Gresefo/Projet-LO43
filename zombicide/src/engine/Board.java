package engine;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//import java.util.*;
//import java.io.*;

public class Board {
	Case board[][] = new Case[7][5];
	Professor listProf[] = new Professor[4]; 
	ArrayList<Student> listStudent = new ArrayList<Student>();
	Item listAllItems[] = new Item[11];
	private BufferedImage STYLO, CLE, GUITARE, CRAIE, CRAIE_AM, FIL, LISTE, DICTIO_ANG, DICTIO_FRA, DICTIONNAIRE, LOUPE;
	
	
	// Constructors

	public Board() 
	{		
		for (int i = 0; i < 4; i++)
		{
			listProf[i] = null;
		}
		
		try {
			STYLO = ImageIO.read(new File("img/stylo.png"));
			CLE = ImageIO.read(new File("img/cle.png"));
			GUITARE = ImageIO.read(new File("img/guitare.png"));
			CRAIE = ImageIO.read(new File("img/craie.png"));
			CRAIE_AM = ImageIO.read(new File("img/craie_am.png"));
			FIL = ImageIO.read(new File("img/fil.png"));
			LISTE = ImageIO.read(new File("img/liste.png"));
			DICTIO_ANG = ImageIO.read(new File("img/dictionnaire1.png"));
			DICTIO_FRA = ImageIO.read(new File("img/dictionnaire2.png"));
			DICTIONNAIRE = ImageIO.read(new File("img/dictionnaire.png"));
			LOUPE = ImageIO.read(new File("img/loupe.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// Initialize a list of all Items
		listAllItems[0] = new Weapon(0, "Stylo", STYLO, true, true, false, true, 2, 1, 4, 2);
		listAllItems[1] = new Weapon(1, "Clé", CLE, true, true, false, true, 0, 3, 5, 2);
		listAllItems[2] = new Weapon(2, "Guitare", GUITARE, true, false, false, false, 0, 3, 4, 2);
		listAllItems[3] = new Weapon(3, "Craies", CRAIE, false, false, false, true, 2, 3, 5, 1);
		listAllItems[4] = new Weapon(4, "Craies améliorées", CRAIE_AM, false, false, false, true, 2, 4, 3, 1);
		listAllItems[5] = new Weapon(5, "Fil de souris", FIL, false, false, true, false, 1, 2, 4, 1);
		listAllItems[6] = new Weapon(6, "Liste des UV de culture générale", LISTE, false, false, true, false, 0, 3, 3, 1);
		listAllItems[7] = new Weapon(7, "Dictionnaire français-anglais", DICTIONNAIRE, false, false, false, false, 2, 1, 1, 3);
		listAllItems[8] = new Consumable(8, "Loupe", LOUPE);
		listAllItems[9] = new Consumable(9, "Dictionnaire partie 1", DICTIO_ANG);
		listAllItems[10] = new Consumable(10, "Dictionnaire partie 2", DICTIO_FRA);
	}
	
	
	/*******************  Getters and Setters  ********************/
	
	public Case[][] getBoard() {
		return board;
	}

	public void setBoard(Case[][] board) {
		this.board = board;
	}
	
	public Item[] getListAllItems() {
		return listAllItems;
	}

	public ArrayList<Student> getListStudent() {
		return listStudent;
	}
	
	public Professor[] getListProf() {
		return listProf;
	}
	
	public void setListProf(Professor prof, int i) {
		this.listProf[i] = prof;
	}
	
	public void setListStudent(ArrayList<Student> student) {
		this.listStudent = student;
	}


	/*******************  Operations  ********************/
	
	// Launch the round of every student
	public void startRoundStudent()
	{
		// Spawn new student
		int nbNewStudent = nbNewStudent();
		for (int i = 1; i < 5; i++)
		{
			addHumanoide(nbNewStudent, i);
		}
		
		// Do the round of every student
		int size = getListStudent().size();
		for(int i = 0; i < size; i++)
		{
			getListStudent().get(i).begingRound(this);
		}
		
		// Put null for every professor dead
		for (int i = 0; i < 4; i++)
		{
			if (listProf[i].health <= 0)
				listProf[i] = null;
		}
		
		// Reset the noise
		for (int i = 0; i < 7; i++) 
		{
			for (int j = 0; j < 5; j++) 
			{
				board[i][j].setNoise(0);
			}
		}
	}
	
	// Create a new random type Student in listStudent in one of the 4th spawns
	public void addHumanoide(int nombre, int spawn)
	{
		int x = 0, y = 0;
		if (spawn == 1) {
			x = 0;
			y = 2;
		}
		else if (spawn == 2) {
			x = 3;
			y = 0;
		}
		else if (spawn == 3) {
			x = 4;
			y = 2;
		}
		else if (spawn == 4) {
			x = 6;
			y = 4;
		}
		for (int i = 0; i < nombre; i++) {
			int roll = (int) (Math.random() * 20) + 1;
		    switch(roll)
		    {
		    // Student TC
		    case 1: case 2: case 3: case 4: case 5: case 6: case 7: case 8: 
		    	listStudent.add(new Student_TC(this.board[x][y]));
		    	this.board[x][y].setNbStudent(this.board[x][y].getNbStudent() + 1);;
		    	break;
		    // Student BDS
		    case 9: case 10: case 11: case 12: case 13 : 
		    	listStudent.add(new Student_BDS(this.board[x][y]));
		    	this.board[x][y].setNbStudent(this.board[x][y].getNbStudent() + 1);;
		    	break;
		    // Student IUT
		    case 14: case 15: case 16: case 17: case 18: case 19 :
		    	listStudent.add(new Student_IUT(this.board[x][y]));
		    	this.board[x][y].setNbStudent(this.board[x][y].getNbStudent() + 1);;
		    	break;
		    // Foreigner Student
		    case 20 : 
		    	listStudent.add(new Student_foreigners(this.board[x][y]));
		    	this.board[x][y].setNbStudent(this.board[x][y].getNbStudent() + 1);;
		    	break;
		    }
		}
	}


	// Return the number of student to create depending of the max level of the profs
	public int nbNewStudent()
	{
		int max = 1;
		for (int i = 0; i < 4; i++)
		{
			if (listProf[i] != null)
			{
				if (listProf[i].getLevel() > max)
				{
					max = listProf[i].getLevel();
				}
			}
		}
		switch(max)
		{
		case 1: case 2: case 3: case 4: case 5: case 6: case 7:
			return 1;
		case 8: case 9: case 10: case 11: case 12: case 13: case 14: case 15 :
			return 2;
		case 16: case 17: case 18: case 19: case 20: case 21: case 22: case 23: case 24: case 25: case 26: case 27: case 28: case 29:
			return 3;
		default:
			return 4;
		}
	}
	
	
	//pathfinder
		 //ArrayList al = new ArrayList();
		 public ArrayList<Case> pathFinder(Case cs,Case ct)
		 {
			 Case current;
			 cs.setCost(0);
			 cs.setHeuristic(0);
			 ct.setPred(null);
			 ArrayList<Case> path=new ArrayList<Case>();
			 ArrayList<Case> closedList = new ArrayList<Case>();
			 ArrayList<Case> openList = new ArrayList<Case>();
			 openList.add(cs);
			 while(openList.size()!=0)
			 {
				 current=openList.get(0);
				 if(current==ct) {break;}
				 closedList.add(current);
				 openList.remove(0);
				 for(int x=-1;x<2;x++)
				 {
					 for(int y=-1;y<2;y++)
					 {
						 if (x == 0 || y == 0 /*&& !(x==0 && y==0)*/) 
						 {
							 if(x != 0 || y != 0)
							 {
								 int xp = x + current.getX();
								 int yp = y + current.getY();
								 if(reachable(current, xp, yp))
								 {
									 int Nextstepcost=current.getCost()+1;
									 Case neighbour=board[yp][xp];
									 if(Nextstepcost < neighbour.getCost())
									 {
										 if(openList.contains(neighbour)) {openList.remove(neighbour);}
										 if(closedList.contains(neighbour)){closedList.remove(neighbour);}
									 }
									 if(!openList.contains(neighbour) && !closedList.contains(neighbour))
									 {
										 neighbour.setCost(Nextstepcost);
										 int kx=ct.getX()-xp,ky=ct.getY()-yp;
										 neighbour.setHeuristic(neighbour.getCost()+Math.sqrt((kx*kx)+(ky*ky)));
										 neighbour.setPred(current);
										 openList.add(neighbour);
										 openList=sort(openList);
									 }
								 }
							 } 
						 }
					 }
				 }
			 }
			 if (ct.getPred() == null) {
					return null;
				}
			 Case walker=ct;
			 path.add(walker);
			 while(walker != cs)
			 {
				 path.add(walker.getPred());
				 walker=walker.getPred();
			 }
			 return path;
		 }
		 
		 public ArrayList<Case> sort(ArrayList<Case> al)//tri a bulle avec pour clé la valeur heuristic
		 {
			 Case temp;
			 boolean sorted=true;
			 for(int i=al.size()-1;i>1 && sorted;i--)
			 {
				 sorted=true;
				 for(int j=0;j<i-1;j++)
				 if(al.get(j+1).getHeuristic()<al.get(j).getHeuristic())
				 {
					 sorted=false;
					 temp=al.get(j+1);
					 al.set(j+1,al.get(j));
					 al.set(j,temp);
				 }
				 
			 }
			 return al;
		 }
		 
		 public boolean reachable(Case s, int xp,int yp)
		 {
			 int ecartX=xp-s.getX(),ecartY=yp-s.getY();
			 if(ecartX==0)
			 {
				 if(ecartY>0)
				 {
					 if(s.getIsLinkedTo(1))
					 { return true;}
				 }
				 else
				 {
					 if(s.getIsLinkedTo(0))
					 {
						 return true;
					 }
				 }
			 }
			 else
			 {
				 if(ecartX<0)
				 {
					 if(s.getIsLinkedTo(3))
					 {return true;}
				 }
				 else
				 {
					 if(s.getIsLinkedTo(2))
					 {
						 return true;
					 }
				 }
			 }
			 return false;
		 }
		 
		 
		 public int compareCase(Case c1,Case c2)
		 {
			 if(c1.getHeuristic()<c2.getHeuristic())
			 {
				 return 1;
			 }
			 else if(c1.getHeuristic()==c2.getHeuristic())
			 {
				 return 0 ;
			 }
			 else
			 {
				 return -1;
			 }
		 }
	
}