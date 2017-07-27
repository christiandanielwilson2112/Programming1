import java.util.*;
import java.text.*;

/*
 * FutureValues: calculate future value of compound interest and future value of annuity
 */
public class FutureValues {
  public static final Scanner CONSOLE = new Scanner(System.in); 
  
  //prints CompoundInterest method
  public static double compoundInterest(double value, double rate, double years) {
    return value * Math.pow((1 + rate / 100), years);
  }//ends CompoundInterest
  
  //prints Annuity method
  public static double annuity(double payment, double rate, double years) {
    return payment * (Math.pow((1 + rate / 100), years) - 1) / (rate / 100);
  }//ends Annuity
  
  // Returns a String $dollars.cents rounded to the nearest cent.
  public static String moneyString(double amount) {
    DecimalFormat dollarsAndCents = new DecimalFormat("$#0.00");
    return dollarsAndCents.format(amount);
  }//ends moneyString
  
  //main: exe starts here
  public static void main(String [] args) {
    //1. print title
    System.out.println("Lab 3 written by Christian Wilson");
    
    //2. get input from user from CONSOLE and save variables
    System.out.println("Enter present value of money: ");
    double value = CONSOLE.nextDouble();
    System.out.println("Enter interest rate: ");
    double rate = CONSOLE.nextDouble();
    System.out.println("Enter number of years: ");
    double years = CONSOLE.nextDouble();
    System.out.println("Enter yearly payment: ");
    double payment = CONSOLE.nextDouble();
    
    //3. calls compoundInterest and converts to dollar and cents
    double amountCI = compoundInterest(value, rate, years);
    String dollarAmountCI = moneyString(amountCI);
    
    //4. calls annuity and converts to dollars and cents  
    double amountA = annuity(payment, rate, years);
    String dollarAmountA = moneyString(amountA);
    
    //5. prints values into a sentence after computing
    System.out.println("The future value of an account of $" + value + " with " + rate 
                         + "% interest in " + years + " years is " + dollarAmountCI + ".");
    System.out.println("The future value of an annuity of $" + payment + " with " + rate 
                         + "% interest in " + years + " years is " + dollarAmountA + ".");
    
  }//ends main
}//ends class