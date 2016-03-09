package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

//Implements allows the class to act on other classes i.e. updatable and renderable
public class Pipes implements Updatable, Renderable 
{
    //Initialise variables
    //Some are set to be used exclusively in this class(Private)
    private int pipewidth = 100;
    private int pipeHorizontalSpacing = 210;
    private int pipeVerticalSpacing = 180;
    
    private float xVel = -5.0f;
    private float x1, x2, x3;
    private float y1, y2, y3;
    
    // The pipe that is closest to the bird
    private int currentPipe;
    // An array to hold the pipes
    private float[][] pipeCoords = new float[3][2];
    
    //This method lets me automatically generate randomom numbers
    private Random random;
    
    
    public Pipes() 
    {
        random = new Random();
        
        resetPipes();
    }
    
    
    public void resetPipes() 
    {
        currentPipe = 0;
        
        x1 = Game.width * 2;
        //This will give you the co-ordinates for the next set of x and y co-ordinates
        //with spacing included
        x2 = x1 + pipewidth + pipeHorizontalSpacing;
        x3 = x2 + pipewidth + pipeHorizontalSpacing;
        
        y1 = getrandomomY();
        y2 = getrandomomY();
        y3 = getrandomomY();
    }
    
    
    //Helper method to return relevent information from class
    public float[] getCurrentPipe() 
    {
        return pipeCoords[currentPipe];
    }
    
    public int getCurrentPipeID() 
    { 
        return currentPipe;
    }
    
    public int getPipewidth() 
    {
        return pipewidth;
    }
    
    public int getPipeHorizontalSpacing() 
    {
        return pipeHorizontalSpacing;
    }
    
    public int getPipeVerticalSpacing() 
    {
        return pipeVerticalSpacing;
    }
    
    private int getrandomomY() 
    {
        //This will give you 40% of the games height
        //This required me to draw this out multiple times on paper to 
        //understand the equation i'm trying to create
        return random.nextInt((int)(Game.height * 0.4f)) + (Game.height / 10);
    }
    
    @Override
    public void update(Input input) 
    {
        x1 += xVel;
        x2 += xVel;
        x3 += xVel;
        
        //Reset pipes if they move off the window
        if(x1 + pipewidth < 0) 
        {
            x1 = Game.width;
            y1 = getrandomomY();
            //This is the only pipe which is possible for the bird to
            //collide with
            currentPipe = 1;
        }
        
        if(x2 + pipewidth < 0) 
        {
            x2 = Game.width;
            y2 = getrandomomY();
            currentPipe = 2;
        }
        
        if(x3 + pipewidth < 0) 
        {
            x3 = Game.width;
            y3 = getrandomomY();
            currentPipe = 0;
        }
        
        // Update pipe coordinates
        switch(currentPipe) 
        {
            case 0:
                pipeCoords[0][0] = x1;
                pipeCoords[0][1] = y1;
                break;
            case 1:
                pipeCoords[1][0] = x2;
                pipeCoords[1][1] = y2;
                break;
            case 2:
                pipeCoords[2][0] = x3;
                pipeCoords[2][1] = y3;
                break;
        }
    }
    

    //This enders the pipes    
    public void render(Graphics2D g, float timeGap) 
    {
        g.setColor(Color.GREEN);
        
        // Pipe 1
        //This will give me the amount of space the pipe has shifted
        g.fillRect((int) (x1 + (xVel * timeGap)), 0, pipewidth, (int) y1);
        g.fillRect((int) (x1 + (xVel * timeGap)), (int) (y1 + pipeVerticalSpacing), pipewidth, Game.height);
        g.setColor(Color.getHSBColor (116, 100, 70));
        // Pipe 2
        g.fillRect((int) (x2 + (xVel * timeGap)), 0, pipewidth, (int) y2);
        g.fillRect((int) (x2 + (xVel * timeGap)), (int) (y2 + pipeVerticalSpacing), pipewidth, Game.height);
        g.setColor(Color.RED);
        // Pipe 3
        g.fillRect((int) (x3 + (xVel * timeGap)), 0, pipewidth, (int) y3);
        g.fillRect((int) (x3 + (xVel * timeGap)), (int) (y3 + pipeVerticalSpacing), pipewidth, Game.height);
    }
}
