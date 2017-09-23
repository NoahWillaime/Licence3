package toucan.modele;

public class Case {
	private LesMouvs m;
	private int tempMax;
	private int value;
	
	/**
	 * Constructeur sans param�tre de Case
	 */
	public Case(){
		this.m = new LesMouvs(0, 0);
		this.tempMax = 0;
		this.value = 0;
	}
	
	/**
	 * Constructeur de case avec val en param�tre
	 * @param val valeur de la case
	 */
	public Case(int val) {
		this.m = new LesMouvs(0, 0);
		this.tempMax = 0;
		this.value = val;
	}
	
	/**
	 * Constructeur de Case
	 * @param x1 coordonn�e x de la case
	 * @param y1 coordonn�e y de la case
	 */
	public Case(int x1, int y1){
		this.m = new LesMouvs(x1, y1);
		this.tempMax = 0;
		this.value = 0;
	}
	
	/**
	 * Permet de d�finir les coordonn�es de la case
	 * @param x coordonn�e x
	 * @param y coordonn�e y
	 */
	public void setCoord(int x, int y){
		m.setxIn(x);
		m.setyIn(y);
	}
	
	/**
	 * Mouvement vers la droite de la Case
	 * @param d Dur�e du mouvement
	 * @exception AssertionError si d est n�gatif
	 */
	public void droite(int d){
		assert(d >= 0):"la dur�e doit �tre sup�rieure � 0";
		this.m.droite(d);
		this.tempMax += d;
	}
	
	/**
	 * Mouvement vers la gauche de la Case
	 * @param d Dur�e du mouvement
	 * @exception AssertionError si d est n�gatif
	 */
	public void gauche(int d){
		assert(d >= 0):"la dur�e doit �tre sup�rieure � 0";
		this.m.gauche(d);
		this.tempMax += d;
	}
	
	/**
	 * Mouvement vers le haut de la Case
	 * @param d Dur�e du mouvement
	 * @exception AssertionError si d est n�gatif
	 */
	public void monter(int d){
		assert(d >= 0):"la dur�e doit �tre sup�rieure � 0";
		this.m.monter(d);
		this.tempMax += d;
	}
	
	/**
	 * Mouvement vers le bas de la Case
	 * @param d Dur�e du mouvement
	 * @exception AssertionError si d est n�gatif
	 */
	public void descendre(int d){
		assert(d >= 0):"la dur�e doit �tre sup�rieure � 0";
		this.m.descendre(d);
		this.tempMax += d;
	}
	
	/**
	 * Mouvement de pause de la Case
	 * @param d Dur�e du mouvement
	 * @exception AssertionError si d est n�gatif
	 */
	public void stable(int d){
		assert(d >= 0):"la dur�e doit �tre sup�rieure � 0";
		this.m.stable(d);
		this.tempMax += d;
	}
	
	/**
	 * Return la position x de la case � un moment t
	 * @param t Temps de la position
	 * @return coordonn�e x de la case
	 * @exception AssertionError si t est n�gatif
	 */
	public int posX(int t){
		assert(t >= 0):"temps doit �tre positif";
		for (Mouvement mv : this.m){
			if (mv.gettempsAr() > t){
				if (mv.getxIn() < mv.getxAr())
					return mv.getxIn() + (t - mv.gettempsIn());
				else if (mv.getxIn() > mv.getxAr())
					return mv.getxIn() - (t - mv.gettempsIn());
				else if (mv.getxIn() == mv.getxAr())
					return mv.getxAr();
			} else if (mv.gettempsAr() == t){
				return mv.getxAr();
			}
		}
		if (m.getSize() > 0)
			return this.m.lastmoove().getxAr();
		else
			return m.getxIn();
	}
	
	/**
	 * Return la position y de la case � un moment t
	 * @param t Temps de la position
	 * @return coordonn�e y de la case
	 * @exception AssertionError si t est n�gatif
	 */
	public int posY(int t){
		assert(t >= 0):"temps doit �tre positif";
		for (Mouvement mv : this.m){
			if (mv.gettempsAr() > t && mv.gettempsIn() <= t){
				if (mv.getyIn() < mv.getyAr())
					return mv.getyIn() + (t - mv.gettempsIn());
				else if (mv.getyIn() > mv.getyAr()){
					return mv.getyIn() - (t - mv.gettempsIn());
				}
				else if (mv.getyIn() == mv.getyAr())
					return mv.getyIn();
			} else if (mv.gettempsAr() == t){
				return mv.getyAr();
			} else if (mv.gettempsIn() > t) {
				return mv.getyIn();
			}
		}
		if (m.getSize() > 0)
			return this.m.lastmoove().getyAr();
		else
			return m.getyIn();
	}
	
	/**
	 * Return la dur�e total des mouvements de la case
	 * @return tempsMax
	 */
	public int getTempsMax(){
		return tempMax;
	}
	
	/**
	 * Return la valeur de la case
	 * @return value
	 */
	public int getValeur() {
		return this.value;
	}
	
	public String toString(){
		return m.toString();
	}
}
