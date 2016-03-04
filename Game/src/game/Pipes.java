package game;

import java.awt.Color;
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
    //This ensure the pipes slide of to the right
     public void update(Input input)
     {
         x1+=xVel;
         x2+=xVel;
         x3+=xVel;
         
         //reset pipes if moved off screen
         if(x1+pipeWidth<0)
         {
            x1=Game.width;
            y1=getRandomY();
            //this is the only pipe which is possible for the bird to collide with
            currentPipe=1;
         }
         if(x1+pipeWidth<0)
         {
             x2=Game.width;
             y2=getRandomY();
             currentPipe=2;
         }
         if(x3+pipeWidth<0)
         {
             x3=Game.width;
             y3=getRandomY();
             currentPipe=0;
         }
            
         switch(currentPipe)
         {
             case 0:
                pipeCoords[0][0]=x1;
                pipeCoords[0][1]=y1;
                break;
             case 1:
                pipeCoords[1][0]=x2;
                pipeCoords[1][1]=y2;
                break;
             case 2:
                pipeCoords[2][0]=x3;
                pipeCoords[2][1]=y3;
                break;
         }
     }
     //This renders the pipes
     public void render(Graphics2D g, float interpolation)
     {
         g.setColor(Color.blue);
         
         
         //pipe1
         //this will give me the amount of space the pipe shifted
         //top pipe
         g.fillRect((int) (x1+(xVel*interpolation)), 0, pipeWidth, (int) y1);
         //bottom pipe
         g.fillRect((int) (x1+(xVel*interpolation)), (int) (y1+pipeVerticalSpacing), pipeWidth, Game.height);
         
        //pipe2
        //top pipe
         g.fillRect((int) (x2+(xVel*interpolation)), 0, pipeWidth, (int) y1);
         //bottom pipe
         g.fillRect((int) (x2+(xVel*interpolation)), (int) (y2+pipeVerticalSpacing), pipeWidth, Game.height);
          
         //pipe3
         //top pipe
         g.fillRect((int) (x3+(xVel*interpolation)), 0, pipeWidth, (int) y1);
         //bottom pipe
         g.fillRect((int) (x3+(xVel*interpolation)), (int) (y3+pipeVerticalSpacing), pipeWidth, Game.height);
         
     }
     
     public float[] getCurrentPipe()
     {
         return pipeCoords[currentPipe];
     }
     
     public int getCurrentPipeID()
     {
         return currentPipe;
     }
     
     public int getPipeWidth()
     {
         return pipeWidth;
     }
     
     public int getPipeHorizontalSpacing()
     {
         return pipeHorizontalSpacing;
     }
     
     public int getPipeVerticalSpacing()
     {
         return pipeVerticalSpacing;
     }
     
    
         
}
