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

import javax.swing.Box;
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
		setBounds(100, 100, 3000, 2000); 
		contentPane = new Fondoa();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//JokoKudeatzailea.getnJokoKudeatzailea().addObserver(this);
		
		JPanel contenedorTextos = new JPanel();
		contenedorTextos.setLayout(new javax.swing.BoxLayout(contenedorTextos, javax.swing.BoxLayout.Y_AXIS));
		contenedorTextos.setOpaque(false);
		
		contenedorTextos.setBorder(new EmptyBorder(530, -20, 0, 0));
		
		aukeraL = new JLabel("AUKERATUTAKO ONTZIA: 1");
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
					case KeyEvent.VK_1:
						aukeratutakoOntzia=1;
						aukeraL.setText("AUKERATUTAKO ONTZIA: 1");
						aukeraL.setForeground(Color.RED);
						break;
					case KeyEvent.VK_2:
						aukeratutakoOntzia=2;
						aukeraL.setText("AUKERATUTAKO ONTZIA: 2");
						aukeraL.setForeground(Color.BLUE);
						break;
					case KeyEvent.VK_3:
						aukeratutakoOntzia=3;
						aukeraL.setText("AUKERATUTAKO ONTZIA: 3");
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
	
	private class Fondoa extends JPanel {
        private Image irudia;

        public Fondoa() {
            java.net.URL imgUrl = getClass().getResource("/img/k_p-2.png");
            if (imgUrl != null) {
                irudia = new ImageIcon(imgUrl).getImage();
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
