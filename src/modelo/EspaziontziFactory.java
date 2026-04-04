package modelo;
import java.awt.Color;

public class EspaziontziFactory {
	public static EspaziontziFactory nireEspaziontziFactory;
	private int azkenMota = 1;
	private EspaziontziFactory() {
		
	}
	public static EspaziontziFactory getNireEspaziontziFactory() {
		if(nireEspaziontziFactory == null) {
			nireEspaziontziFactory = new EspaziontziFactory();
		}
		return nireEspaziontziFactory;
	}
	public Espaziontzi sortuEspaziontzia(int pMota) {
		this.azkenMota = pMota;
		switch(pMota) {
		case 1:
			return new Espaziontzi(1, 1, true, Color.CYAN);
		case 2:
			return new Espaziontzi(1, 2, true, Color.MAGENTA);
		case 3:
			return new Espaziontzi(1, 3, true, Color.ORANGE);
		default:
			return new Espaziontzi(1, 1, true, Color.CYAN);
		}
	}
	public Color getAzkenKolorea() {
		switch(this.azkenMota) {
		case 1:
			return Color.CYAN;
		case 2:
			return Color.MAGENTA;
		case 3:
			return Color.ORANGE;
		default:
			return Color.CYAN;
		}
	}
}
//