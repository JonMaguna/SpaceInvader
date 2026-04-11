package modelo;

import java.util.ArrayList;

public class BalaMugimenduEstrategia implements MugimenduEstrategia {
	@Override
    public boolean mugituDaiteke(Entitate ent, Mugimendua m) {
        BalaNodo nodo = (BalaNodo) ent;
        ArrayList<Entitate> gelaxkak = nodo.getGelaxkak();
        boolean mugitu = true;
        int i = 0;
        while (i < gelaxkak.size() && mugitu) {
            mugitu = gelaxkak.get(i).mugituDaiteke(Mugimendua.GORA);
            if (!gelaxkak.get(i).bizirik()) {
                mugitu = false;
                nodo.setBizirik(false);
            }
            i++;
        }
        return mugitu;
    }
    @Override
    public void mugitu(Entitate ent, Mugimendua m) {
        BalaNodo nodo = (BalaNodo) ent;
        ArrayList<Entitate> gelaxkak = nodo.getGelaxkak();
        if (mugituDaiteke(ent, m)) {
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, 0, EntitateMota.HUTSA);
            for (Entitate pixel : gelaxkak) {
                pixel.mugitu(Mugimendua.GORA);
            }
            MatrizeM.getnMatrizeM().gelaxkakAktualizatu(gelaxkak, nodo.getId(), EntitateMota.BALA);
            nodo.setY(nodo.getY() - 1);
        } else {
            nodo.setBizirik(false);
        }
    }
}
