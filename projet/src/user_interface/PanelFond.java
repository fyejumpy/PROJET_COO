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
    public class PanelFond extends JPanel{
        private Image image;
        private int cmpt=0;
        
        public PanelFond(GridLayout g){
            this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ressource/fond.jpg"));
            super.setLayout(g); 
            this.repaint();
  
        }
        
        public PanelFond(GridBagLayout g, String chemin){
            this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource(chemin));
            super.setLayout(g);
            this.repaint();  
        }
        
        public PanelFond(GridBagLayout g){
              this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ressource/fond.jpg"));
              super.setLayout(g); 
              this.repaint();
        }
  
        @Override
        public void paintComponent(Graphics g)
        {
          super.paintComponent(g);
          g.drawImage (image, 0, 0, null);
          repaint();
        }
}

