package vista;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import modelo.GelaxkaM;

public class GelaxkaV extends JLabel implements Observer {
	
	private static final long serialVersionUID = 1L;
	
	public GelaxkaV(int korX, int korY) {
		setOpaque(false);
		koloreaEzarri(null); 
	}
	

	private void koloreaEzarri(Color c) {
		if (c == null) {
			setOpaque(false);
			setBorder(null);
		} else {
			setBackground(c);
			setOpaque(true);
			if (c == Color.WHITE) {
				setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			} else {
				setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof GelaxkaM) {
			Color colorRecibido = (Color) arg; 
			koloreaEzarri(colorRecibido);
		}
	}
}