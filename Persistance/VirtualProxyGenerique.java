/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Virtual proxy générique permettant de créer le proxy de Personne pour l'initialisation des listes d'amis
 * @author lemoine
 */
public class VirtualProxyGenerique {
     public static class VirtualProxyBuilder<T> implements InvocationHandler {
        T realObject = null; 
        Factory<T> factory; 
        Class<?> iface;
        /*
         * On passe iface (qui doit représenter le type T), par exemple si on cree un VirtualProxyBuilder<Toto>
         * alors iface doit etre Toto.class. Si on ne respecte pas ceci, on aura une exception lors de l'appel
         * de getProxy()
         */
        public VirtualProxyBuilder(Class<?> iface, Factory<T> factory) {
            this.iface = iface;
            this.factory = factory;
        }
        
        /*
         * getProxy() va creer un virtual proxy de T, et le retourner.
         * On appelle Proxy.newProxyInstance(), qui fait partie de l'API reflexion Java.
         * Le @SuppressWarnings() est la pour éviter le warning à propos du cast (T),
         * en effet rien ne permet au compilateur Java d'être sur que au moment de l'execution
         * le retour de Proxy.newProxyInstance() sera bien de type T.
         *
         * Par contre nous on peut en etre sur a partir du moment où iface represente bien le type T.
         */
        public T getProxy() {
            @SuppressWarnings("unchecked")
            T r  = (T) Proxy.newProxyInstance(iface.getClassLoader(), new Class<?>[] { iface }, this);
            System.out.println("PROXY: On a cree le virtual proxy!");
            return r;
        }

        /*
         * Cette methode sera appellee automatiquement (via la reflexion Java) chaque fois qu'une methode
         * va etre appelée sur le virtual proxy (c-a-d sur l'objet retourné par getProxy())
         * Si realObject est null, alors on le créé à l'aide de la factory.
         */
 	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
 	        /*System.out.println("PROXY: On a appelle la methode " + method.getName() + " sur le virtual proxy!");*/
 	        if (realObject == null) {
 	            System.out.println("PROXY: On initialise l'objet proxyfié maintenant");
 	            realObject = factory.create();
 	        }
 	        /*System.out.println("PROXY: On appelle la methode sur l'objet reel.");*/
 	        return method.invoke(realObject, args);
  	}
    }
}
