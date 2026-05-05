package modelo;

import java.util.ArrayList;

public class BalaNodo extends Entitate implements Runnable {
    private Mugimendua norabidea;
    private Thread ThreadBala;
    private EntitateMota nireMota;
    protected ArrayList<Entitate> gelaxkak = new ArrayList<>();
    protected volatile boolean bizirik = true;
    protected int abiadura;

   /* public BalaNodo(int x, int y, int[][] koordenatuak, int id, int abiadura) {
        this(x, y, koordenatuak, id, abiadura, Mugimendua.GORA);
    }*/

    public BalaNodo(int x, int y, int[][] koordenatuak, int id, int abiadura, Mugimendua norabidea) {
        super(x, y, id, true);        
        this.abiadura = abiadura; 
        this.norabidea = norabidea;        
        
        if (this.norabidea == Mugimendua.BEHERA) {
            this.nireMota = EntitateMota.BALA_ETSAIA; 
        } else {
            this.nireMota = EntitateMota.BALA;        
        }        
        
        boolean talka = false;
        for (int i = 0; i < koordenatuak.length; i++) {
            int posX = koordenatuak[i][0];
            int posY = koordenatuak[i][1];
            int[][] posHurrengoa = {{posX, posY}};
            EntitateMota entitatea = MatrizeM.getnMatrizeM().zerDago(posHurrengoa);
            int besteId = MatrizeM.getnMatrizeM().zeinIDDago(posHurrengoa);
            
            if (this.norabidea == Mugimendua.GORA && entitatea == EntitateMota.ETSAIA) {
                EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ETSAIA, besteId, false);
                talka = true;
            } else if (this.norabidea == Mugimendua.BEHERA && entitatea == EntitateMota.ESPAZIONTZI) {
                EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ESPAZIONTZI, besteId, false);
                talka = true;
            }
            this.gelaxkak.add(new Bala(posX, posY, id));
        }
        
        if (talka) {
            this.bizirik = false; 
        } else {    
        	MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, this.getId(), this.nireMota);
            this.ThreadBala = new Thread(this);
            this.ThreadBala.start();
        }
    }

    @Override
    public boolean mugituDaiteke(Mugimendua m) {
    	return this.gelaxkak.stream()
    	        .map(pixel -> {
    	            boolean mugitu = pixel.mugituDaiteke(this.norabidea);
    	            if (!pixel.bizirik()) {
    	                this.bizirik = false; 
    	            }
    	            return mugitu;
    	        })
    	        .reduce(true, (x, y) -> x && y);
    }

    @Override
    public void mugitu(Mugimendua m) {
        if (this.mugituDaiteke(this.norabidea)) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);
            for (Entitate pixel : this.gelaxkak) {
                pixel.mugitu(this.norabidea);
            }
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, this.getId(), this.nireMota);
            if (this.norabidea == Mugimendua.GORA) { 
            	this.y--; 
            } else { 
            	this.y++; 
            }
        } else {
            this.setBizirik(false);
        }
    }

    @Override
    public void run() {
        try {
            while (this.bizirik && JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) { 
                this.mugitu(this.norabidea); 
                Thread.sleep(this.abiadura);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.bizirik = false;
            if (JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
                MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);
            }
        }
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