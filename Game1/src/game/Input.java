package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//this is a bult in interface for users input
public class Input implements KeyListener
{
    private boolean spacePressed=false;
    private boolean spaceReleased=true;
    
    public boolean isSpacePressed()
    {
        boolean s=spacePressed;
        spacePressed=false;
        return s;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        //VK_SPACE == spacebar
        if(e.getKeyCode() == KeyEvent.VK_SPACE && spaceReleased)
        {
            spacePressed=true;
            spaceReleased=false;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) 
    {
        if(e.getKeyCode() == KeyEvent.VK_SPACE)
        {
                spacePressed=true;
                spaceReleased=false;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) 
    {
        
    }


    


}
