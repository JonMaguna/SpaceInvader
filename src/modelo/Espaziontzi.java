package modelo;

public class Espaziontzi extends Pertsonai {
	
	public Espaziontzi(int x, int y, boolean bizirik) {
		super(x, y, bizirik);
	}
	
	@Override
	public Integer[] lortuEgoera() {
		return new Integer[] {1,0,0,0};
	}
	
	@Override
	public void mugitu(Mugimendua m) {
	    switch(m) {
	        case GORA:    super.mugituGora(); break;
	        case BEHERA:  super.mugituBehera(); break;
	        case EZKERRA: super.mugituEzkerrera(); break;
	        case ESKUMA:  super.mugituEskumara(); break;
	    }
	}
	public int getXposizioa() {return x;}
    public int getYposizioa() {return y;}
    
    public Bala disparatu() {
        return new Bala(this.x, this.y - 1);
    }
}
