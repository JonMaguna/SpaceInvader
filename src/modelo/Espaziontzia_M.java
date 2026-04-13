package modelo;
import java.awt.Color;

public class Espaziontzia_M implements Egoera_G {
    public EntitateMota getEntitateMota() { return EntitateMota.ESPAZIONTZI; }
    public Color getColor() { 
        return EspaziontziFactory.getNireEspaziontziFactory().getAzkenKolorea(); 
    }
}