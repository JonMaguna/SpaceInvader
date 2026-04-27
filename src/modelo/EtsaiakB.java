package modelo;

public class EtsaiakB extends EtsaiNodo implements Runnable{
	private Thread threadKamikaze;
	protected volatile boolean bizirik = true;
	
    protected EtsaiakB(int x, int y, int id) {
        super(x, y, new int[][]{ {0, 0},{-1, 0},{1, 0},{0, 1} }, id);
    }
    
    public void banzai() {
    	if(JokoKudeatzailea.getnJokoKudeatzailea().kamikazerik() && MatrizeM.getnMatrizeM().etsairikAurrean(this.gelaxkak)) {
        	this.threadKamikaze = new Thread(this);
            this.threadKamikaze.start();
            JokoKudeatzailea.getnJokoKudeatzailea().setKamikaze(true);
    	}
    }

	@Override
	public void run() {
		
		
	}
    
    
}
