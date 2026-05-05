package modelo;

import java.util.ArrayList;

import musikie.Efektuak;

public abstract class EtsaiNodo extends Entitate {
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
    
    public boolean mugituDaiteke(Mugimendua m) {
    	boolean kamikaze;
    	if(this instanceof EtsaiakC) {
    		kamikaze = true;
    	}else {
    		kamikaze = false;
    	}
    	return this.gelaxkak.stream()
    			.filter(pixel -> !pixel.mugituDaiteke(m, kamikaze))
    			.findFirst()
    			.map(pixel -> {
    				if (!pixel.bizirik()) {
						this.setBizirik(false); 
					}
					return false;
    			})
				.orElse(true);
    }
    @Override
    public void mugitu(Mugimendua m) {
        if (!this.bizirik) {
            return;
        }

        if (this.mugituDaiteke(m)) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);            
            for (Entitate pixel : this.gelaxkak) {
                pixel.mugitu(m);
            }
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, this.getId(), EntitateMota.ETSAIA);
            this.eguneratuPosizioNagusia(m);
        }
    }

    private void eguneratuPosizioNagusia(Mugimendua m) {
        switch(m) {
            case EZKERRA: this.setX(this.getX() - 1); break;
            case ESKUMA:  this.setX(this.getX() + 1); break;
            case BEHERA:  this.setY(this.getY() + 1); break;
            default: break;
        }
    }
    
    public void setBizirik(boolean bizirik) {
		Efektuak e = new Efektuak();
		e.erreproduzidu("src/musikie/cohetea_exp.mp3");
        this.bizirik = bizirik;
        for (Entitate pixel : gelaxkak) {
            pixel.setBizirik(bizirik);
        }
        if(!bizirik && JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);
        }
    }
}