package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class EtsaiNodo extends Entitate{
	protected List<Etsaiak> gelaxkak = new ArrayList<>();
	private Etsaiak nagusi;

	public EtsaiNodo(int x, int y, int[][] koordenatuak, int id) {
		super(x, y, id, true);
		for (int i = 0; i < koordenatuak.length; i++) {
		    int pX = x + koordenatuak[i][0];
		    int pY = y + koordenatuak[i][1];
		    this.gelaxkak.add(new Etsaiak(pX, pY, id));
		    if (koordenatuak[i][0] == 0 && koordenatuak[i][1] == 0) {
		        this.nagusi = this.gelaxkak.get(i);
		    }
		}
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
