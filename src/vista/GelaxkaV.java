package vista;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import modelo.EntitateKolekzio;
import modelo.EntitateMota;
import modelo.Espaziontzi;
import modelo.EspaziontziFactory;
import modelo.GelaxkaM;

public class GelaxkaV extends JLabel implements Observer {
	
	private static final long serialVersionUID = 1L;
	
	public GelaxkaV(int korX, int korY) {
		setOpaque(false);
		koloreaEzarri(EntitateMota.HUTSA); 
	}
	

	private void koloreaEzarri(EntitateMota c) {
		switch (c) {
		case ESPAZIONTZI:
			setBackground(EntitateKolekzio.getnPertsonaiZerrenda().getOntziarenKolorea());
			setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
			setOpaque(true);
			break;
		case ETSAIA:
			setBackground(Color.BLUE);
			setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
			setOpaque(true);
			break;
		case BALA:
			setBackground(Color.WHITE);
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
			setOpaque(true);
			break;
		case HUTSA:
			setBorder(null);
	        setOpaque(false);
			break;
		default:
			break;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof GelaxkaM) {
			EntitateMota e = (EntitateMota) arg; 
			koloreaEzarri(e);
		}
	}
}