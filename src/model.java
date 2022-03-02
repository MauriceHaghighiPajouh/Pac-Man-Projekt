import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class model extends JPanel implements ActionListener {
    private Dimension d;
    private final Font smallFont = new Font("Arial",Font.BOLD,14);
    private boolean inGame= false;
    private boolean sterben = false;

    private final int BLOCK_GROESSE = 24;
    private final int ANZAHL_BLOCKS = 15;
    private final int BILD_GROESSE = BLOCK_GROESSE * ANZAHL_BLOCKS ;
    private final int MAX_GEISTER = 16 ;
    private final int PACMAN_GESCHWINDIGKEIT = 6 ;

    private int ANZAHL_GEISTER = 4;
    private int leben, punktestand;
    private int [] dx, dy ;
    private int[] ghost_x, ghost_y, ghost_dx,ghost_dy,ghostSpeed;

    private Image heart, ghost ;
    private Image up,down,left,right;

    private int pacman_x,pacman_y,pacmand_x,pacmand_y;
    private int req_dx,req_dy;

    private final int validSpeeds[]={1,2,3,4,6,8};
    private int maxSpeed = 6;
    private int currentSpeed= 3;
    private short [] screenData;
    private Timer timer;

    private final int leveData[] = {
            19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22,
            17, 16, 16, 16, 16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            0,  0,  0,  0,  0,  0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
            19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24, 24, 24, 20,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0,  0,  0,   0, 21,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 18, 18, 18, 18, 20,
            17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20,
            21, 0,  0,  0,  0,  0,  0,   0, 17, 16, 16, 16, 16, 16, 20,
            17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20,
            25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28


            /* 0 = blau , 1 = wand links , 2 = wand oben , 4 = wand rechts ,
            8= wand unten , 16 = weiße punkte
             */

    };

    public Model () {
        loadImages(); // bild laden
        initVariables(); // variablen initalisieren
        addKeyListener(new TAdapter());
        setFocusable(true);  // fenster fokus
        initGame();  // spiel initialisieren
    }
    private void loadImages(){
        down = new ImageIcon("/Users/mauricehaghighi/IdeaProjects/Pac-Man-Projekt/gifs/down.gif").getImage();
        up = new ImageIcon ("/Users/mauricehaghighi/IdeaProjects/Pac-Man-Projekt/gifs/up.gif").getImage();
        left = new ImageIcon("/Users/mauricehaghighi/IdeaProjects/Pac-Man-Projekt/gifs/left.gif").getImage();
        right = new ImageIcon ("/Users/mauricehaghighi/IdeaProjects/Pac-Man-Projekt/gifs/right.gif").getImage();
        heart = new ImageIcon("/Users/mauricehaghighi/IdeaProjects/Pac-Man-Projekt/gifs/heart.png").getImage();
        ghost = new ImageIcon("/Users/mauricehaghighi/IdeaProjects/Pac-Man-Projekt/gifs/ghost.gif").getImage();

    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
