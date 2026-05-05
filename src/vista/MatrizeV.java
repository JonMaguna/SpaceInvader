package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
	private boolean ezkerra, eskuma, gora, behera, tiroEgin, nextBala, kohete;
	private Timer mainTimer;
	private int x = 200;
	private int y = 120;
	private boolean jokoaAmaituta = false;
	
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
		setBounds(100, 100, 3000, 2000); 
		
		contentPane = new Fondoa("/img/e_3.jpg");
		
		contentPane.setBackground(Color.BLACK); 
		contentPane.setBorder(new EmptyBorder(1, 1, 1, 1));
		contentPane.setLayout(new GridLayout(y, x, 0, 0));
		setContentPane(contentPane);
		
		this.matrizeV = new GelaxkaV[x][y];
		JokoKudeatzailea.getnJokoKudeatzailea().addObserver(this);
		this.addKeyListener(this); 
		this.setFocusable(true);
		
		mainTimer = new Timer(16, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mugimenduakAktualizatu();
			}
		});
		mainTimer.start();
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
        case KeyEvent.VK_Q:
			kohete = true;
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
	    if(kohete) {
	    	EntitateKolekzio.getnPertsonaiZerrenda().tiroKohete();
	    	kohete = false;
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
        case KeyEvent.VK_Q:
			kohete = false;
			break;
		}
    }
    
    private class Fondoa extends JPanel {
        private Image irudia;

        public Fondoa(String errutea) {
            java.net.URL imgUrl = getClass().getResource(errutea);
            if (imgUrl != null) {
                irudia = new ImageIcon(imgUrl).getImage();
            }else {
            	System.out.println("ERROREA");
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
	

	public void update(Observable o, Object arg) {
		int argInt = (int) arg;
		switch (argInt) {
			case 0:
				for (int i = 0; i < y; i++) {
		          	for (int j = 0; j < x; j++) {
		           	GelaxkaV gelaxka = new GelaxkaV(j, i);
		           	matrizeV[j][i] = gelaxka;
		          	contentPane.add(gelaxka);
		            MatrizeM.getnMatrizeM().getGelaxka(j, i).addObserver(gelaxka);
		           	}
				}
				break;
			case 1:
				if (!jokoaAmaituta) {
	                jokoaAmaituta = true;
	                if (mainTimer != null) mainTimer.stop(); 
	                
	                dispose();
	                
	                Pantaila_finala_galdu pfI = new Pantaila_finala_galdu();
	                pfI.setVisible(true);
	            }
				break;
			case 2:
				if (!jokoaAmaituta) {
	                jokoaAmaituta = true;
	                if (mainTimer != null) mainTimer.stop(); 
	                
	                dispose();
	                
	                Pantaila_finala_irabazi pfI = new Pantaila_finala_irabazi();
	                pfI.setVisible(true);
	            }
				break;
			case 3:
				if (mainTimer != null) mainTimer.stop();
				LeihoNagusiaV.LVmain(null);
				this.dispose();
				break;
			default:
				break;
		}
	}
	
}
