package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class EtsaiakC extends EtsaiNodo{
	private Timer kamikazeTimer;
	private double mugituBehera = 0;
	private boolean kamikaze = false;
	
    protected EtsaiakC(int x, int y, int id) {
        super(x, y, new int[][]{ {0, 0},{-1, 0},{1, 0},{1, 1},{-1,1}}, id);
    }

    
    public void banzai() {
    	if(!JokoKudeatzailea.getnJokoKudeatzailea().kamikazerik() && MatrizeM.getnMatrizeM().etsairikAurrean(this.gelaxkak) && EntitateKolekzio.getnPertsonaiZerrenda().nahikoUrruti(this.x, this.y)) {
        	JokoKudeatzailea.getnJokoKudeatzailea().setKamikaze(true);
        	kamikaze = true;
        	this.kamikazeTimer = new Timer(40, new ActionListener() {
    	        public void actionPerformed(ActionEvent e) {
    	            mugituKamikaze(0);
    	        }
    	    });
    	    this.kamikazeTimer.start();
        	}
    }
    
	
	
	private void mugituKamikaze(int saiakera) {
		if(saiakera > 10) {return;}
		int disX = EntitateKolekzio.getnPertsonaiZerrenda().getX(EntitateMota.ESPAZIONTZI, 1);
		boolean mugitu;
		Mugimendua m;
		if(disX - this.x != 0 && mugituBehera != 1) {
			mugituBehera+=0.5;
			if (disX > this.x) {
				m = Mugimendua.ESKUMA;
				mugitu = mugituDaiteke(m);
			}else {
				m = Mugimendua.EZKERRA;
				mugitu = mugituDaiteke(m);
			}
		}else {
			mugituBehera = 0;
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
                this.x = this.koordenatu[0][0];
         		break;
         	case EZKERRA:
         		this.koordenatu[0][0] -= 1;
                this.x = this.koordenatu[0][0];
         	case BEHERA:
         		this.koordenatu[0][1] += 1;
                this.y = this.koordenatu[0][1];
         	default:
         		break;
        	}
		}else if(this.bizirik()){
			System.out.println(saiakera++);
			mugituKamikaze(saiakera++);
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
