/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author Paul
 */
public class PanelMenu extends JPanel{
        private Image image;
        
        public PanelMenu(GridLayout g, boolean cote){
            if(!cote){
                this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ressource/menu/menu_milieu.png"));
            }else{
                this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ressource/menu/menu_cote.png"));
            }
            super.setLayout(g);
            this.repaint();  
        }

        public PanelMenu(GridBagLayout g){
              this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ressource/menu_2.png"));
              super.setLayout(g); 
              this.repaint();
        }
       
        @Override
        public void paintComponent(Graphics g)
        {
          super.paintComponent(g);
          g.drawImage (image, 0, 0, null);
          //repaint();
        }
}
