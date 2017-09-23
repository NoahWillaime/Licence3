package toucan.vues;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import toucan.graphique.PanneauAnimation;
import toucan.modele.Modele;

public class VueGraphique extends JPanel implements Observer {
	private Observable o;
	private PanneauAnimation pa;
	
	public VueGraphique(Observable o) {
		super();
		o.addObserver(this);
		pa = new PanneauAnimation(((Modele)o).getLesCases());
		this.add(pa);
	}

	@Override
	public void update(Observable o, Object arg1) {
		pa.repaint();
	}	
}
