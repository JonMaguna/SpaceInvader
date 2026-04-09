package modelo;

import java.util.ArrayList;

public class BalaNodo extends Entitate implements Runnable{
	
	private Thread ThreadBala;
	private ArrayList<Entitate> gelaxkak = new ArrayList<>();

	public BalaNodo(int x, int y, int[][] koordenatuak, int id) {
		super(x, y, id, true);
		for (int i = 0; i < koordenatuak.length; i++) {
			this.gelaxkak.add(new Bala(koordenatuak[i][0], koordenatuak[i][1], id));
		}
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, this.id, EntitateMota.BALA);
		this.ThreadBala = new Thread(this);
		this.ThreadBala.start();
	}

	public void run() {
		while (bizirik && JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) { 
            try {
                Thread.sleep(50);
                boolean mugituDaiteke = true;
        		int i = 0;
        		while(i < this.gelaxkak.size() && mugituDaiteke){
        			mugituDaiteke = this.gelaxkak.get(i).mugituDaiteke(Mugimendua.GORA);
        			for(Entitate g: gelaxkak) {
        				EntitateMota e= MatrizeM.getnMatrizeM().zerDago(g.koordenatu);
        				if(e.equals(EntitateMota.ETSAIA)) {
        					mugituDaiteke= false;
        				}
        			}
        			MatrizeM.getnMatrizeM().zerDago(this.koordenatu);
        			i++;
        		}
        		if(mugituDaiteke) {
        			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);
        			for (Entitate pixel : this.gelaxkak) {
        				pixel.mugitu(Mugimendua.GORA);
        			}
        			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, this.id, EntitateMota.BALA);
        			this.y--;
        		}
        		else {
        			setBizirik(false);
        			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);
        		}
            } catch (InterruptedException e) {
                setBizirik(false);
            }
        }
    }
	
	public void setBizirik(boolean bizirik) {
		this.bizirik = bizirik;
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);
	}
}
