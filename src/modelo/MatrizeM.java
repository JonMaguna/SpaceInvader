package modelo;

import java.util.ArrayList;

public class MatrizeM{
	private static MatrizeM nMatrizeM;
	private GelaxkaM[][] matrizea;
	
	private MatrizeM() {
		this.matrizea = new GelaxkaM[100][60];
	}
	
	public static MatrizeM getnMatrizeM() {
		if (nMatrizeM == null) {
			nMatrizeM = new MatrizeM();
		}
		return nMatrizeM;
	}
	
	public void SortuMatrizea() {
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < 100; j++) {
				matrizea[j][i] = new GelaxkaM();	
			}
		}
	}
	
	public GelaxkaM getGelaxka(int x, int y) {
        return this.matrizea[x][y];
    }

	public void gelaxkakAktualizatu(ArrayList<Entitate> entitateLista, int id, EntitateMota entitate) {
		for (Entitate ent : entitateLista) {
			int [][] kordenatu = ent.getKoordenatu();
			int x = kordenatu[0][0];
			int y = kordenatu[0][1];
			this.matrizea[x][y].setEntitate(entitate, id);
		}
	}
	
	public EntitateMota zerDago(int[][] koordenatu) {
		return matrizea[koordenatu[0][0]][koordenatu[0][1]].zerDago();
	}

	public int zeinIDDago(int[][] koordenatu) {
		return matrizea[koordenatu[0][0]][koordenatu[0][1]].getID();
	}
}
