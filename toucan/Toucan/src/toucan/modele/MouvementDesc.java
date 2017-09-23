package toucan.modele;

/**
 * @author NoahWillaime
 *
 */
public class MouvementDesc extends Mouvement{
	/**
	 * Constructeur de MouvementDesc
	 * @param temps Temps de départ du mouvement
	 * @param duree Durée du mouvement
	 * @param x coordonnée x de départ
	 * @param y coordonnée y de départ
	 */
	public MouvementDesc(int temps, int duree, int x, int y){
		super(temps, duree, x, y);
		xAr = x;
		yAr = y + duree;
		tempsAr = temps + duree;
	}
}
