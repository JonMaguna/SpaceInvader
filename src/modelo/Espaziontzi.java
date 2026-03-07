package modelo;

public class Espaziontzi extends Entitate {
	
	public Espaziontzi(int gelaxkak, int id,  boolean bizirik) {
		super(gelaxkak, id, bizirik);
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
