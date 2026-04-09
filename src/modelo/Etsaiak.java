package modelo;

public class Etsaiak extends Entitate {
	
	public Etsaiak(int x, int y, int id) {
		super(x, y, id, true);
	}

	public boolean mugituDaiteke(Mugimendua mugimendu) {
		boolean mugitu = true;
		EntitateMota entitatea = null;
		int xHurrengoa = this.koordenatu[0][0];
		int yHurrengoa = this.koordenatu[0][1];
		
		switch(mugimendu) {
	        case BEHERA:  yHurrengoa++; break;
	        case EZKERRA: xHurrengoa--; break;
	        case ESKUMA:  xHurrengoa++; break;
		}
		if (yHurrengoa > 59) {
			JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(1);
			return false;
		}
		if(xHurrengoa < 0 || xHurrengoa > 99) {
			return false;
		}
		int[][] Hurrengoa = {{xHurrengoa, yHurrengoa}};
		entitatea = MatrizeM.getnMatrizeM().zerDago(Hurrengoa);
		int BesteId = MatrizeM.getnMatrizeM().zeinIDDago(Hurrengoa);
		switch(entitatea) {
		case ESPAZIONTZI:
			EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ESPAZIONTZI, 1, false);
            mugitu = false;
            break;
		case BALA:
			EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ETSAIA, this.id, false);
			this.setBizirik(false);
			mugitu = false;
			break;
		case ETSAIA:
			if(BesteId != this.id) {
                mugitu = false; 
            }
			break;
		default:
			break;
		}
		return mugitu;
	}
	
	public void mugitu(Mugimendua mugimendu) {
		switch(mugimendu) {
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
