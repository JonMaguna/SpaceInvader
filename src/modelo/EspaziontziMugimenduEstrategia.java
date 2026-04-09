package modelo;

import java.util.ArrayList;

public class EspaziontziMugimenduEstrategia implements MugimenduEstrategia {
	@Override
    public boolean mugituDaiteke(Entitate ent, Mugimendua m) {
        EspaziontziNodo nodo = (EspaziontziNodo) ent;
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
        EspaziontziNodo nodo = (EspaziontziNodo) ent;
        ArrayList<Entitate> gelaxkak = nodo.getGelaxkak();
        if (this.mugituDaiteke(ent, m)) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);
            for (Entitate pixel : gelaxkak) {
                pixel.mugitu(m);
            }
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, nodo.getId(), EntitateMota.ESPAZIONTZI);
            this.eguneratuPosizioNagusia(nodo, m);
        }
    }
    private void eguneratuPosizioNagusia(EspaziontziNodo nodo, Mugimendua m) {
        switch(m) {
            case EZKERRA: nodo.setX(nodo.getX() - 1); break;
            case ESKUMA:  nodo.setX(nodo.getX() + 1); break;
            case GORA:    nodo.setY(nodo.getY() - 1); break;
            case BEHERA:  nodo.setY(nodo.getY() + 1); break;
            default: break;
        }
    }
}

