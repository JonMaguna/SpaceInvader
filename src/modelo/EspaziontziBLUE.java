package modelo;

import java.awt.Color;

public class EspaziontziBLUE extends EspaziontziNodo {
	private int bala3 = 0;
	
	protected EspaziontziBLUE(int x, int y, int id) {
		super(x,y,id);
		tiroEstrategia = new BlueTiroEstrategia();
		int[][]forma ={{-1,0},{1,0},{-2,1},{-1,1},{0,1},{1,1},{2,1},{-2,2},{-1,2},{0,2},{1,2},{2,2},{-1,3},{0,3},{1,3}};
		for (int[] p: forma) {
			this.gelaxkak.add(new Espaziontzi(x+p[0], y+p[1], id, Color.BLUE));
		}
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, id, EntitateMota.ESPAZIONTZI);
	}
	
	public void setBala3(int bala) {
		this.bala2 = bala3;
	}
	public int getBala3() {
		return this.bala3;
	}
}
