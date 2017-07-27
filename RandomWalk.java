import java.util.*;
import java.awt.*;
public class RandomWalk {
  public static final Scanner CONSOLE = new Scanner(System.in);
  
  //exe starts here
  public static void main(String [] args) {
    System.out.println("Lab 7 written by Christian Wilson.");
    String color = color();
    int radius = radius(); 
    int count = randomWalk(radius, color);
    System.out.println("You entered " + color + " and " + radius + ". " + "The number of steps in the random walk is " + count + ".");    
  }//ends main
  
  //draw randomWalk
  public static int randomWalk(int radius, String color) {
    int diameter = radius * 2;
    int PANEL_SIZE = diameter + 10;
    
    //provides drawing panel
    DrawingPanel panel = new DrawingPanel(PANEL_SIZE, PANEL_SIZE);
    Graphics g = panel.getGraphics();
    int x = PANEL_SIZE/2 - radius;
    
    //draws circle either blue or red
    if(color.equals("blue")) {
      drawCircle(g, Color.BLUE, x, diameter);
    } else if(color.equals("red")) {
      drawCircle(g, Color.RED, x, diameter);
    }//ends if/else
    
    //draws the actual random walk
    Random rand = new Random();
    int num1 = rand.nextInt(4);
    int xMid = x + radius;
    int x1 = x + radius;
    int y1 = x + radius;
    int count = 0;
    drawDot(g, x1, y1);
    while(insideCircle(x1, y1, xMid, radius) == true) {
      num1 = rand.nextInt(4);
      if(num1 == 0) {
        drawDot(g, x1, y1);
        y1++;
      } else if(num1 == 1) {
        drawDot(g, x1, y1);
        y1--;
      } else if(num1 == 2) {
        drawDot(g, x1, y1);
        x1++;
      } else if(num1 == 3) {
        drawDot(g, x1, y1);
        x1--;
      }//ends if/else
      count++;
      panel.sleep(1);
    }//ends while
    
    return count;
  }//ends RandomWalk
  
  //draws circle
  public static void drawCircle(Graphics g, Color c, int x, int diameter) {
    g.setColor(c);
    g.drawOval(x, x, diameter, diameter);
  }//ends drawCircle
  
  //draws dot
  public static void drawDot(Graphics g,int x1, int y1) {
    g.setColor(Color.BLACK);
    g.drawLine(x1, y1, x1, y1);
  }//ends drawDot
  
  //determines if dot is inside the circle
  public static boolean insideCircle(int x1, int y1, int xMid, int radius) {
    return Math.sqrt((xMid - x1)*(xMid - x1) + (xMid - y1)*(xMid - y1)) < radius;
  }//ends insideCircle
  
  //radius: verifies correctly chosen radius
  public static int radius(){
    boolean done = false;
    int num = 0;
    while(!done) {
      num =  promptForInt("Enter a radius between 50 and 400: ");
      done = num >= 50 && num <= 400;
    }//ends while
    return num;
  }//ends radius
  
  //color: verifies correctly chosen color
  public static String color() {
    boolean done = false;
    String s = "";
    while(!done) {
      s = promptForString("Enter either red or blue: ");
      done = matchesChoice(s, "blue") || matchesChoice(s, "red") || matchesChoice(s, "b") || matchesChoice(s, "r");
    }//ends while
    if(matchesChoice(s, "blue") || matchesChoice(s, "b")) {
      return "blue";
    } else if(matchesChoice(s, "red") || matchesChoice(s, "r")) {
      return "red";
    }//ends if else loop
    return s;                  
  }//ends color
  
  //prompts user for a string
  public static String promptForString(String prompt) {
    System.out.println(prompt);
    return CONSOLE.nextLine();
  }//ends promptForInt
  
  //prompts user for an int
  public static int promptForInt(String prompt) {
    System.out.println(prompt);
    return CONSOLE.nextInt();
  }//ends promptForString
  
  //determines if string put in works
  public static boolean matchesChoice(String answer, String choice) {
    return answer.equalsIgnoreCase(choice); 
  }//ends matchesChoice
}//ends class