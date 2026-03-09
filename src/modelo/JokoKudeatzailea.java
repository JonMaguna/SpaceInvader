package modelo;

import javax.swing.JOptionPane;

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
		if(jokoanDa){
			jokoaGelditu();
		} else {
			jokoanDa = true;
			m.SortuMatrizea();
			e.sortuEntitateak();
			m.EtsaienMugimendua();
		}
	}
		
	public boolean getJokoanDa() {
		return this.jokoanDa;
	}
	
	public void jokoaGaldu() {
		this.jokoanDa = false;
	}
	
	public void jokoaIrabazi() {
		this.jokoanDa = false;
	}
	
	public void jokoaGelditu() {
		this.jokoanDa = false;
	}
}
