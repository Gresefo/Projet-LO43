
public class Consumable extends Item{
	String effect;
	
	public Consumable(int id, String _name, String _effect) {
		super(id, _name);
		effect = _effect;
	}
}
