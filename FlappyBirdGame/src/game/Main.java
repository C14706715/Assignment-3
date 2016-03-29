package game;
  

public class Main 
{
    public static void main(String[] args) 
    { 
        Game g = new Game();
        //Initailise game objects
        Pipes p = new Pipes();
        Bird b = new Bird(p);
        
        //Add renderables and updatables for pipes
        g.addRenderable(p);
        g.addUpdatable(p);
        
        //Add renderables and updatables Bird
        g.addRenderable(b);
        g.addUpdatable(b);
        
        //Start the game
        g.start();
    }
}