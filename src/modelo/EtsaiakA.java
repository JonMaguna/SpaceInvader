package modelo;

public class EtsaiakA extends EtsaiNodo{
	    public EtsaiakA(int x, int y, int id) {
	        super(x, y, new int[][]{ {x, y},{x-1, y-1},{x-1, y},{x-1, y+1},{x, y-1},{x, y+1},{x+1, y-1},{x+1, y},{x+1,y+1}}, id);
	    }
	}
