package modelo;

import java.util.Observable;

public class GelaxkaM extends Observable {
    private int id;
    
    private Egoera_G gelaxka_mota; 
    
    public GelaxkaM(){
        this.id = 0;
        this.gelaxka_mota = new Hutsa_M(); 
    }
    
    public EntitateMota zerDago() { return this.gelaxka_mota.getEntitateMota();}
    
    public int zeinDago() { return this.id; }
    
    public void setEntitate(EntitateMota entitate, int id){ 
        Egoera_G egoeraBerria= new Hutsa_M();
        switch(entitate) {
            case BALA: egoeraBerria = new Bala_M(); break;
            case ETSAIA: egoeraBerria = new Etsaia_M(); break;
            case ESPAZIONTZI: egoeraBerria = new Espaziontzia_M(); break;
            case HUTSA: egoeraBerria = new Hutsa_M(); break;
        }
        this.gelaxka_mota = egoeraBerria;
        this.id = id;
        aldaketaNotifikatu();
    }

    private void aldaketaNotifikatu() {
        setChanged();	
        notifyObservers(this.gelaxka_mota.getEntitateMota());
    }

	public int getID() { return this.id; }
}