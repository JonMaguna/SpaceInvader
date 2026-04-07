package modelo;

import java.util.Observable;

public class GelaxkaM extends Observable {
    private int kordenatuaX;
    private int kordenatuaY;
    private int id;
    
    private Egoera_G gelaxka_mota; 
    
    public GelaxkaM(int kordenatuaX, int kordenatuaY){
        this.kordenatuaX = kordenatuaX;
        this.kordenatuaY = kordenatuaY;
        this.id = 0;
        this.gelaxka_mota = new Hutsa_M(); 
    }
    
    public int getKordenatuaX() { return kordenatuaX; }
    public int getKordenatuaY() { return kordenatuaY; }
    
    public EntitateMota zerDago() { return this.gelaxka_mota.getEntitateMota();}
    
    public int zeinDago() { return this.id; }
    
    public void setId(int id) { this.id = id; }
    
    public void setEntitate(EntitateMota entitate, int id){ 
        Egoera_G egoeraBerria= new Hutsa_M();
        switch(entitate) {
            case BALA: egoeraBerria = new Bala_M(); break;
            case ETSAIA: egoeraBerria = new Etsaia_M(); break;
            case ESPAZIONTZI: egoeraBerria = new Espaziontzia_M(); break;
            case HUTSA: egoeraBerria = new Hutsa_M(); break;
        }
        egoeraAldatu(egoeraBerria, id);
    }
    
    public void egoeraAldatu(Egoera_G pEgoera, int id) {
        this.gelaxka_mota = pEgoera;
        this.gelaxka_mota.gelaxkaEguneratu(this, id);
    }

    public void aldaketaNotifikatu(EntitateMota e) {
        setChanged();	
        notifyObservers(e);
    }

	public int getID() { return this.id; }
}