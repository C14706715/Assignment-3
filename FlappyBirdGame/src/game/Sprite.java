package game;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

//this class is used for creating the sprites image
public class Sprite 
{
    public static BufferedImage getSprite(String fileName) throws IOException
    {
       return ImageIO.read(Sprite.class.getResourceAsStream(fileName));
    }
}
