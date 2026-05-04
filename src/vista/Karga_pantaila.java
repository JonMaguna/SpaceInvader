package vista;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Karga_pantaila extends JPanel {
	
	private Image fondoa;

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Karga_pantaila() {
		java.net.URL imgUrl = getClass().getResource("/img/karga.png");
		
		if (imgUrl != null) {
			this.fondoa = new ImageIcon(imgUrl).getImage();	
		} else {
			System.err.println("Error: No se encontró la imagen en la ruta /img/e_3.jpg");
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (fondoa != null) {
			g.drawImage(fondoa, 0, 0, getWidth(), getHeight(), this);
		}
	}
}