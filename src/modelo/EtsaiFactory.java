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
	public Etsaiak SortuEtsaiak(EtsaiMota mota, int gelaxkak, int id, boolean bizirik) {
		switch(mota) {
		case MOTA_A:
			return new EtsaiakA(gelaxkak, id, bizirik);
		case MOTA_B:
			return new EtsaiakB(gelaxkak, id, bizirik);
		case MOTA_C:
			return new EtsaiakC(gelaxkak, id, bizirik);
		}
		return null;
	}
}
