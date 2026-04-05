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
	public EtsaiNodo SortuEtsaiak(int id, int x, int y ) {
		int forma[][] = {{0,0},{1,0},{2,0},{1,1}};
		return new EtsaiNodo(x, y, forma, id);
	}
		
}
