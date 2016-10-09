import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nghia on 10/8/2016.
 */
public abstract class Plane {

    ArrayList<Bullet> bArr = new ArrayList<>();
    Bullet b;

    //location exactly at the middle of the plane
    int x;
    int y;
    Image image;


    public Plane(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


    public abstract void drawImage(Graphics g);

    public void newBullet(int x, int y, int direction) {
        try {
            b = new Bullet(x, y, ImageIO.read(new File("resources/bullet.png")), direction);

        } catch (IOException e) {
            e.printStackTrace();
        }
        bArr.add(b);
    }

    public abstract void fire();

    void drawBullet(Graphics g) {
        ArrayList<Bullet> removingBullet = new ArrayList<>();
        for (Bullet bullet : bArr) {
            bullet.fly();
            if (bullet.getY() < 0)
                removingBullet.add(bullet);
            else
                bullet.drawImage(g);

        }
        bArr.removeAll(removingBullet);
    }


}
