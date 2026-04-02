package modelo;

import java.util.ArrayList;
import java.util.List;

public class EspaziontziNodo extends Entitate{
	private List<Espaziontzi> gelaxkak = new ArrayList<>();
	private Espaziontzi nagusi;

	public EspaziontziNodo(int x, int y, int[][] koordenatuak, int id) {
		super(x, y, id, true);
		for (int i = 0; i < koordenatuak.length; i++) {
			this.gelaxkak.add(new Espaziontzi(koordenatuak[i][0], koordenatuak[i][1], id));
			if (koordenatuak[i][0] == x && koordenatuak[i][1] == y) {
				this.nagusi = this.gelaxkak.get(i);
			}
		}
	}
	
	public void mugitu(Mugimendua mugimendu) {
		boolean mugituDaiteke = true;
		int i = 0;
		while(i < this.gelaxkak.size() && mugituDaiteke){
			mugituDaiteke = this.gelaxkak.get(i).mugituDaiteke(mugimendu);
			if(!this.gelaxkak.get(i).bizirik()) {
				this.bizirik = false;
				JokoKudeatzailea.getnJokoKudeatzailea().jokoaGelditu(1);
			}
			i++;
		}
		if(mugituDaiteke) {
			for (Espaziontzi gelaxka : this.gelaxkak) {
				gelaxka.mugitu(mugimendu);
			}
		}
	}
}
