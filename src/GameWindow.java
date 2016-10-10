import Utils.utils;
import controllers.PlayerPlaneController;
import models.EnemyPlane;
import models.PlayerPlane;
import views.EnemyPlaneView;
import views.PlayerPlaneView;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import controllers.EnemyPlaneController;

/**
 * Created by Nghia on 10/2/2016.
 */
public class GameWindow extends Frame implements Runnable {

    public static final int BACKGROUND_WIDTH = 800;
    public static final int BACKGROUND_HEIGHT = 600;

    Image backgroundImage = null;
    Image backBufferImage = null;

    PlayerPlane playerPlane;
    PlayerPlaneController playerPlaneController;
    Vector<EnemyPlaneController> enemyPlaneControllersVector ;
    private int MOVE_DISTANCE = 10;


    public GameWindow() throws IOException {
        backBufferImage = new BufferedImage(BACKGROUND_WIDTH, BACKGROUND_HEIGHT, BufferedImage.TYPE_INT_ARGB);

//        playerPlane3 = new models.PlayerPlane(BACKGROUND_WIDTH/2,BACKGROUND_HEIGHT*7/8,
//                        ImageIO.read(new File("resources/plane3.png")));
        playerPlaneController = new PlayerPlaneController(
                                new PlayerPlane(BACKGROUND_WIDTH/2,BACKGROUND_HEIGHT*7/8),
                                new PlayerPlaneView(utils.loadImageFromRes("plane3.png"))
                                );

        enemyPlaneControllersVector = new Vector<>();



//        for (int i = 0; i < 10; i++) {
//            int y=60;
//            int x = (models.EnemyPlane.WIDTH + 10)*i;
//            EnemyPlaneController enemyPlaneController = new EnemyPlaneController(
//                    new EnemyPlane(x,y),
//                    new EnemyPlaneView(utils.loadImageFromRes("plane1.png"))
//                    );
//            enemyPlaneControllersVector.add(enemyPlaneController);
//        }



        this.setVisible(true);
        this.setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
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
                playerPlaneController.mouseMoved(e);
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playerPlaneController.mouseClicked(e);


            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed");

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited");
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Key Typed");
                playerPlaneController.keyPressed(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                playerPlaneController.keyPressed(e);

            }

            @Override
            public void keyReleased(KeyEvent e) {
                playerPlaneController.keyRelease(e);
            }
        });



        try {
            backgroundImage =
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
        Graphics backBufferGraphics = backBufferImage.getGraphics();


        backBufferGraphics.drawImage(backgroundImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
        playerPlaneController.update(backBufferGraphics);
////        playerPlane3.drawImage(backBufferGraphics);
//        playerPlane.drawImage(backBufferGraphics);
////        playerPlane3.setBullet();
////        playerPlane3.drawBullet(backBufferGraphics);
//        playerPlane.drawBullet(backBufferGraphics);
////        enemyPlane.moveDown();
////        enemyPlane.drawImage(backBufferGraphics);
////        enemyPlane.drawBullet(backBufferGraphics);


        for (EnemyPlaneController e : enemyPlaneControllersVector){
            e.update(backBufferGraphics);
//            e.moveDown();
//            e.drawImage(backBufferGraphics);
//            e.drawBullet(backBufferGraphics);
        }



        g.drawImage(backBufferImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);

    }

    @Override
    public void run() {
        int count =0;
        int count2=0;
        while (true) {

            try {
                Thread.sleep(17);
                playerPlaneController.run();
                for (EnemyPlaneController e : enemyPlaneControllersVector){
                    e.run();
                }
                count++;
                count2++;
                if (count2 == 45){
                    count2=0;
                    int y=60;
                    int x = (int) (EnemyPlane.WIDTH/2+(BACKGROUND_WIDTH-EnemyPlane.WIDTH)*Math.random());
                    EnemyPlaneController enemyPlaneController = new EnemyPlaneController(
                            new EnemyPlane(x,y),
                            new EnemyPlaneView(utils.loadImageFromRes("plane1.png"))
                    );
                    enemyPlaneControllersVector.add(enemyPlaneController);

                }


                if (count== 60/models.EnemyPlane.FIRE_RATE){
                    count=0;
                    for (EnemyPlaneController e : enemyPlaneControllersVector ){
                        e.fire();
                    }
//                    enemyPlane.fire();
                }


                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
