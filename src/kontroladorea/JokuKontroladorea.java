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
        int delay = 50; 

        timerBala = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarBalas();
            }
        });
        timerBala.start();
    }

    private void actualizarBalas() {
        for (int i = 0; i < balasActivas.size(); i++) {
            Bala bala = balasActivas.get(i);
            
            bala.run();

            if (!bala.isActive()) {
                balasActivas.remove(i);
                i--;
            }
        }
        // vista.repintarPantalla(); 
    }
    public void jugadorDispara(int naveX, int naveY) {
        Bala nuevaBala = new Bala(naveX, naveY);
        balasActivas.add(nuevaBala);
    }
}