package modelo;

import java.util.ArrayList;

public class BalaNodo extends Entitate implements Runnable{
	protected MugimenduEstrategia mugimenduEstrategia;
	private Thread ThreadBala;
	private ArrayList<Entitate> gelaxkak = new ArrayList<>();

	public BalaNodo(int x, int y, int[][] koordenatuak, int id) {
		super(x, y, id, true);
		this.mugimenduEstrategia = new BalaMugimenduEstrategia();
		boolean EtsaiaDago = false;
	    for (int i = 0; i < koordenatuak.length; i++) {
	        int posX = koordenatuak[i][0];
	        int posY = koordenatuak[i][1];
	        int[][] posHurrengoa = {{posX, posY}};
	        EntitateMota entitatea = MatrizeM.getnMatrizeM().zerDago(posHurrengoa);
	        int besteId = MatrizeM.getnMatrizeM().zeinIDDago(posHurrengoa);
	        if (entitatea == EntitateMota.ETSAIA) {
	            EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ETSAIA, besteId, false);
	            EtsaiaDago = true;
	        }
	        this.gelaxkak.add(new Bala(posX, posY, id));
	    }
	    if (EtsaiaDago) {
	        this.bizirik = false; 
	    } else {
	        MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, this.id, EntitateMota.BALA);
	        this.ThreadBala = new Thread(this);
	        this.ThreadBala.start();
	    }
	}

	public void run() {
		while (bizirik && JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) { 
            try {
            	Thread.sleep(50);
                this.mugimenduEstrategia.mugitu(this, Mugimendua.GORA);
            } catch (InterruptedException e) {
                this.bizirik = false;
            }
		}
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);
    }
	public ArrayList<Entitate> getGelaxkak() {
		return gelaxkak;
	}
	
	public void setBizirik(boolean bizirik) {
		this.bizirik = bizirik;
		for (Entitate pixel : gelaxkak) {
			pixel.setBizirik(bizirik);
		}
		if(!bizirik) {
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);
		}
	}
}
