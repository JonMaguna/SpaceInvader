package modelo;
import GelaxkaM;

import java.util.ArrayList;
import java.util.Observable;
import.java.util.Random;
public class MatrizeM extends Observable{
	private MatrizeM nMatrizeM;
	private GelaxkaM[][] matrizea;
	
	private MatrizeM() {
	
	}
	public MatrizeM getnMatrizeM() {
		return nMatrizeM;
	}
	public void SortuMatrizea() {
		Random random = new Random();
		ArrayList<GelaxkaM> Etsaiak = new ArrayList<>();
		for (int i = 0; i<100; i++) {
			for (int j=0;j<60;j++) {
				matrizea[i][j] = new GelaxkaM();
				if (i%5 = 4 && j=5) {
					Etsaiak.add(matrizea[i][j]);
				}
				
			}
		}
		int EtsaienKantitatea = random.nextInt(5) + 4; 
        
        Collections.shuffle(Etsaiak);
        for (int k=0; k<EtsaienKantitatea;k++) {
        	Etsaiak.get[k].entitate = ETSAIA;
        }
		matrizea[55][50].entitate = ESPAZIONTZI;
	}	
	public void mugituOntzia (int Mugimendua) {
		
	}
}
