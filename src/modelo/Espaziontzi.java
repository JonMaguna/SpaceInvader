package modelo;

public class Espaziontzi extends Entitate {
	
	public Espaziontzi(int x, int y, int id) {
		super(x, y, id, true);
	}
	
	public boolean mugituDaiteke(Mugimendua mugimendua) {
	    int xHurrengoa = this.koordenatu[0][0];
	    int yHurrengoa = this.koordenatu[0][1];

	    switch (mugimendua) {
	        case GORA:    yHurrengoa--; break;
	        case BEHERA:  yHurrengoa++; break;
	        case EZKERRA: xHurrengoa--; break;
	        case ESKUMA:  xHurrengoa++; break;
	    }

	    if (xHurrengoa < 0 || xHurrengoa > MatrizeM.getnMatrizeM().getX() -1 || yHurrengoa < 0 || yHurrengoa > MatrizeM.getnMatrizeM().getY() -1)  {
	        return false;
	    }
	    int[][] posHurrengoa = {{xHurrengoa, yHurrengoa}};
	    EntitateMota entitatea = MatrizeM.getnMatrizeM().zerDago(posHurrengoa);
	    if (entitatea == EntitateMota.ETSAIA||entitatea == EntitateMota.BALA_ETSAIA || entitatea == EntitateMota.BALA) {
	    	EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ESPAZIONTZI, 1, false); 
	        return false;         
	    	}      
	    return true;
	}
	
	public void mugitu(Mugimendua mugimendu) {
		switch (mugimendu) {
		case GORA:
			this.koordenatu[0][1] -= 1;
			break;
		case BEHERA:
			this.koordenatu[0][1] += 1;
			break;
		case EZKERRA:
			this.koordenatu[0][0] -= 1;
			break;
		case ESKUMA:
			this.koordenatu[0][0] += 1;
			break;
		default:
			break;
		}
	}
}
