package modelo;

import java.util.ArrayList;
import java.util.List;

public class BalaNodo extends Entitate implements Runnable{
	
	private Thread ThreadBala;
	private List<Bala> gelaxkak = new ArrayList<>();
	private Bala nagusi;

	public BalaNodo(int x, int y, int[][] koordenatuak, int id) {
		super(x, y, id, true);
		for (int i = 0; i < koordenatuak.length; i++) {
			this.gelaxkak.add(new Bala(koordenatuak[i][0], koordenatuak[i][1], id));
			if (koordenatuak[i][0] == x && koordenatuak[i][1] == y) {
				this.nagusi = this.gelaxkak.get(i);
			}
		}
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
        			i++;
        		}
        		if(mugituDaiteke) {
        			for (Bala pixel : this.gelaxkak) {
        				pixel.mugitu(Mugimendua.GORA);
        			}
        		}
            } catch (InterruptedException e) {
                this.bizirik = false;
            }
        }
        this.bizirik = false;
    }
}
