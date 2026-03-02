package modelo;
import GelaxkaM;
import java.util.Observable;

public class MatrizeM extends Observable{
	private MatrizeM nMatrizeM;
	private GelaxkaM[][] matrizea;
	
	private MatrizeM() {
	
	}
	public MatrizeM getnMatrizeM() {
		return nMatrizeM;
	}
	public void SortuMatrizea() {
		for (int i = 0; i<100; i++) {
			for (int j=0;j<60;j++) {
				matrizea[i][j] = new GelaxkaM();
			}
		}
	}
	public void mugituOntzia (int Mugimendua) {
		
	}
}
