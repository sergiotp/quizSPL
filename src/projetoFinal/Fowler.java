package projetoFinal;

public class Fowler {
	static int fowlers;
	
	public int decrementaFowler() {
		return this.fowlers -= fowlers;
	}
	
	protected int getFowler() {
		return this.fowlers;
	}
	
	protected int setFowler(int fowlers) {
		return this.fowlers = fowlers;
	}
}
