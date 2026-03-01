package kontroladorea;

import javax.swing.Timer;

import modelo.Bala;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JokuKontroladorea {
	
    private List<Bala> balasActivas;
    private Timer timerBala;

    public JokuKontroladorea() {
        this.balasActivas = new ArrayList<>();
        iniciarTimerDisparos();
    }

    private void iniciarTimerDisparos() {
        // El enunciado especifica que el tiro se mueve cada 50 milisegundos 
        int delay = 50; 

        timerBala = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarBalas();
            }
        });
        
        // Arrancamos el reloj
        timerBala.start();
    }

    private void actualizarBalas() {
        // Recorremos la lista de balas activas
        for (int i = 0; i < balasActivas.size(); i++) {
            Bala bala = balasActivas.get(i);
            
            // Le decimos al modelo que calcule su nueva posición
            bala.run();

            // Limpieza: Si la bala se ha desactivado (salió de la pantalla o chocó)
            if (!bala.isActive()) {
                balasActivas.remove(i);
                i--; // Ajustamos el índice del bucle tras eliminar un elemento
            }
        }
        
        // IMPORTANTE: Después de actualizar los modelos, le decimos a la Vista que se repinte
        // vista.repintarPantalla(); 
    }

    /**
     * Este método se llamará cuando el Controller detecte que el jugador
     * ha pulsado la tecla de disparo.
     */
    public void jugadorDispara(int naveX, int naveY) {
        Bala nuevaBala = new Bala(naveX, naveY);
        balasActivas.add(nuevaBala);
    }
}