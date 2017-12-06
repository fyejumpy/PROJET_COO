/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface;

import Domaine.Carte;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Paul
 */
public class Interface_jeux extends JFrame{
    private GridLayout glMap, glPM1, glPM2, glPM3;
    private GridBagLayout gbl,glPanel, glMenu;
    private GridBagConstraints cBouton, cMenu;
    private JPanel panelMap, panelMenus;
    private PanelFond pf;
    private PanelMenu pM1, pM2, pM3;
    private JLabel nomJoueur, coordChoix;
    private JButton forcerTour, finTour;
    private JScrollPane jSP;
    private Dimension dimEcranR, dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
    private String cheminImage = "..\\Projet_V1.0\\image\\decor\\";
    
    public Interface_jeux(){
        /*on charge les éléments de la page d'accueil*/
        this.setTitle("Battle of Kingdoms");
        Dimension dim = new Dimension(WIDTH, HEIGHT);
        
       
        
        //System.out.println((int)dimEcran.getWidth()-50);
       
        /*Met la fenetre en plein écran*/
        super.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        super.add(this.pf);
        /*super.add(panelMenu);*/
        super.setSize(dimEcran);
        /*fermeture via le bouton de la croix*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*on met la fenetre en visible*/
        this.setVisible(true);
        //resize();
        this.invalidate();
        this.revalidate();
        this.validate();
    }
    
    public void charger_interface_jeux(){
        
    }
    
    
    public void resize(){
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
              dimEcranR = getSize();
              jSP.setPreferredSize(new Dimension((int)dimEcranR.getWidth(),(int)dimEcranR.getHeight()-300));
              panelMenus.setPreferredSize(new Dimension((int)dimEcranR.getWidth()-50, (int) (jSP.getHeight()-dimEcranR.getHeight()+100)));
                System.out.println("");
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                
            }

            @Override
            public void componentShown(ComponentEvent e) {
                
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                
            }
        });
    }
}
