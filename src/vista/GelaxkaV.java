package vista;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import modelo.EntitateMota;



public class GelaxkaV extends JLabel implements Observer{
	
	private static final long serialVersionUID = 1L;
	private EntitateMota mota;
	
	public GelaxkaV(int korX, int korY) {
		this.mota = EntitateMota.HUTSA;
		setOpaque(true);
		koloreaEzarri(this.mota);
	}
	
	
	private void koloreaEzarri(EntitateMota mota) {
		this.mota = mota;
		switch (mota) {
			case ESPAZIONTZI:
				setBackground(Color.MAGENTA);
				setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
				break;
			case ETSAIA:
				setBackground(Color.BLUE);
				setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
				break;
			case BALA:
				setBackground(Color.WHITE);
				setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				break;
			case HUTSA:
				 setBackground(Color.BLACK);
				 setBorder(BorderFactory.createLineBorder(Color.GRAY, 0));
				break;
			default:
				break;
		}
	}


	@Override
	public void update(Observable o, Object arg) {
		this.mota = (EntitateMota) arg;
		koloreaEzarri((EntitateMota) arg);
	}
}
