package modelo;

import java.util.ArrayList;

import vista.GelaxkaV;

public class MatrizeM{
	private static MatrizeM nMatrizeM;
	private GelaxkaM[][] matrizea;
	private GelaxkaV[][] matrizeaV;
	private int x = 100;
	private int y = 60;
	
	private MatrizeM() {
		this.matrizea = new GelaxkaM[x][y];
	}
	
	public static MatrizeM getnMatrizeM() {
		if (nMatrizeM == null) {
			nMatrizeM = new MatrizeM();
		}
		return nMatrizeM;
	}
	
	public void SortuMatrizea() {
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				matrizea[j][i] = new GelaxkaM();	
			}
		}
	}
	
	public GelaxkaM getGelaxka(int x, int y) {
        return this.matrizea[x][y];
    }
	public GelaxkaV[][] getMatrizea() {
		return this.matrizeaV;
	}
	public GelaxkaM getGelaxkaM(int x, int y) {
		return this.matrizea[x][y];
	}
	public void setMatrizeaV(GelaxkaV[][] matrizeaV) {
		this.matrizeaV = matrizeaV;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}

	public void gelaxkakAktualizatu(ArrayList<Entitate> entitateLista, int id, EntitateMota entitate) {
		if(nMatrizeM == null || this.matrizea == null) {
			return;
		}
		for (Entitate ent : entitateLista) {
			int [][] kordenatu = ent.getKoordenatu();
			int x = kordenatu[0][0];
			int y = kordenatu[0][1];
			if (x >= 0 && x < this.x && y >= 0 && y < this.y) {
				if(this.matrizea[x][y]!=null) {
					this.matrizea[x][y].setEntitate(entitate, id);
				}
			}
		}
	}
	
	public EntitateMota zerDago(int[][] koordenatu) {
		if (koordenatu == null || matrizea == null) return EntitateMota.HUTSA;
        int x = koordenatu[0][0];
        int y = koordenatu[0][1];
        if (x >= 0 && x < this.x && y >= 0 && y < this.y) {
            if (this.matrizea[x][y] != null) {
                return this.matrizea[x][y].zerDago();
            }
        }
        return EntitateMota.HUTSA;
	}

	public int zeinIDDago(int[][] koordenatu) {
		if (koordenatu == null || matrizea == null) return 0;
        int x = koordenatu[0][0];
        int y = koordenatu[0][1];
        if (x >= 0 && x < this.x && y >= 0 && y < this.y) {
            if (this.matrizea[x][y] != null) {
                return this.matrizea[x][y].getID();
            }
        }
        return 0;
	}
	
	
	
	public void resetMatrizea() {
		this.matrizea = null;
		nMatrizeM = null;
	}
}
