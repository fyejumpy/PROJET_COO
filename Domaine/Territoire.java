/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import Domaine.Carte;
import Domaine.Ville;
import Domaine.Joueur;

/**
 *
 * @author gaillardc
 */
public class Territoire {
    private int idTerritoire;
    private int coord_x;
    private int coord_y;
    private Carte carte;
    private Joueur joueur;
    private Ville ville;
    private TypeTerritoire tt;

    public Territoire( Joueur joueur, Ville ville, TypeTerritoire typeTerritoire) {
        this.idTerritoire = this.idTerritoire+1;
        if(ville != null){
            this.ville = ville;
        }
        this.tt = typeTerritoire;
    }

    public int getIdTerritoire() {
        return idTerritoire;
    }

    public int getCoord_x() {
        return coord_x;
    }

    public int getCoord_y() {
        return coord_y;
    }

    public Carte getCarte() {
        return carte;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public TypeTerritoire getTt() {
        return tt;
    }

    public void setTt(TypeTerritoire tt) {
        this.tt = tt;
    }

    @Override
    public String toString() {
        return "Territoire{" + "idTerritoire=" + idTerritoire + ", coord_x=" + coord_x + ", coord_y=" + coord_y +  ", carte=" + carte + ", joueur=" + joueur + ", ville=" + ville + ", typeTerritoire=" + tt + '}';
    }
}
