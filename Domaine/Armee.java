/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import Domaine.Joueur;
import Persistance.IDomainObject;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author gaillardc
 */
public class Armee implements IDomainObject{
    private String idArmee;
    private int nbMembresArmee;
    private int coord_x;
    private int coord_y;
    private Joueur joueur;
    private List<Observateur> obs;
    
    public Armee(int nbMembresArmee, int coord_x, int coord_y, Joueur joueur) {
        this.idArmee= UUID.randomUUID().toString();
        this.nbMembresArmee = nbMembresArmee;
        this.coord_x = coord_x;
        this.coord_y = coord_y;
        this.joueur = joueur;
    }

    public void setIdArmee(String idArmee) {
        this.idArmee = idArmee;
    }
    
    public String getIdArmee() {
        return idArmee;
    }

    public int getNbMembresArmee() {
        return nbMembresArmee;
    }

    public void setNbMembresArmee(int nbMembresArmee) {
        this.nbMembresArmee = nbMembresArmee;
    }

    public int getCoord_x() {
        return coord_x;
    }

    public void setCoord_x(int coord_x) {
        this.coord_x = coord_x;
    }

    public int getCoord_y() {
        return coord_y;
    }

    public void setCoord_y(int coord_y) {
        this.coord_y = coord_y;
    }
    
    public Joueur getJoueur() {
        return joueur;
    }

    public List<Observateur> getObs() {
        return obs;
    }

    public void setObs(List<Observateur> obs) {
        this.obs = obs;
    }
    
    @Override
    public String toString() {
        return "Armee{" + "idArmee=" + idArmee + ", nbMembresArmee=" + nbMembresArmee + ", coord_x=" + coord_x + ", coord_y=" + coord_y + ", joueur=" + joueur + '}';
    }

    public void accepter(Visiteur v) {
            v.visiter(this);
    }
    
    public void notifier() {
            System.out.println("Armee: event detecte! on notifie tous les observateurs...");
            for (Observateur o : obs) {
                    o.action(this);
            }
    }
    
    public void add(Observateur o) {
            System.out.println("Joueur: Ajout d'un observateur!");
            obs.add(o);
    }
}
