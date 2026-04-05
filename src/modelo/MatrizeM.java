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
	public void hasieratuOntzia(int pMota) {
		Espaziontzi nireEspaziontzi = EspaziontziFactory.getNireEspaziontziFactory().sortuEspaziontzia(pMota);
		int xHasiera = 50;
		int yHasiera = 55;
		matrizea[xHasiera][yHasiera].setEntitate(EntitateMota.ESPAZIONTZI, 1);
		int[][] hasierakoHitbox = {{xHasiera, yHasiera}};
		EntitateKolekzio.getnPertsonaiZerrenda().setHitBox(hasierakoHitbox, 1, EntitateMota.ESPAZIONTZI);
		
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

	/*public synchronized void mugituBalaBakarra(Bala pBala) {
		if(!JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
			pBala.setActive(false);
			return;
		}
		int [][] hitBoxZaharra = pBala.getHitBox();
		int x = hitBoxZaharra[0][0];
		int y = hitBoxZaharra[0][1];
		gelaxkakAktualizatu(hitBoxZaharra, 0, EntitateMota.HUTSA);
		int yBerria = y - 1; 
		if (yBerria >= 0) {
			EntitateMota zerDago = matrizea[x][yBerria].zerDago();
			if (zerDago == EntitateMota.ETSAIA) {
				Integer idEtsai = matrizea[x][yBerria].zeinDago();
				EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ETSAIA, idEtsai, false);
				gelaxkakAktualizatu(EntitateKolekzio.getnPertsonaiZerrenda().getHitBox(idEtsai, EntitateMota.ETSAIA), 0, EntitateMota.HUTSA);
				pBala.setActive(false);
				etsaiID.remove(idEtsai);
				if(etsaiID.isEmpty()) {
					JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(2);
				}
			}else {
				int[][] hitBoxBerria = new int[1][2];
				hitBoxBerria[0][0] = x;
				hitBoxBerria[0][1] = yBerria;
				gelaxkakAktualizatu(hitBoxBerria, pBala.getId(), EntitateMota.BALA);
				pBala.setHitBox(hitBoxBerria);
			}
		}else {
			pBala.setActive(false);
		}
	
	}*/
	public void tiroEgin() {
		if(!JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa() || denboraPasaBala()) {
			return;
		}
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
	
	public void gelaxkakAktualizatu(int[][] koordenatu, int id, EntitateMota entitate) {
		matrizea[koordenatu[0][0]][koordenatu[0][1]].setEntitate(entitate, id);
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
