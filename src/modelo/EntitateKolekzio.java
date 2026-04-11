package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.swing.Timer;

public class EntitateKolekzio {
	private static EntitateKolekzio nPertsonaiZerrenda;
	private HashMap<EntitateMota, ArrayList<Entitate>> mapa;
	private long azkenMugimendua;
	private long azkenTiroa;
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
			int mota = new Random().nextInt(3) + 1;
			EtsaiNodo etsai = EtsaiFactory.getEtsaiFactory().SortuEtsaiak(idBerria,x,y,mota);
			this.mapa.get(EntitateMota.ETSAIA).add(etsai);
		}
		etsaienMugimendua();
	}
	
	private void etsaienMugimendua() {
		Timer timer = new Timer(400, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            etsaiakMugitu();
	        }
	    });
	    timer.start();
	}

	private void etsaiakMugitu() {
		if(!JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
			return;
		}
		for(int i = 0; i < this.mapa.get(EntitateMota.ETSAIA).size(); i++) {
			int nora = new Random().nextInt(3);
			Entitate etsai = this.mapa.get(EntitateMota.ETSAIA).get(i);
			switch(nora) {
			case 0: 
				etsai.mugitu(Mugimendua.BEHERA);
				break;
			case 1:
				etsai.mugitu(Mugimendua.EZKERRA);
				break;
			case 2:
				etsai.mugitu(Mugimendua.ESKUMA);
				break;
			}
			if(!etsai.bizirik()) {
				    this.mapa.get(EntitateMota.ETSAIA).remove(etsai);
				    i--;
				    if(this.mapa.get(EntitateMota.ETSAIA).size() == 0) {
				        JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(2);
				    }
				}
			}
	}
	
	public void mugituOntzia (Mugimendua mugimendua) {
		if(!JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa() || denboraPasaMugitu()) {
			return;
		}
		this.mapa.get(EntitateMota.ESPAZIONTZI).get(0).mugitu(mugimendua);
	}

	private boolean denboraPasaMugitu() {
		 boolean pasaDa = false;
		 long orain = System.currentTimeMillis();
		 
		 if (orain - this.azkenMugimendua < 130) {
			 pasaDa = true;
		 }
		 else {
			 this.azkenMugimendua = orain;
		 }
		 return pasaDa;
	}

	public void setBizirik(EntitateMota entitate, int i, boolean b) {
		ArrayList<Entitate> entitateak = this.mapa.get(entitate);
	    for (Entitate e : entitateak) {
	        if (e.getId() == i) {
	            e.setBizirik(b);
	            if(b == false) {
	            	this.mapa.get(entitate).remove(e);
	            	if(this.mapa.get(EntitateMota.ETSAIA).size() == 0) {
				        JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(2);
	            	}
	            }
	            break;
	        }
	    }
	}
	
	public void tiroEgin() {
		if(!JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa() || denboraPasaBala()) {
			return;
		}
		BalaNodo bala = this.mapa.get(EntitateMota.ESPAZIONTZI).get(0).tiroEgin(balaKopurua() + 1);
		this.mapa.get(EntitateMota.BALA).add(bala);
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
