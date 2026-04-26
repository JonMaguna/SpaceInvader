package modelo;

import java.awt.Color; 

public class Bala extends Entitate{
	public Bala(int x, int y, int id) {
		super(x, y, id, true);
	}
	public boolean mugituDaiteke(Mugimendua mugimendua) {
    	boolean mugitu = true;
    	if(this.koordenatu[0][1]<=1 || this.koordenatu[0][1]>=119) {
			return false;
		}
    	for(int i=0; i < this.koordenatu.length; i++) {
    		int xHurrengoa = this.koordenatu[i][0];
    		int yHurrengoa = this.koordenatu[i][1];
    		switch(mugimendua) {
	 		case GORA:
    			yHurrengoa -= 1;
    			break;
    		case BEHERA:
	 			yHurrengoa += 1;
	 			break;
     		case ESKUMA:
     			xHurrengoa += 1;
     			break;
     		case EZKERRA:
     			xHurrengoa -= 1;
     			break;
     		default:
     			break;
    		}
        	int[][] Hurrengoa = {{xHurrengoa, yHurrengoa}};
        	EntitateMota entitatea = MatrizeM.getnMatrizeM().zerDago(Hurrengoa);
       		int BesteId = MatrizeM.getnMatrizeM().zeinIDDago(Hurrengoa);
        	if(entitatea != null) { 
        		switch (entitatea) {
        		case ETSAIA:
        		    if (mugimendua == Mugimendua.GORA) {
        		        EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ETSAIA, BesteId, false); 
        		        mugitu = false;
        		        setBizirik(false);
        		    }
        		    break;
        		case BALA:
        			if(BesteId != this.id) {
        			EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.BALA, BesteId, false);
        			mugitu = false;
        			setBizirik(false);
        			}
        			break;
        		case ESPAZIONTZI:
    				EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ESPAZIONTZI, 1, false);
    			    mugitu = false;
    	            break;
        		default:			
        			break;
        			}
        		}
        	}
    	return mugitu;
    	}
	
    public void mugitu(Mugimendua mugimendua) {
    	switch(mugimendua){
     	case ESKUMA:
     		this.koordenatu[0][0] += 1;
            this.x = this.koordenatu[0][0];
     		break;
     	case EZKERRA:
     		this.koordenatu[0][0] -= 1;
            this.x = this.koordenatu[0][0];
            break; 
     	case GORA:
     		this.koordenatu[0][1] -= 1;
            this.y = this.koordenatu[0][1];
            break; 
     	case BEHERA:
	 		this.koordenatu[0][1] += 1;
			this.y = this.koordenatu[0][1];
			System.out.println("Soy la bala enemiga y estoy cayendo por la Y: " + this.y);
			break;             
     	default:
     		break;
    	} 
    }
}