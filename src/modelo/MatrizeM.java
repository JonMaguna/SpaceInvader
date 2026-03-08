package modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Observable;
import java.util.Random;
import modelo.EntitateMota;
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
					e.setBizirik(EntitateMota.ESPAZIONTZI, 1, false);
					mugitu = false;
					break;
				case ETSAIA:
					e.setBizirik(EntitateMota.ESPAZIONTZI, 1, false);
					mugitu = false;
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
                EtsaiakMugitu();
            }
        };

        timer.schedule(ataza, 0, 200);
    }
	
	private void EtsaiakMugitu() {
		EntitateKolekzio e = EntitateKolekzio.getnPertsonaiZerrenda();
	    int[][] hitbox = new int[1][2];
	    for(int i = 1;;i++){
	    	int nora = new Random().nextInt(3);
	    	hitbox = e.getHitBox(i, EntitateMota.ETSAIA);
	    	int[][] hitboxberria = new int[hitbox.length][2];
	    	etsaiaMugitu(hitbox,nora);
			gelaxkakAktualizatu(hitbox, 0, EntitateMota.HUTSA);
			gelaxkakAktualizatu(hitboxberria, i, EntitateMota.ETSAIA);
			e.setHitBox(hitboxberria, i, EntitateMota.ETSAIA);
	    }
	}	
	public void etsaiaMugitu(int[][] hitbox, int mugimendua) {
		int[][] hitboxberria = new int[hitbox.length][2];
		int i = 0;
		while (i < hitbox.length) {
		switch(mugimendua) {
		case 0: 
	        if (hitbox[i][1] == 59 || matrizea[hitbox[i][0]][hitbox[i][1] + 1].zerDago() == EntitateMota.ETSAIA) {
	        	hitboxberria[i][0] = hitbox[i][0] - 1;
				hitboxberria[i][1] = hitbox[i][1];
	        }
	        else {
	        	hitboxberria[i][0] = hitbox[i][0];
				hitboxberria[i][1] = hitbox[i][1] + 1;
	        }
	        i++;
	        break;
	    case 1: 
	        if (hitbox[i][0] == 0 || matrizea[hitbox[i][0] - 1][hitbox[i][1]].zerDago() == EntitateMota.ETSAIA) {
	        	hitboxberria[i][0] = hitbox[i][0];
				hitboxberria[i][1] = hitbox[i][1] + 1;
	        } else {
	        	hitboxberria[i][0] = hitbox[i][0] - 1;
				hitboxberria[i][1] = hitbox[i][1];
	        }
	        i++;
	        break;
	    case 2: 
	        if (hitbox[i][0] == 99 || matrizea[hitbox[i][0] + 1][hitbox[i][1]].zerDago() == EntitateMota.ETSAIA) {
	        	hitboxberria[i][0] = hitbox[i][0];
				hitboxberria[i][1] = hitbox[i][1] + 1;
	        } else {
	        	hitboxberria[i][0] = hitbox[i][0] + 1;
				hitboxberria[i][1] = hitbox[i][1];
	        }
	        i++;
	        break;
		}
	}
}
	public void AldatuGelaxka () {
	}
	public void balaMugitu() {
		// TODO Auto-generated method stub
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
