/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

import Persistance.IDomainObject;

/**
 * Interface déclarant une méthode permettant de faire une "action" sur l'objet IDomainObject passé en paramètre (ici Personne)
 * @author lemoine
 */
public interface Observateur {
    void action(IDomainObject o);
}
