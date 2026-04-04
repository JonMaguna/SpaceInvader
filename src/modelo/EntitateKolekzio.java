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
		Espaziontzi espaziontzi = new Espaziontzi(1, 1, true);
		espaziontzi.setHitBox(new int[][] {{50, 55}});
		this.mapa.get(EntitateMota.ESPAZIONTZI).add(espaziontzi);
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(espaziontzi.getHitBox(), espaziontzi.getId(), EntitateMota.ESPAZIONTZI);
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
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(etsai.getHitBox(), etsai.getId(), EntitateMota.ETSAIA);
			this.mapa.get(EntitateMota.ETSAIA).add(etsai);
		}
		MatrizeM.getnMatrizeM().setEtsaiak(etsaiID);
	}
	
	public void mugituEntitatea(Mugimendua mugimendua, EntitateMota entitate, int i) {
		this.mapa.get(entitate).get(i-1).mugitu(mugimendua);
	}

	public void setBizirik(EntitateMota entitate, int i, boolean b) {
		this.mapa.get(entitate).get(i-1).setBizirik(b);
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
