package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.JokoKudeatzailea;

public class LeihoNagusiaV extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void LVmain(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeihoNagusiaV frame = new LeihoNagusiaV();
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
	public LeihoNagusiaV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.BLACK);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		java.net.URL imgUrl = getClass().getResource("/img/alien2.png");
		ImageIcon iconoOriginal = new ImageIcon(imgUrl);
		java.awt.Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
		ImageIcon iconoAlien = new ImageIcon(imagenEscalada);
		
		JLabel goiL = new JLabel("Press <UP,DOWN,RIGHT,LEFT> or <W,S,D,A> to move");
		goiL.setFont(new Font("Arial", Font.BOLD, 20));
		goiL.setForeground(Color.WHITE);
		goiL.setHorizontalAlignment(JLabel.CENTER);
	    contentPane.add(goiL, BorderLayout.NORTH);
	    
		JLabel titL = new JLabel("SPACE INVADER");
		titL.setFont(new Font("Arial", Font.BOLD, 100));
		titL.setForeground(Color.YELLOW);
		titL.setHorizontalAlignment(JLabel.CENTER);
		titL.setIcon(iconoAlien);
		titL.setHorizontalTextPosition(JLabel.CENTER);
		titL.setVerticalTextPosition(JLabel.BOTTOM);
		contentPane.add(titL, BorderLayout.CENTER);
		
		JLabel beheL = new JLabel("Press <ENTER> to start the game");
		beheL.setFont(new Font("Arial", Font.BOLD, 20));
		beheL.setForeground(Color.WHITE);
		beheL.setHorizontalAlignment(JLabel.CENTER);
	    contentPane.add(beheL, BorderLayout.SOUTH);
	    
	    this.setFocusable(true); 
		this.requestFocusInWindow();
		
		this.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					MatrizeV mV= new MatrizeV();
					mV.setVisible(true);
					dispose();
					JokoKudeatzailea.getnJokoKudeatzailea().jokoaHasieratu();
				}
			}
		});
	}
}
