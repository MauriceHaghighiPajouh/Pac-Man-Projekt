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
    private final int ANZAHL_BLOCKS = 30;
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




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
