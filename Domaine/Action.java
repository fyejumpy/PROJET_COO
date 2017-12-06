/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domaine;

/**
 * A voir
 * @author gaillardc
 */
public class Action {
    private int idAction;
    private int distanceMaxDep;
    private TypeAction typeAction;

    public Action(int distanceMaxDep, TypeAction typeAction) {
        this.idAction = this.idAction+1;
        this.distanceMaxDep = distanceMaxDep;
        this.typeAction = typeAction;
    }

    public int getIdAction() {
        return idAction;
    }

    public int getDistanceMaxDep() {
        return distanceMaxDep;
    }

    public TypeAction getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(TypeAction typeAction) {
        this.typeAction = typeAction;
    }

    @Override
    public String toString() {
        return "Action{" + "idAction=" + idAction + ", distanceMaxDep=" + distanceMaxDep + ", typeAction=" + typeAction + '}';
    }
    
    
}
