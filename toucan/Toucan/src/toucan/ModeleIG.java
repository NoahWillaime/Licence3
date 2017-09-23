package toucan;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import toucan.modele.Modele;
import toucan.vues.VueGraphique;

public class ModeleIG extends JFrame{
	public ModeleIG(Modele m) {
		super("Toucan");
		
		VueGraphique v1 = new VueGraphique(m);
		add(v1, BorderLayout.CENTER);
		
		//
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		int tab[] = {0, 1, 2};
		Modele m = new Modele(tab);
		m.setPosition(2, 100, 100);
		m.setPosition(0, 250, 250);
		m.creerLesMouvements(
				0, Modele.NORD, 250,
				0, Modele.EST, 200,
				1, Modele.STABLE, 100,
				1, Modele.SUD, 100,
				2, Modele.OUEST, 50,
				2, Modele.STABLE, 200,
				2, Modele.SUD, 150);		
        
		new ModeleIG(m);
	}
}

