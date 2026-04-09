package modelo;

import java.util.ArrayList;

public abstract class EtsaiNodo extends Entitate{
	protected ArrayList<Entitate> gelaxkak = new ArrayList<>();

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
				setBizirik(false);
				MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);
			}
			i++;
		}
		if(mugituDaiteke) {
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);
			for (Entitate pixel : this.gelaxkak) {
				pixel.mugitu(mugimendu);
			}
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, id, EntitateMota.ETSAIA);
			eguneratuPosizioNagusia(mugimendu);
		}
	}
	
	private void eguneratuPosizioNagusia(Mugimendua m) {
		switch(m) {
            case EZKERRA: this.x--; break;
            case ESKUMA:  this.x++; break;
            case BEHERA:  this.y++; break;
            default: break;
        }
    }
	
	public ArrayList<Entitate> getGelaxkak() {
		return this.gelaxkak;
	}
<<<<<<< HEAD
	
	public void setBizirik(boolean bizirik) {
		this.bizirik = bizirik;
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);
=======
	public void setBizirik(boolean bizirik) {
		this.bizirik = bizirik;
		if (!bizirik) {
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);
		}
>>>>>>> 9106b28c071fa07d26a508a01ba2c7a7b9de0942
	}
}
