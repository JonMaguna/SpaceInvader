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
	private long azkenTiroa;
	
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

	public void tiroEgin(BalaMota mota) {
		if(!JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa() || denboraPasaBala()) {
			return;
		}
		EntitateKolekzio.getnPertsonaiZerrenda().tiroEgin(mota);
	}
	
	private boolean denboraPasaBala() {
		 boolean pasaDa = false;
		 long orain = System.currentTimeMillis();
		 
		 if (orain - this.azkenTiroa < 350) {
			 pasaDa = true;
		 }
		 else {
			 this.azkenTiroa = orain;
		 }
		 return pasaDa;
	}
	
	public void gelaxkakAktualizatu(List<Entitate> entitaLista, int id, EntitateMota entitate) {
		for (Entitate ent : entitaLista) {
			int [][] kordenatu = ent.getKoordenatu();
			int x = kordenatu[0][0];
			int y = kordenatu[0][1];
			this.matrizea[x][y].setEntitate(entitate, id);
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
