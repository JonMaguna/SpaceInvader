package modelo;

import musikie.Musika_erreproduzidu;
import vista.LeihoNagusiaV;

public class main {
	public static void main(String[] args) {
		LeihoNagusiaV.LVmain(args);
		Musika_erreproduzidu.getME().erreproduzidu("src/musikie/DU.mp3");
	}
}
