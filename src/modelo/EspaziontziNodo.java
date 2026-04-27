package modelo;

import java.util.ArrayList;
import java.awt.Color;

public abstract class EspaziontziNodo extends Entitate {
	protected TiroEstrategia tiroEstrategia;
    protected ArrayList<Entitate> gelaxkak = new ArrayList<>();
    protected int bala = 1;
    protected int bala2 = 0;
    protected Color kolorea;

    public EspaziontziNodo(int x, int y, int id) {
        super(x, y, id, true);
    }    
    
    public ArrayList<Entitate> getGelaxkak() {
        return this.gelaxkak;
    }
    
    public boolean mugituDaiteke(Mugimendua m) {
    	return this.gelaxkak.stream()
    			.filter(pixel -> !pixel.mugituDaiteke(m))
    			.findFirst()
    			.map(pixel -> {
    				if (!pixel.bizirik()) {
						this.setBizirik(false); 
					}
					return false;
    			})
				.orElse(true);
    }
    
    @Override
    public void mugitu(Mugimendua m) {
        if (this.mugituDaiteke(m)) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, 0, EntitateMota.HUTSA);
            for (Entitate pixel : this.gelaxkak) {
                pixel.mugitu(m);
            }
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(this.gelaxkak, this.getId(), EntitateMota.ESPAZIONTZI);
            this.eguneratuPosizioNagusia(m);
        }
    }
    
    protected void eguneratuPosizioNagusia(Mugimendua m) {
        switch(m) {
            case EZKERRA: this.setX(this.getX() - 1); break;
            case ESKUMA:  this.setX(this.getX() + 1); break;
            case GORA:    this.setY(this.getY() - 1); break;
            case BEHERA:  this.setY(this.getY() + 1); break;
            default: break;
        }
    }
    
    public void setBizirik(boolean bizirik) {
        this.bizirik = bizirik;
        for (Entitate pixel : gelaxkak) {
            pixel.setBizirik(bizirik);
        }
        if(!bizirik) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);
        }
    }
    public Color getKolorea() {
        return this.kolorea;
    }
	public void nextBala() {
		this.tiroEstrategia.nextBala(this);
	}
	
	public BalaNodo tiroEgin(int id) {
		return this.tiroEstrategia.tiroEgin(this, id);
	}

	public void setBala(int bala) {
		this.bala = bala;
	}
	public int getBala() {
		return this.bala;
	}
	public void setBala2(int bala) {
		this.bala2 = bala;
	}
	public int getBala2() {
		return this.bala2;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
