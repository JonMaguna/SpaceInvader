package modelo;

public class Bala extends Entitate{
	
	public Bala(int x, int y, int id) {
		super(x, y, id, true);
	}
	
	public boolean mugituDaiteke(Mugimendua mugimendua) {
    	EntitateKolekzio ek = EntitateKolekzio.getnPertsonaiZerrenda();
    	MatrizeM m = MatrizeM.getnMatrizeM();
    	boolean mugitu = true;
    	EntitateMota entitatea = null;
    	int id = 0;

    	if(this.koordenatu[0][1] <= 1) { 
            mugitu = false;
            setBizirik(false);             
            GelaxkaM gM = m.getGelaxka(this.koordenatu[0][0], this.koordenatu[0][1]);
            gM.egoeraAldatu(new Hutsa_M(), 0);
            
    	} else {
    		entitatea = m.zerDago(this.koordenatu);
    		id = m.zeinIDDago(this.koordenatu);
    	}
        
    	if(mugitu && entitatea != null) { 
			switch (entitatea) {
			case ETSAIA:
				mugitu = false;
				setBizirik(false);
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