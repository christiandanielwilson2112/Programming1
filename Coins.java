import java.util.*;

/* 
 * Lab 2 number of coins and their value in dollars
 */

public class Coins {
  public static final Scanner CONSOLE = new Scanner (System.in);
  
  // prints getCoins
  public static void getCoins() {
    // calls number of quarters
    int quarters;
    // calls number of dimes
    int dimes;
    // calls number of nickels
    int nickels;
    // calls number of pennies
    int pennies;
    // calls dollar value of quarters
    double amountQ;
    // calls dollar value of dimes
    double amountD;
    // calls dollar value of nickels
    double amountN;
    // calls dollar value of pennies
    double amountP;
    
    // prints number and value of quarters
    System.out.println("Enter the number of quarters: ");
    quarters = CONSOLE.nextInt();
    amountQ = quarters * 0.25;
    
    
    // prints number and value of dimes
    System.out.println("Enter the number of dimes: ");
    dimes = CONSOLE.nextInt();
    amountD = dimes * 0.10;
    
    
    // prints number of value of nickels
    System.out.println("Enter the number of nickels: ");
    nickels = CONSOLE.nextInt();
    amountN = nickels * 0.05;
    
    
    // prints number and value of pennies
    System.out.println("Enter the number of pennies: ");
    pennies = CONSOLE.nextInt();
    amountP = pennies * 0.01;
    
    // number of coins and dollar value
    System.out.println(quarters + dimes + nickels + pennies + " coins made up of " 
                         + quarters + " quarters, " 
                         + dimes + " dimes, " 
                         + nickels + " nickels, and " 
                         + pennies + " pennies, equal to $" 
                         + (amountQ + amountD + amountN + amountP) + ".");
    
  }
  
  // prints getCents
  public static void getCents() {
    int cents;
    int quarters;
    int number;
    int dimes;
    int nickels;
    int pennies;
    
    // converts dollar amount of cents into number of each coin
    System.out.println("Enter the amount of cents: ");
    cents = CONSOLE.nextInt();
    quarters = cents / 25;
    number = cents - (quarters * 25);
    dimes = number / 10;
    number = number - (dimes * 10);
    nickels = number / 5;
    number = number - (nickels * 5);
    pennies = number;
    
    System.out.println(cents + " cents is " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, " + pennies + " pennies.");
  }
  
  public static void main(String [] args) {
    
    // prints author of program
    System.out.println("Lab 2 written by Christian Wilson");
    
    // call getCoins
    getCoins();
    
    // call getCents
    getCents();
    
  }
}