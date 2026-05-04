package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fondoa extends JPanel {
	
    private Image irudia;
    private static final long serialVersionUID = 1L;

    public Fondoa(String errutie) {
        java.net.URL imgUrl = getClass().getResource(errutie);
        if (imgUrl != null) {
            irudia = new ImageIcon(imgUrl).getImage();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (irudia != null) {
            g.drawImage(irudia, 0, 0, getWidth(), getHeight(), this);
        } else {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}