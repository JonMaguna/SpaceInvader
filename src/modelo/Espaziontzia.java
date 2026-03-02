package modelo;

public class Espaziontzia extends Pertsonai{
	
	private int abiadura;
	public Espaziontzia(int x, int y, boolean bizirik) {
		super(x,y,bizirik);
		this.abiadura= 1;
	}
	
	public void mugitu(String pNorabidea) {
		if(pNorabidea.equals("GORA")) {y--;}
		else if(pNorabidea.equals("BEHERA")) {y++;}
		else if(pNorabidea.equals("ESKUINA")) {x++;}
		else if(pNorabidea.equals("EZKERRA")) {x--;}
	}
}
