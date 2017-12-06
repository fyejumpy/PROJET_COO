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
public class BoutonMap extends JButton{
    private int id;
    private static final long serialVersionUID = 1L;
    ImageIcon imgClick, imgNClick, imgHover;
    
    public BoutonMap(int id, String tImgNClick, String tImgClick,String tImgHover){
        this.imgNClick = new ImageIcon(this.getClass().getResource(tImgNClick));
        this.imgClick =new ImageIcon(this.getClass().getResource(tImgClick));
        this.imgHover = new ImageIcon(this.getClass().getResource(tImgHover));

        this.id =id;
        //this.addMouseListener(new MouseL(this));
        this.setBorderPainted(false); 
        this.setContentAreaFilled(false); 
        this.setFocusPainted(false); 
        this.setOpaque(false);
        this.setIcon(this.imgNClick);
        this.addMouseListener(new MouseLMap(this));
        this.setBorder(null);
    }
    
   public void paintNover(Graphics g){
       this.setIcon(this.imgNClick);
    }

   public void paintOver(){
         this.setIcon(this.imgHover);
    } 
   public void paintClick(){
       this.setIcon(this.imgClick);
   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
   
}
