/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface;

import Domaine.Joueur;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Paul
 */
public class Interface_partie extends JFrame{
    public int WIDTH = 300;
    public int HEIGHT = 100;
    
    private JLabel nombreJoueur, tailleCarte;
    private JTextField nbJoueur, longCarte, largCarte;
    private JList<Joueur> listJoueur;
    private JButton retour, valider;
    private GridBagLayout gbl;
    private JPanel panelPartie;
    
    public Interface_partie(){
        super("Création de partie : ");
        Dimension dim = new Dimension(WIDTH, HEIGHT);
        
        this.gbl = new GridBagLayout();
        this.panelPartie = new JPanel(this.gbl);
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(30, 15, 0, 10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=0;
        c.gridy=0;
        
        
        
        this.setVisible(true);
    }
}
