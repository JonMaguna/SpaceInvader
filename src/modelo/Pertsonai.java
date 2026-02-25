package modelo;

public abstract class Pertsonai {
	protected int x;
	protected int y;
	protected boolean bizirik;
	protected Mugimendua mugimendua;
	
	public Pertsonai(int x, int y, boolean bizirik) {
		this.x = x;
		this.y = y;
		this.bizirik = true;
	}
	
	private int getXposizioa() {
		return this.x;
	}
	private int getYposizioa() {
		return this.y;
	}
	
}
