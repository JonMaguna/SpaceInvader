package modelo;


public class EspaziontziFactory {
	private static EspaziontziFactory nireEspaziontziFactory;
	private EspaziontziFactory() {
		
	}
	public static EspaziontziFactory getNireEspaziontziFactory() {
		if(nireEspaziontziFactory == null) {
			nireEspaziontziFactory = new EspaziontziFactory();
		}
		return nireEspaziontziFactory;
	}
	public EspaziontziNodo sortuEspaziontzia(int pMota) {	
		int xHasiera = MatrizeM.getnMatrizeM().getX()/2;
		int yHasiera = MatrizeM.getnMatrizeM().getY() - 5;
		int id = 1;
		switch(pMota) {
		case 1:
			return new EspaziontziRED(xHasiera, yHasiera, id);
        case 2:
        	return new EspaziontziBLUE(xHasiera, yHasiera, id);
        case 3:
        	return new EspaziontziGREEN(xHasiera, yHasiera, id);
        case 4:
        	return new EspaziontziROSE(xHasiera, yHasiera, id);
        default:
        	return null;
		}
	}
}