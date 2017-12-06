/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import Persistance.IDomainObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Persistance.*;
import java.util.UUID;

/**
 *
 * @author gaillardc
 */
public class Joueur implements IDomainObject{
    private String pseudo;
    private String mdp;
    private int nbRessources;
    private List<Partie> listePartieJoueur;
    private List<Ville> listeVilleJoueur;
    private List<Territoire> listeTerritoireJoueur;
    private List<Armee> listeArmeeJoueur;
    List<Observateur> obs;
    

    public Joueur(String pseudo, String mdp, int nbRessources) {
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.nbRessources = nbRessources;
        this.listePartieJoueur = null;
        this.listeVilleJoueur = null;
        this.listeTerritoireJoueur = null;
        this.listeArmeeJoueur = null;
        this.obs = new ArrayList<Observateur>();
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
 
    public String getPseudo() {
        return pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    
    

    public int getNbRessources() {
        return nbRessources;
    }

    public void setNbRessources(int nbRessources) {
        this.nbRessources = nbRessources;
        notifier();
    }

    public List<Partie> getListePartieJoueur() {
        return listePartieJoueur;
    }

    /*public void setListePartieJoueur(List<Partie> listePartieJoueur) {
        this.listePartieJoueur = listePartieJoueur;
        notifier();
    }

    public List<Ville> getListeVilleJoueur() {
        return listeVilleJoueur;
    }

    public void setListeVilleJoueur(List<Ville> listeVilleJoueur) {
        this.listeVilleJoueur = listeVilleJoueur;
        notifier();
    }

    public List<Territoire> getListeTerritoireJoueur() {
        return listeTerritoireJoueur;
    }

    public void setListeTerritoireJoueur(List<Territoire> listeTerritoireJoueur) {
        this.listeTerritoireJoueur = listeTerritoireJoueur;
        notifier();
    }*/

    public List<Armee> getListeArmeeJoueur() {
        return listeArmeeJoueur;
    }

    public void setListeArmeeJoueur(List<Armee> listeArmeeJoueur) {
        this.listeArmeeJoueur = listeArmeeJoueur;
        notifier();
    }

    public void accepter(Visiteur v) {
            v.visiter(this);
    }
    
    public void notifier() {
            System.out.println("Joueur: event detecte! on notifie tous les observateurs...");
            for (Observateur o : obs) {
                    o.action(this);
            }
    }
    
    public void add(Observateur o) {
            System.out.println("Joueur: Ajout d'un observateur!");
            obs.add(o);
    }
    
    @Override
    public String toString() {
        return "Joueur{" + "pseudo=" + pseudo + ", nbRessources=" + nbRessources + ", listePartieJoueur=" + listePartieJoueur + ", listeVilleJoueur=" + listeVilleJoueur + ", listeTerritoireJoueur=" + listeTerritoireJoueur + ", listeArmeeJoueur=" + listeArmeeJoueur + '}';
    }
    
}
