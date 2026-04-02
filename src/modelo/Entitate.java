package modelo;

public abstract class Entitate {
	protected int[][] koordenatu;
	protected boolean bizirik;
	protected int id;
	
	public Entitate(int x, int y, int id, boolean bizirik) {
		this.koordenatu = new int[][] {{x, y}};
		this.id = id;
		this.bizirik = true;
	}
	
	public void mugitu(Mugimendua mugimendu) {	}
	
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
}
