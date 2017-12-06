/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import Domaine.Partie;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gaillardc
 */
public class Carte {
    private int idCarte;
    private int  hauteur, largeur;
    private List<Territoire> listeTerritoiresCarte;

    public Carte(int idCarte,  List<Territoire> listeTerritoiresCarte, List<Partie> listePartieTerritoire) {
        this.idCarte = idCarte;
        this.listeTerritoiresCarte = listeTerritoiresCarte;
    }

    public Carte(int idCarte, int hauteur, int largeur, int probaPlaine, int probaMontagne, int probaChamps) {
        this.idCarte = idCarte;
        this.hauteur=hauteur;
        this.largeur= largeur;
        this.listeTerritoiresCarte = new ArrayList<Territoire>();
        
        for(int i = 0; i< hauteur*largeur; i++){
            int territoire = (int)(Math.random() * (100-0));
            if(territoire >= 0 && territoire <= probaPlaine){
                this.listeTerritoiresCarte.add(new Territoire(null,null, TypeTerritoire.PLAINE));
            } else if(territoire > probaPlaine && territoire <= probaMontagne){
                this.listeTerritoiresCarte.add(new Territoire(null,null, TypeTerritoire.MONTAGNE));
            }else if(territoire > probaMontagne && territoire <= probaChamps){
                this.listeTerritoiresCarte.add(new Territoire(null,null, TypeTerritoire.CHAMPS));
            }else if (territoire > probaChamps && territoire <=100){
                this.listeTerritoiresCarte.add(new Territoire(null,null, TypeTerritoire.FORET));
            }
        }
        //p.add(e); on doit ajouter un objet de type component mais component dans la couche presentation, pas domaine. Il faut que le component rep
        //resente un component, on ajoute pas un territoire direct
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public int getIdCarte() {
        return idCarte;
    }

    public List<Territoire> getListeTerritoiresCarte() {
        return listeTerritoiresCarte;
    }
    
    
    public void ajoutTerritoire(int indice, Territoire t){
        this.listeTerritoiresCarte.remove(indice);
        this.listeTerritoiresCarte.add(indice, t);
    }
    
    @Override
    public String toString() {
        return "Carte{" + "idCarte=" + idCarte + ", listeTerritoiresCarte=" + listeTerritoiresCarte + '}';
    }
    
    
    
}
