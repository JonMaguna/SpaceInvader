package modelo;

import java.awt.Color;

public class EspaziontziRED extends EspaziontziNodo {
	private int bala = 1;
	
	protected EspaziontziRED(int x, int y, int id) {
		super(x, y, id);
        int[][] forma = {{-1,0},{1,0},{-1,1},{0,1},{1,1},{-1,2},{0,2},{1,2}};
		for (int[] p: forma) {
			this.gelaxkak.add(new Espaziontzi(x+p[0], y+p[1], id, Color.RED));
		}
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, id, EntitateMota.ESPAZIONTZI);
	}
	
	public void nextBala() {
		if(this.bala == 2) {
			this.bala = 1;
		} else {
			this.bala++;
		}
	}
	
	public BalaNodo tiroEgin(int id) {
		switch(this.bala) {
		case 1:
			return BalaFactory.getnBalaFactory().sortuBala(this.x, this.y - 1, id, BalaMota.BALA_NORMALA);
		case 2:
			return BalaFactory.getnBalaFactory().sortuBala(this.x, this.y - 1, id, BalaMota.BALA_HANDIA);
		default:
			return null;
		}
	}
}
