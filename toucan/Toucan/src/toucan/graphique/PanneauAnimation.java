package toucan.graphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import toucan.modele.LesCases;

/**
 * 24 juin 2014 - maj 29 août 2017
 *
 * @author brigitte wrobel-dautcourt
 */

public class PanneauAnimation extends JPanel {
    
    protected LesCasesAnimation lesCasesAnimation ;
    
    protected int temps ;
    protected static int temporisation = 100 ;
    protected LesCases cases;
    
    public PanneauAnimation(LesCases cases) {
        super() ;
        this.cases = cases;
        this.setPreferredSize(new Dimension(500, 500)) ;
        lesCasesAnimation = new LesCasesAnimation(this.cases) ;
        temps = 0 ;
        repaint() ;
    }
     
    @Override
    public void paintComponent(Graphics g) { 
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth() ;
        int h = getHeight() ;

        GradientPaint gp = new GradientPaint(-w, -h, Color.LIGHT_GRAY, w, h, Color.WHITE);
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);
        lesCasesAnimation.dessiner(g, temps) ;
        temps ++ ;
        
        // à décommenter pour l'exercice 2...
         try {
             Thread.sleep(temporisation) ;
         } catch (InterruptedException ex) {
             Logger.getLogger(PanneauAnimation.class.getName()).log(Level.SEVERE, null, ex);
         }
        if (temps < this.cases.getMaxTemps())
        	repaint() ;
    }
}
