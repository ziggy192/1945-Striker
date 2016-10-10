package models;

import models.Bullet;

import java.awt.*;

/**
 * Created by Nghia on 10/10/2016.
 */
public class PlayerBullet extends Bullet {
    public PlayerBullet() {
    }

    public PlayerBullet(int x, int y ) {
        super(x, y);
    }

    public void increseY(int dy){
        setY(getY()+dy);
    }



}
