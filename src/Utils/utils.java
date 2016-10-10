package Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nghia on 10/9/2016.
 */
public class utils {
    public static Image loadImage(String url){
        Image returnImage = null;
        try {
            returnImage = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnImage;
    }
    public static Image loadImageFromRes(String url){
        Image returnImage = null;
        try {
            returnImage = ImageIO.read(new File("resources/"+url));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnImage;
    }
}
