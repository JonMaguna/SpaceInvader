package modelo;

public class Espaziontzi extends Entitate {
	
	public Espaziontzi(int gelaxkak, int id,  boolean bizirik) {
		super(gelaxkak, id, bizirik);
	}
	public void setBizirik(boolean bizirik) {
		this.bizirik = bizirik;
		if (!bizirik) {
			JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu();
		}
	}
}
