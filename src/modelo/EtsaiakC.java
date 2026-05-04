package modelo;
public class EtsaiakC extends EtsaiNodo{
	
    protected EtsaiakC(int x, int y, int id) {
        super(x, y, new int[][]{ {-2, -2},{2, -2},{-2, -1}, {-1, -1}, {0, -1}, {1, -1}, {2, -1},{0, 0}}, id);
    }
}
