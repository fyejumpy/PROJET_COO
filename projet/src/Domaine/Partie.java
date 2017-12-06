/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import java.util.List;

/**
 *
 * @author gaillardc
 */
public class Partie {
    private int idPartie;
    private String nomPartie;
    private String etat;
    private int dureeTour;
    private int nbTours;
    private String nomGagnant;
    private List<Joueur> listeJoueurPartie;
    private Carte carte;
    /*A voir List d'action*/
    private List<Action> listeActionPartie;
    
    private Reglages reglages;

    public Partie(String nomPartie, String etat, int dureeTour, int nbTours, String nomGagnant, List<Joueur> listeJoueurPartie, Carte carte, List<Action> listeActionPartie, Reglages reglages) {
        this.idPartie = this.idPartie+1;
        this.nomPartie = nomPartie;
        this.etat = etat;
        this.dureeTour = dureeTour;
        this.nbTours = nbTours;
        this.nomGagnant = nomGagnant;
        this.listeJoueurPartie = listeJoueurPartie;
        this.carte = carte;
        this.listeActionPartie = listeActionPartie;
        this.reglages = reglages;
    }

    public int getIdPartie() {
        return idPartie;
    }

    public String getNomPartie() {
        return nomPartie;
    }
    
    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getDureeTour() {
        return dureeTour;
    }

    public int getNbTours() {
        return nbTours;
    }

    public String getNomGagnant() {
        return nomGagnant;
    }

    public void setNomGagnant(String nomGagnant) {
        this.nomGagnant = nomGagnant;
    }

    public List<Joueur> getListeJoueurPartie() {
        return listeJoueurPartie;
    }

    public void setListeJoueurPartie(List<Joueur> listeJoueurPartie) {
        this.listeJoueurPartie = listeJoueurPartie;
    }

    public Carte getCarte() {
        return carte;
    }

    public List<Action> getListeActionPartie() {
        return listeActionPartie;
    }

    public Reglages getReglages() {
        return reglages;
    }    

    @Override
    public String toString() {
        return "Partie{" + "idPartie=" + idPartie + ", nomPartie=" + nomPartie + ", etat=" + etat + ", dureeTour=" + dureeTour + ", nbTours=" + nbTours + ", nomGagnant=" + nomGagnant + ", listeJoueurPartie=" + listeJoueurPartie + ", carte=" + carte + ", listeActionPartie=" + listeActionPartie + ", reglages=" + reglages + '}';
    }
    
    
    
}
