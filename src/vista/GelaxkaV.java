package vista;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class GelaxkaV extends JLabel {

	public GelaxkaV(String texto) {
    	super(texto); 
        this.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
        this.setForeground(Color.BLACK);
        this.setBackground(Color.BLACK);
    }
}