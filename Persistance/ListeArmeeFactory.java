/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

import Domaine.Armee;
import Persistance.JoueurMapper;
import java.util.List;

/**
 * Methode permettant la création de la factory de création de la liste de fils
 * @author lemoine
 */

public class ListeArmeeFactory implements Factory<List<Armee> > {

    private String Id;
    public ListeArmeeFactory(String Id) {
            this.Id = Id;
    }
    public List<Armee> create() {
            System.out.println("On est dans la factory");
            return ArmeeMapper.getInstance().findArmeeById(Id);
    }
}
