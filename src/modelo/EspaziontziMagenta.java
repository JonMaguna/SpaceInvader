package modelo;

import java.awt.Color;

public class EspaziontziMagenta extends EspaziontziNodo {
	public EspaziontziMagenta(int x, int y, int id) {
		super(x,y,id);
		int[][]forma ={{1,0},{3,0},{0,1},{1,1},{2,1},{3,1},{4,1},{0,2},{1,2},{2,2},{3,2},{4,2},{1,3},{2,3},{3,3}};
		for (int[] p: forma) {
			this.getGelaxkak().add(new Espaziontzi(x+p[0], y+p[1], id, Color.MAGENTA));
		}
	}
}
