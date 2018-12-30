package engine;

import java.util.ArrayList;

//import java.util.*;
//import java.io.*;

public class Board {
	private Case board[][] = new Case[5][7];
	private Case start, end;
	// All class from the package can access those 2 attributs
	Humanoides listHumanoides[]; 
	Item listAllItems[] = new Item[11];
	
	/*public Case[] neighbour(int x, int y) {
	Case neigh[] = null;
	Case n = new Case();
	Case e = new Case();
	Case s = new Case();
	Case o = new Case();
	  board[y+1][x]=n;
	  board[y][x+1]=e;
	  board[y-1][x]=s;
	  board[y][x-1]=o;
	  neigh[0] = n;
	  neigh[1] = e;
	  neigh[2] = s;
	  neigh[3] = o;
	  
	  return neigh;
	  } */
	
	// Constructors

	public Board() 
	{
		for (int j=0; j<7; j++) 
		{
			for (int i=0; i<5; i++) 
			{

				Case c = new Case(i,j);
				board [j][i] = c;
				System.out.print("-");
			}
			System.out.println(" ");
		}
		// Initialize a list of all Items
		listAllItems[0] = new Weapon(1, "Stylo", true, true, false, true, 2, 1, 4, 2);
		listAllItems[1] = new Weapon(2, "Clé", true, true, false, true, 0, 3, 5, 2);
		listAllItems[2] = new Weapon(3, "Guitare", true, false, false, false, 0, 3, 4, 2);
		listAllItems[3] = new Weapon(4, "Craies", false, false, false, true, 2, 3, 5, 1);
		listAllItems[4] = new Weapon(5, "Craies améliorées", false, false, false, true, 2, 4, 3, 1);
		listAllItems[5] = new Weapon(6, "Fil de souris", false, false, true, false, 1, 2, 4, 1);
		listAllItems[6] = new Weapon(7, "Liste des UV de culture générale", false, false, true, false, 0, 3, 3, 1);
		listAllItems[7] = new Weapon(8, "Dictionnaire français-anglais", false, false, false, false, 2, 1, 1, 3);
		listAllItems[8] = new Item(9, "Loupe");
		listAllItems[9] = new Item(10, "Dictionnaire partie 1");
		listAllItems[10] = new Item(11, "Dictionnaire partie 2");
	}
	
	// Getters and Setters
	
	public Case getEnd() {
		return this.end;
	}
	
	public Case getStart() {
		return this.start;
	}
	
	public Case[][] getBoard() {
		return board;
	}

	public void setBoard(Case[][] board) {
		this.board = board;
	}

	public void setStart(int x, int y) {
		Case re = new Case();
		for(int i=0; i<= 7|| i!=y; i++) {
			for(int j=0; j<=5 || j !=x; j++) {
				board[j][i] = re;
			}
		}
		this.start= re;
	}
	
	public void setEnd(int x, int y) {
		Case re = new Case();
		for(int i=0; i<= 8 || i!=y; i++) {
			for(int j=0; j<=4 || j !=x; j++) {
				board[j][i] = re;
			}
		}
		this.end= re;
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