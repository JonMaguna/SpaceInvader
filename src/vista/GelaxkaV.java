package vista;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import modelo.EntitateMota;
import modelo.GelaxkaM;
import modelo.JokoKudeatzailea;

public class GelaxkaV extends JLabel implements Observer {
	
	private static final long serialVersionUID = 1L;
	
	public GelaxkaV(int korX, int korY) {
		setOpaque(false);
		koloreaEzarri(EntitateMota.HUTSA); 
	}
	

	private void koloreaEzarri(EntitateMota c) {
		switch (c) {
		case ESPAZIONTZI:
			switch(JokoKudeatzailea.getnJokoKudeatzailea().getEspaziontziMota()) {
			case 1:
				setBackground(Color.RED);
				setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				setOpaque(true);
				break;
			case 2:
				setBackground(Color.BLUE);
				setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				setOpaque(true);
				break;
			case 3:
				setBackground(Color.GREEN);
				setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
				setOpaque(true);
				break;
			default:
				break;
			}
		break;
		case ETSAIA:
			setBackground(Color.BLUE);
			setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			setOpaque(true);
			break;
		case BALA:
			setBackground(Color.WHITE);
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			setOpaque(true);
			break;
		case BALA_ETSAIA:
			setBackground(Color.PINK); 
			setBorder(BorderFactory.createLineBorder(Color.ORANGE, 2));
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