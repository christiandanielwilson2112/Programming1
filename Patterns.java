import java.util.*;

/*
 * Project 1 takes user input for number of boxes and text tiles
 */

public class Patterns {
  public static final Scanner CONSOLE = new Scanner (System.in);
  
// exe of program Patterns starts here
  public static void main(String [] args) {
    
    //prints name of author of program
    System.out.println("Project 1 written by Christian Wilson");
    
    //calls Box method
    Box();
    
    //calls TextTiles method
    TextTiles(); 
    
  }//main ends
  
  
//prints new Line
  public static void Line() {
    System.out.print("\n");
  }
  
  //prints Box method
  public static void Box() {
    
    //user input for number of boxes
    System.out.println("Enter number of boxes: ");
    int numBoxes = CONSOLE.nextInt();
    
    //prints top ofBox
    System.out.print("+");
    for(int i = 1; i <= numBoxes; i++) { 
      System.out.print("-------+");
    }//end for loop
    
    Line();
    //ends top
    
    //print middle of Box
    System.out.print("|");
    for(int i = 1; i <= numBoxes; i++) {
      System.out.print("       |");
    }//end for loop
    
    Line();
    //ends middle
    
    System.out.print("|");
    for(int i = 1; i <= numBoxes; i++) {
      System.out.print("       |");
    }//end for loop
    
    Line();
    //ends middle
    
    //prints bottom of Box
    System.out.print("+");
    for(int i = 1; i <= numBoxes; i++) { 
      System.out.print("-------+");
    }//end for loop
    
    Line();
    //ends bottom
    
  }//ends box
  
  //prints TextTiles method
  public static void TextTiles() {
    Line();
    System.out.println("Enter height of pattern: ");
    int height = CONSOLE.nextInt();
    System.out.println("Enter width of pattern: ");
    int width = CONSOLE.nextInt();
    
    //prints top of hexagon
    for(int i = 1; i <= width; i++){
      System.out.print(" __   ");
    }//end for loop
    Line();
    
    //prints middle and bottom of hexagon
    for(int i = 1; i <=height; i++) {
      for(int j = 1; j <= width; j++)
        System.out.print("/  \\__");
      Line();
      for(int k = 1; k <= width; k++)
        System.out.print("\\__/  ");
      Line();
    }//end for loop
    
  }//end TextTiles
  
}//end class