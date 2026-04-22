package modelo;

import java.awt.Color;

public class EspaziontziGREEN  extends EspaziontziNodo{

	protected EspaziontziGREEN(int x, int y, int id) {
		super(x,y,id);
		tiroEstrategia = new GreenTiroEstrategia();
		int[][] forma = {{0,0},{-1,1},{0,1},{1,1},{-2,2},{-1,2},{0,2},{1,2},{2,2}};
		this.bala = 1;
		for (int[] p: forma) {
			this.gelaxkak.add(new Espaziontzi(x+p[0], y+p[1], id, Color.GREEN));
		}
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, id, EntitateMota.ESPAZIONTZI);
	}
	
}
