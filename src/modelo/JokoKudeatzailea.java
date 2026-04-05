package modelo;

import java.util.Observable;


public class JokoKudeatzailea extends Observable{
	private boolean jokoanDa = false;
	private static JokoKudeatzailea jokonKudeatzailea = null;
	
	private JokoKudeatzailea() {}
	
	public static JokoKudeatzailea getnJokoKudeatzailea() {
		if(jokonKudeatzailea == null) {jokonKudeatzailea = new JokoKudeatzailea();}
		return jokonKudeatzailea;
	}
	
	public void jokoaHasieratu(int pMota) {
		if(!jokoanDa){
			jokoanDa = true;
			setChanged();
			notifyObservers();
			MatrizeM.getnMatrizeM().SortuMatrizea();
			setChanged();
			notifyObservers(0);
			EntitateKolekzio.getnPertsonaiZerrenda().sortuEntitateak(pMota);
			MatrizeM.getnMatrizeM().EtsaienMugimendua();
		}
	}
		
	public boolean getJokoanDa() {
		return this.jokoanDa;
	}
	
	public void jokoaGelditu(int mezua) {
		this.jokoanDa = false;
		setChanged();
		notifyObservers(mezua);
	}
}
