package modelo;

public class EtsaiakB extends EtsaiNodo{
	
    public EtsaiakB(int x, int y, int id) {
        super(x, y, new int[][]{ {x, y},{x-1, y},{x+1, y},{x, y+1} }, id);
    }
}
