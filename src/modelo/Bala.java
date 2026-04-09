package modelo;

public class Bala extends Entitate{
	
	public Bala(int x, int y, int id) {
		super(x, y, id, true);
	}
	
	public boolean mugituDaiteke(Mugimendua mugimendua) {
    	boolean mugitu = true;
    	EntitateMota entitatea = null;
    	int id = 0;

    	if(this.koordenatu[0][1] <= 1) { 
            mugitu = false;
            setBizirik(false); 
    	} else {
    		entitatea = MatrizeM.getnMatrizeM().zerDago(this.koordenatu);
    		id = MatrizeM.getnMatrizeM().zeinIDDago(this.koordenatu);
    	}
        
    	if(mugitu && entitatea != null) { 
			switch (entitatea) {
			case ETSAIA:
			    mugitu = false;
			    this.setBizirik(false);
			    int[][] hitbox = {{this.koordenatu[0][0], this.koordenatu[0][1] - 1}};
			    int etsaiId = MatrizeM.getnMatrizeM().zeinIDDago(hitbox);
			    EntitateKolekzio.getnPertsonaiZerrenda().setBizirik(EntitateMota.ETSAIA, etsaiId, false);
			    break;
			case BALA:
				if(id != this.id) {
					mugitu = false;
				}
				break;
			default:			
				break;
			}
		}
    	return mugitu;
    }
    
    public void mugitu(Mugimendua mugimendua) {
    	this.koordenatu[0][1] -= 1;
        this.y = this.koordenatu[0][1]; 
    }
}