package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class PertsonaiZerrenda {
	private static PertsonaiZerrenda nPertsonaiZerrenda;
	private HashMap<EntitateMota, ArrayList<Pertsonai>> mapa;
	private PertsonaiZerrenda() {
		this.mapa = new HashMap<EntitateMota, ArrayList<Pertsonai>>();
		this.mapa.put(EntitateMota.ESPAZIONTZI, new ArrayList<Pertsonai>());
		this.mapa.put(EntitateMota.ETSAIA, new ArrayList<Pertsonai>());
		this.mapa.put(EntitateMota.BALA, new ArrayList<Pertsonai>());
	}
	public static PertsonaiZerrenda getnPertsonaiZerrenda() {
		if(nPertsonaiZerrenda == null) {
			nPertsonaiZerrenda = new PertsonaiZerrenda();
		}
		return nPertsonaiZerrenda;
	}
	public void gehituPertsonai(EntitateMota pMota, Pertsonai pPertsonai) {
		if(this.mapa.containsKey(pMota)) {	
			this.mapa.get(pMota).add(pPertsonai);
		}
	}
	public Espaziontzi getEspaziontzi() {
		ArrayList<Pertsonai> lista = this.mapa.get(EntitateMota.ESPAZIONTZI);
		if(!lista.isEmpty() && lista!=null) {
			return (Espaziontzi) lista.get(0);
		}
		return null;
	}
	public ArrayList<Pertsonai> getEtsaiak() {
		return this.mapa.get(EntitateMota.ETSAIA);
	}
	public ArrayList<Pertsonai> getBalak() {
		return this.mapa.get(EntitateMota.BALA);
	}
	public void kenduPertsonai(EntitateMota pMota, Pertsonai pPertsonai) {
		if(this.mapa.get(pMota).contains(pPertsonai)) {
			this.mapa.get(pMota).remove(pPertsonai);
		}
	}
	public void gehituPertsonai(EntitateMota pMota, int pX, int pY) {
		Pertsonai p = null;
		switch(pMota) {
			case ESPAZIONTZI:
				p = new Espaziontzi(pX, pY, true);
				break;
			case ETSAIA:
				p = new Etsaiak(pX, pY, true);
				break;
			case BALA:
				p = new Bala(pX, pY);
				break;
		}
		this.mapa.get(pMota).add(p);
	}
	public void mugituEspaziontzia(Mugimendua m) {
		Espaziontzi o = getEspaziontzi();
		if(o != null) {
			o.mugitu(m);
		}
	}
	public void mugituEtsaiak(Mugimendua m) {
		ArrayList<Pertsonai> Etsaia = this.mapa.get(EntitateMota.ETSAIA);
		for(Pertsonai p : Etsaia) {
			p.mugitu(m);
		}
	}
	//Bala mugitu eta balak pantailatik kanpo badaude kendu
	public void mugituBalak() {
		ArrayList<Pertsonai> balak = getBalak();
		for(int i=0; i<balak.size(); i++) {
			Pertsonai bala = balak.get(i);
			bala.mugitu(Mugimendua.GORA);
			if(bala.getYposizioa() < 0) {
				kenduPertsonai(EntitateMota.ETSAIA, bala);
				i--;
			}
		}
	}
}
