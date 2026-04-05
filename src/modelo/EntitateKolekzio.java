package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import modelo.EspaziontziNodo;

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
	
	public void sortuEntitateak(int pMota) {
		EspaziontziNodo espaziontzi = EspaziontziFactory.getNireEspaziontziFactory().sortuEspaziontzia(pMota);
		this.mapa.get(EntitateMota.ESPAZIONTZI).add(espaziontzi);
		for(Espaziontzi pixel : espaziontzi.getGelaxkak()) {
			MatrizeM.getnMatrizeM().getGelaxka(pixel.getX(),pixel.getY()).setEntitate(EntitateMota.ESPAZIONTZI, espaziontzi.getId());
		}
		int numEtsaiak = new Random().nextInt(5) + 4;
		List<Integer> posizio = new ArrayList<>();
		for (int i = 1; i < 19 + 1; i++) {
			posizio.add(i*5 - 1);
		}
		Collections.shuffle(posizio);
		List<Integer> etsaiID = new ArrayList<>();
		for (int i = 0; i < numEtsaiak; i++) {
			int idBerria = i+1;
			etsaiID.add(idBerria);
			int x = posizio.get(i);
			int y = 5;
			EtsaiNodo etsai = EtsaiFactory.getEtsaiFactory().SortuEtsaiak(x, y, idBerria);
			this.mapa.get(EntitateMota.ETSAIA).add(etsai);
			 for(Etsaiak pixel : etsai.getGelaxkak()) {
				 MatrizeM.getnMatrizeM().getGelaxka(pixel.getX(),pixel.getY()).setEntitate(EntitateMota.ETSAIA, idBerria);
			 }
		}
		MatrizeM.getnMatrizeM().setEtsaiak(etsaiID);
	}
	
	public void mugituEntitatea(Mugimendua mugimendua, EntitateMota entitate, int i) {
		this.mapa.get(entitate).get(i-1).mugitu(mugimendua);
	}

	public void setBizirik(EntitateMota entitate, int i, boolean b) {
		this.mapa.get(entitate).get(i-1).setBizirik(b);
	}
	
	public void tiroEgin() {
		BalaNodo bala = this.mapa.get(EntitateMota.ESPAZIONTZI).get(0).tiroEgin(balaKopurua() + 1);
		this.mapa.get(EntitateMota.BALA).add(bala);
	}
	
	public int balaKopurua() {
		return this.mapa.get(EntitateMota.BALA).size();
	}
	
	public boolean getBizirik(EntitateMota entitate, int i) {
		return this.mapa.get(entitate).get(i-1).bizirik();
	}
	public HashMap<EntitateMota, ArrayList<Entitate>> getMapa() {
		return this.mapa;
	}

	public void nextBala() {
		this.mapa.get(EntitateMota.ESPAZIONTZI).get(0).nextBala();
	}
}
