package modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

public class MatrizeM{
	private static MatrizeM nMatrizeM;
	private GelaxkaM[][] matrizea;
	private List<Integer> etsaiID;
	private long azkenMugimendua;
	
	private MatrizeM() {
		this.matrizea = new GelaxkaM[100][60];
	}
	
	public static MatrizeM getnMatrizeM() {
		if (nMatrizeM == null) {
			nMatrizeM = new MatrizeM();
		}
		return nMatrizeM;
	}
	
	public void SortuMatrizea() {
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < 100; j++) {
				matrizea[j][i] = new GelaxkaM(j,i);	
			}
		}
	}
	
	public GelaxkaM getGelaxka(int x, int y) {
        return this.matrizea[x][y];
    }
	
	public void mugituOntzia (Mugimendua mugimendua) {
		if(!JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa() || denboraPasaMugitu()) {
			return;
		}
		EntitateKolekzio.getnPertsonaiZerrenda().mugituEntitatea(mugimendua, EntitateMota.ESPAZIONTZI, 1);
	}
		
	
	private boolean denboraPasaMugitu() {
		 boolean pasaDa = false;
		 long orain = System.currentTimeMillis();
		 
		 if (orain - this.azkenMugimendua < 125) {
			 pasaDa = true;
		 }
		 else {
			 this.azkenMugimendua = orain;
		 }
		 return pasaDa;
	}
	
	
	public void EtsaienMugimendua() {
		Timer timer = new Timer(200, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            EtsaiakMugitu(etsaiID);
	        }
	    });
	    timer.start();
	}
	
	private void EtsaiakMugitu(List<Integer> etsaiID) {
		if(!JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
			return;
		}
		for(int i = 0; i < etsaiID.size(); i++) {
			int nora = new Random().nextInt(3);
			switch(nora) {
			case 0: 
				EntitateKolekzio.getnPertsonaiZerrenda().mugituEntitatea(Mugimendua.BEHERA, EntitateMota.ETSAIA, etsaiID.get(i));
				break;
			case 1:
				EntitateKolekzio.getnPertsonaiZerrenda().mugituEntitatea(Mugimendua.EZKERRA, EntitateMota.ETSAIA, etsaiID.get(i));
				break;
			case 2:
				EntitateKolekzio.getnPertsonaiZerrenda().mugituEntitatea(Mugimendua.ESKUMA, EntitateMota.ETSAIA, etsaiID.get(i));
				break;
			}
			if(!EntitateKolekzio.getnPertsonaiZerrenda().getBizirik(EntitateMota.ETSAIA, etsaiID.get(i))) {
				this.etsaiID.remove(etsaiID.get(i));
				 if(etsaiID.isEmpty()) {
					 JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(2);
				 }
			}
		}
	}
	
	public void gelaxkakAktualizatu(int[][] koordenatu, int id, EntitateMota entitate) {
		for(int i = 0; i < koordenatu.length; i++) {
			matrizea[koordenatu[i][0]][koordenatu[i][1]].setEntitate(entitate, id);
		}
	}


	public void setEtsaiak(List<Integer> etsaiID) {
		this.etsaiID = etsaiID;	
	}

	public EntitateMota zerDago(int[][] koordenatu) {
		return matrizea[koordenatu[0][0]][koordenatu[0][1]].zerDago();
	}

	public int zeinIDDago(int[][] koordenatu) {
		return matrizea[koordenatu[0][0]][koordenatu[0][1]].getID();
	}
}
