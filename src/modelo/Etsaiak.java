package modelo;

public class Etsaiak extends Pertsonai {
	
	public Etsaiak(int x, int y, boolean bizirik) {
		super(x, y, bizirik);
	}
	
	@Override
	public Integer[] lortuEgoera() {
		return new Integer[] {0,1,0,0};
	}

}
