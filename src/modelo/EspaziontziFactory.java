package modelo;
import java.awt.Color;

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
	public EspaziontziNodo sortuEspaziontzia(int pMota) {	
		int xHasiera = 50;
		int yHasiera = 55;
		int id = 1;
		switch(pMota) {
		case 1:
			return new EspaziontziCyan(xHasiera, yHasiera, id);
        case 2:
        	return new EspaziontziMagenta(xHasiera, yHasiera, id);
        case 3:
        	return new EspaziontziOrange(xHasiera, yHasiera, id);
        default:
        	return new EspaziontziCyan(xHasiera, yHasiera, id);
		}
	}	

}
