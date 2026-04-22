package modelo;

import java.awt.event.ActionEvent;
import java.awt.Color;
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
	private Timer etsaienTimer;
	
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
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(espaziontzi.getGelaxkak(), espaziontzi.getId(), EntitateMota.ESPAZIONTZI);
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
		this.etsaienTimer = new Timer(400, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            etsaiakMugitu();
	        }
	    });
	    this.etsaienTimer.start();
	}

	private void etsaiakMugitu() {
	    if (this.mapa == null) {
	        if (this.etsaienTimer != null) {
	            this.etsaienTimer.stop();
	        }
	        return;
	    }
	    if (!JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
	        return;
	    }
	    ArrayList<Entitate> etsaiak = this.mapa.get(EntitateMota.ETSAIA);
	    if (etsaiak == null) {
	        return;
	    }
	    int tamaina = etsaiak.size();
	    for (int i = 0; i < tamaina; i++) {
	        if (this.mapa == null) return;

	        int nora = new Random().nextInt(3);
	        Entitate etsai = etsaiak.get(i);
	        
	        if (etsai != null) {
	            switch(nora) {
	                case 0: etsai.mugitu(Mugimendua.BEHERA); break;
	                case 1: etsai.mugitu(Mugimendua.EZKERRA); break;
	                case 2: etsai.mugitu(Mugimendua.ESKUMA); break;
	            }
	            
	            if (!etsai.bizirik()) {
	                etsaiak.remove(i);
	                i--;
	                tamaina--;
	                
	                if (etsaiak.isEmpty()) {
	                    JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(2);
	                }
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
	            e.setBizirik(b);
	            if(!e.bizirik() && JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
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
		if(bala != null) { return; }
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
	
	private int balaKopurua() {
		return this.mapa.get(EntitateMota.BALA).size();
	}

	public void nextBala() {
		this.mapa.get(EntitateMota.ESPAZIONTZI).get(0).nextBala();
	}
	
	public void resetZerrendak() {
		if(this.etsaienTimer != null) {
			this.etsaienTimer.stop();
			this.etsaienTimer = null;
		}
        if(this.mapa !=null) {
        	this.mapa.clear();
			this.mapa = null;
        }
		this.azkenMugimendua = 0;
		this.azkenTiroa = 0;
		nPertsonaiZerrenda = null;
	}
	public Color getOntziarenKolorea() {
	    ArrayList<Entitate> ontziak = this.mapa.get(EntitateMota.ESPAZIONTZI);
	    if (ontziak != null && !ontziak.isEmpty()) {
	        EspaziontziNodo ontzia = (EspaziontziNodo) ontziak.get(0);
	        return ontzia.getKolorea();
	    }
	    return null;
	}
}
