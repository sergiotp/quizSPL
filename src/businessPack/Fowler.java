package businessPack;

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
	
	public int getFowler() {
		return this.fowlers;
	}
	
	public int setFowler(int fowlers) {
		return this.fowlers = fowlers;
	}
}
