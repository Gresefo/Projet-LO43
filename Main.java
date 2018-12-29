import java.util.ArrayList;

public class Main 
{
	public static void main(String[]argv)
	{

		
		// Creation of the Board
		Board board = new Board();
		ArrayList<Case> Path=board.pathFinder(board.board[0][1],board.board[1][4]);
		
		if(Path==null)
		{
			System.out.println("path vide");
		}
		else
		{
			for(int i=0;i<Path.size();i++)
			{
				System.out.println(Path.get(i).getY()+" "+Path.get(i).getX());
			}
		}

		// Initialization of the profs
		
		

		System.out.println(board.listAllItems[0].getName() + "    " + board.listAllItems[1].getName());

		
		System.out.println(board.listAllItems[0].getName() + "    " + board. listAllItems[1].getName());

		
		
	}
}