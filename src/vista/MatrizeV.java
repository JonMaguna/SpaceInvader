package vista;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.EntitateKolekzio;
import modelo.JokoKudeatzailea;
import modelo.MatrizeM;
import modelo.Mugimendua;


public class MatrizeV extends JFrame implements Observer, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GelaxkaV[][] matrizeV;
	private boolean presionatuta = false;
	private boolean ezkerra, eskuma, gora, behera, tiroEgin, nextBala;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatrizeV frame = new MatrizeV();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MatrizeV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 3000, 2000); // Nota: Esta resolución es muy alta, asegúrate de que tu pantalla lo soporte.
		
		// 1. CREAMOS EL PANEL SOBREESCRIBIENDO paintComponent PARA DIBUJAR EL FONDO
		contentPane = new JPanel() {
			private static final long serialVersionUID = 1L;
			private java.awt.Image imagenFondo;

			// Bloque de inicialización para cargar la imagen
			{
				try {
					// Asegúrate de que la ruta coincida con la ubicación en tu proyecto (carpeta src/img)
					java.net.URL imgUrl = getClass().getResource("/img/ikurrina.png");
					if (imgUrl != null) {
						imagenFondo = new ImageIcon(imgUrl).getImage();
					} else {
						System.err.println("No se pudo encontrar la imagen de fondo.");
					}
				} catch (Exception e) {
					System.err.println("Error al cargar la imagen: " + e.getMessage());
				}
			}

			@Override
			protected void paintComponent(java.awt.Graphics g) {
				super.paintComponent(g);
				if (imagenFondo != null) {
					// Dibuja la imagen para que ocupe todo el panel
					g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
				}
			}
		};

		// Opcional: poner fondo negro por si la imagen tarda en cargar o falla
		contentPane.setBackground(Color.BLACK); 
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.setLayout(new GridLayout(60, 100, 0, 0));
		setContentPane(contentPane);
		
		this.matrizeV = new GelaxkaV[100][60];
		JokoKudeatzailea.getnJokoKudeatzailea().addObserver(this);
		this.addKeyListener(this); 
		this.setFocusable(true);
		
		Timer timer = new Timer(16, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mugimenduakAktualizatu();
			}
		});
		timer.start();
	}

	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
        case KeyEvent.VK_LEFT:  case KeyEvent.VK_A: 
        	ezkerra = true; 
        	break;
        case KeyEvent.VK_RIGHT: case KeyEvent.VK_D: 
        	eskuma = true; 
        	break;
        case KeyEvent.VK_UP:    case KeyEvent.VK_W: 
        	gora = true; 
        	break;
        case KeyEvent.VK_DOWN:  case KeyEvent.VK_S: 
        	behera = true; 
        	break;
        case KeyEvent.VK_SPACE:
        	tiroEgin = true; 
        	break;
        case KeyEvent.VK_SHIFT:
        	nextBala = true;
			break;
		}
    }
	
    private void mugimenduakAktualizatu() {
		if (ezkerra) {EntitateKolekzio.getnPertsonaiZerrenda().mugituOntzia(Mugimendua.EZKERRA);} 
	    else if (eskuma) {EntitateKolekzio.getnPertsonaiZerrenda().mugituOntzia(Mugimendua.ESKUMA);} 
	    if (gora) {EntitateKolekzio.getnPertsonaiZerrenda().mugituOntzia(Mugimendua.GORA);} 
	    else if (behera) {EntitateKolekzio.getnPertsonaiZerrenda().mugituOntzia(Mugimendua.BEHERA);}
	    if (tiroEgin && !presionatuta) {
	    	EntitateKolekzio.getnPertsonaiZerrenda().tiroEgin();
	    	presionatuta = true;
	    }
	    if(nextBala){
	    	EntitateKolekzio.getnPertsonaiZerrenda().nextBala();
	    	nextBala = false;
	    }
	}
	
	public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
    	int keyCode = e.getKeyCode();
		switch (keyCode) {
        case KeyEvent.VK_LEFT:  case KeyEvent.VK_A: 
        	ezkerra = false; 
        	break;
        case KeyEvent.VK_RIGHT: case KeyEvent.VK_D: 
        	eskuma = false; 
        	break;
        case KeyEvent.VK_UP:    case KeyEvent.VK_W: 
        	gora = false; 
        	break;
        case KeyEvent.VK_DOWN:  case KeyEvent.VK_S: 
        	behera = false; 
        	break;
        case KeyEvent.VK_SPACE:
        	tiroEgin = false;
        	presionatuta = false;
        	break;
		}
    } 
	

	public void update(Observable o, Object arg) {
		int argInt = (int) arg;
		switch (argInt) {
			case 0:
				for (int i = 0; i < 60; i++) {
		          	for (int j = 0; j < 100; j++) {
		           	GelaxkaV gelaxka = new GelaxkaV(j, i);
		           	matrizeV[j][i] = gelaxka;
		          	contentPane.add(gelaxka);
		            MatrizeM.getnMatrizeM().getGelaxka(j, i).addObserver(gelaxka);
		           	}
				}
				break;
			case 1:
				JOptionPane.showMessageDialog(this, "Jokoa galdu duzu, saiatu berriro!");
				break;
			case 2:
				JOptionPane.showMessageDialog(this, "Zorionak, irabazi duzu!");
				break;
			default:
				break;
		}
	}
	
}
