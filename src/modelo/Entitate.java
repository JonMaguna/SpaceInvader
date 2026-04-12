package modelo;

public abstract class Entitate {
	protected int[][] koordenatu;
	protected boolean bizirik;
	protected int id;
	protected int x;
	protected int y;
	
	
	public Entitate(int x, int y, int id, boolean bizirik) {
		this.koordenatu = new int[][] {{x, y}};
		this.id = id;
		this.bizirik = true;
		this.x = x;
		this.y = y;
	}
	
	protected void mugitu(Mugimendua mugimendu) {	}
	
	public boolean mugituDaiteke(Mugimendua mugimendu) {
		return true;
	}
	
	public int[][] getKoordenatu() {
		return this.koordenatu;
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean bizirik() {
		return this.bizirik;
	}
	
	public void setBizirik(boolean bizirik) {
		this.bizirik = bizirik;
	}
	
	public void nextBala() { }
	public BalaNodo tiroEgin(int id) { return null; }
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
