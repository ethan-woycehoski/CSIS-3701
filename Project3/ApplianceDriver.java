/*--------------------------------------------------*/
/* Programmed by: Ethan Woycehoski                  */
/* Assignment: Project #3                           */
/* Purpose: Program is the driver class for this    */
/* program. It is designed to gather inputs and to  */
/* call the other classes and their various methods.*/
/* Also it displays the outputs and the menu to the */
/* screen.                                          */
/*--------------------------------------------------*/

import java.util.Scanner;
import java.util.ArrayList;

public class ApplianceDriver {
    public static void main (String[] args) {
        // instantiates variables and objects for the program
        int choice = -1;
        ArrayList<Appliance> appLog = new ArrayList<Appliance>();
        Scanner keyboard = new Scanner(System.in);

        // do while loop to display menu and get the user's choice
        do {
            // calls getMenuChoice method and stores the result in choice
            choice = getMenuChoice(keyboard);

            // if choice is one call getWasher
            if (choice == 1) {
                // appLog.add adds the result of getWasher to the ArrayList appLog
                appLog.add(getWasher(keyboard));
            // else if choice is 2 call getRefrigerator
            } else if (choice == 2) {
                // appLog.add adds the result of getRefrigerator to the ArrayList appLog
                appLog.add(getRefrigerator(keyboard));
            // else if choice is 3 call showApplianceLog
            } else if (choice == 3) {
                showApplianceLog(appLog);
            // else if choice is 4 exit program
            } else if (choice == 4) {
                break;
            }
        // do while choice does not equal 4
        } while (choice != 4);

        // closes the scanner object
        keyboard.close();
    }

    // private method to display the menu and get the choice from the user
    private static int getMenuChoice(Scanner keyboard) {
        // creates variable for storing the user's choice
        int menuChoice = -1;

        // displays the menu and prompts the user
        System.out.println("\nSelect a type of appliance to record: ");
        System.out.println("1. Washer\n2. Refrigerator\n3. Display Appliances\n4. Exit");

        // reads the user's input
        menuChoice = keyboard.nextInt();    
        
        // if statement validates the input
        if (menuChoice < 1 || menuChoice > 4) {
            // displays error warning
            System.out.println("Invalid choice.");
            // recursively calls method again to make user input valid menu choices
            return getMenuChoice(keyboard);
        }

        // clears the keyboard buffer
        keyboard.nextLine();

        // returns the user's choice to main
        return menuChoice;
    }

    // private method to instantiate the Washer object
    private static Washer getWasher(Scanner keyboard) {
        // variables to be used during method
        String brandWash; 
        int yearWash;
        double drumSize;

        // prints formatting text
        System.out.println("\n------------------------------");
        
        // calls getBrandName method and stores result in brandWash
        brandWash = getBrandName(keyboard);
        
        // calls getYearManufactured method and stores it in yearWash
        yearWash = getYearManufactured(keyboard);

        // calls getDrumSize and stores it in drumSize
        drumSize = getDrumSize(keyboard);

        // creates a new Washer object with the inputted brand, year, and drum size
        Washer washer = new Washer(brandWash, yearWash, drumSize);

        // returns Washer object to main
        return washer;
    }

    // private method to instantiate the Refrigerator object
    private static Refrigerator getRefrigerator(Scanner keyboard) {
        // variables to be used during method
        String brandRef;
        int yearRef;
        int doorCount;

        // prints formatting text
        System.out.println("\n------------------------------");
        
        // calls getBrandName stores in brandRef
        brandRef = getBrandName(keyboard);
        
        // calls getYearManufactured stores in yearRef
        yearRef = getYearManufactured(keyboard);

        // calls getDoorCount stores in doorCount
        doorCount = getDoorCount(keyboard);

        // creates a new Refrigerator object with the inputted brand, year, and door count
        Refrigerator refrigerator = new Refrigerator(brandRef, yearRef, doorCount);

        // returns Refrigerator object to main
        return refrigerator;
    }

    // private method to display appliance log
    private static void showApplianceLog(ArrayList<Appliance> log) {
        // validates the size of the array is greater than zero
        if (log.size() <= 0) {
            System.out.println("No appliances logged");
            return;
        }
        
        // prints formatting text
        System.out.println("\n--------------------");
        System.out.println("Show Appliance Log");
        System.out.println("--------------------");
        
        // loops through and displays each Appliance in the ArrayList  
        for (Appliance a : log ) {
            System.out.println(a);
        }

        // prints more formatting text
        System.out.println("--------------------\n");
    }

    // private method to get brand name from user
    private static String getBrandName(Scanner keyboard) {
        // variable for use during method
        String brandName;

        // prompts the user for the brand name
        System.out.println("Enter the brand of the appliance: ");

        // reads and stores the user's input
        brandName = keyboard.nextLine();

        // validates the user input to make sure they inputted something
        if (brandName.length() <= 0) {
            // displays an error message
            System.out.println("You must enter the brand name for the appliance.");
            
            // recursively calls method again to make user input a valid brand name
            return getBrandName(keyboard);
        }

        // returns the inputted brand name
        return brandName;
    }

    // private method to get year manufactured from user
    private static int getYearManufactured(Scanner keyboard) {
        // variable for use during method
        int yearMan = -1;

        // prompts the user for the year the appliance was built
        System.out.println("Enter the year it was built: ");

        // reads and stores user's input
        yearMan = keyboard.nextInt();

        // validates the user's input, must be between 1990 and 2025
        if (yearMan < Appliance.YEAR_MIN || yearMan > Appliance.YEAR_MAX) {
            // displays error message
            System.out.println("Year must be between 1990 and 2025.");
            
            // recursively calls method again to make user input a valid year
            return getYearManufactured(keyboard);
        }

        // returns the year manufactured
        return yearMan;
    }

    // private method to get drum size
    private static double getDrumSize(Scanner keyboard) {
        // variable for use during method
        double drumLbs = -1;

        // prompts user for the drum size
        System.out.println("Enter the drum size (lbs):");

        // reads and stores the user's input
        drumLbs = keyboard.nextDouble();

        // if statement validates the user's input, must be between 5.0 and 25.0
        if (drumLbs < Washer.WASHER_MIN_LBS || drumLbs > Washer.WASHER_MAX_LBS) {
            // display an error message
            System.out.println("Drum size must be between 5.0 and 25.0.");

            // recursively calls the method again until user inputs valid data
            return getDrumSize(keyboard);
        }

        // returns the drum size
        return drumLbs;
    }

    // private method to get door count
    private static int getDoorCount(Scanner keyboard) {
        // variable for use during method
        int door = -1;

        // prompts user for door count
        System.out.println("Enter the door count:");

        // reads and stores the input from user
        door = keyboard.nextInt();

        // if statement validates user's input, must be between 1 and 4
        if (door < Refrigerator.FRIDGE_DOORS_MIN || door > Refrigerator.FRIDGE_DOORS_MAX) {
            // displays an error message
            System.out.println("Door count must be between 1 and 4.");

            // recursively calls the method again until user inputs valid data
            return getDoorCount(keyboard);
        }

        // returns door count
        return door;
    }
 }