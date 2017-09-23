package toucan.modele;

/**
 * @author NoahWillaime
 *
 */
public class MouvementMonter extends Mouvement{
	/**
	 * Constructeur de MouvementMonter
	 * @param temps Temps de départ du mouvement
	 * @param duree Durée du mouvement
	 * @param x coordonnée x de départ
	 * @param y coordonnée y de départ
	 */
	public MouvementMonter(int temps, int duree, int x, int y){
		super(temps, duree, x, y);
		xAr = x;
		yAr = y - duree;
		tempsAr = temps + duree;
	}
}
