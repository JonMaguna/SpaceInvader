package modelo;
import java.util.Observable;

public class MatrizeM extends Observable{
	private static MatrizeM nMatrizeM= null;
	private GelaxkaM[][] matrizea;
	private Espaziontzia jokalaria;
	
	private MatrizeM() {}
	
	public static MatrizeM getnMatrizeM() {
		if(nMatrizeM== null) {
			nMatrizeM= new MatrizeM();
		}
		return nMatrizeM;
	}
	
	public void sortuMatrizea() {
		for (int i = 0; i<100; i++) {
			for (int j=0;j<60;j++) {
				matrizea[i][j] = new GelaxkaM(i,j);
			}
		}
	}
	
	public void sortuPertsonaia() {
		Espaziontzia e= new Espaziontzia(50,55);
	}
	
	public void mugituOntzia (String pNorabidea) {
		this.jokalaria.mugitu(pNorabidea);
	}
}
