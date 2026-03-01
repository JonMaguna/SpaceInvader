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
            // 2. Comprobar si salió de los límites de la matriz
            if (this.y<= 0) {
                this.balaOK = false; // Al ponerla en false, el bucle while terminará
            
                setChanged();
                notifyObservers();
                
            // 3. Dormir el hilo 50 milisegundos 
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // Esto ocurre si alguien interrumpe el hilo de golpe
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
