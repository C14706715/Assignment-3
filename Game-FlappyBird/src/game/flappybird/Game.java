/*
    Assignment 3-Flappy Bird
    Jake Young 
    DT282 Year 2
*/
package game.flappybird;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Game
{
    //Final means it cant be changed
    public final static int width=800;
    public final static int height=600;
    //String to use as Game title
    private String gameName="Flappy Bird";
    
    //Java object which allows me to draw to a window
    private Canvas GameFlappBird= new Canvas();
            
    public void Start()
    {
        //initialise windows and jframe
        //game loop
        //while loop
        Dimension gameSize= new Dimension(GameFlappyBird.width, GameFlappyBird.height);
        //window that canvas sits inside of
        JFrame gameWindow= new JFrame(gameName);
        //when press X it makes sure game shuts down
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(gameSize);
        gameWindow.setResizable(false);
        gameWindow.setVisible(true);
        game.setSize(gameSize);
        
        
        
        boolean running=true;
        while(running)
        {
        }
    }


    
}
















