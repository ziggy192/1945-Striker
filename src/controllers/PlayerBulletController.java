package controllers;

import models.PlayerBullet;
import models.PlayerPlane;
import views.PlayerBulletView;
import views.PlayerPlaneView;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Nghia on 10/10/2016.
 */
public class PlayerBulletController {
    private static final int SPEED = 10;
    private PlayerBullet playerBullet;
    private PlayerBulletView playerBulletView;

    public PlayerBulletController(PlayerBullet playerBullet, PlayerBulletView playerBulletView) {
        this.playerBullet = playerBullet;
        this.playerBulletView = playerBulletView;
    }

    public void fly(int speed){
        playerBullet.increseY(-speed);
    }
    public boolean update(Graphics g){
        fly(SPEED);
        if (playerBullet.getY() < 0)
            return false;
        else
            playerBulletView.drawImage(playerBullet,g);
        return true;
    }

}
