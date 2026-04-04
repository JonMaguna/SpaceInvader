package modelo;

import java.util.Observable;

public class GelaxkaM extends Observable {
	private int kordenatuaX;
	private int kordenatuaY;
	private EntitateMota entitate;
	private int id;
	private Egoera_G gelaxka_mota;
	
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
		//egoeraAldatu();
		setChanged();	
		notifyObservers(id);
	}
	
	public void egoeraAldatu(Egoera_G pEgoera) {
		gelaxka_mota= pEgoera;
		gelaxka_mota.gelaxkaEguneratu(this);
		setChanged();
		notifyObservers(pEgoera);
	}
}