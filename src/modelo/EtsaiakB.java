package modelo;

public class EtsaiakB extends EtsaiNodo{
	
    public EtsaiakB(int x, int y, int id) {
        super(x, y, new int[][]{ {0, 0},{-1, 0},{1, 0},{0, 1} }, id);
    }
}
