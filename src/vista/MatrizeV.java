package vista;

import java.awt.Color;
import java.awt.EventQueue;
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

	/**
	 * Create the frame.
	 */
	public MatrizeV() {
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
	
	public void keyPressed(KeyEvent e) {
        int tekla = e.getKeyCode();
        if(tekla == KeyEvent.VK_LEFT || tekla == KeyEvent.VK_A) { espaziontzianew.mugitu("EZKERRA"); } 
        else if(tekla == KeyEvent.VK_RIGHT || tekla == KeyEvent.VK_D) { espaziontzianew.mugitu("ESKUINA"); } 
        else if(tekla == KeyEvent.VK_UP || tekla == KeyEvent.VK_W) { espaziontzianew.mugitu("GORA"); } 
        else if(tekla == KeyEvent.VK_DOWN || tekla == KeyEvent.VK_S) { espaziontzianew.mugitu("BEHERA"); }
        //else if(tekla == KeyEvent.VK_SPACE) {navePrincipal.bala()}
    }
	
	public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {} 
}
