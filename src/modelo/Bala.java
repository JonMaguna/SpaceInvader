package modelo;
public class Bala extends Pertsonai implements Runnable{
	private boolean balaOK;
	private Thread ThreadBala;
	
	public Bala(int x, int y) {
		super(x, y, true);
		this.balaOK= true;
		
		this.ThreadBala= new Thread(this);
		this.ThreadBala.start();
	}
	
	@Override
    public void run() {
        while (balaOK) { 
            try {
                Thread.sleep(50);
                this.y --; 
                if (this.y<= 0) {
                	this.balaOK = false;             
                }
            } catch (InterruptedException e) {
                this.balaOK = false; 
            }
        }
    }
	
	
	public int getX() {return x;}
	public int getY() {return y;}
	public boolean isActive() {return balaOK;}
	public void setActive(boolean active) {this.balaOK= active;}

	@Override
	public Integer[] lortuEgoera() {
		return new Integer[] {0,0,1,0};
	}

	@Override
	public void mugitu(Mugimendua m) {
 		
	}
}