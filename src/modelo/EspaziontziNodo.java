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
	protected void eguneratuPosizioNagusia(Mugimendua m) {
		switch(m) {
            case EZKERRA: this.x--; break;
            case ESKUMA:  this.x++; break;
            case GORA:    this.y--; break;
            case BEHERA:  this.y++; break;
        }
    }
	public void setEstrategy(MugimenduEstrategia estrategia) {
		this.mugimenduEstrategia = estrategia;
	}
}
