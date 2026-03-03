package vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.MatrizeM;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;

public class MatrizeV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(60, 100, 0, 0));
		this.matrizeaSortu();

	}
	
	public void matrizeaSortu() {
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < 100; j++) {
				GelaxkaV gelaxka = new GelaxkaV("");
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
