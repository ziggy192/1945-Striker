import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nghia on 10/8/2016.
 */
public class EnemyPlane extends Plane {

    public static final int FIRE_RATE = 3;
    public static final int WIDTH = 70;
    public static final int HEIGHT = 50;
    public static final int MAX_BULLET_NUM = 10;
    private static final double MOVE_SPEED = 1;


//    ArrayList<Bullet> bArr = new ArrayList<>();
//    Bullet b;

    //location exactly at the middle of the plane


    public EnemyPlane(int x, int y, Image image) {
        super(x, y, image);

    }

    @Override
    public void drawImage(Graphics g) {
        g.drawImage(image, x - WIDTH / 2, y - HEIGHT / 2, WIDTH, HEIGHT, null);
    }


    public void moveDown() {
        y += MOVE_SPEED;
    }



    public void fire() {
        newBullet(x, y + HEIGHT / 2 + Bullet.HEIGHT / 2, -1);
    }

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


    public boolean hasBullet() {
        if (b == null) return false;
        return true;
    }


}