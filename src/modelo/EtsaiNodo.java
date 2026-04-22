package modelo;

import java.util.ArrayList;

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
        boolean mugitu = true;
        MatrizeM matrizeM = MatrizeM.getnMatrizeM();
        for (Entitate pixel : this.gelaxkak) {
            if (!pixel.mugituDaiteke(m)) {
                mugitu = false;
                if (!pixel.bizirik()) {
                    this.setBizirik(false); 
                }
                break; 
            }
            int x = pixel.getKoordenatu()[0][0];
            int y = pixel.getKoordenatu()[0][1];
            
            switch(m) {
                case EZKERRA: x--; break;
                case ESKUMA:  x++; break;
                case BEHERA:  y++; break;
                default: break;
            }

            int[][] hurrengoa = {{x, y}};
            if (matrizeM.zerDago(hurrengoa) == EntitateMota.ESPAZIONTZI) {
                JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(1);
                return false; 
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
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, this.getId(), EntitateMota.ETSAIA);
            this.eguneratuPosizioNagusia(m);
        }
    }

    private void eguneratuPosizioNagusia(Mugimendua m) {
        switch(m) {
            case EZKERRA: this.setX(this.getX() - 1); 
            break;
            case ESKUMA:  this.setX(this.getX() + 1); 
            break;
            case BEHERA:  this.setY(this.getY() + 1); 
            break;
            default: 
            break;
        }
    }
    
    public ArrayList<Entitate> getGelaxkak() {
        return this.gelaxkak;
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