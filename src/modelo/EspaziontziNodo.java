package modelo;

import java.util.ArrayList;

public abstract class EspaziontziNodo extends Entitate{
	protected MugimenduEstrategia mugimenduEstrategia;
	protected ArrayList<Entitate> gelaxkak = new ArrayList<>();

	public EspaziontziNodo(int x, int y, int id) {
		super(x,y,id,true);
		this.mugimenduEstrategia = new EspaziontziMugimenduEstrategia();
	}	
	public ArrayList<Entitate> getGelaxkak() {
		return this.gelaxkak;
	}
	public void mugitu(Mugimendua mugimendu) {
		this.mugimenduEstrategia.mugitu(this, mugimendu);
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
