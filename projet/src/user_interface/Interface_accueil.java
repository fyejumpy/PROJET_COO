/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface;

import Control.Controleur;
import Domaine.Carte;
import Persistance.JoueurMapper;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;


/**
 *
 * @author Paul
 */
public class Interface_accueil extends JFrame{
    private BoutonMenu nouvellePartie, chargerPartie, quitter, retour;
    private Controleur c;
    private GridBagLayout gbl;
    private PanelFond  panelJeu;
    private  MediaPlayer mediaPlayer;
    private Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize(), dimBouton = new Dimension(225, 100);
    
    public Interface_accueil(Controleur c)  {
        this.c = c;
        chargementAccueil();
    }
    
    public void chargementAccueil(){
        /*on charge les éléments de la page d'accueil*/
        this.setTitle("Battle of Kingdoms");
        Dimension dim = new Dimension(WIDTH, HEIGHT);
      
        JFXPanel fxPanel= new JFXPanel();
        
        panelAccueil();

        //this.pf.add(this.panelAccueil);
        /*Ne marche pas*/
        
        //super.add(panelAccueil);
        super.setContentPane(panelAccueil());
        
        super.setSize(dimEcran);
        
        /*Met la fenetre en plein écran*/
        super.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
        /*fermeture via le bouton de la croix*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*on met la fenetre en visible*/
        
        Media hit = new Media(getClass().getResource("/ressource/son/musicIntro.mp3").toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setVolume(0.03);
        mediaPlayer.play();
        
        this.setVisible(true);
        
        this.invalidate();
        this.revalidate();
        this.validate();
        
        nouvellePartie(this);
        chargerPartie();
        quitter();
        
    }
    
    public void chargementJeux(){
        /*on met en place la fenetre de jeux*/
        //Interface_jeux ij= new Interface_jeux(); 
         /*Initialisation des différents element de la frame*/
        /*partie panel*/
        getContentPane().removeAll();
        Carte carte = new Carte(0,30,30,50,65,80);
         //panelJeu(carte);
        add(panelJeu(carte));
        retour();
        this.invalidate();
        this.revalidate();
        this.validate();
        
        System.out.println("test");
        /*On dispose la fenetre*/
        //dispose();
    }
    
    public PanelFond panelJeu(Carte carte){
        GridLayout glMap, glPM1, glPM2, glPM3; 
        GridBagLayout glMenu, glPanel;
        GridBagConstraints cBouton, cMenu;
        JPanel panelMap, panelMenus;
        JScrollPane jSP;
        PanelMenu pM1,pM2,pM3;
        PanelFond pf;
        
        /*partie panel*/
        
        /*Panel de la map et JScrollPane*/
        glMap = new GridLayout(30,30);
        panelMap = new JPanel(glMap);
        jSP = new JScrollPane(panelMap, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,  JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jSP.setPreferredSize(new Dimension((int)dimEcran.getWidth(),(int)dimEcran.getHeight()-300));
         
        /*Panel Menu*/
        glMenu = new GridBagLayout();
        glPM1 = new GridLayout(1,1);
        glPM2 = new GridLayout(1,1);
        glPM3 = new GridLayout(1,1);
        
        panelMenus = new JPanel(glMenu);
        pM1= new PanelMenu(glPM1,true);
        pM2= new PanelMenu(glPM2, false);
        pM3= new PanelMenu(glPM3, true);
        
        panelMenus.setOpaque(false);
        /*Panel gestion de l'ensemble des panel*/
        glPanel = new GridBagLayout();
        pf =new PanelFond(glPanel);
        
        /*Partie création map*/
        /*gestion des contraintes*/
        cBouton = new GridBagConstraints();
        cMenu = new GridBagConstraints();
        
        /*Partie ajout bouton de la map*/
        cBouton.fill =GridBagConstraints.CENTER;
        for(int i =0;i<carte.getHauteur()*carte.getLargeur(); i++){
            BoutonMap buttonMap; 
            switch(carte.getListeTerritoiresCarte().get(i).getTt()){
                case FORET:
                    buttonMap = new BoutonMap(i, "/ressource/decor/foret.png","/ressource/decor/foret_click.png","/ressource/decor/foret_Hover.png");
                    panelMap.add(buttonMap,cBouton);
                    break;
                case MONTAGNE:
                    buttonMap = new BoutonMap(i, "/ressource/decor/montagne.png", "/ressource/decor/montagne_click.png","/ressource/decor/montagne_Hover.png");
                    panelMap.add(buttonMap,cBouton);
                    break;
                case PLAINE:
                    //buttonMap = new JButton("p");
                    buttonMap = new BoutonMap(i, "/ressource/decor/plaine.png", "/ressource/decor/plaine_click.png","/ressource/decor/plaine_Hover.png");
                    panelMap.add(buttonMap,cBouton);
                    break;
                case CHAMPS:
                    buttonMap= new BoutonMap(i, "/ressource/decor/champs.png","/ressource/decor/champs_click.png","/ressource/decor/champs_Hover.png");
                    panelMap.add(buttonMap,cBouton);
                    break;
            }
        }
        
        /*Partie bouton menu*/
        /*ajout de l'ensemble des elements (différents panel etc)*/
        /*Partie ajout panel map*/
        cMenu.fill =GridBagConstraints.VERTICAL;
        cMenu.gridx=0;
        cMenu.gridy=0;
        pf.add(jSP , cMenu  );
        
        /*Partie ajout panel menu*/
        this.retour = new BoutonMenu("/ressource/boutons/but_quit_game_pasClick.png","/ressource/boutons/but_quit_game_Click.png");
        panelMenus.setPreferredSize(new Dimension((int)dimEcran.getWidth()-50,220));
        pM1.setPreferredSize(new Dimension(515, 220));
        pM2.setPreferredSize(new Dimension(840, 220));
        pM3.setPreferredSize(new Dimension(515, 220));
                
        
        pM1.add(this.retour);
        
        cMenu.fill =GridBagConstraints.CENTER;
        cMenu.gridx=0;
        cMenu.gridy=0;
        panelMenus.add(pM1, cMenu);
        cMenu.fill =GridBagConstraints.CENTER;
        cMenu.gridx=1;
        cMenu.gridy=0;
        panelMenus.add(pM2);
        cMenu.fill =GridBagConstraints.CENTER;
        cMenu.gridx=2;
        cMenu.gridy=0;
        panelMenus.add(pM3);
        
        cMenu.fill =GridBagConstraints.BOTH;
        cMenu.gridx=0;
        cMenu.gridy=1;
        pf.add(panelMenus,cMenu);
        return pf;
    }
    
    public PanelFond panelAccueil() {
         /*Initialisation des différents element de la frame*/
        /*partie panel*/
        this.gbl = new GridBagLayout();
        PanelFond panelAccueil = new PanelFond(this.gbl);
        
        /*gestion des contraintes*/
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(30, 15, 0, 10);
        
        /*Partie boutons*/
        this.nouvellePartie = new BoutonMenu("/ressource/boutons/but_new_game_pasclick.png","/ressource/boutons/but_new_game_click.png");
        this.nouvellePartie.setPreferredSize(dimBouton);
        c.fill =GridBagConstraints.CENTER;
        c.gridx=0;
        c.gridy=0;
        panelAccueil.add(this.nouvellePartie,c);

        this.chargerPartie = new BoutonMenu("/ressource/boutons/but_load_game_pasClick.png","/ressource/boutons/but_load_game_Click.png");
        this.chargerPartie.setPreferredSize(dimBouton);
        c.fill =GridBagConstraints.CENTER;
        c.gridx=0;
        c.gridy=1;
        panelAccueil.add(this.chargerPartie,c);
        
        this.quitter = new BoutonMenu("/ressource/boutons/but_quit_game_pasClick.png","/ressource/boutons/but_quit_game_Click.png");
        this.quitter.setPreferredSize(dimBouton);
        c.fill =GridBagConstraints.CENTER;
        c.gridx=0;
        c.gridy=2;
        panelAccueil.add(this.quitter,c);
        
        
        
        /*ajout de l'ensemble des elements*/
        panelAccueil.setOpaque(false);
        
        nouvellePartie(this);
        chargerPartie();
        quitter();
        
        return panelAccueil;
    }
    
    public void nouvellePartie(JFrame fen){
        this.nouvellePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Je m'active");
                chargementJeux();
            }
        });
    }
    
    public void chargerPartie(){
        this.chargerPartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
    public void quitter(){
        this.quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("yolo");
                mediaPlayer.dispose();
                dispose();
                System.exit(0);
            }
        }); 
    }
    
    public void retour(){
        this.retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                add(panelAccueil());
                invalidate();
                revalidate();
                validate();
                
            }
        });
    }


}
