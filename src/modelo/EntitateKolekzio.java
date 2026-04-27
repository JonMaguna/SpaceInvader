package modelo;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
	private Timer etsaienTiroTimer;
	
	private EntitateKolekzio() {
		this.mapa = new HashMap<EntitateMota, ArrayList<Entitate>>();
		this.mapa.put(EntitateMota.ESPAZIONTZI, new ArrayList<Entitate>());
		this.mapa.put(EntitateMota.ETSAIA, new ArrayList<Entitate>());
		this.mapa.put(EntitateMota.BALA, new ArrayList<Entitate>());
		this.mapa.put(EntitateMota.BALA_ETSAIA, new ArrayList<>());
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
		int numEtsaiak = new Random().nextInt(10) + 8;
		List<Integer> posizio = new ArrayList<>();
		for (int i = 1; i < MatrizeM.getnMatrizeM().getX()/5; i++) {
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
		this.etsaienTiroTimer = new Timer(1500, e -> etsaiakTiroEgin());
        this.etsaienTiroTimer.start();
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
		if (this.mapa == null || !JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
	        if (this.etsaienTimer != null) this.etsaienTimer.stop();
	        return;
	    }
	    ArrayList<Entitate> etsaiak = this.mapa.get(EntitateMota.ETSAIA);
	    if (etsaiak == null) {
	        return;
	    }
	    etsaiak.forEach(etsai -> {
	        int nora = new Random().nextInt(3);
	        switch(nora) {
	            case 0: etsai.mugitu(Mugimendua.BEHERA); break;
	            case 1: etsai.mugitu(Mugimendua.EZKERRA); break;
	            case 2: etsai.mugitu(Mugimendua.ESKUMA); break;
	        }
	    });
	    etsaiak.removeIf(etsai -> !etsai.bizirik());
	    if (etsaiak.isEmpty()) { JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(2);}
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
	    if (entitateak == null) return;
	    entitateak.stream()
	              .filter(e -> e.getId() == i) 
	              .findFirst()                  
	              .ifPresent(e -> {             	                  
	                  e.setBizirik(b); 
	                  if (!e.bizirik() && JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
	                      entitateak.remove(e);
	                      if (entitate == EntitateMota.ETSAIA && entitateak.isEmpty()) { 
	                          JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(2);
	                      }
	                  }
	              });
	}
	
	public void tiroEgin() {
		if(!JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa() || denboraPasaBala()) {
			return;
		}
		BalaNodo bala = this.mapa.get(EntitateMota.ESPAZIONTZI).get(0).tiroEgin(balaKopurua() + 1);
		if(bala == null) { 
			return; }
		if (bala != null) {
	        this.mapa.get(EntitateMota.BALA).add(bala);
	    }
	}
	
	private boolean denboraPasaBala() {	
		 boolean pasaDa = false;
		 long orain = System.currentTimeMillis();
		 
		 if (orain - this.azkenTiroa < 375) {
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
		if(this.etsaienTiroTimer != null) {
			this.etsaienTiroTimer.stop();
			this.etsaienTiroTimer = null;
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

	public void tiroKohete() {
		if(!JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa() || denboraPasaBala()) {
			return;
		}
		(this.mapa.get(EntitateMota.ESPAZIONTZI).get(0)).tiroKohete(balaKopurua() + 1);	
	}

	public Entitate etsaiHurbilena(int x, int y) { 
		return this.mapa.get(EntitateMota.ETSAIA).stream()
				.min(Comparator.comparingDouble(e -> 
				Math.sqrt(Math.pow(e.getX() - x, 2) + Math.pow(e.getY() - y, 2))))
				.orElse(null);	
	}
	private void etsaiakTiroEgin() {
        try {
            if (this.mapa == null || !JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
                return;
            }
            ArrayList<Entitate> etsaiak = this.mapa.get(EntitateMota.ETSAIA);
            if (etsaiak == null || etsaiak.isEmpty()) return;
            ArrayList<Entitate> EtsaiB = new ArrayList<>();
            for (Entitate e : etsaiak) {
                if (e instanceof EtsaiakB) {
                    EtsaiB.add(e);
                }
            }            
            if (EtsaiB.isEmpty()) return;
            int random = new java.util.Random().nextInt(EtsaiB.size());
            Entitate tiratzailea = EtsaiB.get(random);
            int idBalaEtsaia = (int)(Math.random() * 100000) + 1000;
            BalaNodo bala = BalaFactory.getnBalaFactory().sortuBala(
                tiratzailea.getX(), 
                tiratzailea.getY() + 3, 
                idBalaEtsaia, 
                BalaMota.BALA_ETSAIA
            );
            if (bala != null) {
                this.mapa.get(EntitateMota.BALA_ETSAIA).add(bala); 
            }
        } catch (Exception e) {
            System.out.println("¡ERROR FATAL AL DISPARAR!");
            e.printStackTrace(); 
        }
    }
}

