package game;

//This library gives you extra control on your design of 
//your interface like color, size etc
import java.awt.Graphics2D;

public interface Renderable
{
    
    public void render(Graphics2D g, float timeGap);
    
}
