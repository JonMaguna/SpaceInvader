package modelo;

public class Espaziontzi extends Pertsonai {
	
	public Espaziontzi(int x, int y, boolean bizirik) {
		super(x, y, bizirik);
	}
	
	@Override
	public Integer[] lortuEgoera() {
		return new Integer[] {1,0,0,0};
	}

}
