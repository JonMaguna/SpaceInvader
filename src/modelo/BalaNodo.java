package modelo;

import java.util.ArrayList;

public class BalaNodo extends Entitate implements Runnable {
    private Thread ThreadBala;
    private ArrayList<Entitate> gelaxkak = new ArrayList<>();
    private volatile boolean bizirik = true;

    public BalaNodo(int x, int y, int[][] koordenatuak, int id) {
        super(x, y, id, true);
        
        boolean EtsaiaDago = false;
        for (int i = 0; i < koordenatuak.length; i++) {
            int posX = koordenatuak[i][0];
            int posY = koordenatuak[i][1];
            int[][] posHurrengoa = {{posX, posY}};
            EntitateMota entitatea = MatrizeM.getnMatrizeM().zerDago(posHurrengoa);
            int besteId = MatrizeM.getnMatrizeM().zeinIDDago(posHurrengoa);
            if (entitatea == EntitateMota.ETSAIA) {
                EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ETSAIA, besteId, false);
                EtsaiaDago = true;
            }
            this.gelaxkak.add(new Bala(posX, posY, id));
        }
        
        if (EtsaiaDago) {
            this.bizirik = false; 
        } else {    
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, this.id, EntitateMota.BALA);
            this.ThreadBala = new Thread(this);
            this.ThreadBala.start();
        }
    }

    public boolean mugituDaiteke(Mugimendua m) {
    	return this.gelaxkak.stream()
    	        .map(pixel -> {
    	            boolean puedeEstePixel = pixel.mugituDaiteke(m);
    	            if (!pixel.bizirik()) {
    	                this.setBizirik(false); 
    	            }
    	            return puedeEstePixel;
    	        })
    	        .reduce(true, (acumulado, actual) -> acumulado && actual);
    }

    @Override
    public void mugitu(Mugimendua m) {
        if (this.mugituDaiteke(m)) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);
            for (Entitate pixel : this.gelaxkak) {
                pixel.mugitu(Mugimendua.GORA);
            }
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, this.getId(), EntitateMota.BALA);
            this.setY(this.getY() - 1);
        } else {
            this.setBizirik(false);
        }
    }

    @Override
    public void run() {
        while (this.bizirik && JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) { 
            try {
                this.mugitu(Mugimendua.GORA); 
                Thread.sleep(50);
            } catch (InterruptedException e) {
                this.bizirik = false;
            }
        }
    }

    public ArrayList<Entitate> getGelaxkak() {
        return this.gelaxkak;
    }
    
    public void setBizirik(boolean bizirik) {
        this.bizirik = bizirik;
        for (Entitate pixel : this.gelaxkak) {
            pixel.setBizirik(bizirik);
        }
        if(!bizirik && JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);
        }
    }
}
