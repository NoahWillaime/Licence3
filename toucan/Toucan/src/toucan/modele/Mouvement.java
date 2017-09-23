package toucan.modele;

/**
 * @author NoahWillaime 
 *
 */
public abstract class Mouvement {
	private int tempsIn;
	private int d;
	private int xIn;
	private int yIn;
	protected int xAr;
	protected int yAr;
	protected int tempsAr;
	
	/**
	 * Constructeur de Mouvement
	 * @param temps Temps de début du mouvement
	 * @param duree Durée du mouvement
	 * @param x X de depart
	 * @param y Y de depart
	 * @exception AssertionError si le temps est négatif
	 * @exception AssertionError si la durée est négative
	 */
	public Mouvement(int temps, int duree, int x, int y){
		assert(temps >= 0):"temps doit être positif";
		assert(duree >= 0):"la durée doit être supérieure à 0";
		this.tempsIn = temps;
		this.tempsAr = temps + duree;
		this.d = duree;
		this.xIn = x;
		this.yIn = y;
	}
	
	/**
	 * Return le x d'arrivé
	 * @return xAr 
	 */
	public int getxAr(){
		return xAr;
	}
	
	/**
	 * Return le y d'arrivé
	 * @return yAr
	 */
	public int getyAr(){
		return yAr;
	}
	
	/**
	 * Return le x de départ
	 * @return xIn
	 */
	public int getxIn(){
		return xIn;
	}
	
	/**
	 * Return le y de depart
	 * @return yIn
	 */
	public int getyIn(){
		return yIn;
	}
	
	/**
	 * Return le temps de départ
	 * @return tempsIn
	 */
	public int gettempsIn(){
		return tempsIn;
	}
	
	/**
	 * Return le temps d'arrivé
	 * @return tempsAr
	 */
	public int gettempsAr(){
		return tempsAr;
	}
	
	public String toString(){
		return ("Temps Initial : "+tempsIn+"\n Durée : "+d+"\n Temps Arrivé : "+tempsAr+"\n x In / Ar : "+xIn+" / "+xAr+"\n y In / Ar : "+yIn+" / "+yAr);
	}
}
