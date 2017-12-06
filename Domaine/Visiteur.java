/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import Persistance.IDomainObject;

/**
 * Classe abstraite donnant le corps des méthode pour pouvoir visiter un objets
 * @author lemoine
 */
public abstract class Visiteur {
        public void visiter(IDomainObject o) {
                o.accepter(this);
        }
        abstract public void visiter(Joueur j);
        abstract public void visiter(Armee a);
        
}