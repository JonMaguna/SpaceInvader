package modelo;

import java.awt.Color;

public class EspaziontziMagenta extends EspaziontziNodo {
	private int bala = 1;
	
	public EspaziontziMagenta(int x, int y, int id) {
		super(x,y,id);
		int[][]forma ={{1,0},{3,0},{0,1},{1,1},{2,1},{3,1},{4,1},{0,2},{1,2},{2,2},{3,2},{4,2},{1,3},{2,3},{3,3}};
		for (int[] p: forma) {
			this.gelaxkak.add(new Espaziontzi(x+p[0], y+p[1], id, Color.MAGENTA));
		}
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, id, EntitateMota.ESPAZIONTZI);
	}
	
	public void nextBala() {
		if(this.bala == 3) {
			this.bala = 1;
		} else {
			this.bala++;
		}
	}
	
	public BalaNodo tiroEgin(int id) {
		switch(this.bala) {
		case 1:
			return BalaFactory.getnBalaFactory().sortuBala(this.x, this.y - 2, id, BalaMota.BALA_NORMALA);
		case 2:
			return BalaFactory.getnBalaFactory().sortuBala(this.x, this.y - 2, id, BalaMota.BALA_AZKARRA);
		case 3:
			return BalaFactory.getnBalaFactory().sortuBala(this.x, this.y - 2, id, BalaMota.BALA_HANDIA);
		default:
			return null;
		}
	}
}
