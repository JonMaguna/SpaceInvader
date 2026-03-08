package modelo;

import java.util.Scanner;

import vista.MatrizeV;

public class JokoKudeatzailea {
	private boolean jokoanDa = false;
	private static JokoKudeatzailea instantzia= null;
	
	private JokoKudeatzailea() {}
	
	public static JokoKudeatzailea getnJokoKudeatzailea() {
		if(instantzia==null) {instantzia= new JokoKudeatzailea();}
		return instantzia;
	}
	
	public void jokoaHasieratu() {
		MatrizeM m = MatrizeM.getnMatrizeM();
		EntitateKolekzio e = EntitateKolekzio.getnPertsonaiZerrenda();
		if(!jokoanDa){
			m.SortuMatrizea();
			e.sortuEntitateak();
			jokoanDa = true;
		}
	}
	
	public void etsaiakBuk() {
		System.exit(0);
	}
}
