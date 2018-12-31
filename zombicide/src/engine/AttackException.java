package engine;

public class AttackException extends Exception{
	private static final long serialVersionUID = -838545690208533091L;
	
	public AttackException(){
		super();
	}
	public AttackException(String s){
		super();
		System.out.println(s);
	}
}