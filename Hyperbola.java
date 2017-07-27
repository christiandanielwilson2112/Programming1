import java.awt.*;

public class Hyperbola {
  
  //width and height of the DrawingPanel.
  public static final int PANEL_SIZE = 512;
  public static final int Hyperbola_Size1 = 32;
  public static final int Hyperbola_Size2 = 8;
  
  //draws two hyperbolas
  public static void main(String [] args) {
    DrawingPanel panel = new DrawingPanel(PANEL_SIZE, PANEL_SIZE);
    Graphics g = panel.getGraphics();
    
    //draw lower left hyperbola
    for(int i = 0; i < PANEL_SIZE; i+=Hyperbola_Size1) {
      g.drawLine(0, i, i, PANEL_SIZE);
    }//ends for loop
    
    //draws upper right hyperbola
    for(int i = PANEL_SIZE; i > 0; i-=Hyperbola_Size2) {
      g.drawLine(i, 0, PANEL_SIZE, i);
    }//ends for loop
    
  }//ends main
}//ends class