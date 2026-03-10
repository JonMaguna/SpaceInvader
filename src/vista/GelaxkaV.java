package vista;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;
import modelo.EntitateMota;



public class GelaxkaV extends JLabel{
	
	private static final long serialVersionUID = 1L;
	private EntitateMota mota;
	
	public GelaxkaV(int korX, int korY) {
		this.mota = EntitateMota.HUTSA;
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
}
