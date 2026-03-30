package modelo;

public class Espaziontzia_M implements Egoera_G{

	public void gelaxkaEguneratu(GelaxkaM pGelaxka) {
		EntitateMota entitatea = pGelaxka.zerDago();
		if(entitatea== EntitateMota.ESPAZIONTZI) {}
		else {
			pGelaxka.setEntitate(EntitateMota.ESPAZIONTZI, 0);
		}
	}
}
