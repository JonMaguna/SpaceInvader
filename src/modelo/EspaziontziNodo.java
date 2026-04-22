package modelo;

import java.util.ArrayList;

public abstract class EspaziontziNodo extends Entitate {
    protected ArrayList<Entitate> gelaxkak = new ArrayList<>();

    public EspaziontziNodo(int x, int y, int id) {
        super(x, y, id, true);
    }    
    
    public ArrayList<Entitate> getGelaxkak() {
        return this.gelaxkak;
    }
    
    public boolean mugituDaiteke(Mugimendua m) {
        boolean mugitu = true;
        for (Entitate pixel : this.gelaxkak) {
            if (!pixel.mugituDaiteke(m)) {
                mugitu = false;
                if (!pixel.bizirik()) {
                    this.setBizirik(false); 
                }
                break;
            }
        }
        return mugitu;
    }
    
    @Override
    public void mugitu(Mugimendua m) {
        if (this.mugituDaiteke(m)) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);
            for (Entitate pixel : this.gelaxkak) {
                pixel.mugitu(m);
            }
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, this.getId(), EntitateMota.ESPAZIONTZI);
            this.eguneratuPosizioNagusia(m);
        }
    }
    
    private void eguneratuPosizioNagusia(Mugimendua m) {
        switch(m) {
            case EZKERRA: this.setX(this.getX() - 1); break;
            case ESKUMA:  this.setX(this.getX() + 1); break;
            case GORA:    this.setY(this.getY() - 1); break;
            case BEHERA:  this.setY(this.getY() + 1); break;
            default: break;
        }
    }
    
    public void setBizirik(boolean bizirik) {
        this.bizirik = bizirik;
        for (Entitate pixel : gelaxkak) {
            pixel.setBizirik(bizirik);
        }
        if(!bizirik && JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);
        }
    }
}
