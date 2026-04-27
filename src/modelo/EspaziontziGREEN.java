package modelo;

import java.awt.Color;

public class EspaziontziGREEN  extends EspaziontziNodo{
	private int bizitzak = 3;
	private long azkenKolpea = 0;
	protected EspaziontziGREEN(int x, int y, int id) {
		super(x,y,id);
		this.kolorea = Color.GREEN;
		tiroEstrategia = new GreenTiroEstrategia();
		int[][] forma = {{0, -3},{-1, -2}, {0, -2}, {1, -2},{-1, -1}, {0, -1}, {1, -1},{-2, 0}, {-1, 0}, {0, 0}, {1, 0}, {2, 0},{-3, 1}, {-2, 1}, {-1, 1}, {0, 1}, {1, 1}, {2, 1}, {3, 1},{-3, 2}, {-2, 2}, {2, 2}, {3, 2},{-3, 3}, {-2, 3}, {2, 3}, {3, 3},{-3, 4}, {3, 4}};
		this.bala = 1;
		for (int[] p: forma) {
			this.gelaxkak.add(new Espaziontzi(x+p[0], y+p[1], id, Color.GREEN));
		}
		MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, id, EntitateMota.ESPAZIONTZI);
	}
	@Override
    public void setBizirik(boolean b) {
        if (!b) { 	
        	long orain = System.currentTimeMillis();
        	if (orain - this.azkenKolpea < 500) {
            return; 
        }
        	this.azkenKolpea = orain; 
            this.bizitzak--;
            if (this.bizitzak <= 0) {
                super.setBizirik(false);
            }else {
            	this.StepBack();
            }
        }
    }
	
	@Override
    public BalaNodo tiroEgin(int pId) {
        return this.tiroEstrategia.tiroEgin(this, pId);
    }
	
	private void StepBack() {
		for (int i = 0; i < 5; i++) {
			this.mugitu(Mugimendua.BEHERA);
		}
	}
}
