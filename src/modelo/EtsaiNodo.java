package modelo;

import java.util.ArrayList;
import java.util.List;

public class EtsaiNodo extends Entitate{
	private List<Etsaiak> gelaxkak = new ArrayList<>();

	public EtsaiNodo(int x, int y, int[][] koordenatuak, int id) {
		super(x, y, id, true);
		for (int i = 0; i < koordenatuak.length; i++) {
		    int pX = x + koordenatuak[i][0];
		    int pY = y + koordenatuak[i][1];
		    this.gelaxkak.add(new Etsaiak(pX, pY, id));
		}
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, id, EntitateMota.ETSAIA);
	}
	
	public void mugitu(Mugimendua mugimendu) {
		boolean mugituDaiteke = true;
		int i = 0;
		while(i < this.gelaxkak.size() && mugituDaiteke){
			mugituDaiteke = this.gelaxkak.get(i).mugituDaiteke(mugimendu);
			if(!this.gelaxkak.get(i).bizirik()) {
				this.bizirik = false;
			}
			i++;
		}
		if(mugituDaiteke) {
			for (Etsaiak pixel : this.gelaxkak) {
				pixel.mugitu(mugimendu);
			}
		}
	}
	public List<Etsaiak> getGelaxkak() {
		return this.gelaxkak;
	}
}
