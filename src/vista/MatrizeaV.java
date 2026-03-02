package vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class MatrizeaV extends JFrame {

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
				JPanel panel = new JPanel();
				panel.setLayout(new GridLayout(i, j, 0, 0));
				Border redborder = BorderFactory.createLineBorder(Color.RED, 1);
				panel.setBackground(Color.BLACK);
				panel.setBorder(redborder);
				getContentPane().add(panel);
			}
			
		}

	}

}
