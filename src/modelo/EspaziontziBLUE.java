package modelo;

public class EspaziontziBLUE extends EspaziontziNodo {
	private int bala3 = 0;
	private int kohete = 0;
	
	protected EspaziontziBLUE(int x, int y, int id) {
		super(x,y,id);
		tiroEstrategia = new BlueTiroEstrategia();
		int[][]forma ={{0, 0},{-1, -2}, {-1, -1},{1, -2}, {1, -1},{-2, 0}, {-1, 0}, {1, 0}, {2, 0},{-2, 1}, {-1, 1}, {0, 1}, {1, 1}, {2, 1},{-2, 2}, {-1, 2}, {0, 2}, {1, 2}, {2, 2},{-1, 3}, {0, 3}, {1, 3}};
		for (int[] p: forma) {
			this.gelaxkak.add(new Espaziontzi(x+p[0], y+p[1], id));
		}
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, id, EntitateMota.ESPAZIONTZI);
	}
	
	public void setBala3(int bala) {
		this.bala2 = bala3;
	}
	public int getBala3() {
		return this.bala3;
	}
	
	public void tiroKohete(int i) {
		if (kohete < 5) {
			BalaFactory.getnBalaFactory().sortuBala(this.x, this.y - 3, i, BalaMota.BALA_KOHETE);
			kohete++;
		}
	}
}
