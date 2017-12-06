/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

import Domaine.Observable;
import Domaine.Visitable;


/**
 * Interface pour la récupération de l'UoW des objets
 * @author lemoine
 */
public interface IDomainObject extends Observable,Visitable {
}
