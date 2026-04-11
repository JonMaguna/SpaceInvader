package vista;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import modelo.EntitateMota;
import modelo.GelaxkaM;
import modelo.EspaziontziFactory;



public class GelaxkaV extends JLabel implements Observer{
	
	private static final long serialVersionUID = 1L;
	private EntitateMota mota;
	
	public GelaxkaV(int korX, int korY) {
		this.mota = EntitateMota.HUTSA;
		setOpaque(false);
		koloreaEzarri(this.mota);
	}
	
	
	private void koloreaEzarri(EntitateMota mota) {
		this.mota = mota;
		switch (mota) {
			case ESPAZIONTZI:
				setBackground(EspaziontziFactory.getNireEspaziontziFactory().getAzkenKolorea());
				setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
				setOpaque(true);
				break;
			case ETSAIA:
				setBackground(Color.GRAY);
				setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
				setOpaque(true);
				break;
			case BALA:
				setBackground(Color.WHITE);
				setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				setOpaque(true);
				break;
			case HUTSA:
				setOpaque(false);
				setBorder(null);
				//setBackground(Color.BLACK);
				//setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
				break;
			default:
				break;
		}
	}


	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof GelaxkaM) {
			GelaxkaM gelaxkaM = (GelaxkaM) o;
			koloreaEzarri(gelaxkaM.zerDago());
		}
	}
}
