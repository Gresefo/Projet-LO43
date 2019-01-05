package engine;

public class Gechter extends Professor{
	
	public void effect (Board board)
	{
		if (stillHasEffect)
		{
			current_case.setNoise(100);
			stillHasEffect = false;
		}
	}
}