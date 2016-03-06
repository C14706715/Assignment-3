package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//This is a built in interface for users input
public class Input implements KeyListener 
{    
    //Initialise booleans
    private boolean spacePressed = false;
    private boolean spaceReleased = true;
    
    public boolean isSpacePressed() 
    {
        boolean s = spacePressed;
        spacePressed = false;
        return s;
    }
    
    @Override
    public void keyPressed(KeyEvent ke) 
    {
        //VK_SPACE is equivolent to spacebar 
        if(ke.getKeyCode() == KeyEvent.VK_SPACE && spaceReleased) 
        {
            spacePressed = true;
            spaceReleased = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) 
    {
        if(ke.getKeyCode() == KeyEvent.VK_SPACE) 
        {
            spaceReleased = true;
        }
    }
    
    //Since this is a built-in interface you must declare all methods whether 
    //you intend on using them or not 
    @Override
    public void keyTyped(KeyEvent ke) 
    {
    
    }
    
}
