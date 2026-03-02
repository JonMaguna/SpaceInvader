package modelo;

public class Espaziontzia extends Pertsonai{
	
	public Espaziontzia(int x, int y, boolean bizirik) {super(x,y,bizirik);}
	
	public void mugitu(String pNorabidea) {
		if(pNorabidea.equals("GORA")) {y--;}
		else if(pNorabidea.equals("BEHERA")) {y++;}
		else if(pNorabidea.equals("ESKUINA")) {x++;}
		else if(pNorabidea.equals("EZKERRA")) {x--;}
	}
}
