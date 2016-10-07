import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nghia on 10/2/2016.
 */
public class GameWindow extends Frame implements Runnable {

    private static final int BACKGROUND_WIDTH = 800;
    private static final int BACKGROUND_HEIGHT = 600;

    Image backgroundImage = null;
    Image backBufferImage= null;

    Plane playerPlane ;
    Plane playerPlane2;
    private int MOVE_DISTANCE= 10;



    public GameWindow() throws IOException  {
        backBufferImage = new BufferedImage(BACKGROUND_WIDTH, BACKGROUND_HEIGHT,BufferedImage.TYPE_INT_ARGB );

        playerPlane = new Plane(BACKGROUND_WIDTH/2,BACKGROUND_HEIGHT*7/8,
                        ImageIO.read(new File("resources/plane3.png")));
        playerPlane2 = new Plane(BACKGROUND_WIDTH/2,BACKGROUND_HEIGHT*7/8-100,
                        ImageIO.read(new File("resources/plane2.png")));


        this.setVisible(true);
        this.setSize(BACKGROUND_WIDTH,BACKGROUND_HEIGHT);
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened");

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
                System.exit(0);

            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed");

            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified");

            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowActivated");

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactivated");
            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            playerPlane2.mouseMoved(e);
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playerPlane2.mouseClicked(e);


            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                    System.out.println("Key Typed");
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    playerPlane.keyPressed(e);
                }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Key Released");
            }
        });
        try {
            backgroundImage=
            ImageIO.read(new File("resources/background.png"));
            System.out.println("Loaded backgroundImage");


        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("draw background ");
    }

    @Override
    public void update(Graphics g) {
        Graphics backBufferGraphics=  backBufferImage.getGraphics();


        backBufferGraphics.drawImage(backgroundImage, 0, 0, BACKGROUND_WIDTH,BACKGROUND_HEIGHT, null);
        playerPlane.drawImage(backBufferGraphics);
        playerPlane2.drawImage(backBufferGraphics);
        if (playerPlane.hasBullet())
            playerPlane.setBullet(backBufferGraphics);
        if (playerPlane2.hasBullet())
            playerPlane2.setBullet(backBufferGraphics);
//        playerPlane.setBullet();



        g.drawImage(backBufferImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT,null);
    }

    @Override
    public void run() {
        while (true){

            try {
                Thread.sleep(17);
//                new Bullet();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
