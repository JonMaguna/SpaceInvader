package modelo;

import java.util.Scanner;

public class JokoKudeatzailea {
	private boolean jokoanDa= false;
	private static JokoKudeatzailea instantzia= null;
	
	private JokoKudeatzailea() {}
	
	public static JokoKudeatzailea getInstantzia() {
		if(instantzia==null) {instantzia= new JokoKudeatzailea();}
		return instantzia;
	}
	
	public void jokoaHasieratu(int saiakera) {
		MatrizeM m= MatrizeM.getnMatrizeM();
		if(jokoanDa) {this.jokatzen();}
		else{
			Scanner sc = new Scanner(System.in);
			//System.out.print("Partida hasteko [l] tekla sakatu eta Enter eman:");
		    String entrada = sc.nextLine();
		    if (entrada.equalsIgnoreCase("l")) {
		        this.jokoanDa = true;
		        System.out.println("Jokoa hasieratzen...");
		        jokoanDa= true;
		        m.sortuMatrizea();
		        m.sortuPertsonaia();
		        //MatrizeV();
		        //while(MatrizeaM.pertsonaiaTopatu().bizirikDago()== true) {this.jokatzen();}
		        //if(MatrizeaM.pertsonaiaTopatu().bizirikDago()== false) {this.jokoanDa= false;}
		    } else {
		        System.out.println("Tekla okerra. 'l' sakatu behar duzu.");
		        saiakera++;
		        if(saiakera<4) {
		        	this.jokoaHasieratu(saiakera);
		        }else {
		        	System.out.println("Programa berriz exekutatu");
		        }
		    }
		}
	}

	private void jokatzen() {
		
	}
}
