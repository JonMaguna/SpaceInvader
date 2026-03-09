package vista;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import modelo.EntitateMota;
import modelo.GelaxkaM;
import modelo.MatrizeM;
import modelo.Mugimendua;
import modelo.JokoKudeatzailea;


public class MatrizeV extends JFrame implements Observer, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GelaxkaV[][] matrizeV;
	private boolean presionatuta = false;
	
	
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
		setBounds(100, 100, 1150, 1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.setLayout(new GridLayout(60, 100, 0, 0));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		this.matrizeV = new GelaxkaV[100][60];
		MatrizeM.getnMatrizeM().addObserver(this);
        this.addKeyListener(this); 
        this.setFocusable(true);
        JokoKudeatzailea.getnJokoKudeatzailea().jokoaHasieratu();
    }

	
	private void gelaxkaBerria(int korX, int korY, EntitateMota mota) {
		GelaxkaV gelaxka = new GelaxkaV(korX, korY, mota);
		matrizeV[korX][korY] = gelaxka;
		contentPane.add(gelaxka);
	}
	
	
	
	public void keyPressed(KeyEvent e) {
	    MatrizeM matrizeM = MatrizeM.getnMatrizeM();
		int tekla = e.getKeyCode();
	    if(tekla == KeyEvent.VK_LEFT || tekla == KeyEvent.VK_A) {matrizeM.mugituOntzia(Mugimendua.EZKERRA);} 
	    else if(tekla == KeyEvent.VK_RIGHT || tekla == KeyEvent.VK_D) {matrizeM.mugituOntzia(Mugimendua.ESKUMA);} 
	    else if(tekla == KeyEvent.VK_UP || tekla == KeyEvent.VK_W) {matrizeM.mugituOntzia(Mugimendua.GORA);} 
	    else if(tekla == KeyEvent.VK_DOWN || tekla == KeyEvent.VK_S) {matrizeM.mugituOntzia(Mugimendua.BEHERA);}
	    else if(tekla == KeyEvent.VK_SPACE && !presionatuta) {
	    	presionatuta = true;
	    	matrizeM.tiroEgin();
	    }
    }
	
	public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {
    	int tekla = e.getKeyCode();
    	if(tekla == KeyEvent.VK_SPACE) {presionatuta = false;}
    } 
    
	

	public void update(Observable o, Object arg) {
		if(arg instanceof String) {
			String mezua = (String) arg;
			if(mezua.equals("GALDU")) {
				JOptionPane.showMessageDialog(this, "Jokoa galdu duzu, saiatu berriro!");
			} else if(mezua.equals("IRABAZI")) {
				JOptionPane.showMessageDialog(this, "Zorionak, irabazi duzu!");
			}
			return;
		}
		if (o instanceof MatrizeM) {
			if (arg instanceof GelaxkaM) { 
				GelaxkaM gelaxka = (GelaxkaM) arg;
				gelaxka.addObserver(this);
				gelaxkaBerria(gelaxka.getKordenatuaX(), gelaxka.getKordenatuaY(), gelaxka.zerDago());	
			}
		}
		else if (o instanceof GelaxkaM) {
			GelaxkaM gelaxka = (GelaxkaM) o;
			EntitateMota mota = gelaxka.zerDago();
			matrizeV[gelaxka.getKordenatuaX()][gelaxka.getKordenatuaY()].koloreaEzarri(mota);
			}
	}
	
}
