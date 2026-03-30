package modelo;

public class Etsaia_M implements Egoera_G{
	
	@Override
    public void gelaxkaEguneratu(GelaxkaM pGelaxka, int id) {
        pGelaxka.setId(id);
        pGelaxka.aldaketaNotifikatu(getEntitateMota());
    }

    @Override
    public EntitateMota getEntitateMota() {
        return EntitateMota.ETSAIA;
    }
}
