package modelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Observable;
import java.util.Random;
import modelo.EntitateMota;
import java.util.Timer;
import java.util.TimerTask;

public class MatrizeM extends Observable{
	private MatrizeM nMatrizeM;
	private GelaxkaM[][] matrizea;
	
	private MatrizeM() {
	
	}
	public MatrizeM getnMatrizeM() {
		return nMatrizeM;
	}
	public void SortuMatrizea() {
		matrizea = new GelaxkaM[100][60];
		ArrayList<GelaxkaM> etsaiak = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 60; j++) {
				matrizea[i][j] = new GelaxkaM(i, j, EntitateMota.HUTSA);
				setChanged();
				notifyObservers();
				
				if (i % 5 == 4 && i != 99) {
					etsaiak.add(matrizea[i][j]);
				}
			}
		}
		int numEtsaiak = random.nextInt(5) + 4;
		Collections.shuffle(etsaiak);
		for (int k = 0; k < numEtsaiak; k++) {
			GelaxkaM gelaxka = etsaiak.get(k);
			gelaxka.setEntitate(EntitateMota.ETSAIA); 
			setChanged();
			notifyObservers(gelaxka);
			
		}
		GelaxkaM gelaxka = matrizea[50][55];
		gelaxka.setEntitate(EntitateMota.ESPAZIONTZI); 
		setChanged();
		notifyObservers(gelaxka);
	}
	public void mugituOntzia (String Mugimendua) {
		
		Pertsonai Espaziontzi = PertsonaiZerrenda.getnPertsonaiZerrenda().getEspaziontzi();
		if (Mugimendua.equals("w")) {
			Espaziontzi.mugituGora();
			setChanged();
			notifyObservers();
		}else if(Mugimendua.equals("a")) {
			Espaziontzi.mugituBehera();
			setChanged();
			notifyObservers();
		}else if(Mugimendua.equals("s")) {
			Espaziontzi.mugituEzkerrera();
			setChanged();
			notifyObservers();
		}else if(Mugimendua.equals("d")) {
			Espaziontzi.mugituEskumara();
			setChanged();
			notifyObservers();
		}
			
	}
	public GelaxkaM getGelaxka(int i, int j) {
		return matrizea[i][j];
	}
	public void EtsaiakMugitu() {
        Timer timer = new Timer();
        TimerTask ataza = new TimerTask() {
            public void run() {
                EtsaiaMugitu();
            }
        };

        timer.schedule(ataza, 0, 200);
    }
	private void EtsaiaMugitu() {
		PertsonaiZerrenda zerrenda = PertsonaiZerrenda.getnPertsonaiZerrenda(); 
		ArrayList<Pertsonai> Etsaiak = zerrenda.getEtsaiak();
		while (Etsaiak.hasnext()) {
			int Random = random.nextInt(4);
			Pertsonai Etsaia = Etsaiak.get(0);
			switch (Random) {
            case 0:
            	Etsaia.mugituGora;
            	setChanged();
				notifyObservers();
                break;
            case 1:
            	Etsaia.mugituBehera;
            	setChanged();
				notifyObservers();
            	break;
            case 2:
            	Etsaia.mugituEzkerrera;
            	setChanged();
				notifyObservers();
            	break;
            case 3:
            	Etsaia.mugituEskumara;
            	setChanged();
				notifyObservers();
            	break;
		}
	}
	public void AldatuGelaxka () {
	}
}
