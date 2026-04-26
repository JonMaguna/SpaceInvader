package modelo;

public class BalaKohete extends BalaNodo {
	public BalaKohete(int x, int y, int[][] forma, int id) {
		super(x, y, forma, id);
	}
	private Entitate objetiboa = EntitateKolekzio.getnPertsonaiZerrenda().etsaiHurbilena(this.x, this.y);
	private int mugituGora = 0;
	
	public void run() {
		while (this.bizirik && JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) {
			try {
				this.mugitu();
				Thread.sleep(40); 
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				this.bizirik = false;
			}
		}
	}
	
	public void mugitu() {
		if(this.objetiboa == null || !this.objetiboa.bizirik()) {
			this.objetiboa = EntitateKolekzio.getnPertsonaiZerrenda().etsaiHurbilena(x, y);
		}
		int disX = this.objetiboa.getX();
		int disY = this.objetiboa.getY();
		boolean mugitu;
		Mugimendua m;
		if(Math.abs(disX -this.x) != 0 && !(mugituGora == 4)) {
			this.mugituGora++;
			if (disX > this.x) {
				m = Mugimendua.ESKUMA;
				mugitu = mugituDaiteke(m);
			}else {
				m = Mugimendua.EZKERRA;
				mugitu = mugituDaiteke(m);
			}
		}else {
			m = Mugimendua.GORA;
			mugitu = mugituDaiteke(m);
			this.mugituGora = 0;
		}
		if(mugitu) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);
            for (Entitate pixel : this.gelaxkak) {
                pixel.mugitu(m);
            }
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, this.getId(), EntitateMota.BALA);
            switch(m){
         	case ESKUMA:
         		this.koordenatu[0][0] += 1;
                this.x = this.koordenatu[0][0];
         		break;
         	case EZKERRA:
         		this.koordenatu[0][0] -= 1;
                this.x = this.koordenatu[0][0];
         	case GORA:
         		this.koordenatu[0][1] -= 1;
                this.y = this.koordenatu[0][1];
         	default:
         		break;
        	}
		}else {
			this.setBizirik(false);
		}
	}
}
