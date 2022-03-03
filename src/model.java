import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class model extends JPanel implements ActionListener {
    private Dimension d; //dimension (x = x-achse) (y= y-achse)
    private final Font smallFont = new Font("Arial", Font.BOLD, 14);
    private boolean inGame = false;
    private boolean sterben = false;

    private final int BLOCK_GROESSE = 24;
    private final int ANZAHL_BLOCKS = 15;
    private final int BILD_GROESSE = BLOCK_GROESSE * ANZAHL_BLOCKS;
    private final int MAX_GEISTER = 16;
    private final int PACMAN_GESCHWINDIGKEIT = 6;

    private int ANZAHL_GEISTER = 4;
    private int leben, punktestand;
    private int[] dx, dy;
    private int[] ghost_x, ghost_y, ghost_dx, ghost_dy, ghostSpeed;

    private Image heart, ghost;
    private Image up, down, left, right;

    private int pacman_x, pacman_y, pacmand_x, pacmand_y;
    private int req_dx, req_dy;

    private final int validSpeeds[] = {1, 2, 3, 4, 6, 8};
    private int maxSpeed = 6;
    private int jetzigeGeschwindigkeit = 3;
    private int[] screenData;
    private Timer timer;

    private final int levelData[] = {
            19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
            17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            0, 0, 0, 0, 0, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0, 0, 0, 0, 21,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0, 0, 0, 0, 21,
            17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0, 0, 0, 0, 21,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
            17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
            21, 0, 0, 0, 0, 0, 0, 0, 17, 16, 16, 16, 16, 16, 20,
            17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28


            /* 0 = blau , 1 = wand links , 2 = wand oben , 4 = wand rechts ,
            8= wand unten , 16 = weiße punkte
             */

    };

    public model() {
        loadImages(); // bild laden
        initVariables(); // variablen initalisieren
        addKeyListener(new TAdapter());
        setFocusable(true);  // fenster fokus
        initSpiel();  // spiel initialisieren
    }

    private void loadImages() {
        down = new ImageIcon("/Users/mauricehaghighi/IdeaProjects/Pac-Man-Projekt/gifs/down.gif").getImage();
        up = new ImageIcon("/Users/mauricehaghighi/IdeaProjects/Pac-Man-Projekt/gifs/up.gif").getImage();
        left = new ImageIcon("/Users/mauricehaghighi/IdeaProjects/Pac-Man-Projekt/gifs/left.gif").getImage();
        right = new ImageIcon("/Users/mauricehaghighi/IdeaProjects/Pac-Man-Projekt/gifs/right.gif").getImage();
        heart = new ImageIcon("/Users/mauricehaghighi/IdeaProjects/Pac-Man-Projekt/gifs/heart.png").getImage();
        ghost = new ImageIcon("/Users/mauricehaghighi/IdeaProjects/Pac-Man-Projekt/gifs/ghost.gif").getImage();

    }

    private void initVariables() {  // Initialisieren Variablen
        screenData = new int[ANZAHL_BLOCKS * ANZAHL_BLOCKS];
        d = new Dimension(400, 400);
        ghost_x = new int[MAX_GEISTER];
        ghost_dx = new int[MAX_GEISTER];
        ghost_y = new int[MAX_GEISTER];
        ghost_dy = new int[MAX_GEISTER];
        ghostSpeed = new int[MAX_GEISTER];
        dx = new int[4];
        dy = new int[4];
        timer = new Timer(50, this); // Animation delay=Wiederholrate Hz
        timer.restart();  // Timer wird immer neu ausgeführt
    }

    private void initSpiel() {
        leben = 3;
        punktestand = 0;
        initLevel();
        ANZAHL_GEISTER = 6;
        jetzigeGeschwindigkeit = 3;


    }

    private void initLevel() {
        int i;
        for (i = 0; i < ANZAHL_BLOCKS * ANZAHL_BLOCKS; i++) {
            screenData[i] = levelData[i];
        }
    }

    private void spielStarten(Graphics2D g2d){
        if (sterben){
            tod();
        }else {
            bewegePac();
            drawPac();
            bewegeGhosts();
            checkMaze();

        }

    }

    public void bewegePac(){
        int position;
        int ch;
        if (pacman_x%BLOCK_GROESSE==0&&pacman_y%BLOCK_GROESSE==0){
            position=
        }
    }











    private void weiterLevel() {
        int dx = 1;
        int random;

        for (int i = 0; i < ANZAHL_GEISTER; i++) {
            ghost_y[i] = 4 * BLOCK_GROESSE;
            ghost_x[i] = 4 * BLOCK_GROESSE;
            ghost_dy[i] = 0;
            ghost_dx[i] = dx;
            dx = -dx;
            random = (int) (Math.random() * (jetzigeGeschwindigkeit + 1));

            if (random > jetzigeGeschwindigkeit) {
                random = jetzigeGeschwindigkeit;
            }
            ghostSpeed[i] = validSpeeds[random];
        }

        pacman_x = 1 * BLOCK_GROESSE;
        pacman_y = 1 * BLOCK_GROESSE;
        pacmand_x = 0;
        pacmand_y = 0;
        req_dy=0;
        sterben=false;

    }

    public void grafikErzeugen(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d= (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,d.width,d.height);

        drawMaze(g2d);
        drawScore(g2d);

        if (inGame){
            spielStarten(g2d);
        }else{
            showHauptMenue(g2d);
        }
        Toolkit.getDefaultToolkit().sync();

    }










    class TAdapter extends KeyAdapter {
        public void tastatur(KeyEvent e) {
            int taste = e.getKeyCode();

            if (inGame) {
                if (taste == KeyEvent.VK_LEFT) {
                    req_dx = -1;
                    req_dy = 0;
                } else if (taste == KeyEvent.VK_RIGHT) {
                    req_dx = 1;
                    req_dy = 0;
                } else if (taste == KeyEvent.VK_UP) {
                    req_dx = 0;
                    req_dy = -1;
                } else if (taste == KeyEvent.VK_DOWN) {
                    req_dx = 0;
                    req_dy = 1;
                } else if (taste == KeyEvent.VK_ESCAPE && timer.isRunning()) {
                    inGame = false;
                } else {
                    if (taste == KeyEvent.VK_SPACE) {
                        inGame = true;
                        initSpiel();
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
