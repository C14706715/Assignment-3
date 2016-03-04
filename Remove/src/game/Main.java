package game;


public class Main 
{
    public static void main(String[] args)
    {
        Game g = new Game();
       
        //Initialise game objects
        Pipes p = new Pipes();
        
        //add updatables and renderables
        g.addRenderable(p);
        g.addUpdatable(p);
        
        //Start
        g.Start();
    }
}
