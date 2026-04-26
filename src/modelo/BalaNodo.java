package modelo;

import java.util.ArrayList;

public class BalaNodo extends Entitate implements Runnable {
    private Mugimendua norabidea;
    private Thread ThreadBala;
    private EntitateMota nireMota;
    protected ArrayList<Entitate> gelaxkak = new ArrayList<>();
    protected volatile boolean bizirik = true;
    public BalaNodo(int x, int y, int id) {
		super(x, y, id, true);
		this.norabidea = Mugimendua.GORA;
		
	}
    public BalaNodo(int x, int y, int[][] koordenatuak, int id, Mugimendua norabidea) {
        super(x, y, id, true);        
        this.norabidea = norabidea;
        if (this.norabidea == Mugimendua.BEHERA) {
            this.nireMota = EntitateMota.BALA_ETSAIA; 
        } else {
            this.nireMota = EntitateMota.BALA;        
        }
        boolean EtsaiaDago = false;
        for (int i = 0; i < koordenatuak.length; i++) {
            int posX = koordenatuak[i][0];
            int posY = koordenatuak[i][1];
            int[][] posHurrengoa = {{posX, posY}};
            EntitateMota entitatea = MatrizeM.getnMatrizeM().zerDago(posHurrengoa);
            int besteId = MatrizeM.getnMatrizeM().zeinIDDago(posHurrengoa);
            if (this.norabidea == Mugimendua.GORA && entitatea == EntitateMota.ETSAIA) {
                EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ETSAIA, besteId, false);
                EtsaiaDago = true;
            } else if (this.norabidea == Mugimendua.BEHERA && entitatea == EntitateMota.ESPAZIONTZI) {
                EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ESPAZIONTZI, besteId, false);
                EtsaiaDago = true;
            }
            this.gelaxkak.add(new Bala(posX, posY, id));
        }
        if (EtsaiaDago) {
            this.bizirik = false; 
        } else {    
        	MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, this.getId(), this.nireMota);
            this.ThreadBala = new Thread(this);
            this.ThreadBala.start();
        }
    }

    public boolean mugituDaiteke() {
    	return this.gelaxkak.stream()
    	        .map(pixel -> {
    	            boolean mugitu = pixel.mugituDaiteke(this.norabidea);
    	            if (!pixel.bizirik()) {
    	                this.setBizirik(false); 
    	            }
    	            return mugitu;
    	        })
    	        .reduce(true, (x, y) -> x && y);
    }

    public void mugitu() {
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
    	System.out.println("--> Hilo de la bala " + this.id + " HA ARRANCADO. Dirección: " + this.norabidea);
            
           while (this.bizirik && JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) { 
                try {
                    System.out.println("--> Bala " + this.id + " comprobando si puede moverse...");
                    boolean puede = this.mugituDaiteke(this.norabidea);
                    System.out.println("--> Bala " + this.id + " ¿puede moverse? " + puede);
                    
                    this.mugitu(this.norabidea); 
                    
                    Thread.sleep(50);
                } catch (Exception e) {
                    // ¡AQUÍ ESTÁ LA TRAMPA! Si hay un error de coordenadas, lo pillamos
                    System.out.println("--> ¡ERROR FATAL DENTRO DE LA BALA " + this.id + "!");
                    e.printStackTrace();
                    this.bizirik = false; // La matamos para que no congele el juego
                }
            }
            System.out.println("--> Hilo de la bala " + this.id + " TERMINADO. Bizirik = " + this.bizirik);
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
