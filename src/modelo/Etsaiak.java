package modelo;

public class Etsaiak extends Entitate {
	
	public Etsaiak(int gelaxka, int id, boolean bizirik) {
		super(gelaxka, id, bizirik);
	}
	
	public int[][] getHitBox() {
		return this.hitBox;
	}
	
	public boolean bizirik() {
		return this.bizirik;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setHitBox(int[][] hitBox) {
		this.hitBox = hitBox;
	}
	
	public void setBizirik(boolean bizirik) {
		this.bizirik = bizirik;
	}
}
