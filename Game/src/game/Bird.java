package game;

import java.awt.Graphics2D;

public class Bird implements Updatable, Renderable
{
    private float x, y;
    private float yVel;
    //negative as in java the y value goes in the opposite direction
    private float baseYVel= -0.6f;
    private float gravity = 0.25f;
    
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
