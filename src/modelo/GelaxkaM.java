package modelo;

import java.util.Observable;

public class GelaxkaM extends Observable {
	private int kordenatuaX;
	private int kordenatuaY;
	private EntitateMota entitate;
	private int id;
	
	public GelaxkaM(int kordenatuaX, int kordenatuaY){
		this.kordenatuaX = kordenatuaX;
		this.kordenatuaY = kordenatuaY;
		this.id = 0;
		this.entitate = EntitateMota.HUTSA;	
	}
	
	public int getKordenatuaX() { return kordenatuaX; }
	
	public int getKordenatuaY() { return kordenatuaY; }
	
	public EntitateMota zerDago() { return this.entitate; }
	
	public int zeinDago() { return this.id; }
	
	public void setEntitate(EntitateMota entitate, int id){ 
		this.entitate = entitate;
		this.id = id;
		setChanged();	
		notifyObservers();
	}
	public int getEntitateID(EntitateMota entitate, int i) {
		return this.id;
	}
}