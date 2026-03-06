package modelo;

import java.util.Observable;

public class GelaxkaM extends Observable {
	private int koordenatuaX;
	private int koordenatuaY;
	private EntitateMota entitate;
	
	public GelaxkaM(int koordenatuaX, int koordenatuaY){
		this.koordenatuaX = koordenatuaX;
		this.koordenatuaY = koordenatuaY;
		if(koordenatuaX== 50 && koordenatuaY== 55) {
			this.entitate = EntitateMota.ESPAZIONTZI;
		}else {
			this.entitate = null;
		}
	}
	
	public int getKordenatuaX() { return koordenatuaX; }
	
	public int getKoordenatuaY() { return koordenatuaY; }
	
	public EntitateMota zerDago() { return this.entitate; }
	
	public void setEntitate(EntitateMota entitate){ 
		this.entitate = entitate;
		setChanged();	
		notifyObservers();
	}
}