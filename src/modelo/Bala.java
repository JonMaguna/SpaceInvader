package modelo;

public class Bala extends Entitate{
	
	public Bala(int x, int y, int id) {
		super(x, y, id, true);
	}
	
	public boolean mugituDaiteke(Mugimendua mugimendua) {
    	boolean mugitu = true;
    	MatrizeM matrizeM = MatrizeM.getnMatrizeM();
    	if(this.koordenatu[0][1]<=1) { 
			this.setBizirik(false);
			return false;
		}
    	for(int i=0; i < this.koordenatu.length; i++) {
    		int xHurrengoa = this.koordenatu[i][0];
        	int yHurrengoa = this.koordenatu[i][1]-1;
        	int[][] Hurrengoa = {{xHurrengoa, yHurrengoa}};
        	EntitateMota entitatea = MatrizeM.getnMatrizeM().zerDago(Hurrengoa);
       		int BesteId = MatrizeM.getnMatrizeM().zeinIDDago(Hurrengoa);
            
        	if(entitatea != null) { 
        		if(entitatea != null) { 
        			switch (entitatea) {
        			case ETSAIA:
        			    EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ETSAIA, BesteId, false); 
        			    mugitu = false;
        			    setBizirik(false);
        			    break;
        			case BALA:
        				if(BesteId != this.id) {
        					mugitu = false;
        					setBizirik(false);
        				}
        				break;
        			default:			
        				break;
        			}
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