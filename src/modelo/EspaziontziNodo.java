package modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class EspaziontziNodo extends Entitate{
	protected List<Espaziontzi> gelaxkak = new ArrayList<>();

	public EspaziontziNodo(int x, int y, int id) {
		super(x,y,id,true);
	}	
	public List<Espaziontzi> getGelaxkak() {
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
			for (Espaziontzi pixel : this.gelaxkak) {
				pixel.mugitu(mugimendu);
			}
		}
	}
	protected void eguneratuPosizioNagusia(Mugimendua m) { 
		///no se le llama en ningun momento a este metodo
		/// hay que crear uno igual en etsaiNodo
		switch(m) {
            case EZKERRA: this.x--; break;
            case ESKUMA:  this.x++; break;
            case GORA:    this.y--; break;
            case BEHERA:  this.y++; break;
        }
    }
}
