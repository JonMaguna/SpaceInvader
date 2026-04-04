package modelo;

public class EspaziontziFactory {
	public static EspaziontziFactory nireEspaziontziFactory;
	private EspaziontziFactory() {
		
	}
	public static EspaziontziFactory getNireEspaziontziFactory() {
		if(nireEspaziontziFactory == null) {
			nireEspaziontziFactory = new EspaziontziFactory();
		}
		return nireEspaziontziFactory;
	}
	public Espaziontzi sortuEspaziontzia(int pMota) {
		Espaziontzi espaziontzi = null;
		switch(pMota) {
		case 1:
			espaziontzi = new Espaziontzi(1, 1, true);
			break;
		case 2:
			espaziontzi = new Espaziontzi(1, 2, true);
			break;
		case 3:
			espaziontzi = new Espaziontzi(1, 3, true);
			break;
		default:
			break;
		}
		return espaziontzi;
	}
}
//