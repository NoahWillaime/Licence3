package toucan.modele;

/**
 * @author NoahWillaime
 *
 */
public class MouvementStable extends Mouvement{
	/**
	 * Constructeur de MouvementStable
	 * @param temps Temps de d�part du mouvement
	 * @param duree Dur�e du mouvement
	 * @param x coordonn�e x de d�part
	 * @param y coordonn�e y de d�part
	 */
	public MouvementStable(int temps, int duree, int x, int y){
		super(temps, duree, x, y);
		xAr = x;
		yAr = y;
		tempsAr = temps + duree;
	}
}
