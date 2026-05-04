package vista;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.JokoKudeatzailea;
import musikie.Efektuak;
import musikie.Musika_erreproduzidu;

public class Pantaila_finala_galdu extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantaila_finala_galdu frame = new Pantaila_finala_galdu();
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
	public Pantaila_finala_galdu() {
		Musika_erreproduzidu.getME().detener();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 3000, 2000);
		contentPane = new Fondoa("/img/galdu.png");
		Efektuak eG = new Efektuak();
		eG.erreproduzidu("src/musikie/galdu_sound.mp3");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		this.addKeyListener(this);

        this.setFocusable(true);
        this.requestFocusInWindow();
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
        case KeyEvent.VK_R: 
        	JokoKudeatzailea.getnJokoKudeatzailea().reset();
        	dispose();
        	break;
        case KeyEvent.VK_ESCAPE:
        	System.exit(0);
        	break;
		}
    }
	
	@Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

}
