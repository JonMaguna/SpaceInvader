package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.Observer;
import modelo.MatrizeM;
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
				GelaxkaV gelaxka = new GelaxkaV("");
				gelaxka.setBorder(BorderFactory.createLineBorder(Color.RED));
				gelaxka.setBackground(Color.BLACK);
				contentPane.add(gelaxka);
			}
			
		}

	}
	
	
	
	
	
	
	
	public void keyPressed(KeyEvent e) {
	    int tekla = e.getKeyCode();
	    MatrizeM matrizeM = MatrizeM.getnMatrizeM();
	    if(tekla == KeyEvent.VK_LEFT || tekla == KeyEvent.VK_A) {matrizeM.mugituOntzia("EZKERRA");} 
	    else if(tekla == KeyEvent.VK_RIGHT || tekla == KeyEvent.VK_D) {matrizeM.mugituOntzia("ESKUMA");} 
	    else if(tekla == KeyEvent.VK_UP || tekla == KeyEvent.VK_W) {matrizeM.mugituOntzia("GORA");} 
	    else if(tekla == KeyEvent.VK_DOWN || tekla == KeyEvent.VK_S) {matrizeM.mugituOntzia("BEHERA");}
	    
	}

}
