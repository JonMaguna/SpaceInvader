package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class PertsonaiZerrenda {
	private static PertsonaiZerrenda nPertsonaiZerrenda;
	public static final String Ontzia = "Ontzia";
	public static final String Etsaia = "Etsaia";
	public static final String Bala = "Bala";
	private HashMap<String, ArrayList<Pertsonai>> mapa;
	private PertsonaiZerrenda() {
		this.mapa = new HashMap<String, ArrayList<Pertsonai>>();
		this.mapa.put(Ontzia, new ArrayList<Pertsonai>());
		this.mapa.put(Etsaia, new ArrayList<Pertsonai>());
		this.mapa.put(Bala, new ArrayList<Pertsonai>());
	}
	public static PertsonaiZerrenda getnPertsonaiZerrenda() {
		if(nPertsonaiZerrenda == null) {
			nPertsonaiZerrenda = new PertsonaiZerrenda();
		}
		return nPertsonaiZerrenda;
	}
	public void gehituPertsonai(String pMota, Pertsonai pPertsonai) {
		this.mapa.get(pMota).add(pPertsonai);
	}
	public Espaziontzi getEspaziontzi() {
		ArrayList<Pertsonai> lista = this.mapa.get(Ontzia);
		if(!lista.isEmpty()) {
			return (Espaziontzi) lista.get(0);
		}
		return null;
	}
	public ArrayList<Pertsonai> getEtsaiak() {
		return this.mapa.get(Etsaia);
	}
	public ArrayList<Pertsonai> getBalak() {
		return this.mapa.get(Bala);
	}
	public void kenduPertsonai(String pMota, Pertsonai pPertsonai) {
		if(this.mapa.get(pMota).contains(pPertsonai)) {
			this.mapa.get(pMota).remove(pPertsonai);
		}
	}
	public void gehituPertsonai(String pMota, int pX, int pY) {
		Pertsonai p = null;
		switch(pMota) {
			case Ontzia:
				p = new Espaziontzi(pX, pY, true);
				break;
			case Etsaia:
				p = new Etsaiak(pX, pY, true);
				break;
			case Bala:
				//p = new Bala(pX, pY);
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
		for(Pertsonai p : this.mapa.get(Etsaia)) {
			Etsaiak e = (Etsaiak) p;
			e.mugitu(m);
		}
	}
	//Bala mugitu eta balak pantailatik kanpo badaude, kendu
	public void mugituBalak() {
		ArrayList<Pertsonai> balak = getBalak();
		for(int i=0; i<balak.size(); i++) {
			balak.get(i).mugitu(Mugimendua.GORA);
			if(balak.get(i).getYposizioa() < 0) {
				kenduPertsonai(Bala, balak.get(i));
				i--;
			}
		}
	}
}
