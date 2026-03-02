package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.Observer;
import vista.
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MatrizeaV extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatrizeaV frame = new MatrizeaV();
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
	public MatrizeaV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 816, 519);
		getContentPane().setLayout(new GridLayout(60, 100, 0, 0));
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.BLACK);
		//pack();
		
		for (int i = 1; i < 61; i++) {
			for (int j = 1; j < 101; j++) {
				GelaxkaV gelaxka = new GelaxkaV();
				Border redborder = BorderFactory.createLineBorder(Color.RED, 1);
				gelaxka.setBackground(Color.BLACK);
				panel.setBorder(redborder);
				getContentPane().add(panel);
			}
			
		}

	}
	
	
	
	
	
	
	
	public void keyPressed(KeyEvent e) {
	    int tekla = e.getKeyCode();
	    MatrizeaM modelo = MatrizeaM.getnMatrizeaM();
	    
	    // 2. Llamamos al método mugituOntzia pasándole el ENUM Mugimendua
	    if(tekla == KeyEvent.VK_LEFT || tekla == KeyEvent.VK_A) {
	        modelo.mugituOntzia(Mugimendua.EZKERRA);
	    } 
	    else if(tekla == KeyEvent.VK_RIGHT || tekla == KeyEvent.VK_D) {
	        modelo.mugituOntzia(Mugimendua.ESKUMA);
	    } 
	    else if(tekla == KeyEvent.VK_UP || tekla == KeyEvent.VK_W) {
	        modelo.mugituOntzia(Mugimendua.GORA);
	    } 
	    else if(tekla == KeyEvent.VK_DOWN || tekla == KeyEvent.VK_S) {
	        modelo.mugituOntzia(Mugimendua.BEHERA);
	    }
	    // ... aquí puedes añadir el disparo (VK_SPACE) llamando a otro método
	}

}
