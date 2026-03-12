package modelo;
public class Bala extends Entitate implements Runnable{
	private boolean balaOK;
	private Thread ThreadBala;
	
	public Bala(int gelaxkak, int id) {
		super(gelaxkak, id, true);
		
		this.balaOK = true;
		this.ThreadBala = new Thread(this);
		this.ThreadBala.start();
	}
	
	/*public int[][] getHitBox() {
		return this.hitBox;
	}
	
	public void setHitBox(int[][] hitBox) {
		this.hitBox = hitBox;
	}
	*/
    public void run() {
        while (balaOK && JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) { 
            try {
                Thread.sleep(50);
                MatrizeM.getnMatrizeM().mugituBalaBakarra(this);
            } catch (InterruptedException e) {
                this.balaOK = false;
            }
        }
        this.balaOK = false;
    }
    
	public void setActive(boolean active) {this.balaOK = active;}
}