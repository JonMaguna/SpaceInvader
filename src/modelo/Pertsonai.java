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
	public void mugituGora() {
		if(y > 0) {
			y--;
		}
	}
	public void mugituBehera() {
		if(y < 59) {
			y++;
		}
	}
	public void mugituEzkerrera() {
		if(x > 0) {
			x--;
		}
	}
	public void mugituEskumara() {
		if(x < 99) {
			x++;
		}
	}
	public abstract Integer[] lortuEgoera();
	
	
}
