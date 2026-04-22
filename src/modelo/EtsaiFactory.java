package modelo;

public class EtsaiFactory {
	private static EtsaiFactory nEtsaiFactory;
	
	private EtsaiFactory() {}
	
	public static EtsaiFactory getEtsaiFactory() {
		if(nEtsaiFactory == null) {
			nEtsaiFactory = new EtsaiFactory();
		}
		return nEtsaiFactory;
	}
	
	public EtsaiNodo SortuEtsaiak(int id, int x, int y,int mota) {
		switch(mota) {
		case 1: return new EtsaiakA(x,y,id);
		case 2: return new EtsaiakB(x,y,id);
		case 3: return new EtsaiakC(x,y,id);
		}
		return null;
	}
		
}
