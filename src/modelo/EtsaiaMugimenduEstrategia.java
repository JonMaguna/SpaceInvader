package modelo;

import java.util.ArrayList;

public class EtsaiaMugimenduEstrategia implements MugimenduEstrategia {
	@Override
    public boolean mugituDaiteke(Entitate ent, Mugimendua m) {
        return true;
    }
    @Override
    public void mugitu(Entitate ent, Mugimendua m) {
        EtsaiNodo nodo = (EtsaiNodo) ent;
        ArrayList<Entitate> gelaxkak = nodo.getGelaxkak();
        boolean mugituDaiteke = true;
        int i = 0;
        while(i < gelaxkak.size() && mugituDaiteke){
            mugituDaiteke = gelaxkak.get(i).mugituDaiteke(m);
            if(!gelaxkak.get(i).bizirik()) {
                nodo.setBizirik(false);
            }
            i++;
        }
        if(mugituDaiteke) {
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
