package modelo;

public class Etsaia_M implements Egoera_G{
	
	public void gelaxkaEguneratu(GelaxkaM pGelaxka) {
		EntitateMota entitatea = pGelaxka.zerDago();
		if(entitatea== EntitateMota.ETSAIA) {}
		else {
			pGelaxka.setEntitate(EntitateMota.ETSAIA, 0);
		}
	}
}
