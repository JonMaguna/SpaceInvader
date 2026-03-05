package vista;
//import modelo.Bala;
import modelo.Espaziontzia;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

<<<<<<< HEAD
public class GelaxkaV extends JLabel implements Observer {

    private static final long serialVersionUID = 1L;
    private int Xpos;
    private int Ypos;

    public GelaxkaV(String texto, int x, int y, Espaziontzia perts) {
        super(texto);
        this.Xpos = x;
        this.Ypos = y;
        
        perts.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        
        Espaziontzia espaziontzia = (Espaziontzia) o;
        //Bala bala= (Bala) o;
        
        if (this.Xpos == espaziontzia.getXposizioa() && this.Ypos == espaziontzia.getYposizioa()) {
            this.setBackground(Color.MAGENTA);
        /*} else if(this.miX == bala.getX() && this.miY == bala.getY()){
            this.setBackground(Color.WHITE);  // La nave no está, soy espacio vacío
        */}else {
        	this.setBackground(Color.BLACK);
        }
    }
}
=======
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

>>>>>>> 95dbae67b4c7f3da4a5bd4896c0a050391de1d32
