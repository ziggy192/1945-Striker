import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nghia on 10/4/2016.
 */
public class Plane {
    public static final int PLAYER_PLANE_WIDTH = 70;
    public static final int PLAYER_PLANE_HEIGHT = 50;
    public static final int MAX_BULLET_NUM = 10;
    ArrayList<Bullet> bArr = new ArrayList<>();
    Bullet b;
    private int x;
    private int y;
    private Image image;
    private Bullet BulletArr[] = new Bullet[10];
    private int putloc;
    private int getloc;


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

    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
        System.out.println(String.format("%s,%s", x, y));
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                System.out.println("Key Right");
                x += 10;

                break;
            case KeyEvent.VK_LEFT:
                System.out.println("Key Left");
                x -= 10;
                break;
            case KeyEvent.VK_UP:
                System.out.println("Key Up");
                y -= 10;
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Key down");
                y += 10;
                break;
            case KeyEvent.VK_SPACE:
                System.out.println("Space");
//                fire();
                try {
                    b = new Bullet(x + PLAYER_PLANE_WIDTH / 2 - Bullet.WIDTH / 2, y - Bullet.HEIGHT, ImageIO.read(new File("resources/bullet.png")));
                    bArr.add(b);


//                    b.fly();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                break;


        }
    }

    public void mouseMoved(MouseEvent e) {
        System.out.println(String.format("%s,%s", e.getX(), e.getY()));
        x = e.getX() - PLAYER_PLANE_HEIGHT / 2;
        y = e.getY() - PLAYER_PLANE_WIDTH / 2;

    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked");
        if (e.getButton() == MouseEvent.BUTTON1) {
            newBullet();

        }

    }

    public void drawImage(Graphics g) {
        g.drawImage(image, x, y, PLAYER_PLANE_WIDTH, PLAYER_PLANE_HEIGHT, null);

    }

    public void newBullet() {
        try {
            b = new Bullet(x + PLAYER_PLANE_WIDTH / 2 - Bullet.WIDTH / 2, y - Bullet.HEIGHT, ImageIO.read(new File("resources/bullet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bArr.add(b);
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
