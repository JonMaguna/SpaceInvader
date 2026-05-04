package modelo;

public class EtsaiakB extends EtsaiNodo{
	
    protected EtsaiakB(int x, int y, int id) {
        super(x, y, new int[][]{ {0, -3},{-1, -2}, {0, -2}, {1, -2},{-2, -1}, {-1, -1}, {0, -1}, {1, -1}, {2, -1},{-2, 0}, {0, 0}, {2, 0},{-2, 1}, {2, 1},{-3, 2}, {-2, 2}, {2, 2}, {3, 2} }, id);
    }
}
