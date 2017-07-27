import java.util.*;

public class SumNumbers {
  public static final Scanner CONSOLE = new Scanner(System.in);
  
  //promptForInt
  public static int promptForInt(String prompt) {
   System.out.println(prompt);
   return CONSOLE.nextInt();
  }
  
  //exe starts here
  public static void main(String [] args) {
    //get first number
    int num1 = promptForInt("Enter first number: ");
    
    //get second number
    int num2 = promptForInt("Enter second number: ");
    
    //sum the numbers 
    int sum = 0;
      for(int i = num1; i <= num2; i++) {
      sum += i;
    }//ends for loop
    System.out.println("The sum of numbers from " + num1 + " to " + num2 + " is " + sum + ".");
  }//ends main
  
}//ends class
