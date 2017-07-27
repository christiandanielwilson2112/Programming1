import java.awt.*;

public class Project3 {
  //size of panel
  public static final int PANEL_WIDTH = 600; //x
  public static final int PANEL_HEIGHT = 400; //y
  
  //specs of patrol ship
  public static final int PATROL_WIDTH = 31;
  public static final int PATROL_HEIGHT = 17;
  public static int patrolX = 550;
  public static final int PATROL_Y = 350;
  
  //specs of enemy ship
  public static final int ENEMY_WIDTH = 36;
  public static final int ENEMY_HEIGHT = 21;
  public static int enemyX = 0;
  public static final int ENEMY_Y = 20;
  
  //constants for handle keys
  public static final int RIGHT_ARROW = 39;
  public static final int LEFT_ARROW = 37;
  public static final int UP_ARROW = 38;
  public static final int SPACE_BAR = ' ';
  
  //specs of patrol missile
  public static int patrolMissileX = patrolX;
  public static int patrolMissileY = 0;
  public static final int MISSILE_LENGTH = 10;
  
  //boolean class variable hit
  public static boolean hit = false;
  
  //exe starts here
  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(PANEL_WIDTH, PANEL_HEIGHT);
    Graphics g = panel.getGraphics( );
    g.drawString("Project 3 written by Christian Wilson.", 10, 15);
    startGame(panel, g);
  }//ends main
  
  //draws patrol ship
  public static void drawPatrol(Graphics g, Color c){
    g.setColor(c);
    g.fillRect(patrolX, PATROL_Y, PATROL_WIDTH, PATROL_HEIGHT);
  }//ends drawPatrol
  
  //draws and moves enemy ship
  public static void moveEnemyShipAndDraw(Graphics g){
   if (hit == true) {
      g.setColor(Color.BLACK);
      g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
      g.setColor(Color.GREEN);
      g.drawString("ENEMY SHIP HIT!", 20, 385);
    } else {
      g.setColor(Color.WHITE);
      g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
      enemyX++;
      g.setColor(Color.RED);
      g.fillRect(enemyX, ENEMY_Y, ENEMY_WIDTH, ENEMY_HEIGHT);
    }// ends if/else 
  }//ends moves and draws enemy ship
  
  //monitors when keys are pressed
  public static void handleKeys(DrawingPanel panel, Graphics g) {
    int key = panel.getKeyCode();
    
    if (key == RIGHT_ARROW && patrolX <= PANEL_WIDTH - PATROL_WIDTH - 1) {
      drawPatrol(g, Color.WHITE);
      patrolX+=3;
      drawPatrol(g, Color.GREEN);
    } else if (key == LEFT_ARROW && patrolX >= 2) {
      drawPatrol(g, Color.WHITE);
      patrolX-=3;
      drawPatrol(g, Color.GREEN);
    } else if (key == UP_ARROW && patrolMissileY <= 0) {
      patrolMissileY = PATROL_Y - 1;
      patrolMissileX = patrolX + PATROL_WIDTH/2;
    } else if(key == SPACE_BAR) {
     restartGame(panel, g);
    }//ends if else loop
  }//ends handleKeys
  
  //resets all values
  public static void restartGame(DrawingPanel panel, Graphics g) {
    
  }//ends restartGame
  
  //draws missile
  public static void movePatrolMissileAndDraw(Graphics g) {
    g.setColor(Color.WHITE);
    g.drawLine(patrolMissileX, patrolMissileY, patrolMissileX, patrolMissileY - MISSILE_LENGTH);
    patrolMissileY-=5;
    g.setColor(Color.BLACK);
    g.drawLine(patrolMissileX, patrolMissileY, patrolMissileX, patrolMissileY - MISSILE_LENGTH);
  }//ends moveMissileAndDraw
  
  public static boolean detectHit() {
    return patrolMissileX >= enemyX && patrolMissileX <= enemyX + ENEMY_WIDTH && 
      patrolMissileY - MISSILE_LENGTH >= ENEMY_Y && patrolMissileY - MISSILE_LENGTH <= ENEMY_Y + ENEMY_HEIGHT;
  }//ends detectHit
  
  //starts the game
  public static void startGame(DrawingPanel panel, Graphics g) {
    
    drawPatrol(g, Color.GREEN);
    int i = 0;
    while(i < 1) {
      movePatrolMissileAndDraw(g);
      panel.sleep(50); 
      moveEnemyShipAndDraw(g); 
      handleKeys(panel, g);
      if(detectHit() == true) {
        hit = true;
      } else if (enemyX == PANEL_WIDTH) {
        g.setColor(Color.RED);
        g.drawString("ENEMY SHIP GOT AWAY!", 20, 385);
      }//ends if else
      
    }//ends for loop
  }//ends startGame 
}//ends class