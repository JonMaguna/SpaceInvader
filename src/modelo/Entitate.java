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
	
	public void mugitu(Mugimendua mugimendu) {	}
	
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
	
	public void setKoordenatu(int[][] koordenatu) {
		this.koordenatu = koordenatu;
	}
	
	public void setBizirik(boolean bizirik) {
		this.bizirik = bizirik;
	}
	public void nextBala() { }
	public BalaNodo tiroEgin(int id) { return null; }
}
