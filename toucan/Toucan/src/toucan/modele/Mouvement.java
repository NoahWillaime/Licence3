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
	 * @param temps Temps de d�but du mouvement
	 * @param duree Dur�e du mouvement
	 * @param x X de depart
	 * @param y Y de depart
	 * @exception AssertionError si le temps est n�gatif
	 * @exception AssertionError si la dur�e est n�gative
	 */
	public Mouvement(int temps, int duree, int x, int y){
		assert(temps >= 0):"temps doit �tre positif";
		assert(duree >= 0):"la dur�e doit �tre sup�rieure � 0";
		this.tempsIn = temps;
		this.tempsAr = temps + duree;
		this.d = duree;
		this.xIn = x;
		this.yIn = y;
	}
	
	/**
	 * Return le x d'arriv�
	 * @return xAr 
	 */
	public int getxAr(){
		return xAr;
	}
	
	/**
	 * Return le y d'arriv�
	 * @return yAr
	 */
	public int getyAr(){
		return yAr;
	}
	
	/**
	 * Return le x de d�part
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
	 * Return le temps de d�part
	 * @return tempsIn
	 */
	public int gettempsIn(){
		return tempsIn;
	}
	
	/**
	 * Return le temps d'arriv�
	 * @return tempsAr
	 */
	public int gettempsAr(){
		return tempsAr;
	}
	
	public String toString(){
		return ("Temps Initial : "+tempsIn+"\n Dur�e : "+d+"\n Temps Arriv� : "+tempsAr+"\n x In / Ar : "+xIn+" / "+xAr+"\n y In / Ar : "+yIn+" / "+yAr);
	}
}
