package toucan.modele;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author NoahWillaime
 *
 */
public class LesMouvs implements Iterable<Mouvement>{
	private ArrayList<Mouvement> mooves;
	private int xIn;
	private int yIn;
	
	/**
	 * Constructeur de LesMouvs
	 * @param x coordonnée x
	 * @param y coordonnée y
	 */
	public LesMouvs(int x, int y){
		this.mooves = new ArrayList<Mouvement>();
		this.xIn = x;
		this.yIn = y;
	}
	
	/**
	 * Permet d'initialiser le x de départ de la case
	 * @param x coordonnée x
	 */
	public void setxIn(int x){
		this.xIn = x;
	}
	
	/**
	 * Permet d'initialiser le y de départ de la case
	 * @param y coordonnée y
	 */
	public void setyIn(int y){
		this.yIn = y;
	}
	
	/**
	 * Mouvement vers la droite
	 * @param d Durée du Mouvement
	 * @exception AssertionError si la durée est négative
	 */
	public void droite(int d){
		assert(d >= 0):"la durée doit être supérieure à 0";
		if (mooves.isEmpty()){
			Mouvement m = new MouvementDroite(0, d, xIn, yIn);
			ajouter(m);
		} else {
			int index = mooves.size() - 1;
			Mouvement temp = mooves.get(index);
			Mouvement m = new MouvementDroite(temp.gettempsAr(), d, temp.getxAr(), temp.getyAr());
			ajouter(m);
		}
	}
	
	/**
	 * Mouvement vers la gauche
	 * @param d Durée du Mouvement
	 * @exception AssertionError si la durée est négative
	 */
	public void gauche(int d){
		assert(d >= 0):"la durée doit être supérieure à 0";
		if (mooves.isEmpty()){
			Mouvement m = new MouvementGauche(0, d, xIn, yIn);
			ajouter(m);
		} else {
			int index = mooves.size() - 1;
			Mouvement temp = mooves.get(index);
			Mouvement m = new MouvementGauche(temp.gettempsAr(), d, temp.getxAr(), temp.getyAr());
			ajouter(m);
		}
	}	
	
	/**
	 * Mouvement vers le haut
	 * @param d Durée du Mouvement
	 * @exception AssertionError si la durée est négative
	 */
	public void monter(int d){
		assert(d >= 0):"la durée doit être supérieure à 0";
		if (mooves.isEmpty()){
			Mouvement m = new MouvementMonter(0, d, xIn, yIn);
			ajouter(m);
		} else {
			int index = mooves.size() - 1;
			Mouvement temp = mooves.get(index);
			Mouvement m = new MouvementMonter(temp.gettempsAr(), d, temp.getxAr(), temp.getyAr());
			ajouter(m);
		}
	}
	
	/**
	 * Mouvement vers le bas
	 * @param d Durée du Mouvement
	 * @exception AssertionError si la durée est négative
	 */
	public void descendre(int d){
		assert(d >= 0):"la durée doit être supérieure à 0";
		if (mooves.isEmpty()){
			Mouvement m = new MouvementDesc(0, d, xIn, yIn);
			ajouter(m);
		} else {
			int index = mooves.size() - 1;
			Mouvement temp = mooves.get(index);
			Mouvement m = new MouvementDesc(temp.gettempsAr(), d, temp.getxAr(), temp.getyAr());
			ajouter(m);
		}
	}
	
	/**
	 * Mouvement de pause
	 * @param d Durée du Mouvement
	 * @exception AssertionError si la durée est négative
	 */
	public void stable(int d){
		assert(d >= 0):"la durée doit être supérieure à 0";
		if (mooves.isEmpty()){
			Mouvement m = new MouvementStable(0, d, xIn, yIn);
			ajouter(m);
		} else {
			int index = mooves.size() - 1;
			Mouvement temp = mooves.get(index);
			Mouvement m = new MouvementStable(temp.gettempsAr(), d, temp.getxAr(), temp.getyAr());
			ajouter(m);
		}
	}
	
	/**
	 * Return le dernier mouvement effectuer par la case
	 * @return le dernier mouvement
	 */
	public Mouvement lastmoove(){
		if (mooves.size() > 0){
			return mooves.get(mooves.size() - 1);
		} else {
			return mooves.get(0);
		}
	}
	
	/**
	 * Nombre de mouvements
	 * @return le nombre de mouvements
	 */
	public int getSize(){
		return mooves.size();
	}
	
	/**
	 * Return le x de départ
	 * @return xIn
	 */
	public int getxIn(){
		return xIn;
	}
	
	/**
	 * Return le y de départ
	 * @return yIn
	 */
	public int getyIn(){
		return yIn;
	}
	
	/**
	 * Itérator de Mouvement
	 */
	public Iterator<Mouvement> iterator(){
		return mooves.iterator();
	}
	
	/**
	 * Permet l'ajout de mouvement
	 * @param p Mouvement à ajouter
	 * @exception AssertionError si p est null
	 */
	private void ajouter(Mouvement p){
		assert(p!=null):"Erreur : p est null";
		mooves.add(p);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("LesMouvs [mooves= ");
		for (Mouvement m : mooves) {
			sb.append(m.toString());
			sb.append("\n");
		}
		sb.append("]");
		return sb.toString();
	}
}
