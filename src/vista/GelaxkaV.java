package vista;
//import modelo.Bala;
import modelo.Espaziontzia;
import javax.swing.JLabel;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

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