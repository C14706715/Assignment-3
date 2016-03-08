package game;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class Bird implements Updatable, Renderable 
{
    //Declare and initialise variables
    private float x, y;
    private float yVel;
    //In Java the Y graph goes in the opposite direction, hence the negative value
    private float baseYVel = -6.0f;
    private float gravity = 0.25f;
    private int scoredPipe = 0;
    private int score = 0;
   
    private Pipes pipes;
    
    //I created a font to display the score on the screen
    private Font gameFont = new Font("Arial", Font.BOLD, 30);
    
    private BufferedImage flapUp;
    private BufferedImage flapDown;
    
    
    public Bird(Pipes pipes) 
    {
        resetBird();
        
        this.pipes = pipes;
        
        try 
        {
            //this displays the flap up and flap down image when needed to
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
        x = 100;
        y = 100;
        yVel = baseYVel;
    }
    
    private void flap() 
    {
        yVel = baseYVel;
    }

   //This method constantly updates the bird
    //@Override overrides the functionality of the method
    @Override
    public void update(Input input) 
    {
        y += yVel;
        //Overtime the YVel will slowly change direction from upward to downwards due to gravity
        yVel += gravity;
        
        //This keeps the bird at the top of the screen as long as the user presses the spacebar
        if(y < 0) 
        {    
            y = 0;
            yVel = 0;
        }
        
        if(input.isSpacePressed()) 
        {
            flap();
        }
        
        float[] pipeCoords = pipes.getCurrentPipe();
        float pipeX = pipeCoords[0];
        float pipeY = pipeCoords[1];
        
        //this long if statement is implemnted when the bird attempts to pass through the first(current) pipe
        if((x >= pipeX && x <= pipeX + pipes.getPipewidth() && 
          (y <= pipeY || y >= pipeY + pipes.getPipeVerticalSpacing())) || 
           y >= Game.height ) 
        {
            pipes.resetPipes();
            resetBird();
            score = 0;
        }
        else 
        {
            //Error checking: to only allow the user to score once per pipe
            int currentPipeID = pipes.getCurrentPipeID();
            // ?: This is a conditional operator
            score = (scoredPipe != currentPipeID) ? score + 1 : score;
            scoredPipe = currentPipeID;
        }
    }

 
    public void render(Graphics2D g, float timeGap) 
    {
        g.setColor(Color.red);
        g.setFont(gameFont);
        
        g.drawImage(yVel <= 0 ? flapUp : flapDown, (int) x, (int) (y + (yVel * timeGap)), null);
        g.drawString("Score: " + score, 20, 50);
    }
}