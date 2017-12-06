/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import Domaine.Partie;

/**
 *
 * @author gaillardc
 */
public class Reglages {
    private int idReglages;
    private int distanceMaxTerr;
    private int tailleCarte;
    private int nbRessources;
    private int nbMaxJoueurs;
    private int nbRessNG;
    private int distanceMinVille;
    private Partie partie;
    private TypeCarte typeCarte;

    public Reglages(int distanceMaxTerr, int tailleCarte, int nbRessources, int nbMaxJoueurs, int nbRessNG, int distanceMinVille, Partie partie, TypeCarte typeCarte) {
        this.idReglages = this.idReglages+1;
        this.distanceMaxTerr = distanceMaxTerr;
        this.tailleCarte = tailleCarte;
        this.nbRessources = nbRessources;
        this.nbMaxJoueurs = nbMaxJoueurs;
        this.nbRessNG = nbRessNG;
        this.distanceMinVille = distanceMinVille;
        this.partie = partie;
        this.typeCarte = typeCarte;
    }

    public int getIdReglages() {
        return idReglages;
    }

    public int getDistanceMaxTerr() {
        return distanceMaxTerr;
    }
    
    public int getTailleCarte() {
        return tailleCarte;
    }

    public int getNbRessources() {
        return nbRessources;
    }

    public void setNbRessources(int nbRessources) {
        this.nbRessources = nbRessources;
    }

    public int getNbMaxJoueurs() {
        return nbMaxJoueurs;
    }

    public int getNbRessNG() {
        return nbRessNG;
    }

    public void setNbRessNG(int nbRessNG) {
        this.nbRessNG = nbRessNG;
    }

    public int getDistanceMinVille() {
        return distanceMinVille;
    }

    public Partie getPartie() {
        return partie;
    }

    public TypeCarte getTypeCarte() {
        return typeCarte;
    }    

    @Override
    public String toString() {
        return "Reglages{" + "idReglages=" + idReglages + ", distanceMaxTerr=" + distanceMaxTerr + ", tailleCarte=" + tailleCarte + ", nbRessources=" + nbRessources + ", nbMaxJoueurs=" + nbMaxJoueurs + ", nbRessNG=" + nbRessNG + ", distanceMinVille=" + distanceMinVille + ", partie=" + partie + ", typeCarte=" + typeCarte + '}';
    }
    
    
}

