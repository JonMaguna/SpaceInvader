package modelo;

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
			jokoanDa = true;
			m.SortuMatrizea();
			e.sortuEntitateak();
			m.EtsaienMugimendua();
		}
	}
	
	public void jokoaGaldu() {
		try {
	        Thread.sleep(2000); 
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
		System.exit(0);
	}
	
	public void jokoaIrabazi() {
		try {
	        Thread.sleep(2000); 
	    } catch (InterruptedException e) {
	        Thread.currentThread().interrupt();
	    }
		System.exit(0);
	}
}
