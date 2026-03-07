package vista;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Observer;

import modelo.EntitateMota;



public class GelaxkaV extends JLabel /*implements Observer */{
	
	private static final long serialVersionUID = 1L;
	private int koordenatuX;
	private int koordenatuY;
	private EntitateMota mota;
	
	
	public GelaxkaV(int korX, int korY, EntitateMota mota) {
		this.koordenatuY = korY;
		this.koordenatuX = korX;
		this.mota = mota;
		setOpaque(true);
		koloreaEzarri(this.mota);
	}
	
	
	public void koloreaEzarri(EntitateMota mota) {
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
	
	/*public void update(java.util.Observable o, Object arg) {
		if (o instanceof modelo.GelaxkaM) {
			modelo.GelaxkaM gelaxkaM = (modelo.GelaxkaM) o;
			if (gelaxkaM.getKordenatuaX() == this.koordenatuX && gelaxkaM.getKoordenatuaY() == this.koordenatuY) {
				koloreaEzarri(gelaxkaM.zerDago());
			}
		}
	}*/
	
}
