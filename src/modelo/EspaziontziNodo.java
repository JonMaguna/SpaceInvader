package modelo;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public abstract class EspaziontziNodo extends Entitate{
	private List<Espaziontzi> gelaxkak = new ArrayList<>();
	private Espaziontzi nagusi;

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
	private void eguneratuPosizioNagusia(Mugimendua m) {
        switch(m) {
            case EZKERRA: this.x--; break;
            case ESKUMA:  this.x++; break;
            case GORA:    this.y--; break;
            case BEHERA:  this.y++; break;
        }
    }
}
