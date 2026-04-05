package modelo;

public class BalaFactory {
	private static BalaFactory nBalaFactory;
	
	private BalaFactory() {}
	
	public static BalaFactory getnBalaFactory() {
		if(nBalaFactory == null) {
			nBalaFactory = new BalaFactory();
		}
		return nBalaFactory;
	}
	
	public BalaNodo SortuBala(int x, int y, int id, BalaMota mota) {
		switch(mota) {
		case BALA_NORMALA:
			return new BalaNodo(x, y, new int[][]{{x, y}}, id);
		case BALA_AZKARRA:
			return new BalaNodo(x, y, new int[][]{{x, y}, {x-1, y-1}, {x+1, y+1}}, id);
		case BALA_HANDIA:
			return new BalaNodo(x, y, new int[][]{{x, y}, {x, y-1}, {x+1, y-1}, {x-1, y-1}, 
				{x, y-2}, {x+1, y-2}, {x+2, y-2}, {x-1, y-2}, {x-2, y-2}, {x, y-3}, {x+1, y-3}, {x-1, y-3}, {x, y-4}}, id);
		default:
			return null;
		}
		
	}
}
