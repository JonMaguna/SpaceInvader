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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.MatrizeM;
import modelo.Mugimendua;


public class MatrizeV extends JFrame implements Observer, KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private GelaxkaV[][] matrizeV;
	private boolean presionatuta = false;
	private boolean ezkerra, eskuma, gora, behera, tiroEgin;
	
	
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
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.setLayout(new GridLayout(60, 100, 0, 0));
		setContentPane(contentPane);
		this.matrizeV = new GelaxkaV[100][60];
		MatrizeM.getnMatrizeM().addObserver(this);
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
		}
    }
	
    private void mugimenduakAktualizatu() {
		MatrizeM matrizeM = MatrizeM.getnMatrizeM();
		if (ezkerra) {matrizeM.mugituOntzia(Mugimendua.EZKERRA);} 
	    else if (eskuma) {matrizeM.mugituOntzia(Mugimendua.ESKUMA);} 
	    if (gora) {matrizeM.mugituOntzia(Mugimendua.GORA);} 
	    else if (behera) {matrizeM.mugituOntzia(Mugimendua.BEHERA);}
	    if (tiroEgin && !presionatuta) {
	    	matrizeM.tiroEgin();
	    	presionatuta = true;
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
			MatrizeM modelo = (MatrizeM) o;
	            for (int i = 0; i < 60; i++) {
	            	for (int j = 0; j < 100; j++) {
	               	GelaxkaV gelaxka = new GelaxkaV(j, i);
	            	matrizeV[j][i] = gelaxka;
	            	contentPane.add(gelaxka);
	                modelo.getGelaxka(j, i).addObserver(gelaxka);
	            }
	        }
		}
	}
	
}
