import java.util.*;

public class SumInput {
  public static final Scanner CONSOLE = new Scanner(System.in);
  
    //promptForInt
  public static int promptForInt(String prompt) {
   System.out.println(prompt);
   return CONSOLE.nextInt();
  }
  
    //promptForDouble
  public static double promptForDouble(String prompt) {
   System.out.println(prompt);
   return CONSOLE.nextDouble();
  }
  
  public static void main(String [] args) {
    //prompt for number of doubles
    int numDoubles = promptForInt("How many doubles to enter?");
    
    //loop receiving doubles from user input and adding to sum
    double sum = 0.0;
    double product = 1.0;
    int countOfNeg = 0;
    for(int i = 1; i <= numDoubles; i++) {
      double d = promptForDouble("Enter a double:");
      sum += d;
      product *= d;
      //if d is negative, increment count
      if(d < 0) {
      countOfNeg++;
      }//ends if
    }//ends for loop
    
    //print out sum
    System.out.println("Sum of " + numDoubles + " doubles is " + sum + ".");
    
    //print out average
    if (numDoubles > 0) {
    System.out.println("Average of " + numDoubles + " doubles is " + (sum / numDoubles) + ".");
    } else { 
    System.out.println("Cannot compute an average of zero doubles!"); 
    }//ends if/else
    
    //print product
    System.out.println("Product of " + numDoubles + " doubles is " + product + ".");
    
    //print count of negative
    if(countOfNeg != 1) {
    System.out.println("There were " + countOfNeg + " negative numbers entered.");
    } else {
      System.out.println("There was " + countOfNeg + " negative number entered.");
  }//ends if/else
  }//ends main
}//ends class