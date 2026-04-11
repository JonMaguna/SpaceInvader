package modelo;

public class Bala extends Entitate{
	
	public Bala(int x, int y, int id) {
		super(x, y, id, true);
	}
	
	public boolean mugituDaiteke(Mugimendua mugimendua) {

    	boolean mugitu = true;
    	EntitateMota entitatea = null;
    	int xHurrengoa = this.koordenatu[0][0];
    	int yHurrengoa = this.koordenatu[0][1]-1;
    	if(yHurrengoa == -1) { 
            this.setBizirik(false);         
            return false;
    	}
    	int[][] Hurrengoa = {{xHurrengoa, yHurrengoa}};
    	entitatea = MatrizeM.getnMatrizeM().zerDago(Hurrengoa);
   		int BesteId = MatrizeM.getnMatrizeM().zeinIDDago(Hurrengoa);
        
    	if(mugitu && entitatea != null) { 
    		if(entitatea != null) { 
    			switch (entitatea) {
    			case ETSAIA:
    			    EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ETSAIA, BesteId, false); 
    			    mugitu = false;
    			    this.setBizirik(false);
    			    break;
    			case BALA:
    				if(BesteId != this.id) {
    					mugitu = false;
    					this.setBizirik(false);
    				}
    				break;
    			default:			
    				break;
    			}
    		}
    	}
     return mugitu;	
    }
	
    public void mugitu(Mugimendua mugimendua) {
    	this.koordenatu[0][1] -= 1;
        this.y = this.koordenatu[0][1]; 
    }
}