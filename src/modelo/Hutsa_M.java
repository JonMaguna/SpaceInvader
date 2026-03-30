package modelo;

public class Hutsa_M implements Egoera_G{
	
	public void gelaxkaEguneratu(GelaxkaM pGelaxka) {
		EntitateMota entitatea = pGelaxka.zerDago();
		if(entitatea== EntitateMota.HUTSA) {}
		else {
			pGelaxka.setEntitate(EntitateMota.HUTSA, 0);
		}
	}
}
