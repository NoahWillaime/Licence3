package toucan.modele;

import java.util.ArrayList;

/**
 * @author NoahWillaime
 *
 */
public class LesCases{
	private ArrayList<Case> lesCases;
	private int tempsMax;
	
	/**
	 * Constructeur sans param�tre de LesCases
	 */
	public LesCases(){
		this.lesCases = new ArrayList<Case>();
	}
	
	/**
	 * Cpnstructeur avec param�tre de LesCases
	 * @param tab tableau d'int qui contient les valeurs des cases
	 * @exception AssertionError si le nombre de case est n�gatif
	 */
	public LesCases(int[] tab){
		assert(tab != null):"tab ne doit pas �tre null";
		this.lesCases = new ArrayList<Case>(tab.length);
		for (int i = 0; i < tab.length; i++){
			lesCases.add(new Case(tab[i]));
		}
	}
	
	/**
	 * Permet de choisir les coordonn�es d'une case
	 * @param index Case � laquelle on veut affecter x et y
	 * @param x coordonn�e x
	 * @param y coordonn�e y
	 * @exception AssertionError si l'index de la case n'est pas compris
	 */
	public void setCase(int index, int x, int y){
		assert(index >= 0 && index < this.getSize()):"index non valable";
		lesCases.get(index).setCoord(x, y);
	}
	
	/**
	 * Mouvement de la case vers la droite
	 * @param index Case qui va recevoir le mouvement
	 * @param temps dur�e du mouvement
	 * @exception AssertionError si l'index n'est pas compris
	 * @exception AssertionError si le temps est n�gatif
	 */
	public void droite(int index, int temps){
		assert(index >= 0 && index < this.getSize()):"index non valable";
		assert(temps >= 0):"temps doit �tre positif";
		if (index < lesCases.size()){
			lesCases.get(index).droite(temps);
			if (lesCases.get(index).getTempsMax() > tempsMax){
				tempsMax = lesCases.get(index).getTempsMax();
			}
		}
	}
	
	/**
	 * Mouvement de la case vers la gauche
	 * @param index Case qui va recevoir le mouvement
	 * @param temps dur�e du mouvement
	 * @exception AssertionError si l'index n'est pas compris
	 * @exception AssertionError si le temps est n�gatif
	 */
	public void gauche(int index, int temps){
		assert(index >= 0 && index < this.getSize()):"index non valable";
		assert(temps >= 0):"temps doit �tre positif";
		if (index < lesCases.size()){
			lesCases.get(index).gauche(temps);
			if (lesCases.get(index).getTempsMax() > tempsMax){
				tempsMax = lesCases.get(index).getTempsMax();
			}
		}
	}
	
	/**
	 * Mouvement de la case vers le haut
	 * @param index Case qui va recevoir le mouvement
	 * @param temps dur�e du mouvement
	 * @exception AssertionError si l'index n'est pas compris
	 * @exception AssertionError si le temps est n�gatif
	 */
	public void monter(int index, int temps){
		assert(index >= 0 && index < this.getSize()):"index non valable";
		assert(temps >= 0):"temps doit �tre positif";
		if (index < lesCases.size()){
			lesCases.get(index).monter(temps);
			if (lesCases.get(index).getTempsMax() > tempsMax){
				tempsMax = lesCases.get(index).getTempsMax();
			}
		}
	}
	
	/**
	 * Mouvement de la case vers le bas
	 * @param index Case qui va recevoir le mouvement
	 * @param temps dur�e du mouvement
	 * @exception AssertionError si l'index n'est pas compris
	 * @exception AssertionError si le temps est n�gatif
	 */
	public void descendre(int index, int temps){
		assert(index >= 0 && index < this.getSize()):"index non valable";
		assert(temps >= 0):"temps doit �tre positif";
		if (index < lesCases.size()){
			lesCases.get(index).descendre(temps);
			if (lesCases.get(index).getTempsMax() > tempsMax){
				tempsMax = lesCases.get(index).getTempsMax();
			}
		}
	}
	
	/**
	 * Mouvement de pause de la case
	 * @param index Case qui va recevoir le mouvement
	 * @param temps dur�e du mouvement
	 * @exception AssertionError si l'index n'est pas compris
	 * @exception AssertionError si le temps est n�gatif
	 */
	public void stable(int index, int temps){
		assert(index >= 0 && index < this.getSize()):"index non valable";
		assert(temps >= 0):"temps doit �tre positif";
		if (index < lesCases.size()){
			lesCases.get(index).stable(temps);
			if (lesCases.get(index).getTempsMax() > tempsMax){
				tempsMax = lesCases.get(index).getTempsMax();
			}
		}
	}
	
	/**
	 * Pour avoir le temps maximal parmis toutes les cases
	 * @return tempsMax
	 */
	public int getMaxTemps(){
		return tempsMax;
	}
	
	/**
	 * Pour avoir le nombre de case total
	 * @return le nombre de case
	 */
	public int getSize() {
		return lesCases.size();
	}
	
	/**
	 * Pour avoir une Case index� � i
	 * @param i index de la case
	 * @return la Case souhait�
	 */
	public Case getCase(int i) {
		assert(i >= 0 && i < lesCases.size()):"i hors index";
		return lesCases.get(i);
	}
	
    @Override
    public String toString() {
        int maxTemps = getMaxTemps();
        StringBuilder sb = new StringBuilder() ;
        for (int i = 0 ; i < lesCases.size() ; i++) {
            sb.append("Case " + i + ": ") ;
            Case c = lesCases.get(i) ;
            for (int t = 0 ; t <= maxTemps ; t++) {
                int x = c.posX(t) ;
                int y = c.posY(t) ;
                int v = c.getValeur();
                sb.append("\t" + t + " (" + x + "," + y + ") : "+v) ;
                if (t % 5 == 0) {
                    sb.append("\n\t") ;
                }
            }
            sb.append("\n") ;
        }
        return sb.toString() ;
    }
}
