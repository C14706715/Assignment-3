package game;

import java.awt.Graphics2D;
import java.util.Random;

public class Pipes implements Updatable, Renderable
{
    private int pipeWidth=100;
    private int pipeHorizontalSpacing=210;
    private int pipeVerticalSpacing=180;
    
    private float xVel=-5.0f;
    //three x and y values for three pipes
    private float x1, x2, x3;
    private float y1, y2, y3;
    
    //closest pipe
    private int currentPipe;
    //array to hold pipes co-oridinates
    private float[][] pipeCoords = new float[3][2];
    
    //lets me generate random numbers
    private Random rand;
    
    public void Pipes()
    {
        rand= new Random();
        resetPipes();
    }
    
    public void resetPipes()
    {
        
    }
    
    
            
            
            
    //This updates the pipes
     public void update(Input input)
     {
         
     }
     //This renders the pipes
     public void render(Graphics2D g, float interpolation)
     {
     
     }
}
