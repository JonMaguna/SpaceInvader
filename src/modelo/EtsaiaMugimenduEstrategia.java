package modelo;

import java.util.ArrayList;

public class EtsaiaMugimenduEstrategia implements MugimenduEstrategia {
	@Override
    public boolean mugituDaiteke(Entitate ent, Mugimendua m) {
		EtsaiNodo nodo = (EtsaiNodo) ent;
        ArrayList<Entitate> gelaxkak = nodo.getGelaxkak();
        boolean mugitu = true;
        for (Entitate pixel : gelaxkak) {
            if (!pixel.mugituDaiteke(m)) {
                mugitu = false;
                if (!pixel.bizirik()) {
                    nodo.setBizirik(false);
                }
                break; 
            }
        }
        return mugitu;
    }
    
    @Override
    public void mugitu(Entitate ent, Mugimendua m) {
        EtsaiNodo nodo = (EtsaiNodo) ent;
        ArrayList<Entitate> gelaxkak = nodo.getGelaxkak();
        if(mugituDaiteke(ent, m)) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);            
            for (Entitate pixel : gelaxkak) {
                pixel.mugitu(m);
            }
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, nodo.getId(), EntitateMota.ETSAIA);
            this.eguneratuPosizioNagusia(nodo, m);
        }
    }

    private void eguneratuPosizioNagusia(EtsaiNodo nodo, Mugimendua m) {
        switch(m) {
            case EZKERRA: nodo.setX(nodo.getX() - 1); 
            break;
            case ESKUMA:  nodo.setX(nodo.getX() + 1); 
            break;
            case BEHERA:  nodo.setY(nodo.getY() + 1); 
            break;
            default: 
            break;
        }
    }
}
