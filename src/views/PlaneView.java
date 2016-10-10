package views;

import models.Bullet;
import models.Plane;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nghia on 10/9/2016.
 */
public abstract class PlaneView {
    public PlaneView(Image image) {
        this.image = image;
    }

    private Image image;
    public Image getImage(){
        return image;
    }






}
