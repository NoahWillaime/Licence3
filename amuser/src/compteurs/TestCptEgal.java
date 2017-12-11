package compteurs;

import java.io.*;

public class TestCptEgal {
	public static void main (String[] args) {
		CptEgal analyseur = new CptEgal(new InputStreamReader(System.in)) ;
		try {
			String s;
			s = analyseur.analyser() ;
			while (s!= null){
				System.out.println(s);
				s = analyseur.analyser() ;
			}
			/*System.out.println("resultat de l'analyse : " + k) ;
			System.out.println("nombre de caracteres = : " + analyseur.nbOccurrences()) ;
			System.out.println("nombre de nbCases : " + analyseur.nbNbCases()) ;
			System.out.println("nombre de tab : " + analyseur.nbTab()) ;*/
		}
		catch (IOException e) {
			System.out.println("probleme d'entree-sortie..." + e.getMessage()) ;
			}
	}
}
