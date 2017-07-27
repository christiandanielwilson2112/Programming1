import java.util.*;

public class StarWarsName {
  public static final Scanner CONSOLE = new Scanner(System.in);
  
  //removes leading and trailing white space
  public static String promptString(String string){
    return string.trim();
  }//ends promptString
  
  //exe starts here
  public static void main(String [] args) {
    
    //prints author's name
    System.out.println("Lab 4 written by Christian Wilson.");
    
    //prints title
    System.out.println("Star Wars Name Generator");
    
    //prints first name  
    System.out.println("Enter your first name:");
    String firstName = CONSOLE.nextLine();
    String firstName1 = promptString(firstName);
    
    //prints last name
    System.out.println("Enter your last name:");
    String lastName = CONSOLE.nextLine();
    String lastName1 = promptString(lastName);
    
    //prints mother's maiden name
    System.out.println("Enter your mother's maiden name:");
    String motherName = CONSOLE.nextLine();
    String motherName1 = promptString(motherName);
    
    //prints place of birth
    System.out.println("Enter the city of your birth:");
    String birthPlace = CONSOLE.nextLine();
    String birthPlace1 = promptString(birthPlace);
    
    //prints first car
    System.out.println("Enter the name of your first car:");
    String firstCar = CONSOLE.nextLine();
    String firstCar1 = promptString(firstCar);
    
    //prints Star Wars name
    String firstSWname = firstName1.substring(0,3) + lastName1.substring(0,2);
    String lastSWname = motherName1.substring(0,2) + birthPlace1.substring(0,3);
    String capsFirstSWname = firstSWname.toUpperCase();
    String capsLastSWname = lastSWname.toUpperCase();
    
    //prints planet
    String planet = lastName1.substring(lastName1.length() - 2, lastName1.length()) + firstCar1;
    String capsPlanet = planet.toUpperCase();  
    
    //prints Star Wars name and planet in a sentence
    System.out.print("You are " + capsFirstSWname + " " + capsLastSWname 
                       + " from " + capsPlanet + ".");
    
  }//ends main
}//end class