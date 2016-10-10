package controllers;

import Utils.utils;
import models.PlayerPlane;
import views.PlayerPlaneView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 * Created by Nghia on 10/10/2016.
 */
public class PlayerPlaneController extends PlaneControllers{

    private int dx;
    private int dy;

    private PlayerPlane playerPlane;
    private PlayerPlaneView playerPlanView;
    public PlayerPlaneController() {
    }

    public PlayerPlaneController(PlayerPlane playerPlane, PlayerPlaneView playerPlanView) {
        this.playerPlane = playerPlane;
        this.playerPlanView = playerPlanView;
    }

    public static final int SPEED = 4;


    public void fire() {
        playerPlane.newBulletController();

    }



    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
//        System.out.println(String.format("%s,%s", playerPlane.getX(), playerPlane.getY()));
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                System.out.println("Key Right");
                dx += SPEED;

                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Key Left");
                dx -= SPEED;
                break;
            case KeyEvent.VK_UP:
                System.out.println("Key Up");
                dy -= SPEED;
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Key down");
                dy += SPEED;
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("Space");
                fire();
                break;
        }
    }
    public void keyRelease(KeyEvent e) {
        System.out.println("Key Released");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_LEFT:
                dx = 0;
                break;

            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                dy = 0;
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("Space");
                fire();
                break;
        }
    }

    public void mouseMoved(MouseEvent e) {
//        System.out.println(String.format("%s,%s", e.getX(), e.getY()));
        playerPlane.moveTo(e.getX(),e.getY());

    }
    public void update(Graphics g){
        playerPlanView.drawImage(g,playerPlane);
        playerPlanView.drawBullet(g,playerPlane);


    }
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");
        if (e.getButton() == MouseEvent.BUTTON1) {
            fire();
        }
    }


    public void run(){

        playerPlane.move(dx,dy);
    }
}
