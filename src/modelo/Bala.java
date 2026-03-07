package modelo;
public class Bala extends Entitate implements Runnable{
	private boolean balaOK;
	private Thread ThreadBala;
	
	public Bala(int gelaxkak, int id) {
		super(gelaxkak, id, true);
		
		this.balaOK = true;
		this.ThreadBala= new Thread(this);
		this.ThreadBala.start();
	}
	
	public int[][] getHitBox() {
		return this.hitBox;
	}
	
	public void setHitBox(int[][] hitBox) {
		this.hitBox = hitBox;
	}
	
    public void run() {
        while (balaOK) { 
            try {
                Thread.sleep(50);
                MatrizeM.getnMatrizeM().balaMugitu();
            } catch (InterruptedException e) {
                this.balaOK = false; 
            }
        }
    }
	
	public boolean isActive() {return balaOK;}
	public void setActive(boolean active) {this.balaOK = active;}
}