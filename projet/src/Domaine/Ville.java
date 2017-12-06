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
public class Ville {
    private int idVille;
    private String nomVille;
    private Joueur joueur;
    private List<Territoire> listeTerritoireVille;

    public Ville(String nomVille, Joueur joueur, List<Territoire> listeTerritoireVille) {
        this.idVille = this.idVille+1;
        this.nomVille = nomVille;
        this.joueur = joueur;
        this.listeTerritoireVille = listeTerritoireVille;
    }

    public int getIdVille() {
        return idVille;
    }

    public String getNomVille() {
        return nomVille;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public List<Territoire> getListeTerritoireVille() {
        return listeTerritoireVille;
    }

    @Override
    public String toString() {
        return "Ville{" + "idVille=" + idVille + ", nomVille=" + nomVille + ", joueur=" + joueur + ", listeTerritoireVille=" + listeTerritoireVille + '}';
    }  
}
