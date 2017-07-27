import java.util.*;

public class Playoffs {
  
  public static final Scanner CONSOLE = new Scanner(System.in);
  
  //exe starts here
  public static void main(String [] args) {
    System.out.println("Lab 6 written by Christian Wilson.");
    int percent = promptForInt("Enter percent chance that Team 1 will win a game:");
    while(percent < 0 || percent > 100) {
      System.out.println("Sorry. The number " + percent + " is unusable.  Please enter a number between 0 and 100.");
      percent = promptForInt("Enter percent chance that Team 1 will win a game:");
    }//end while
    
    Random rand = new Random();
    multiplePlayoffs(percent, rand);
  }//ends main
  
  //prompts user for int
  public static int promptForInt(String prompt) {
    System.out.println(prompt);
    return CONSOLE.nextInt();
  }//ends promptForInt
  
  //simulates single game
  public static boolean Game(int percent, Random rand) {
    int num1 = rand.nextInt(100);
    return num1 < percent;
  }//ends Game
  
  //simulates single playoff
  public static boolean Playoff(int percent, Random rand) {
    int winsTeam1 = 0;
    int winsTeam2 = 0;
    
    while(winsTeam1 < 4 && winsTeam2 < 4) { 
      if(Game(percent, rand)) {
        winsTeam1++;
      } else {
        winsTeam2++;
      }//ends if/else loop
    }//ends while loop
    
    return winsTeam1 > winsTeam2;
  }//ends Playoff
  
  //simulates multiple playoffs
  public static void multiplePlayoffs(int percent, Random rand) {
    int winsTeam1 = 0;
    int winsTeam2 = 0;
    
    while(winsTeam1 < winsTeam2 + 10 && winsTeam2 < winsTeam1 + 10) {
      if(Playoff(percent, rand)) {
        winsTeam1++;
        System.out.print("1");
      } else {
        winsTeam2++;
        System.out.print("2");
      }//ends if/else loop
    }//ends while loop
    
    //prints final results
    System.out.println();
    if(winsTeam1 > winsTeam2) {
      System.out.println("Team 1 won!");
    } else {
      System.out.println("Team 2 won!");
    }//ends if/else loop
    
  }//ends Playoffs
  
}//ends class