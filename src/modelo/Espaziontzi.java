package modelo;
import java.awt.Color;

public class Espaziontzi extends Entitate {
	private Color kolorea;
	
	public Espaziontzi(int x, int y, int id, Color pKolorea) {
		super(x, y, id, true);
		this.kolorea=pKolorea;
		
	}
	public Color getKolorea() {
		return this.kolorea;
	}
	
	public void setBizirik(boolean bizirik) {
		this.bizirik = bizirik;
		if (!bizirik) {
			JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(1);
		}
	}
	
	public boolean mugituDaiteke(Mugimendua mugimendua) {
		boolean mugitu = true;
		EntitateMota entitatea = null;
		
		switch (mugimendua) {
		case GORA:
			if(this.koordenatu[0][1] == 0) {mugitu = false;} 
			else {
				entitatea = MatrizeM.getnMatrizeM().zerDago(this.koordenatu);
			}
			break;
		case BEHERA:
			if(this.koordenatu[0][1] == 59) {mugitu = false;} 
			else {
				entitatea = MatrizeM.getnMatrizeM().zerDago(this.koordenatu);
			}
			break;
		case EZKERRA:
			if(this.koordenatu[0][0] == 0) {mugitu = false;} 
			else {
				MatrizeM.getnMatrizeM().zerDago(this.koordenatu);
			}
			break;
		case ESKUMA:
			if(this.koordenatu[0][0] == 99) {mugitu = false;} 
			else {
				MatrizeM.getnMatrizeM().zerDago(this.koordenatu);
			}
			break;
		default:
			break;
		}
		if(mugitu) { 
			switch (entitatea) {
			case ETSAIA:
				mugitu = false;
				setBizirik(false);
				break;
			default:			
				break;
			}
		}
		return mugitu;
	}
	
	public void mugitu(Mugimendua mugimendu) {
		switch (mugimendu) {
		case GORA:
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 0, EntitateMota.HUTSA);
			this.koordenatu[0][1] -= 1;
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 1, EntitateMota.ESPAZIONTZI);
			break;
		case BEHERA:
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 0, EntitateMota.HUTSA);
			this.koordenatu[0][1] += 1;
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 1, EntitateMota.ESPAZIONTZI);
			break;
		case EZKERRA:
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 0, EntitateMota.HUTSA);
			this.koordenatu[0][1] -= 1;
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 1, EntitateMota.ESPAZIONTZI);
			break;
		case ESKUMA:
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 0, EntitateMota.HUTSA);
			this.koordenatu[0][1] += 1;
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 1, EntitateMota.ESPAZIONTZI);
			break;
		default:
			break;
		}
	}
}
