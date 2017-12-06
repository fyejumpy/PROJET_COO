/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

import Domaine.Armee;
import Domaine.Visiteur;
import Domaine.Joueur;
import Domaine.Personne;

/**
 * Committer permettant de mettre à jour les objets modifiés vers la base
 * @author lemoine
 */
public class Committer extends Visiteur {
   public void visiter(Joueur j) {
        JoueurMapper.getInstance().update(j);
        System.out.println("On fait une update d'un objet Personne!");
    } 
   
   public void visiter(Armee a){
       
   }    
}
