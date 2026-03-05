package vista;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.CardLayout;

public class LehioNagusiaV extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MatrizeaV matrizea;
	private JButton btnJolastu;
	private CardLayout diseinua;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LehioNagusiaV frame = new LehioNagusiaV();
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
	public LehioNagusiaV() {
	    setTitle("Space Invaders");
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);
	    MatrizeM.getMatrizea().addObserver(this);
	    CardLayout diseinua = new CardLayout();
	    contentPane = new JPanel(diseinua); 
	    setContentPane(contentPane);
	    JPanel hasieraPanela = new JPanel(); 
	    matrizea = new MatrizeaV();         
	    contentPane.add(hasieraPanela, "MENUA");
	    contentPane.add(matrizea, "JOKOA");
	    JokoKontrolatzailea kontrolatzailea = new JokoKontrolatzailea();
	    this.addKeyListener(kontrolatzailea);
	    this.btnJolastu = new JButton("Jolastu");
	    hasieraPanela.add(btnJolastu);
		btnJolastu.addActionListener(kontrolatzailea);
	    pack();
	    setLocationRelativeTo(null);
	}

	@Override
	public void update(Observable o, Object arg) {
		matrizea.repaint(); 
		
	}

}
