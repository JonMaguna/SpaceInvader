package modelo;

public class JokoKudeatzailea {
	private boolean jokoanDa = false;
	private static JokoKudeatzailea jokonKudeatzailea = null;
	
	private JokoKudeatzailea() {}
	
	public static JokoKudeatzailea getnJokoKudeatzailea() {
		if(jokonKudeatzailea == null) {jokonKudeatzailea = new JokoKudeatzailea();}
		return jokonKudeatzailea;
	}
	
	public void jokoaHasieratu() {
		MatrizeM m = MatrizeM.getnMatrizeM();
		EntitateKolekzio e = EntitateKolekzio.getnPertsonaiZerrenda();
		if(!jokoanDa){
			jokoanDa = true;
			m.SortuMatrizea();
			e.sortuEntitateak();
			m.EtsaienMugimendua();
		}
	}
		
	public boolean getJokoanDa() {
		return this.jokoanDa;
	}
	
	public void jokoaGelditu() {
		this.jokoanDa = false;
	}
}
