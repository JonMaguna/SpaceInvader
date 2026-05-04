package vista;

import java.awt.Graphics; // ¡No olvides importar Graphics!
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
		
		// Es buena práctica comprobar si la imagen existe para evitar errores (NullPointerException)
		if (imgUrl != null) {
			this.fondoa = new ImageIcon(imgUrl).getImage();	
		} else {
			System.err.println("Error: No se encontró la imagen en la ruta /img/e_3.jpg");
		}
	}

	// --- ESTE ES EL MÉTODO QUE TE FALTABA AÑADIR ---
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Limpia el panel
		
		// Si la imagen cargó correctamente, la dibujamos
		if (fondoa != null) {
			// Dibuja la imagen ocupando el 100% del ancho y alto del panel
			g.drawImage(fondoa, 0, 0, getWidth(), getHeight(), this);
		}
	}
}