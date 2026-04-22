package modelo;

import java.awt.Color;

public class EspaziontziRED extends EspaziontziNodo {
	
	protected EspaziontziRED(int x, int y, int id) {
		super(x, y, id);
		tiroEstrategia = new RedTiroEstrategia();
        int[][] forma = {{-1,0},{1,0},{-1,1},{0,1},{1,1},{-1,2},{0,2},{1,2}};
		for (int[] p: forma) {
			this.gelaxkak.add(new Espaziontzi(x+p[0], y+p[1], id, Color.RED));
		}
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, id, EntitateMota.ESPAZIONTZI);
	}
	
}
