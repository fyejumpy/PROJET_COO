/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_interface;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Paul
 */
public class MouseLMap extends MouseAdapter{
     private BoutonMap Jb;

    public MouseLMap(BoutonMap Jb) {
        this.Jb = Jb;
        
    }

    public BoutonMap getJb() {
        return Jb;
    }

    public void setJb(BoutonMap Jb) {
        this.Jb = Jb;
    }
    
    public void mouseExited(MouseEvent me)
    {
      new Thread(new Runnable()
      {
        public void run(){
          System.out.println("Test sortie.");
          Jb.paintNover(Jb.getGraphics());
          
          try {Thread.sleep(1000);}
          catch (Exception e){}
        }
      }).start();
    }

    public void mouseEntered(MouseEvent me)
    {
      new Thread(new Runnable()
      {
        public void run()
        {
            Jb.paintOver();
            try {Thread.sleep(1000);}
            catch (Exception e){}
        }
      }).start();
    }

    public void mousePressed(MouseEvent me)
    {
      new Thread(new Runnable()
      {
        public void run()
        {
          Jb.paintClick();
            System.out.println(Jb.getId());
          try {Thread.sleep(1000);}
          catch (Exception e){}
        }
      }).start();
    }  
}
