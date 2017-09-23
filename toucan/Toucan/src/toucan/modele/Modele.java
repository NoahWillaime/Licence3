package toucan.modele;

import java.util.Observable;

/**
 * @author NoahWillaime
 *
 */
public class Modele extends Observable{
	private LesCases lesCases;
	public final static int STABLE = 0;
	public final static int NORD = 1;
	public final static int EST = 2;
	public final static int SUD = 3;
	public final static int OUEST = 4;

	/**
	 * Constructeur de Modele
	 * @param tab tableau d'int contenant les valeurs de chaque cases
	 * @exception AssertionError si tab est null
	 */
	public Modele(int[] tab){
		assert(tab != null):"tab ne doit pas être null";
		this.lesCases = new LesCases(tab);
	}
	
	/**
	 * Définition de la position initial des cases
	 * @param noCase index de la case
	 * @param x coordonnée x de la case
	 * @param y coordonnée y de la case
	 * @exception AssertionError si le noCase dépasse les limites
	 */
	public void setPosition(int noCase, int x, int y){
		assert((noCase >= 0 && noCase < lesCases.getSize())):"noCase non valable";
		lesCases.setCase(noCase, x, y);
	}
	
	/**
	 * Permet la création des mouvements des différentes cases
	 * @param dep (index, mouvement à effectuer, durée du mouvement)
	 * @exception AssertionError si il n'y a pas le bon nombre de paramètre (3 par 3)
	 */
	public void creerLesMouvements(int ...dep){
		assert((dep.length%3)==0):"Mauvais nombre paramètres creerLesMouvements";
		int i = 0;
		while (i < dep.length){
			switch(dep[i+1]){
			case STABLE :
				lesCases.stable(dep[i], dep[i+2]);
				break;
			case NORD :
				lesCases.monter(dep[i], dep[i+2]);
				break;
			case EST :
				lesCases.droite(dep[i], dep[i+2]);
				break;
			case SUD :
				lesCases.descendre(dep[i], dep[i+2]);
				break;
			case OUEST :
				lesCases.gauche(dep[i], dep[i+2]);
				break;
			default :
				System.out.println("Mauvais dépalcement");
				break;
			}
			i += 3;
		}
		setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Permet d'avoir lesCases
	 * @return lesCases
	 */
	public LesCases getLesCases() {
		return lesCases;
	}
	
	@Override
	public String toString(){
		return lesCases.toString();
	}
}
