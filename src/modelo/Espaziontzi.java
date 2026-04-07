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
	public int getX() {
		return this.koordenatu[0][0];
	}
	public int getY() {
		return this.koordenatu[0][1];
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
				entitatea = MatrizeM.getnMatrizeM().zerDago(this.koordenatu);
			}
			break;
		case ESKUMA:
			if(this.koordenatu[0][0] == 99) {mugitu = false;} 
			else {
				entitatea = MatrizeM.getnMatrizeM().zerDago(this.koordenatu);
			}
			break;
		default:
			break;
		}
		if(mugitu && entitatea != null) { 
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
