package vista;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;


import modelo.EntitateMota;



public class GelaxkaV extends JLabel{
	
	private int koordenatuX;
	private int koordenatuY;
	private EntitateMota mota;
	
	
	public GelaxkaV(int korX, int korY, EntitateMota mota) {
		this.koordenatuX = korX;
		this.koordenatuY = korY;
		this.mota = mota;
		setOpaque(true);
		koloreaEzarri(this.mota);
	}
	
	public void koloreaEzarri(EntitateMota mota) {
		this.mota = mota;
		switch (mota) {
			case HUTSA:
				setBackground(Color.BLACK);
				break;
			case ESPAZIONTZI:
				setBackground(Color.MAGENTA);
				setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				break;
			case ETSAIA:
				setBackground(Color.BLUE);
				setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				break;
			case BALA:
				setBackground(Color.WHITE);
				setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
				break;
		}
	}
	
	
}
