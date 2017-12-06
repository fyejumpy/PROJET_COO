/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface;

import Control.Controleur;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul
 */
public class Interface_connexion extends JFrame{
    private Image image;
    PanelFond panelCo;
    JTextConnexion nom, mdp;
    BoutonMenu boutNouveau, boutAnnuler, boutRetour, boutValiderAccueil, boutonValiderAjout;
    GridBagConstraints cMenu;
    GridBagLayout gbl;
    Controleur c; 
    
    public Interface_connexion(){
        /*initialisation de la fenetre de connexion*/
        this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ressource/menu/menu_con2.png"));
        this.setUndecorated(true);
        this.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
        
        /*Init controleur*/
        c = new Controleur();
        
        /*partie panel de connexion*/
        gbl = new GridBagLayout();
        this.panelCo= panelAccueil();
        
        this.setLocationRelativeTo(null);
        this.setResizable(false); 
        
        this.add(panelCo);
        this.setVisible(true);
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public PanelFond panelAccueil(){
        PanelFond panelCo = new PanelFond(gbl, "/ressource/menu/menu_con.png");
        panelCo.setSize(new Dimension(395,467)); 
        panelCo.setOpaque(false);
        this.setSize(new Dimension(420,467)); 

        this.boutNouveau = new BoutonMenu("/ressource/boutons/bout_nouveau.png", "/ressource/boutons/bout_nouveau_click.png");
        this.boutAnnuler = new BoutonMenu("/ressource/boutons/bout_annuler.png", "/ressource/boutons/bout_annuler_click.png");
        this.boutValiderAccueil = new BoutonMenu("/ressource/boutons/bout_valider.png", "/ressource/boutons/bout_valider_click.png");
        

        this.nom = new JTextConnexion("Nom d'utilisateur");
        this.mdp = new JTextConnexion("Mot de passe");
        
        cMenu = new GridBagConstraints();
        cMenu.fill = GridBagConstraints.NONE;
        cMenu.gridwidth=2;
        cMenu.gridx=0;
        cMenu.gridy=0;
        panelCo.add(this.nom, cMenu);
        
        cMenu.fill = GridBagConstraints.NONE;
        cMenu.gridwidth=2;
        cMenu.gridx=0;
        cMenu.gridy=1;
        panelCo.add(this.mdp, cMenu);
                
        cMenu.fill =GridBagConstraints.CENTER;
        cMenu.gridwidth=2;
        cMenu.gridx=0;
        cMenu.gridy=2;
        panelCo.add(this.boutNouveau, cMenu);
        
        cMenu.fill =GridBagConstraints.WEST;
        cMenu.gridwidth=1;
        cMenu.gridx=0;
        cMenu.gridy=3;
        panelCo.add(this.boutAnnuler, cMenu);
        
        cMenu.fill =GridBagConstraints.EAST;
        cMenu.gridwidth=1;
        cMenu.gridx=1;
        cMenu.gridy=3;
        panelCo.add(this.boutValiderAccueil, cMenu);
        
        /*Partie listener*/
        annuler();
        identifier();
        nouveau();
        
        return panelCo;
    }
    
    public PanelFond panelAjout(){
        PanelFond panelAjout = new PanelFond(gbl, "/ressource/menu/menu_con.png");
        panelAjout.setSize(new Dimension(395,467)); 
        panelAjout.setOpaque(false);
        this.setSize(new Dimension(420,467)); 

        this.boutRetour = new BoutonMenu("/ressource/boutons/bout_annuler.png", "/ressource/boutons/bout_annuler_click.png");
        this.boutonValiderAjout = new BoutonMenu("/ressource/boutons/bout_valider.png", "/ressource/boutons/bout_valider_click.png");
        
        this.nom = new JTextConnexion("Nom d'utilisateur");
        this.mdp = new JTextConnexion("Mot de passe");
        
        cMenu = new GridBagConstraints();
        cMenu.fill = GridBagConstraints.NONE;
        cMenu.gridwidth=2;
        cMenu.gridx=0;
        cMenu.gridy=0;
        panelAjout.add(this.nom, cMenu);
        
        cMenu.fill = GridBagConstraints.NONE;
        cMenu.gridwidth=2;
        cMenu.gridx=0;
        cMenu.gridy=1;
        panelAjout.add(this.mdp, cMenu);
                
        
        cMenu.fill =GridBagConstraints.WEST;
        cMenu.gridwidth=1;
        cMenu.gridx=0;
        cMenu.gridy=2;
        panelAjout.add(this.boutRetour, cMenu);
        
        cMenu.fill =GridBagConstraints.EAST;
        cMenu.gridwidth=1;
        cMenu.gridx=1;
        cMenu.gridy=2;
        panelAjout.add(this.boutonValiderAjout, cMenu);
        
       /*Partie listener*/
        retour();
        identifier();
        inscriptionJoueur();
        
        
        return panelAjout;
    }
    
        public void annuler(){
        this.boutAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
        
    public void retour(){
        this.boutRetour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                add(panelAccueil());
                repaint(); 
                invalidate();
                revalidate();
                validate();
            }
        });
    }
    
    public void identifier(){
        this.boutValiderAccueil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean coOk = false;
                if((!nom.getText().equals("")&& !nom.getText().equals("Nom d'utilisateur"))
                        && (!mdp.getText().equals("") && !mdp.getText().equals("Mot de passe")) ){
                    
                    coOk = c.connexion(nom.getText(), mdp.getText());
                }
                if(coOk){
                    Interface_accueil iA = new Interface_accueil(c);   
                }else {
                    JOptionPane.showMessageDialog(new JFrame("Erreur :"), "Erreur le joueur n'existe pas.");
                }
            }
                 
        });
    }
    
    public void inscriptionJoueur(){
        this.boutonValiderAjout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean ok=false;
                if(!nom.getText().equals("") 
                        || !nom.getText().equals("Nom d'utilisateur")
                        && !mdp.getText().equals("") 
                        || !mdp.getText().equals("Mot de passe") ){
                    System.out.println("yolo je passe ici");
                    ok = c.ajoutJoueur(nom.getText(), mdp.getText()); 
                    if(!ok){
                        JOptionPane.showMessageDialog(new JFrame("Erreur :"), "Erreur joueur déjà défini.");
                    }
                }else{
                    JOptionPane.showMessageDialog(new JFrame("Erreur :"), "Erreur le champ nom d'utilisateur/mot de passe est vide.");
                }
            }
        });
    }
    
    public void nouveau(){
        this.boutNouveau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                add(panelAjout());
                //add(new PanelCo());
                //Interface_accueil iA = new Interface_accueil();
                repaint();
                
                invalidate();
                revalidate();
                validate();
            }
        });
    }
    
}


