package modelo;

import musikie.Efektuak;

public class BalaFactory {
	private static BalaFactory nBalaFactory;
	
	private BalaFactory() {}
	
	public static BalaFactory getnBalaFactory() {
		if(nBalaFactory == null) {
			nBalaFactory = new BalaFactory();
		}
		return nBalaFactory;
	}
	
	public BalaNodo sortuBala(int x, int y, int id, BalaMota mota) {
		Efektuak e = new Efektuak();
		if(y <= 0) {
			return null;
		}
		switch(mota) {
		case BALA_NORMALA:
			e.erreproduzidu("src/musikie/balak_disparatu_1.mp3", -25f);
			return new BalaNodo(x, y, new int[][]{{x, y}}, id,50, Mugimendua.GORA);
		case BALA_AZKARRA:
			if(y <= 1) {
				return null;
			}
			e.erreproduzidu("src/musikie/balak_disparatu_2.mp3", -25f);
			return new BalaNodo(x, y, new int[][]{{x, y}, {x-1, y+1}, {x+1, y+1}}, id,25, Mugimendua.GORA);
		case BALA_HANDIA:
			if(x <= 1 || x >= MatrizeM.getnMatrizeM().getX() -2 || y <= 4) {
				return null;
			}
			e.erreproduzidu("src/musikie/balak_disparatu_3.mp3", -25f);
			return new BalaNodo(x, y, new int[][]{{x, y}, {x, y-1}, {x+1, y-1}, {x-1, y-1}, 
				{x, y-2}, {x+1, y-2}, {x+2, y-2}, {x-1, y-2}, {x-2, y-2}, {x, y-3}, {x+1, y-3}, {x-1, y-3}, {x, y-4}}, id,50, Mugimendua.GORA);
		case BALA_KOHETE:
			if(y <= 1) {
				return null;
			}
			e.erreproduzidu("src/musikie/cohetea_disp.mp3", 6f);
			return new BalaKohete(x, y, new int[][]{{x+1, y}, {x-1, y}, {x, y-1}, {x, y-2}}, id,40);
		case BALA_ETSAIA:
			e.erreproduzidu("src/musikie/balak_disparatu_3.mp3", -25f);
            return new BalaNodo(x, y, new int[][]{{x, y}}, id,50, Mugimendua.BEHERA);
		default:
			return null;
		}
	}
}
