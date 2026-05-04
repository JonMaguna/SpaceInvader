package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;
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
		setBounds(100, 100, 3000, 2000); 
		contentPane = new Fondoa("/img/k_p-2.png");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//JokoKudeatzailea.getnJokoKudeatzailea().addObserver(this);
		
		JPanel contenedorTextos = new JPanel();
		contenedorTextos.setLayout(new javax.swing.BoxLayout(contenedorTextos, javax.swing.BoxLayout.Y_AXIS));
		contenedorTextos.setOpaque(false);
		
		contenedorTextos.setBorder(new EmptyBorder(530, -20, 0, 0));
		
		aukeraL = new JLabel("SHIP: 1");
		aukeraL.setFont(new Font("Arial", Font.BOLD, 35));
		aukeraL.setForeground(Color.RED);
		aukeraL.setAlignmentX(JLabel.CENTER_ALIGNMENT);

		contenedorTextos.add(aukeraL);
		
		contentPane.add(contenedorTextos, BorderLayout.CENTER);
	    
	    this.setFocusable(true); 
		this.requestFocusInWindow();
		
		this.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				switch(code) {
					case KeyEvent.VK_ESCAPE:
						System.exit(0);
						break;
					case KeyEvent.VK_1:
						aukeratutakoOntzia=1;
						aukeraL.setText("SHIP: 1");
						aukeraL.setForeground(Color.RED);
						break;
					case KeyEvent.VK_2:
						aukeratutakoOntzia=2;
						aukeraL.setText("SHIP: 2");
						aukeraL.setForeground(Color.BLUE);
						break;
					case KeyEvent.VK_3:
						aukeratutakoOntzia=3;
						aukeraL.setText("SHIP: 3");
						aukeraL.setForeground(Color.GREEN);
						break;
					case KeyEvent.VK_ENTER:
						JokoKudeatzailea.getnJokoKudeatzailea().addObserver(LeihoNagusiaV.this);
						JokoKudeatzailea.getnJokoKudeatzailea().jokoaHasieratu(aukeratutakoOntzia);
						dispose();
						break;
				}
			}
		});
	}
	
	public void update(Observable o, Object arg) {
		if(arg == null) {
			MatrizeV m = new MatrizeV();
			m.setVisible(true);
		}else {
			int argInt = (int) arg;
			if(argInt == 99) {
				dispose();
			}
		}
	}
}
