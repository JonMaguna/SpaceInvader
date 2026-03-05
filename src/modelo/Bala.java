package modelo;

import java.util.Observable;

public class Bala extends Observable implements Runnable{
	private int x;
	private int y;
	private boolean balaOK;
	private Thread ThreadBala;
	
	public Bala(int x, int y) {
		this.x= x;
		this.y= y;
		this.balaOK= true;
		
		this.ThreadBala= new Thread(this);
		this.ThreadBala.start();
	}
	
	@Override
    public void run() {
        while (balaOK) {
            this.y --; 
            if (this.y<= 0) {
                this.balaOK = false;             
                setChanged();
                notifyObservers();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                this.balaOK = false; 
            }
            }
        }
	}
	
	public int getX() {return x;}
	public int getY() {return y;}
	public boolean isActive() {return balaOK;}
	public void setActive(boolean active) {this.balaOK= active;}
}