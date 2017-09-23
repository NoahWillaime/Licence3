package toucan.modele;

/**
 * @author NoahWillaime
 *
 */
public class MouvementStable extends Mouvement{
	/**
	 * Constructeur de MouvementStable
	 * @param temps Temps de départ du mouvement
	 * @param duree Durée du mouvement
	 * @param x coordonnée x de départ
	 * @param y coordonnée y de départ
	 */
	public MouvementStable(int temps, int duree, int x, int y){
		super(temps, duree, x, y);
		xAr = x;
		yAr = y;
		tempsAr = temps + duree;
	}
}
