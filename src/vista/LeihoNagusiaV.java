package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
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
		contentPane = new PanelConFondo();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//JokoKudeatzailea.getnJokoKudeatzailea().addObserver(this);
		
		JPanel behekoPanela = new JPanel(new BorderLayout());
		behekoPanela.setBackground(Color.BLACK);
		
		aukeraL = new JLabel("Aukeratutako ontzia: 1");
		aukeraL.setFont(new Font("Arial", Font.BOLD, 20));
		aukeraL.setForeground(Color.RED);
		aukeraL.setHorizontalAlignment(JLabel.CENTER);
		behekoPanela.add(aukeraL, BorderLayout.NORTH);
		
		JLabel infoL = new JLabel("Press <1>, <2> OR <3> to select your ship and press <ENTER> to start the game");
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
				switch(code) {
					case KeyEvent.VK_1:
						aukeratutakoOntzia=1;
						aukeraL.setText("Aukeratutako ontzia: 1");
						aukeraL.setForeground(Color.RED);
						break;
					case KeyEvent.VK_2:
						aukeratutakoOntzia=2;
						aukeraL.setText("Aukeratutako ontzia: 2");
						aukeraL.setForeground(Color.BLUE);
						break;
					case KeyEvent.VK_3:
						aukeratutakoOntzia=3;
						aukeraL.setText("Aukeratutako ontzia: 3");
						aukeraL.setForeground(Color.GREEN);
						break;
					case KeyEvent.VK_ENTER:
						JPanel jp = new Karga_pantaila();
						setContentPane(jp);	
						JokoKudeatzailea.getnJokoKudeatzailea().addObserver(LeihoNagusiaV.this);
						JokoKudeatzailea.getnJokoKudeatzailea().jokoaHasieratu(aukeratutakoOntzia);
						break;
				}
			}
		});
	}
	
	private class PanelConFondo extends JPanel {
        private Image imagen;

        public PanelConFondo() {
            java.net.URL imgUrl = getClass().getResource("/img/k_p-1.png");
            if (imgUrl != null) {
                imagen = new ImageIcon(imgUrl).getImage();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (imagen != null) {
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            } else {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    }
	
	public void update(Observable o, Object arg) {
		int argInt = (int) arg;
		if(arg == null) {
			MatrizeV m = new MatrizeV();
			m.setVisible(true);
		}if(argInt == 99) {
			dispose();
		}
	}
}
