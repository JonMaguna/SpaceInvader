package modelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MatrizeM extends Observable{
	private static MatrizeM nMatrizeM;
	private GelaxkaM[][] matrizea;
	private List<Integer> etsaiID;
	
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
				setChanged();
				notifyObservers(matrizea[j][i]);		
			}
		}
	}
	
	public void mugituOntzia (Mugimendua mugimendua) {
		EntitateKolekzio e = EntitateKolekzio.getnPertsonaiZerrenda();
		int[][] hitBox = e.getHitBox(1, EntitateMota.ESPAZIONTZI);
		int[][] hitBoxBerria = new int[hitBox.length][2];
		boolean mugitu = true;
		int i = 0;
		EntitateMota entitatea = null;
		
		while (mugitu && i < hitBox.length) {
			switch (mugimendua) {
			case GORA:
				if(hitBox[i][1] == 0) {mugitu = false;} 
				else {
					entitatea = matrizea[hitBox[i][0]][hitBox[i][1] - 1].zerDago();
				}
				break;
			case BEHERA:
				if(hitBox[i][1] == 59) {mugitu = false;} 
				else {
					entitatea = matrizea[hitBox[i][0]][hitBox[i][1] + 1].zerDago();
				}
				break;
			case EZKERRA:
				if(hitBox[i][0] == 0) {mugitu = false;} 
				else {
					entitatea = matrizea[hitBox[i][0] - 1][hitBox[i][1]].zerDago();
				}
				break;
			case ESKUMA:
				if(hitBox[i][0] == 99) {mugitu = false;} 
				else {
					entitatea = matrizea[hitBox[i][0] + 1][hitBox[i][1]].zerDago();
				}
				break;
			default:
				break;
			}
			if(mugitu) { 
				switch (entitatea) {
				case BALA:
					gelaxkakAktualizatu(hitBox, 0, EntitateMota.HUTSA);
					e.setBizirik(EntitateMota.ESPAZIONTZI, 1, false);
					mugitu = false;
					break;
				case ETSAIA:
					gelaxkakAktualizatu(hitBox, 0, EntitateMota.HUTSA);
					e.setBizirik(EntitateMota.ESPAZIONTZI, 1, false);
					mugitu = false;
					 JokoKudeatzailea.getnJokoKudeatzailea().jokoaGaldu(); 
					 setChanged();
					 notifyObservers("GALDU");
					break;
				default:
					mugitu = true;					
					break;
				}
			}
			i++;
		}
		
		if (!mugitu) { return; }
		
		for (int j = 0; j < hitBox.length; j++) {
			switch (mugimendua) {
			case GORA:
				hitBoxBerria[j][0] = hitBox[j][0];
				hitBoxBerria[j][1] = hitBox[j][1] - 1;
				break;
			case BEHERA:
				hitBoxBerria[j][0] = hitBox[j][0];
				hitBoxBerria[j][1] = hitBox[j][1] + 1;
				break;
			case EZKERRA:
				hitBoxBerria[j][0] = hitBox[j][0] - 1;
				hitBoxBerria[j][1] = hitBox[j][1];
				break;
			case ESKUMA:
				hitBoxBerria[j][0] = hitBox[j][0] + 1;
				hitBoxBerria[j][1] = hitBox[j][1];
				break;
			default:
				break;
			}
		}
		gelaxkakAktualizatu(hitBox, 0, EntitateMota.HUTSA);
		gelaxkakAktualizatu(hitBoxBerria, 1, EntitateMota.ESPAZIONTZI);
		e.setHitBox(hitBoxBerria, 1, EntitateMota.ESPAZIONTZI);
	}
	
	
	public void EtsaienMugimendua() {
        Timer timer = new Timer();
        TimerTask ataza = new TimerTask() {
            public void run() {
                EtsaiakMugitu(etsaiID);
            }
        };

        timer.schedule(ataza, 0, 200);
    }
	
	private void EtsaiakMugitu(List<Integer> etsaiID) {
		if(!JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
			return;
		}
		List<Integer> mugituGabe = new ArrayList<Integer>();
	    for(int i = 0; i < etsaiID.size(); i++){
	    	Integer idEtsai = etsaiID.get(i);
	    	int[][] hitBox = EntitateKolekzio.getnPertsonaiZerrenda().getHitBox(idEtsai, EntitateMota.ETSAIA);
	    	boolean mugitu = true;
			EntitateMota entitatea = null;
			int mugimendua = new Random().nextInt(3);
			int j = 0;
			while (j  < hitBox.length && mugitu) {
				switch(mugimendua) {
				case 0: 
					if (hitBox[j][1] == 59) { mugitu = false; JokoKudeatzailea.getnJokoKudeatzailea().jokoaGaldu(); 
					setChanged();
					notifyObservers("GALDU");} 
					else {
						entitatea = matrizea[hitBox[j][0]][hitBox[j][1] + 1].zerDago();
					}
					break;
				case 1: 
					if (hitBox[j][0] == 0) { mugitu = false; }
					else {
						entitatea = matrizea[hitBox[j][0] - 1][hitBox[j][1]].zerDago();
					}
					break;
				case 2: 
					if (hitBox[j][0] == 99) { mugitu = false; }
					else {
						entitatea = matrizea[hitBox[j][0] + 1][hitBox[j][1]].zerDago();
					}
					break;
				}
				if (mugitu) {
					switch (entitatea) {
					case ESPAZIONTZI:
						EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ESPAZIONTZI, 1, false);
						mugitu = false;
						 JokoKudeatzailea.getnJokoKudeatzailea().jokoaGaldu(); 
						 setChanged();
						 notifyObservers("GALDU");
						break;
					case ETSAIA:
						mugitu = false;
						break;
					case BALA:
						EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ETSAIA, idEtsai, false);
						gelaxkakAktualizatu(EntitateKolekzio.getnPertsonaiZerrenda().getHitBox(idEtsai, EntitateMota.ETSAIA), 0, EntitateMota.HUTSA);
						etsaiID.remove(idEtsai);
						 if(etsaiID.isEmpty()) {
							 JokoKudeatzailea.getnJokoKudeatzailea().jokoaIrabazi();
							 setChanged();
							 notifyObservers("IRABAZI");
						 }
						mugitu = false;
						break;
					default:
						mugitu = true;
						break;
					}
				}
				j++;
			}
			if (!mugitu && EntitateKolekzio.getnPertsonaiZerrenda().getBizirik(EntitateMota.ETSAIA, idEtsai)) {
				mugituGabe.add(idEtsai);
				break;
			} else {
				int[][] hitboxberria = new int[hitBox.length][2];
				for (int k = 0; k < hitBox.length; k++) {
					switch(mugimendua) {
					case 0: 
						hitboxberria[k][0] = hitBox[k][0];
						hitboxberria[k][1] = hitBox[k][1] + 1;
						break;
					case 1: 
						hitboxberria[k][0] = hitBox[k][0] - 1;
						hitboxberria[k][1] = hitBox[k][1];
						break;
					case 2: 
						hitboxberria[k][0] = hitBox[k][0] + 1;
						hitboxberria[k][1] = hitBox[k][1];
						break;
					}
				}
				gelaxkakAktualizatu(hitBox, 0, EntitateMota.HUTSA);
				gelaxkakAktualizatu(hitboxberria, idEtsai, EntitateMota.ETSAIA);
				EntitateKolekzio.getnPertsonaiZerrenda().setHitBox(hitboxberria, idEtsai, EntitateMota.ETSAIA);
			}
	    }
	   /* if (!mugituGabe.isEmpty()) {
	    	EtsaiakMugitu(mugituGabe);
	    }*/
	    setChanged();
	    notifyObservers();
	}	
	

	public synchronized void mugituBalaBakarra(Bala pBala) {
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
					JokoKudeatzailea.getnJokoKudeatzailea().jokoaIrabazi();
					setChanged();
					notifyObservers("IRABAZI");
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
	
	}
	public void tiroEgin() {
		if(!JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
			return;
		}
		EntitateKolekzio e = EntitateKolekzio.getnPertsonaiZerrenda();
		int [][] hitBox = e.getHitBox(1, EntitateMota.ESPAZIONTZI);
		if(hitBox != null) {
			int x = hitBox[0][0];
			int y = hitBox[0][1] - 1;
			if (y >= 0) {
				int balaID = new Random().nextInt(1000);
				Bala bala = new Bala(1, balaID);
				int[][] hitBoxBala = new int[1][2];
				hitBoxBala[0][0] = x;
				hitBoxBala[0][1] = y;
				bala.setHitBox(hitBoxBala);
				e.getBalak().add(bala);
				gelaxkakAktualizatu(hitBoxBala, balaID, EntitateMota.BALA);
				setChanged();
				notifyObservers();
			}
		}
	}
	public void gelaxkakAktualizatu(int[][] hitBox, int id, EntitateMota entitate) {
		for (int i = 0; i < hitBox.length; i++) {
			matrizea[hitBox[i][0]][hitBox[i][1]].setEntitate(entitate, id);
		}
		
	}


	public void setEtsaiak(List<Integer> etsaiID) {
		this.etsaiID = etsaiID;
		
	}
	
}
