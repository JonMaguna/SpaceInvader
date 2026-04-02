package modelo;

import java.util.ArrayList;
import java.util.List;

public class BalaNodo extends Entitate{
	
	private List<Bala> gelaxkak = new ArrayList<>();
	private Bala nagusi;

	public BalaNodo(int x, int y, int[][] koordenatuak, int id) {
		super(x, y, id, true);
		for (int i = 0; i < koordenatuak.length; i++) {
			this.gelaxkak.add(new Bala(koordenatuak[i][0], koordenatuak[i][1], id));
			if (koordenatuak[i][0] == x && koordenatuak[i][1] == y) {
				this.nagusi = this.gelaxkak.get(i);
			}
		}
		
		
		
		
		
	}

}
