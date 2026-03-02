package modelo;

import java.util.Observable;

public class GelaxkaM extends Observable {
	private int koordenatuaX;
	private int koordenatuaY;
	//private EntitateMota entitate;
	
	public GelaxkaM(int koordenatuaX, int koordenatuaY){//, EntitateMota entitate) {
		this.koordenatuaX = koordenatuaX;
		this.koordenatuaY = koordenatuaY;
		//this.entitate = entitate;
	}
	
	public int getKordenatuaX() { return koordenatuaX; }
	
	public int getKoordenatuaY() { return koordenatuaY; }
	
	public EntitateMota zerDago() { return this.entitate; }
	
	public void setEntitate(EntitateMota entitate){ 
		this.entitate = entitate;
		setChanged();	
		notifyObservers();
	}
=======
public class GelaxkaM {

>>>>>>> Jonzeta
}
