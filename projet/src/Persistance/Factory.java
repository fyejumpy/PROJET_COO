/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

/**
 * Facotry générique permettant la création de la liste de fils
 * @author lemoine
 */

public interface Factory<T> {
        T create();
}