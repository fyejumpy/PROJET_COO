/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

import Domaine.Visiteur;
import Domaine.Observateur;
import Persistance.Committer;
import java.util.HashSet;
import java.util.Set;

/**
 * UoW permettant de récupérer les objets Personnes modifiés pour les update par la suite sur la base
 * @author lemoine
 */
public class UoW implements Observateur {
    static UoW inst = null;
    
    public static UoW getInstance() {
            if (inst == null) {
                    inst = new UoW();
            }
            return inst;
    }
    private Set<IDomainObject> dirty;
    
    UoW() {
            dirty = new HashSet<IDomainObject>();
    }

    public void action(IDomainObject obj) {
            System.out.println("Un objet a ete modifie!");
            dirty.add(obj);
    }
    public void commit() {
            Visiteur v = new Committer();
            for (IDomainObject obj : dirty) {
                    v.visiter(obj);
            }
            dirty.clear();
    }
}
