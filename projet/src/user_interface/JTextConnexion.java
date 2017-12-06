/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 *
 * @author Paul
 */
public class JTextConnexion extends JTextField{
    private Image image;
    
    public JTextConnexion( String infos){
        this.setOpaque( false );
        this.setBorder(null);

        this.setPreferredSize(new Dimension(295,77));
        this.image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ressource/menu/champs.png"));
        this.setText(infos);
        //this.repaint();
        clickChamp();

    }
    
    @Override
    public void paint(Graphics g){
        //ImageIcon ii = new ImageIcon("/ressource/champs.png");
        g.drawImage(image,0,0,this);  
        super.paint(g); 
    }

    /*@Override
    public void paintComponent(Graphics g)
    {
      super.paintComponent(g);
      g.drawImage (image, 0, 0, null);
      repaint();
    }*/
    
    public void clickChamp(){
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setText("");
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
}
