package modelo;
import java.awt.Color;
public class EspaziontziFactory {
	private static EspaziontziFactory nireEspaziontziFactory;
	private Color EspaziontziKolorea;
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
			EspaziontziKolorea = Color.RED;
			return new EspaziontziRED(xHasiera, yHasiera, id);
        case 2:
        	EspaziontziKolorea = Color.BLUE;
        	return new EspaziontziBLUE(xHasiera, yHasiera, id);
        case 3:
        	EspaziontziKolorea = Color.GREEN;
        	return new EspaziontziGREEN(xHasiera, yHasiera, id);
        default:
<<<<<<< HEAD
        	return null;
=======
        	EspaziontziKolorea = Color.RED;
        	return new EspaziontziRED(xHasiera, yHasiera, id);
>>>>>>> a7b1ab31446ebd084718ca16f2834a1d0fd1b5cd
		}
	}	
	public Color getAzkenKolorea() {
		return EspaziontziKolorea;
	}
}
