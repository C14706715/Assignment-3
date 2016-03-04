package game;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Bird implements Updatable, Renderable
{
    private float x, y;
    private float yVel;
    //negative as in java the y value goes in the opposite direction
    private float baseYVel= -0.6f;
    private float gravity = 0.25f;
    
    private Pipes pipes;
    private int scoredPipe=0;
    private int score=0;
    //I created a font to display the score on screen
    private Font gameFont = new Font("Ariel", Font.BOLD, 30);
    
    private BufferedImage flapUp;
    private BufferedImage flapDown;
    
    public Bird (Pipes pipes)
    {
        resetBird();
        
        this.pipes = pipes;
    }
    
    
    public void resetBird()
    {
        x=100;
        y=100;
        yVel=baseYVel;
    }
    
    public void lap()
    {
        yVel = baseYVel;
        
    }
    
    //This updates the bird
     public void update(Input input)
     {
         
     }
     //This renders the bird
     public void render(Graphics2D g, float interpolation)
     {
     
     }
}