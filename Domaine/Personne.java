/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import Persistance.IDomainObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe définissant l'objet personne
 * @author lemoine
 */
public class Personne implements IDomainObject {

    private String Id;
    private String nom;
    private String prenom;
    private String eval;
    private Personne pere;
    private List<Observateur> obs;
    List<Personne> listeFils;

    public void add(Observateur o) {
            obs.add(o);
    }

    public void accepter(Visiteur v) {
            v.visiter(this);
    }		

    public Personne() {
            obs = new ArrayList<Observateur>();
            this.Id="";
            this.nom="";
            this.prenom="";
            this.eval="";
            this.pere=null;
            this.listeFils= new ArrayList<Personne>();
    }

    /* implementer ca dans une superclasse pour eviter d'avoir a le retaper chaque fois */
    public void notifier() {
        for (Observateur o : obs) o.action(this);
        System.out.println("Nouvel modif");
    }

    /*ensemble des getters et setters de l'objet*/
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    
    public String getFullName(){
        return this.nom +" "+this.prenom;
    }
    

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEval() {
        return eval;
    }

    public void setEval(String eval) {
        notifier();
        this.eval = eval;
    }

    public List<Observateur> getObs() {
        return obs;
    }

    public void setObs(List<Observateur> obs) {
        this.obs = obs;
    }

    public List<Personne> getListeFils() {
        return listeFils;
    }

    public void setListeFils(List<Personne> listF) {
        this.listeFils = listF; 
    }
    
    /*méthode permettant la gestion de la liste de fils d'une personne*/
    public void ajoutFils(Personne fils){
        this.listeFils.add(fils);
        if(fils.getPere() != null){
         fils.supprPere();
        }
        fils.setPere(this);
    }
    
    public void ajoutPere(Personne pere){
        this.pere = pere;
    }

    public Personne getPere() {
        return pere;
    }

    private void setPere(Personne pere) {
        this.pere = pere;
    }
    
    private void supprPere(){
        this.pere.getListeFils().remove(this);
        this.pere= null;
    }
    
    public void supprFils(Personne fils){
        this.listeFils.remove(fils);
        fils.supprPere();
    }

    @Override
    public String toString() {
        return getFullName();
    }
    
    
}
