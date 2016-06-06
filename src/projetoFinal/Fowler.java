package projetoFinal;

public class Fowler {
	private int fowlers;
	private static Fowler instance = new Fowler();
	
	private Fowler(){}
	
	public int decrementFowler() {
		return this.fowlers -= fowlers;
	}
	
	public static Fowler getInstance(){
		return instance;
	}
	
	protected int getFowler() {
		return this.fowlers;
	}
	
	protected int setFowler(int fowlers) {
		return this.fowlers = fowlers;
	}
}
