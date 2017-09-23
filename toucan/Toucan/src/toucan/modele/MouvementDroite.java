package toucan.modele;

/**
 * @author NoahWillaime
 *
 */
public class MouvementDroite extends Mouvement{
	/**
	 * Constructeur de MouvementDroite
	 * @param temps Temps de départ du mouvement
	 * @param duree Durée du mouvement
	 * @param x coordonnée x de départ
	 * @param y coordonnée y de départ
	 */
	public MouvementDroite(int temps, int duree, int x, int y){
		super(temps, duree, x, y);
		xAr = x + duree;
		yAr = y;
		tempsAr = temps + duree;
	}
}
