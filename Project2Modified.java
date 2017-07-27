import java.awt.*;

public class Project2Modified {
  //size of panel
  public static final int PANEL_SIZE = 300;
  
  //specs of patrol ship
  public static final int PATROL_Y = 250;
  public static final int PATROL_SIZE = 20;
  public static int patrolX = 270;
  
  //specs of enemy ship
  public static final int ENEMY_Y = 20;
  public static final int ENEMY_SIZE = 30;
  public static int enemyX = 0;
  
  //constants for handle keys
  public static final int RIGHT_ARROW = 39;
  public static final int LEFT_ARROW = 37;
  // public static final int UP_ARROW = 38;
  public static final int SPACE_BAR = 32;
  
  //specs of patrol missile
  public static int patrolMissileX = patrolX;
  public static int patrolMissileY = 0;
  public static final int MISSILE_LENGTH = 10;
  
  //boolean class variable hit
  public static boolean hit = false;
  
  //exe starts here
  public static void main(String[] args) {
    DrawingPanel panel = new DrawingPanel(PANEL_SIZE, PANEL_SIZE);
    Graphics g = panel.getGraphics( );
    g.drawString("Project 2 by Christian Wilson.", 10, 15);
    startGame(panel, g);
  }//ends main
  
  //draws patrol ship
  public static void drawPatrol(Graphics g, Color c){
    g.setColor(c);
    g.fillRect(patrolX, PATROL_Y, PATROL_SIZE, PATROL_SIZE);
  }//ends drawPatrol
  
  //draws and moves enemy ship
  public static void moveEnemyShipAndDraw(Graphics g){
    if (hit == true) {
      g.setColor(Color.WHITE);
      g.fillRect(enemyX, ENEMY_Y, ENEMY_SIZE, ENEMY_SIZE);
      g.setColor(Color.GREEN);
      g.drawString("ENEMY SHIP HIT!", 20, 285); 
      g.setColor(Color.RED);
      g.fillRect(enemyX - 1, ENEMY_Y + ENEMY_SIZE/2, ENEMY_SIZE/6, ENEMY_SIZE/6);
      g.setColor(Color.RED);
      g.fillRect(enemyX - 1, ENEMY_Y, ENEMY_SIZE/6, ENEMY_SIZE/6);
      g.setColor(Color.RED);
      g.fillRect(enemyX + ENEMY_SIZE + 1, ENEMY_Y + ENEMY_SIZE/2, ENEMY_SIZE/6, ENEMY_SIZE/6);
      g.setColor(Color.RED);
      g.fillRect(enemyX + ENEMY_SIZE + 1, ENEMY_Y, ENEMY_SIZE/6, ENEMY_SIZE/6);
      g.setColor(Color.RED);
      g.fillRect(enemyX + ENEMY_SIZE/2, ENEMY_Y + ENEMY_SIZE/2 + ENEMY_SIZE/6, ENEMY_SIZE/6,ENEMY_SIZE/6);
      g.setColor(Color.RED);
      g.fillRect(enemyX + ENEMY_SIZE/2, ENEMY_Y - ENEMY_SIZE/6, ENEMY_SIZE/6, ENEMY_SIZE/6);
    } else {
      g.setColor(Color.WHITE);
      g.fillRect(enemyX, ENEMY_Y, ENEMY_SIZE, ENEMY_SIZE);
      enemyX++;
      g.setColor(Color.RED);
      g.fillRect(enemyX, ENEMY_Y, ENEMY_SIZE, ENEMY_SIZE);
    }// ends if/else 
  }//ends moves and draws enemy ship
  
  //monitors when keys are pressed
  public static void handleKeys(DrawingPanel panel, Graphics g) {
    int key = panel.getKeyCode();

    if (key == RIGHT_ARROW && patrolX <= PANEL_SIZE - PATROL_SIZE - 4) {
      drawPatrol(g, Color.WHITE);
      patrolX+=7;
      drawPatrol(g, Color.GREEN);
    } else if (key == LEFT_ARROW && patrolX >= 5) {
      drawPatrol(g, Color.WHITE);
      patrolX-=7;
      drawPatrol(g, Color.GREEN);
    } else if (key == SPACE_BAR && patrolMissileY <= 0) {
      patrolMissileY = PATROL_Y - 1;
      patrolMissileX = patrolX + PATROL_SIZE/2;
    }//ends if else loop
  }//ends handleKeys
  
  //draws missile
  public static void movePatrolMissileAndDraw(Graphics g) {
    g.setColor(Color.WHITE);
    g.drawLine(patrolMissileX, patrolMissileY, patrolMissileX, patrolMissileY - MISSILE_LENGTH);
    patrolMissileY-=5;
    g.setColor(Color.BLACK);
    g.drawLine(patrolMissileX, patrolMissileY, patrolMissileX, patrolMissileY - MISSILE_LENGTH);
  }//ends moveMissileAndDraw
  
  public static boolean detectHit() {
    if (patrolMissileX >= enemyX && patrolMissileX <= enemyX + ENEMY_SIZE && patrolMissileY - MISSILE_LENGTH >= ENEMY_Y &&
        patrolMissileY - MISSILE_LENGTH <= ENEMY_Y + ENEMY_SIZE) {
      return true; 
    } else {
      return false;
    }//ends if else loop
  }//ends detectHit
 
  //starts the game
  public static void startGame(DrawingPanel panel, Graphics g) {
    
    drawPatrol(g, Color.GREEN);
    for(int time = 0; time <= 1000; time++) {
      movePatrolMissileAndDraw(g);
      panel.sleep(50); 
      moveEnemyShipAndDraw(g); 
      handleKeys(panel, g);
      if(detectHit() == true) {
        hit = true;
      } else if (enemyX == PANEL_SIZE) {
        g.setColor(Color.RED);
        g.drawString("ENEMY SHIP GOT AWAY!", 20, 295);
      }//ends if else
      
    }//ends for loop
  }//ends startGame 
}//ends class