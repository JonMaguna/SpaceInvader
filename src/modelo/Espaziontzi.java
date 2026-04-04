package modelo;
import java.awt.Color;

public class Espaziontzi extends Entitate {
	private Color kolorea;
	
	public Espaziontzi(int gelaxkak, int id,  boolean bizirik, Color pKolorea) {
		super(gelaxkak, id, bizirik);
		this.kolorea=pKolorea;
		
	}
	public Color getKolorea() {
		return this.kolorea;
	}
	
	public void setBizirik(boolean bizirik) {
		this.bizirik = bizirik;
		if (!bizirik) {
			JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(1);
		}
	}
}
