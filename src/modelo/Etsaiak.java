package modelo;

public class Etsaiak extends Entitate {
	
	public Etsaiak(int x, int y, int id) {
		super(x, y, id, true);
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.koordenatu, 1, EntitateMota.ETSAIA);
	}

	public boolean mugituDaiteke(Mugimendua mugimendu) {
		boolean mugitu = true;
		EntitateMota entitatea = null;
		int id = 0;
		
		switch(mugimendu) {
		case BEHERA: 
			if (koordenatu[0][1] == 59) { mugitu = false; JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(1); } 
			else {
				entitatea = MatrizeM.getnMatrizeM().zerDago(this.koordenatu);
				id = MatrizeM.getnMatrizeM().zeinIDDago(this.koordenatu);
			}
			break;
		case EZKERRA: 
			if (koordenatu[0][0] == 0) { mugitu = false; }
			else {
				entitatea = MatrizeM.getnMatrizeM().zerDago(this.koordenatu);
				id = MatrizeM.getnMatrizeM().zeinIDDago(this.koordenatu);
			}
			break;
		case ESKUMA: 
			if (koordenatu[0][0] == 99) { mugitu = false; }
			else {
				entitatea = MatrizeM.getnMatrizeM().zerDago(this.koordenatu);
				id = MatrizeM.getnMatrizeM().zeinIDDago(this.koordenatu);
			}
			break;
		default:
			break;
		}
		if (mugitu) {
			switch (entitatea) {
			case ESPAZIONTZI:
				EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ESPAZIONTZI, 1, false);
				mugitu = false;
				break;
			case ETSAIA:
				mugitu = false;
				if(id == this.id) {
					mugitu = true;
				}
				break;
			case BALA:
				EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ETSAIA, id, false);
				MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 0, EntitateMota.HUTSA);
				mugitu = false;
				break;
			default:
				mugitu = true;
				break;
			}
		}
		return mugitu;
	}
	
	public void mugitu(Mugimendua mugimendu) {
		switch(mugimendu) {
		case BEHERA:
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 0, EntitateMota.HUTSA);
			this.koordenatu[0][1] += 1;
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 1, EntitateMota.ETSAIA);
			break;
		case EZKERRA:
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 0, EntitateMota.HUTSA);
			this.koordenatu[0][0] -= 1;
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 1, EntitateMota.ETSAIA);
			break;
		case ESKUMA:
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 0, EntitateMota.HUTSA);
			this.koordenatu[0][0] += 1;
			MatrizeM.getnMatrizeM().gelaxkakAktualizatu(koordenatu, 1, EntitateMota.ETSAIA);
			break;
		default:
			break;
		}
	}
}
