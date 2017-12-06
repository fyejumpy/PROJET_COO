/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet_v1.pkg0;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import user_interface.Interface_accueil;
import user_interface.Interface_jeux;
import user_interface.Interface_connexion;

/**
 *
 * @author lemoine
 */
public class Projet_V10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SwingUtilities.invokeLater(new Runnable()
        {
          @Override
          public void run()
          {
                Interface_connexion iC= new Interface_connexion();
                //Interface_accueil iA = new Interface_accueil();
                //Interface_jeux iJ = new Interface_jeux();
          }
        });
    }
    
}
