/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Paul
 */
public class BoutonMenu extends JButton {
    private static final long serialVersionUID = 1L;
    ImageIcon imgClick, imgNClick;
    
    public BoutonMenu(String tImgNClick, String tImgClick){
        this.imgClick = new ImageIcon(this.getClass().getResource(tImgClick));
        this.imgNClick=new ImageIcon(this.getClass().getResource(tImgNClick));
        this.addMouseListener(new MouseLMenu(this));
        this.setBorderPainted(false); 
        this.setContentAreaFilled(false); 
        this.setFocusPainted(false); 
        this.setOpaque(false);
        this.setIcon(this.imgNClick);
    }
    
   public void paintNover(Graphics g){
       this.setIcon(this.imgNClick);
    }

   public void paintOver(){
         this.setIcon(this.imgClick);
    }
}
