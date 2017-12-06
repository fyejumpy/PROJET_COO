/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe permettant d'identifié selon son id et une référence une personne donnée
 * @author lemoine
 */
public class IdentityMap<T> {
    private Map<String, WeakReference<T>> map;

    public IdentityMap() {
            map = new HashMap<String, WeakReference<T> >();
    }

    public void del (String id) {
            map.remove(id);
    }

    public T get(String id) {
            WeakReference<T> ref = map.get(id);
            if (ref == null)
                    return null;

            T obj = ref.get();
            if (obj == null) {
                    map.remove(id);
            }
            return obj;
    }

    public void put(String id, T obj) {
            map.put(id, new WeakReference<T>(obj));
    }
}
