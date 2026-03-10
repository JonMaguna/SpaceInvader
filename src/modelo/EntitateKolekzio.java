package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class EntitateKolekzio {
	private static EntitateKolekzio nPertsonaiZerrenda;
	private HashMap<EntitateMota, ArrayList<Entitate>> mapa;
	private EntitateKolekzio() {
		this.mapa = new HashMap<EntitateMota, ArrayList<Entitate>>();
		this.mapa.put(EntitateMota.ESPAZIONTZI, new ArrayList<Entitate>());
		this.mapa.put(EntitateMota.ETSAIA, new ArrayList<Entitate>());
		this.mapa.put(EntitateMota.BALA, new ArrayList<Entitate>());
	}
	
	public static EntitateKolekzio getnPertsonaiZerrenda() {
		if(nPertsonaiZerrenda == null) {
			nPertsonaiZerrenda = new EntitateKolekzio();
		}
		return nPertsonaiZerrenda;
	}
	
	public void sortuEntitateak() {
		MatrizeM m = MatrizeM.getnMatrizeM();
		Espaziontzi espaziontzi = new Espaziontzi(1, 1, true);
		espaziontzi.setHitBox(new int[][] {{50, 55}});
		this.mapa.get(EntitateMota.ESPAZIONTZI).add(espaziontzi);
		m.gelaxkakAktualizatu(espaziontzi.getHitBox(), espaziontzi.getID(), EntitateMota.ESPAZIONTZI);
		int numEtsaiak = new Random().nextInt(5) + 4;
		List<Integer> posizio = new ArrayList<>();
		for (int i = 1; i < 19 + 1; i++) {
			posizio.add(i*5 - 1);
		}
		Collections.shuffle(posizio);
		List<Integer> etsaiID = new ArrayList<>();
		for (int i = 0; i < numEtsaiak; i++) {
			etsaiID.add(i+1);
			Etsaiak etsai = new Etsaiak(1, i+1, true);
			etsai.setHitBox(new int[][] {{posizio.get(i), 5}});
			m.gelaxkakAktualizatu(etsai.getHitBox(), etsai.getID(), EntitateMota.ETSAIA);
			this.mapa.get(EntitateMota.ETSAIA).add(etsai);
		}
		m.setEtsaiak(etsaiID);
	}

	public int[][] getHitBox(int i, EntitateMota entitate) {
		return this.mapa.get(entitate).get(i-1).getHitBox();	
	}

	public void setBizirik(EntitateMota entitate, int i, boolean b) {
		this.mapa.get(entitate).get(i-1).setBizirik(b);
		
	}

	public void setHitBox(int[][] hitBoxBerria, int i, EntitateMota entitate) {
		this.mapa.get(entitate).get(i-1).setHitBox(hitBoxBerria);
	}

	
	public void setBala(Entitate bala) {
		this.mapa.get(EntitateMota.BALA).add(bala);
	}
	
	public int balaKopurua() {
		return this.mapa.get(EntitateMota.BALA).size();
	}
	
	public boolean getBizirik(EntitateMota entitate, int i) {
		return this.mapa.get(entitate).get(i-1).bizirik();
	}
}
