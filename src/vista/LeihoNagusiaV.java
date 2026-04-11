package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.JokoKudeatzailea;

public class LeihoNagusiaV extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int aukeratutakoOntzia=1;
	private JLabel aukeraL;

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
		JokoKudeatzailea.getnJokoKudeatzailea().addObserver(this);
		
		java.net.URL imgUrl = getClass().getResource("/img/alien2.png");
		ImageIcon iconoOriginal = new ImageIcon(imgUrl);
		java.awt.Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
		ImageIcon iconoAlien = new ImageIcon(imagenEscalada);
		
		JLabel goiL = new JLabel("Press <UP,LEFT,DOWN,RIGHT> or <W,A,S,D> to move, <SPACE> to shoot, <Shift> to change bullets");
		goiL.setFont(new Font("Arial", Font.BOLD, 20));
		goiL.setForeground(Color.WHITE);
		goiL.setHorizontalAlignment(JLabel.CENTER);
	    contentPane.add(goiL, BorderLayout.NORTH);
	    
		JLabel titL = new JLabel("SPACE INVADERS");
		titL.setFont(new Font("Arial", Font.BOLD, 100));
		titL.setForeground(Color.YELLOW);
		titL.setHorizontalAlignment(JLabel.CENTER);
		titL.setIcon(iconoAlien);
		titL.setHorizontalTextPosition(JLabel.CENTER);
		titL.setVerticalTextPosition(JLabel.BOTTOM);
		contentPane.add(titL, BorderLayout.CENTER);
		
		JPanel behekoPanela = new JPanel(new BorderLayout());
		behekoPanela.setBackground(Color.BLACK);
		
		aukeraL = new JLabel("Aukeratutako ontzia: 1");
		aukeraL.setFont(new Font("Arial", Font.BOLD, 20));
		aukeraL.setForeground(Color.RED);
		aukeraL.setHorizontalAlignment(JLabel.CENTER);
		behekoPanela.add(aukeraL, BorderLayout.NORTH);
		
		JLabel infoL = new JLabel("Press <1>, <2> or <3> to select your ship and press <ENTER> to start the game");
		infoL.setFont(new Font("Arial", Font.BOLD, 20));
		infoL.setForeground(Color.WHITE);
		infoL.setHorizontalAlignment(JLabel.CENTER);
		behekoPanela.add(infoL, BorderLayout.CENTER);	
		
		
	    contentPane.add(behekoPanela, BorderLayout.SOUTH);
	    
	    this.setFocusable(true); 
		this.requestFocusInWindow();
		
		this.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				if(code == KeyEvent.VK_1) {
					aukeratutakoOntzia=1;
					aukeraL.setText("Aukeratutako ontzia: 1");
					aukeraL.setForeground(Color.RED);
				}
				else if(code == KeyEvent.VK_2) {
					aukeratutakoOntzia=2;
					aukeraL.setText("Aukeratutako ontzia: 2");
					aukeraL.setForeground(Color.BLUE);
				}
				else if(code == KeyEvent.VK_3) {
					aukeratutakoOntzia=3;
					aukeraL.setText("Aukeratutako ontzia: 3");
					aukeraL.setForeground(Color.GREEN);
				}
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					JokoKudeatzailea.getnJokoKudeatzailea().jokoaHasieratu(aukeratutakoOntzia);
				}
			}
		});
	}

	public void update(Observable o, Object arg) {
		if(arg == null) {
			MatrizeV m = new MatrizeV();
		m.setVisible(true);
			dispose();
		}
	}
}
