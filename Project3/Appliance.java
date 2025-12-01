/*--------------------------------------------------*/
/* Programmed by: Ethan Woycehoski                  */
/* Assignment: Project #3                           */
/* Purpose: This is an abstract class that          */
/* initializes the Appliance super class for both   */
/* Washer and Refrigerator classes.                 */
/*--------------------------------------------------*/

public abstract class Appliance {
    // public static variables to be used throughout program and classes
    public static final int YEAR_MIN = 1990;
    public static final int YEAR_MAX = 2025;

    // private variables for use in program
    private String brand; 
    private int yearManufactured; 

    // constructor method to initialize the Appliance object
    public Appliance (String brand, int yearMfg) {
        this.brand = brand;
        this.yearManufactured = yearMfg;
    }

    // overriden to String method to return the desired formatted String
    @Override
    public String toString() {
        return "Brand: " + brand + "\nYear Manufactured: " + yearManufactured;
    }

    /* 
        abstract method requires each child class to 
        provide its own max operating level 
    */
    public abstract double getMaxOperatingLevel();
}
