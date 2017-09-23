package toucan.test;

import toucan.modele.Case;
import toucan.modele.LesCases;
import toucan.modele.Modele;

public class TestToucan {
	public static void main(String args[]) {
		//Test ASSERT
		Case c1 = new Case();
		c1.setCoord(10, -10);
		assert(c1.posX(0) == 10):"Erreur coord X de Case";
		assert(c1.posY(0) == -10):"Erreur coord Y de Case";
		
		int[] t = {0, 0, 0};
		LesCases cases = new LesCases(t);
		cases.setCase(0, 5, 5);
		assert(cases.getCase(0).posX(0) == 5):"Erreur Coord X de la case 0 du test LesCases";
		assert(cases.getCase(0).posY(0) == 5):"Erreur Coord Y de la case 0 du test LesCases";
		cases.setCase(1, -5, -5);
		assert(cases.getCase(1).posX(0) == -5):"Erreur Coord X de la case 1 du test LesCases";
		assert(cases.getCase(1).posY(0) == -5):"Erreur Coord Y de la case 1 du test LesCases";
		cases.setCase(2, 1, -1);
		assert(cases.getCase(2).posX(0) == 1):"Erreur Coord X de la case 0 du test LesCases";
		assert(cases.getCase(2).posY(0) == -1):"Erreur Coord Y de la case 0 du test LesCases";

		int[] t1 = {0};
		Modele am = new Modele(t1);
		am.setPosition(0, 1, 1);
		am.creerLesMouvements(0, Modele.EST, 1);
		LesCases lc = am.getLesCases();
		assert(lc.getCase(0).posX(1) == 2):"Erreur Coord X après déplacement";
		assert(lc.getCase(0).posY(1) == 1):"Erreur Coord Y après déplacement";
		
		//Test de Déplacement
		int[] t2 = {1, 2, 3, 4};
		Modele m = new Modele(t2);
		
		m.setPosition(2, 5, 10);
		m.setPosition(0, -10, 5);
		m.creerLesMouvements(
				0, Modele.NORD, 5,
				0, Modele.EST, 10,
				1, Modele.STABLE, 10,
				1, Modele.SUD, 10,
				2, Modele.OUEST, 5,
				2, Modele.STABLE, 5,
				2, Modele.SUD, 1,
				3, Modele.EST, 20);
		
		System.out.println("Case 0 (-10, 5)\nNord : 5 / Est : 10\n");
		System.out.println("Case 1 (0, 0)\nStable : 10 / Sud : 10\n");
		System.out.println("Case 2 (5, 10)\nOuest : 5 / Stable : 5 / Sud : 1\n");
		System.out.println("Case 3 (0, 0)\nEst : 20\n");
		System.out.println(m.toString());
	}
}
