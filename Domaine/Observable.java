/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

/**
 * Interface permettant d'"observer" l'objet personne (permet par la suite via la notification de placer l'objet personne en attente d'update)
 * @author lemoine
 */
public interface Observable {
        void add(Observateur o);
        void notifier();
}
