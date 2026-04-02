package modelo;
public class Bala extends Entitate implements Runnable{
	private Thread ThreadBala;
	
	public Bala(int x, int y, int id) {
		super(x, y, id, true);
		
		this.ThreadBala = new Thread(this);
		this.ThreadBala.start();
	}
	
    public void run() {
        while (bizirik && JokoKudeatzailea.getnJokoKudeatzailea().getJokoanDa()) { 
            try {
                Thread.sleep(50);
                MatrizeM.getnMatrizeM().mugituBalaBakarra(this);
            } catch (InterruptedException e) {
                this.bizirik = false;
            }
        }
        this.bizirik = false;
    }
    
	public void setActive(boolean active) {this.bizirik = active;}
}