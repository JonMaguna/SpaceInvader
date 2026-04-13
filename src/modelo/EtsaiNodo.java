package modelo;

import java.util.ArrayList;

public abstract class EtsaiNodo extends Entitate{
	protected MugimenduEstrategia mugimenduEstrategia;
	protected ArrayList<Entitate> gelaxkak = new ArrayList<>();

	public EtsaiNodo(int x, int y, int[][] koordenatuak, int id) {
		super(x, y, id, true);
		this.mugimenduEstrategia = new EtsaiaMugimenduEstrategia();	
		for (int i = 0; i < koordenatuak.length; i++) {
		    int pX = x + koordenatuak[i][0];
		    int pY = y + koordenatuak[i][1];
		    this.gelaxkak.add(new Etsaiak(pX, pY, id));
		}
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, id, EntitateMota.ETSAIA);
	}
	
	public void mugitu(Mugimendua mugimendu) {
		this.mugimenduEstrategia.mugitu(this, mugimendu);
	}
	
	public ArrayList<Entitate> getGelaxkak() {
		return this.gelaxkak;
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
