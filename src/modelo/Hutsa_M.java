package modelo;

public class Hutsa_M implements Egoera_G{
	
	@Override
    public void gelaxkaEguneratu(GelaxkaM pGelaxka, int id) {
        pGelaxka.setId(0);
        pGelaxka.aldaketaNotifikatu(getEntitateMota());
    }

    @Override
    public EntitateMota getEntitateMota() {
        return EntitateMota.HUTSA;
    }
}
