package modelo;

import java.util.ArrayList;

public abstract class EspaziontziNodo extends Entitate{
	protected ArrayList<Entitate> gelaxkak = new ArrayList<>();

	public EspaziontziNodo(int x, int y, int id) {
		super(x,y,id,true);
	}	
	public ArrayList<Entitate> getGelaxkak() {
		return this.gelaxkak;
	}
	
	public void mugitu(Mugimendua mugimendu) {
		boolean mugituDaiteke = true;
		int i = 0;
		while(i < this.gelaxkak.size() && mugituDaiteke){
			mugituDaiteke = this.gelaxkak.get(i).mugituDaiteke(mugimendu);
			i++;
		}
		if(mugituDaiteke) {
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);
			for (Entitate pixel : this.gelaxkak) {
				pixel.mugitu(mugimendu);
			}
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, id, EntitateMota.ESPAZIONTZI);
			eguneratuPosizioNagusia(mugimendu);
		}
	}
	protected void eguneratuPosizioNagusia(Mugimendua m) {
		switch(m) {
            case EZKERRA: this.x--; break;
            case ESKUMA:  this.x++; break;
            case GORA:    this.y--; break;
            case BEHERA:  this.y++; break;
        }
    }
}
