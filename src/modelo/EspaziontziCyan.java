package modelo;

import java.awt.Color;

public class EspaziontziCyan extends EspaziontziNodo {
	public EspaziontziCyan(int x, int y, int id) {
		super(x, y, id);
        int[][] forma = {{0,0},{2,0},{0,1},{1,1},{2,1},{0,2},{1,2},{2,2}};
		for (int[] p: forma) {
			this.getGelaxkak().add(new Espaziontzi(x+p[0], y+p[1], id, Color.CYAN));
		}
	}
}
