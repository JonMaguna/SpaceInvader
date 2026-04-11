package modelo;

import java.util.ArrayList;

public class BalaNodo extends Entitate implements Runnable{
	protected MugimenduEstrategia mugimenduEstrategia;
	private Thread ThreadBala;
	private ArrayList<Entitate> gelaxkak = new ArrayList<>();

	public BalaNodo(int x, int y, int[][] koordenatuak, int id) {
		super(x, y, id, true);
		this.mugimenduEstrategia = new BalaMugimenduEstrategia();
		for (int i = 0; i < koordenatuak.length; i++) {
			this.gelaxkak.add(new Bala(koordenatuak[i][0], koordenatuak[i][1], id));
		}
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, this.id, EntitateMota.BALA);
		this.ThreadBala = new Thread(this);
		this.ThreadBala.start();
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
	public void setEstrategy(MugimenduEstrategia estrategia) {
		this.mugimenduEstrategia = estrategia;
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
