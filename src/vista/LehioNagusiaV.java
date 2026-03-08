package vista;

import java.util.Observable;
import java.util.Observer;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.MatrizeM;

import java.awt.CardLayout;

public class LehioNagusiaV extends JFrame implements Observer{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MatrizeV matrizea;
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
	    MatrizeM.getnMatrizeM().addObserver(this);
	    CardLayout diseinua = new CardLayout();
	    contentPane = new JPanel(diseinua); 
	    setContentPane(contentPane);
	    JPanel hasieraPanela = new JPanel(); 
	    matrizea = new MatrizeV();         
	    contentPane.add(hasieraPanela, "MENUA");
	    contentPane.add(matrizea, "JOKOA");
	    pack();
	    setLocationRelativeTo(null);
	}

	@Override
	public void update(Observable o, Object arg) {
		matrizea.repaint(); 
		
	}

}
