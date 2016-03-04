package game;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
        
        try
        {
            flapUp = Sprite.getSprite("bird_up.png");
            flapDown = Sprite.getSprite("bird_down.png");
        }
            catch (IOException ex)
            {
                System.err.println(ex.getMessage());
                System.exit(1);
            }
    }
    
    
    public void resetBird()
    {
        x=100;
        y=100;
        yVel=baseYVel;
    }
    
    public void flap()
    {
        yVel = baseYVel;
        
    }
    
    //This updates the bird
    @Override
     public void update(Input input)
     {
         y += yVel;
         //overtime the yVel will slowly go from upwards to downwards
         yVel += gravity;
         
         if(y<0)
         {
             //keeps the bird at top of screen if bird is pressed to the top of screen
             y=0;
             yVel=0;
         }
         
         if(input.isSpacePressed())
         {
             flap();
         }
         
         
     
     //This renders the bird
     @Override
     public void render(Graphics2D g, float interpolation)
     {
     
     }
}