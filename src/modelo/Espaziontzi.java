package modelo;
import java.awt.Color;
import java.util.ArrayList;

public class Espaziontzi extends Entitate {
	protected ArrayList<Entitate> gelaxkak = new ArrayList<>();
	
	public Espaziontzi(int x, int y, int id, Color pKolorea) {
		super(x, y, id, true);
	}
	
	public void setBizirik(boolean bizirik) {
		this.bizirik = bizirik;
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);
		if (!bizirik) {
			JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(1);
		}
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

	    if (xHurrengoa < 0 || xHurrengoa > 99 || yHurrengoa < 0 || yHurrengoa > 59) {
	        return false;
	    }
	    int[][] posHurrengoa = {{xHurrengoa, yHurrengoa}};
	    EntitateMota entitatea = MatrizeM.getnMatrizeM().zerDago(posHurrengoa);

	    if (entitatea == EntitateMota.ETSAIA) {
	        setBizirik(false); 
	        return false;           
	    }
	    return true;
	}
	
	protected void mugitu(Mugimendua mugimendu) {
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
