package engine;

public class Zullo extends Professor{

	// Instant kill a student BDS or TC for free. It always succeed
	public void effect(Board board) 
	{
		if (stillHasEffect)
		{
			int i = 0;
			int size = board.getListStudent().size();
			while(i < size && (board.getListStudent().get(i).getHealth() != 1 && board.getListStudent().get(i).getCurrent_case() != this.current_case)) 
			{
				i++;
			}
			if(i < size)
			{
				board.getListStudent().remove(i);
				stillHasEffect = false;
			}
		}
	};
}