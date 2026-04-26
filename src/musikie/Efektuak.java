package musikie;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javax.sound.sampled.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field; 

public class Efektuak {
    private Player player;
    private Thread musika;
    private float bolumena = -10.0f;

    public void erreproduzidu(String rutaArchivo) {
        detener();
        try {
            FileInputStream fis = new FileInputStream(rutaArchivo);
            player = new Player(fis);

            musika = new Thread(() -> {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            });
            musika.setDaemon(true);
            musika.start();
            
            try { Thread.sleep(100); } catch (Exception e) {}
            setVolumen(bolumena);

        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void setVolumen(float volumen) {
        this.bolumena = volumen;
        if (player == null) return;

        try {
            Field deviceField = Player.class.getDeclaredField("audio");
            deviceField.setAccessible(true);
            Object device = deviceField.get(player);
            
            Field sourceField = device.getClass().getDeclaredField("source");
            sourceField.setAccessible(true);
            SourceDataLine line = (SourceDataLine) sourceField.get(device);

            if (line != null && line.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                FloatControl gainControl = (FloatControl) line.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(volumen); 
            }
        } catch (Exception e) {
            System.err.println("No se pudo ajustar el volumen: " + e.getMessage());
        }
    }

    public void detener() {
        if (player != null) {
            player.close();
            player = null;
        }
    }
}