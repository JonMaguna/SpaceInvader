package modelo;

public class BlueTiroEstrategia implements TiroEstrategia {

	@Override
	public BalaNodo tiroEgin(EspaziontziNodo nodo,int id) {
		EspaziontziBLUE nodo1 = (EspaziontziBLUE) nodo;
		switch(nodo.getBala()) {
		case 1:
			return BalaFactory.getnBalaFactory().sortuBala(nodo1.getX(), nodo1.getY() - 1, id, BalaMota.BALA_NORMALA);
		case 2:
			nodo1.setBala2(nodo.getBala2()+1);
			if(nodo1.getBala2() >= 30) {return null;}
			return BalaFactory.getnBalaFactory().sortuBala(nodo1.getX(), nodo1.getY() - 2, id, BalaMota.BALA_AZKARRA);
		case 3:
			if(nodo1.getBala3() >= 20) {return null;}
			nodo1.setBala3(nodo1.getBala3() + 1);
			return BalaFactory.getnBalaFactory().sortuBala(nodo1.getX(), nodo1.getY() - 1, id, BalaMota.BALA_HANDIA);
		default:
			return null;
		}
	}

	@Override
	public void nextBala(EspaziontziNodo nodo) {
			if(nodo.getBala() == 3) {
				nodo.setBala(1);
			} else {
				nodo.setBala(nodo.getBala() + 1);
			}
		}
}


