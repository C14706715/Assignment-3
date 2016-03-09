/*
    Assignment 3-Flappy Bird
    Jake Young 
    DT282 Year 2
*/

package game;

//Libraries
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;


public class Game 
{   
    //Java object which allows me to draw to the game window
    //Private means it can only be accessed by instances of the same object class
    private Canvas game = new Canvas();
   
    //Final means it can't be changed

    public final static int width = 800;
    public final static int height = 600;
    
    //String to save in the games title
    private String gameName = "C14706715-Assignment 3: Flappy Bird";
    
    //Instance of input class 
    private Input input;
    
    //Acts as storage for all update and render info
    private ArrayList<Updatable> updatables = new ArrayList<>();
    private ArrayList<Renderable> renderables = new ArrayList<>();
    
    
    public void addUpdatable(Updatable u) 
    {
        updatables.add(u);
    }
    
    
    public void removeUpdatable(Updatable u) 
    {
        updatables.remove(u);
    }
    
    
    public void addRenderable(Renderable r) 
    {
        renderables.add(r);
    }
    
    
    public void removeRenderable(Renderable r) 
    {
        renderables.remove(r);
    }
 

    public void start() 
    {      
        // Initialise windows and JFrame
        Dimension gameSize = new Dimension(Game.width, Game.height);
        //JFrame creates the game window
        JFrame gameWindow = new JFrame(gameName);
        //Eror Handling: this ensures game shuts down when press X
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(gameSize);
        //This means you cant resize the window 
        gameWindow.setResizable(false);
        //allows you to view the game
        gameWindow.setVisible(true);
        game.setSize(gameSize);
        game.setMaximumSize(gameSize);
        game.setMinimumSize(gameSize);
        game.setPreferredSize(gameSize);
        gameWindow.add(game);
        //this ensures the game is centered in the screen
        gameWindow.setLocationRelativeTo(null);

        // Initialise input
        input = new Input();
        //This adds the input to the canvas and ensures
        //the game is using what the user pressed
        game.addKeyListener(input);
        
        // Game loop
        //This is one update
        //60 frames per second
        final int TICKS_PER_SECOND = 60;
        final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
        //this is the max amount of updates per render
        final int MAX_FRAMESKIP = 5;
        //Real time 
        long nextGameTick = System.currentTimeMillis();
        int loops;
        //prevents characters from skipping
        float timeGap;
        
        //To check if game is running
        boolean running = true;
        while(running) 
        {
            //Initialise loop variables
            loops = 0;
            
            //This while loop checks if the program is running slow
            //It keeps updating until it has updated the max amount of times
            while(System.currentTimeMillis() > nextGameTick && loops < MAX_FRAMESKIP) 
            {
                update();
               
                nextGameTick += SKIP_TICKS;
                //Keeps track of how many loops which the whie loop has gone through
                loops++;
            }
            
            //Rendering
            //This compares how much time it actually took to render compared
            //to how much time was predicted to render
            //Have to cast to a float
            timeGap = (float) (System.currentTimeMillis() + SKIP_TICKS - nextGameTick)
                            / (float) SKIP_TICKS;
            render(timeGap);
            
        }//Game is finished
    }
    
    
    private void update() 
    {
        for(Updatable u : updatables) 
        {
            u.update(input);
        }
    }
    
    
    private void render(float timeGap) 
    {
        //Used in gaming
        BufferStrategy bs = game.getBufferStrategy();
        if(bs == null) {
            game.createBufferStrategy(2);
            return;
        }

        Graphics2D g = (Graphics2D) bs.getDrawGraphics();
        //This method clears everything on screen and redraws everything simultaniously
        g.clearRect(0, 0, game.getWidth(), game.getHeight());
        
        for(Renderable r : renderables) 
        {
            r.render(g, timeGap);
        }
        g.dispose();
        bs.show();
    }
}
