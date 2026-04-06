package modelo;
public class Bala extends Entitate{
	
	public Bala(int x, int y, int id) {
		super(x, y, id, true);
	}
	
    public boolean mugituDaiteke(Mugimendua mugimendua) {
    	boolean mugitu = true;
    	EntitateMota entitatea = null;
    	int id = 0;

    	if(this.koordenatu[0][1] == 0) { mugitu = false;}
    	else {
    		entitatea = MatrizeM.getnMatrizeM().zerDago(this.koordenatu);
    		id = MatrizeM.getnMatrizeM().zeinIDDago(this.koordenatu);
    	}
    	if(mugitu) { 
			switch (entitatea) {
			case ETSAIA:
				mugitu = false;
				setBizirik(false);
				break;
			case BALA:
				mugitu = false;
				if(id == this.id) {
					mugitu = true;
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
    }
}