package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import musikie.Efektuak;

public class EtsaiakC extends EtsaiNodo{
	private Timer kamikazeTimer;
	private boolean mugituBehera = false;
	private boolean kamikaze = false;
	
    protected EtsaiakC(int x, int y, int id) {
        super(x, y, new int[][]{ {-2, -2},{2, -2},{-2, -1}, {-1, -1}, {0, -1}, {1, -1}, {2, -1},{0, 0}}, id);
    }

    
    public void banzai() {
    	if(!JokoKudeatzailea.getnJokoKudeatzailea().kamikazerik() && MatrizeM.getnMatrizeM().etsairikAurrean(this.gelaxkak) && EntitateKolekzio.getnPertsonaiZerrenda().nahikoUrruti(this.x, this.y)) {
        	JokoKudeatzailea.getnJokoKudeatzailea().setKamikaze(true);
        	kamikaze = true;
        	Efektuak e = new Efektuak();
        	e.erreproduzidu("src/musikie/kamikaze.mp3", 0f);
        	this.kamikazeTimer = new Timer(20, new ActionListener() {
    	        public void actionPerformed(ActionEvent e) {
    	            mugituKamikaze();
    	        }
    	    });
    	    this.kamikazeTimer.start();
        	}
    }
    
	
	
	private void mugituKamikaze() {
		int disX = EntitateKolekzio.getnPertsonaiZerrenda().getX(EntitateMota.ESPAZIONTZI, 1);
		boolean mugitu;
		Mugimendua m;
		if(Math.abs(disX - this.x) != 0 && !mugituBehera) {
			mugituBehera = true;
			if (disX > this.x) {
				m = Mugimendua.ESKUMA;
				mugitu = mugituDaiteke(m);
			}else {
				m = Mugimendua.EZKERRA;
				mugitu = mugituDaiteke(m);
			}
		}else {
			mugituBehera = false;
			m = Mugimendua.BEHERA;
			mugitu = mugituDaiteke(m);
		}
		if(mugitu) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);
            for (Entitate pixel : this.gelaxkak) {
                pixel.mugitu(m);
            }
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, this.id, EntitateMota.ETSAIA);
            switch(m){
         	case ESKUMA:
         		this.koordenatu[0][0] += 1;
                this.x +=1;
         		break;
         	case EZKERRA:
         		this.koordenatu[0][0] -= 1;
                this.x -=1;
         	case BEHERA:
         		this.koordenatu[0][1] += 1;
                this.y +=1;
         	default:
         		break;
        	}
		}
		if(!this.bizirik()){
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);
			this.kamikaze = false;
			kamikazeTimer.stop();
			JokoKudeatzailea.getnJokoKudeatzailea().setKamikaze(false);
		}
	}


	public boolean getKamikaze() {
		return this.kamikaze;
	}
}
