package modelo;
public class EtsaiakC extends EtsaiNodo{
	
    public EtsaiakC(int x, int y, int id) {
        super(x, y, new int[][]{ {x, y},{x-1, y},{x+1, y},{x-1, y+1},{x-1, y+1}}, id);
    }
}
