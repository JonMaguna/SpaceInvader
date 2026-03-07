package modelo;

public abstract class Entitate {
	protected int[][] hitBox;
	protected boolean bizirik;
	protected int id;
	
	public Entitate(int gelaxkak, int id, boolean bizirik) {
		this.hitBox = new int[gelaxkak][2];
		this.id = id;
		this.bizirik = true;
	}
	
	public int[][] getHitBox() {
		return this.hitBox;
	}
	
	public int getId() {
		return this.id;
	}
	
	public boolean bizirik() {
		return this.bizirik;
	}
	
	public void setHitBox(int[][] hitBox) {
		this.hitBox = hitBox;
	}
	
	public void setBizirik(boolean bizirik) {
		this.bizirik = bizirik;
	}
}
