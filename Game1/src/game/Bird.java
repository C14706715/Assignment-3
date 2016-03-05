package game;

import java.awt.Color;
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
         
         float[] pipeCoords = pipes.getCurrentPipe();
         float pipeX = pipeCoords[0];
         float pipeY = pipeCoords[1];
         
         //this is for the pass through o the first part of the pipe
         if((x <= pipeX && x <= pipeX + pipes.getPipeWidth()
             && (y <= pipeY || y >= pipeY + pipes.getPipeVerticalSpacing()))
             || y >= Game.height)
        {
             pipes.resetPipes();
             resetBird();
             score=0;
        }
        else
        {
            //only allows you to score once per pipe
             int currentPipeID = pipes.getCurrentPipeID();
             score = (scoredPipe != currentPipeID) ? score + 1: score;
             scoredPipe = currentPipeID;
        }
         
         
     
         //This renders the bird
        public void render(Graphics2D g, float interpolation)
        {
            g.setColor(Color.BLUE);
         
            g.drawImage(yVel <= 0 ? flapUp : flapDown, (int) x, (int) (y + (yVel * interpolation)), null);
            g.setFont(gameFont);
            g.drawString("Score: "+ score, 20, 50);
        }
    }