/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

/**
 *Interface déclarant une méthode permttant l'acceptation d'un visiteur sur un objet (ici Personne)
 * @author lemoine
 */
public interface Visitable {
        void accepter(Visiteur v);
}
