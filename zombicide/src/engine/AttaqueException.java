package engine;

public class AttaqueException extends Exception{
	private static final long serialVersionUID = -838545690208533091L;
	
	public AttaqueException(){
		super();
	}
	public AttaqueException(String s){
		super();
		System.out.println(s);
	}
}