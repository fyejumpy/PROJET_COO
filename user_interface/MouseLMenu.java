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
public class MouseLMenu  extends MouseAdapter {
    private BoutonMenu Jb;
    Thread tMExit, tMEntered, tMPressed;

    public MouseLMenu(BoutonMenu Jb) {
        this.Jb = Jb;
    }
    
    public MouseLMenu() {
        this.Jb = null;
    }

    public BoutonMenu getJb() {
        return Jb;
    }

    public void setJb(BoutonMenu Jb) {
        this.Jb = Jb;
    }
    
    public void mouseExited(MouseEvent me)
    {
      Thread t = new Thread(new Runnable()
      {
        public void run(){
          
          System.out.println("Test sortie.");
          Jb.paintNover(Jb.getGraphics());
          try {Thread.sleep(1000);}
          catch (Exception e){}
        }
      });
      t.start();
      //System.out.println(t.getId());
    }

    public void mouseEntered(MouseEvent me)
    {
      Thread t = new Thread(new Runnable()
      {
        public void run()
        { 
            System.out.println("Test entree.");
            Jb.paintOver();
            try {Thread.sleep(1000);}
            catch (Exception e){}
        }
      });
      t.start();
      //System.out.println(t.getId());
    }

    public void mousePressed(MouseEvent me)
    {
      Thread t = new Thread(new Runnable()
      {
        public void run()
        {
          System.out.println("Test press.");
          try {Thread.sleep(1);}
          catch (Exception e){}
          
        }
      });
      t.start();
       //System.out.println(t.getId());
    }
}
