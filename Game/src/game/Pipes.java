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
        currentPipe=0;
        
        x1=Game.width*2;
        //this will give you the next cordinate with spacing included
        x2=x1+pipeWidth+pipeHorizontalSpacing;
        x3=x2+pipeWidth+pipeHorizontalSpacing;
        
        y1=getRandomY();
        y2=getRandomY();
        y3=getRandomY();
        
    }
    
    private int getRandomY()
    {
        //this will give you 40% of the games height
        //this required me to draw this out ultiple times on paper to understand the equation
        return rand.nextInt((int)(Game.height*0.4f)+(Game.height/10));
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
