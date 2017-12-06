/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Domaine.Joueur;
import Persistance.JoueurMapper;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Paul
 */
public class Controleur {
    JoueurMapper jM;
    
    
    public Controleur(){
        jM= new JoueurMapper();
    }
    
    public boolean connexion(String username, String mdp){
        boolean co= false;
        Joueur j = jM.find(username, mdp);
        if(j != null){
            co=true;
        }else{
            JOptionPane.showMessageDialog(new JFrame("Erreur :"), "Erreur le joueur n'existe pas.");
        }
        return co;
    }
    
    public Boolean ajoutJoueur(String username, String mdp){
        boolean insertok= false;
        jM = new JoueurMapper();
        Joueur j = new Joueur(username, mdp, 0);
        insertok=jM.insert(j);
        
        return insertok;
    }
    
   // public void deplacement()
}
