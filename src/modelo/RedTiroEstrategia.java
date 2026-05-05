package modelo;

public class RedTiroEstrategia implements TiroEstrategia {

	@Override
	public BalaNodo tiroEgin(EspaziontziNodo nodo,int id) {
		if(nodo.getBala() == 1) {
			return BalaFactory.getnBalaFactory().sortuBala(nodo.getX(), nodo.getY() - 1, id, BalaMota.BALA_NORMALA);
		} else if (nodo.getBala2() < 10) {
			nodo.setBala2(nodo.getBala2() + 1);
			return BalaFactory.getnBalaFactory().sortuBala(nodo.getX(), nodo.getY() - 2, id, BalaMota.BALA_AZKARRA);
		}
		return null;
	}

	@Override
	public void nextBala(EspaziontziNodo nodo) {
		if(nodo.getBala() == 2) {
			nodo.setBala(1);
		} else {
			nodo.setBala(nodo.getBala() + 1);
		}
	}

}
