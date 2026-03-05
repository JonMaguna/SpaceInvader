package modelo;

import java.util.Observable;

public class Espaziontzia extends Observable {
    private int x;
    private int y;
    private int abiadura;
    
    public Espaziontzia(int x, int y) {
        this.x = x;
        this.y = y;
        this.abiadura = 1;
    }
    
    public void mugitu(String pNorabidea) {
        if(pNorabidea.equals("GORA")) { y -= abiadura; }
        else if(pNorabidea.equals("BEHERA")) { y += abiadura; }
        else if(pNorabidea.equals("ESKUINA")) { x += abiadura; }
        else if(pNorabidea.equals("EZKERRA")) { x -= abiadura; }
        setChanged();
        notifyObservers();
    }
    
    public void disparatu(String bala) {
    	if(bala.equals("OK")) {
    		int xBal= this.x;
        	int yBal= this.y;
        	Bala b= new Bala(xBal, yBal+1);
        	b.run();
        	setChanged();
        	notifyObservers();
    	}
    }
    
    public int getXposizioa() {return x;}
    public int getYposizioa() {return y;}
}