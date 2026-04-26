package modelo;

import java.awt.Color;

public class EspaziontziRED extends EspaziontziNodo {
	
	protected EspaziontziRED(int x, int y, int id) {
		super(x, y, id);
		this.kolorea = Color.RED;
		tiroEstrategia = new RedTiroEstrategia();
        int[][] forma = {{-1,0},{-1,1},{0,1},{0,2},{1,2},{1,3}};
		for (int[] p: forma) {
			this.gelaxkak.add(new Espaziontzi(x+p[0], y+p[1], id, Color.RED));
		}
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, id, EntitateMota.ESPAZIONTZI);
	}
	
	@Override
    public void mugitu(Mugimendua m) {
		for(int i=0; i<5;i++) {
			if (this.mugituDaiteke(m)) {
	            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);
	            for (Entitate pixel : this.gelaxkak) {
	            	pixel.mugitu(m);
	            }
	            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, this.getId(), EntitateMota.ESPAZIONTZI);
	            this.eguneratuPosizioNagusia(m);
	        }
		}
    }
	
}
