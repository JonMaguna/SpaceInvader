package modelo;

public class EtsaiakA extends EtsaiNodo{
	    protected EtsaiakA(int x, int y, int id) {
	        super(x, y, new int[][]{ {0, 0},{-1, -1},{-1, 0},{-1, 1},{0, -1},{0, 1},{1, -1},{1, 0},{1,1}}, id);
	    }
	}
