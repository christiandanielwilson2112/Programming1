import java.awt.*;
import java.util.*;

public class Circles {
  public static final Scanner CONSOLE = new Scanner(System.in);
  
  //main exe starts here
  public static void main(String [] args) {
    
    //provides drawing panel
    DrawingPanel panel = new DrawingPanel(400, 300);
    Graphics g = panel.getGraphics();
    
    //prints author's name
    System.out.println("Lab 5 written by Christian Wilson.");
    
    //draws green circle
    int radius1 = promptForInt("Enter radius of the green circle:");
    int diameter1 = radius1 * 2;
    int x1 = promptForInt("Enter x coordinate of the green circle:") - radius1;
    int y1 = promptForInt("Enter y coordinate of the green circle:") - radius1;
    g.setColor(Color.GREEN);
    g.fillOval(x1, y1, diameter1, diameter1);
    
    //draws red circle
    int radius2 = promptForInt("Enter radius of the red circle:");
    int diameter2 = radius2 * 2;
    int x2 = promptForInt("Enter x coordinate of the red circle:") - radius2;
    int y2 = promptForInt("Enter y coordinate of the red circle:") - radius2;
    g.setColor(Color.RED);
    g.fillOval(x2, y2, diameter2, diameter2);
    
    //draws blue circle
    int radius3 = promptForInt("Enter radius of the blue circle:");
    int diameter3 = radius3 * 2;
    int x3 = promptForInt("Enter x coordinate of the blue circle:") - radius3;
    int y3 = promptForInt("Enter y coordinate of the blue circle:") - radius3;
    g.setColor(Color.BLUE);
    g.fillOval(x3, y3, diameter3, diameter3);
    
    //calls method to compare sizes of the circles
    String circle12 = compareCircles(radius1, radius2);
    System.out.println("The green circle " + circle12 + " the red circle.");
    String circle23 = compareCircles(radius2, radius3);
    System.out.println("The red circle " + circle23 + " the blue circle.");
    String circle31 = compareCircles(radius3, radius1);
    System.out.println("The blue circle " + circle31 + " the green circle.");
    
    //calls method to determine intersection of pairs of circles
    String cross12 = intersection(radius1, radius2, x1, y1, x2, y2);
    System.out.println("The green circle " + cross12 + " the red circle.");
    String cross23 = intersection(radius2, radius3, x2, y2, x3, y3);
    System.out.println("The red circle " + cross23 + " the blue circle.");
    String cross31 = intersection(radius3, radius1, x3, y3, x1, y1);
    System.out.println("The blue circle " + cross31 + " the green circle.");
    
  }//ends main
  
  //intersection: deterines intersection of pairs of circles
  public static String intersection(int radiusOne, int radiusTwo, int xOne, int yOne, int xTwo, int yTwo) {
    if(Math.sqrt((xTwo - xOne)*(xTwo - xOne) + (yTwo - yOne)*(yTwo - yTwo)) > radiusOne + radiusTwo) {
      return "does not intersect";
    } else {
      return "intersects";
    }//ends if/else
    
  }//ends intersection
  
  
  //compareCircles: compares sizes of the circles
  public static String compareCircles(int radiusOne, int radiusTwo) {
    if (radiusOne < radiusTwo){
      return "is smaller than";
    } else if(radiusOne > radiusTwo) {
      return "is larger than";
    } else {
      return "is the same size as";
    }//ends if/else
    
  }//ends compare circles
  
  //promptForInt: prompts user for input on dimensions of circle
  public static int promptForInt(String prompt) {
    System.out.println(prompt);
    return CONSOLE.nextInt();
  }//ends promptForInt
  
}//ends class