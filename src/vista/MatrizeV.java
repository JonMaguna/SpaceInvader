package vista;
import java.util.Observable;
import java.util.Observer;

import java.awt.Color;
import java.awt.EventQueue;
<<<<<<< HEAD
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import modelo.Espaziontzia;
//import modelo.MatrizeM;

public class MatrizeV extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Espaziontzia espaziontzianew;
=======
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.EntitateMota;
import modelo.GelaxkaM;
import modelo.MatrizeM;


public class MatrizeV extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GelaxkaV[][] matrizeV;
>>>>>>> 95dbae67b4c7f3da4a5bd4896c0a050391de1d32

	/**
	 * Launch the application.
	 */
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
<<<<<<< HEAD
        setTitle("SPACE INVADER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(60, 100, 0, 0));
        
        espaziontzianew = new Espaziontzia(50, 55); 
        
        this.addKeyListener(this); 
        this.setFocusable(true);
        this.matrizeaSortu();
    }

	public void matrizeaSortu() {
        for (int i = 0; i < 60; i++) {     
            for (int j = 0; j < 100; j++) {
                GelaxkaV gelaxka = new GelaxkaV("", j, i, espaziontzianew);
                gelaxka.setOpaque(true);
                if(j == espaziontzianew.getXposizioa() && i == espaziontzianew.getYposizioa()) {
                    gelaxka.setBackground(Color.MAGENTA);
                } else {
                    gelaxka.setBackground(Color.BLACK);
                }
                contentPane.add(gelaxka);
            }
        }    
    }
	
	/*public Espaziontzia sortuPerts() {
		Espaziontzia e= MatrizeM
		return e;
	}*/
=======
		setTitle("SPACE INVADER");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(60, 100, 0, 0));
		//this.matrizeaSortu();

	}
	
	
	private void gelaxkaBerria(int korX, int korY, EntitateMota mota) {
		GelaxkaV gelaxka = new GelaxkaV(korX, korY, mota);
		matrizeV[korX][korY] = gelaxka;
		contentPane.add(gelaxka);
	}
>>>>>>> 95dbae67b4c7f3da4a5bd4896c0a050391de1d32
	
	
	
	public void keyPressed(KeyEvent e) {
<<<<<<< HEAD
        int tekla = e.getKeyCode();
        if(tekla == KeyEvent.VK_LEFT || tekla == KeyEvent.VK_A) { espaziontzianew.mugitu("EZKERRA"); } 
        else if(tekla == KeyEvent.VK_RIGHT || tekla == KeyEvent.VK_D) { espaziontzianew.mugitu("ESKUINA"); } 
        else if(tekla == KeyEvent.VK_UP || tekla == KeyEvent.VK_W) { espaziontzianew.mugitu("GORA"); } 
        else if(tekla == KeyEvent.VK_DOWN || tekla == KeyEvent.VK_S) { espaziontzianew.mugitu("BEHERA"); }
        //else if(tekla == KeyEvent.VK_SPACE) {navePrincipal.bala()}
    }
	
	public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {} 
=======
	    int tekla = e.getKeyCode();
	    MatrizeM matrizeM = MatrizeM.getnMatrizeM();
	    if(tekla == KeyEvent.VK_LEFT || tekla == KeyEvent.VK_A) {matrizeM.mugituOntzia("EZKERRA");} 
	    else if(tekla == KeyEvent.VK_RIGHT || tekla == KeyEvent.VK_D) {matrizeM.mugituOntzia("ESKUMA");} 
	    else if(tekla == KeyEvent.VK_UP || tekla == KeyEvent.VK_W) {matrizeM.mugituOntzia("GORA");} 
	    else if(tekla == KeyEvent.VK_DOWN || tekla == KeyEvent.VK_S) {matrizeM.mugituOntzia("BEHERA");}
	}


	public void update(Observable o, Object arg) {
		if (o instanceof MatrizeM) {
		////baliteke if hau borratu ahal izatea
			if (arg instanceof GelaxkaM) { 
				GelaxkaM gelaxka = (GelaxkaM) arg;
				gelaxkaBerria(gelaxka.getKordenatuaX(), gelaxka.getKoordenatuaY(), gelaxka.zerDago());	
			}
		}
		else if (o instanceof GelaxkaM) {
			GelaxkaM gelaxka = (GelaxkaM) o;
			EntitateMota mota = gelaxka.zerDago();
			matrizeV[gelaxka.getKordenatuaX()][gelaxka.getKoordenatuaY()].koloreaEzarri(mota);
		}
	}

	

	/*public void matrizeaSortu() {
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < 100; j++) {
				if(i!= 50 && j!= 55) {
					GelaxkaV gelaxka = new GelaxkaV();
					gelaxka.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
			        gelaxka.setForeground(Color.BLACK);
			        gelaxka.setBackground(Color.BLACK);
			        gelaxka.setOpaque(true);
					contentPane.add(gelaxka);
				}else {
					GelaxkaV perts= new GelaxkaV();
					perts.setBackground(Color.WHITE);
					perts.setOpaque(true);
				}
			}	
		}
	}
	*/
>>>>>>> 95dbae67b4c7f3da4a5bd4896c0a050391de1d32
}
