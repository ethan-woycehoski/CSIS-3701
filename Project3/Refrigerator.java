/*--------------------------------------------------*/
/* Programmed by: Ethan Woycehoski                  */
/* Assignment: Project #3                           */
/* Purpose: This is a class that initializes and    */
/* returns Refrigerator object information to the   */
/* driver class.                                    */
/*--------------------------------------------------*/

public class Refrigerator extends Appliance implements Recyclable  {
    // private variables for use during program
    private int doorCount;
    private final double MAX_COOLING_CAPACITY = 100.0;

    // public static variables for use throughout program and classes
    public static final int FRIDGE_DOORS_MIN = 1;
    public static final int FRIDGE_DOORS_MAX = 4;
    
    // constructor method to initialize the Refrigerator object
    public Refrigerator(String brand, int year, int doorCount) {
        super(brand, year);
        this.doorCount = doorCount;
    }

    // method to get door count
    public int getDoorCount() {
        return doorCount;
    }

    // method to get max operating level of the Refrigerator
    public double getMaxOperatingLevel() {
        double maxOperatingLevel = 0.0;
        
        // if door count is greater than two it has reduced operating level
        if (doorCount > 2) {
            maxOperatingLevel = .85 * MAX_COOLING_CAPACITY;
        // else it is the max cooling capacity
        } else {
            maxOperatingLevel = MAX_COOLING_CAPACITY;
        }
        return maxOperatingLevel;
    }

    // boolean method to check if needs commercial recycling
    public boolean needsCommercialRecycling() {
        /* 
            if the door count is the max fridge doors
            it needs to be commercially recycled
        */
        if (doorCount == FRIDGE_DOORS_MAX) {
            return true;
        // else it does not need to be
        } else {
            return false;
        }
    }

    // overriden to String method returns the desired formatted String
    @Override
    public String toString() {
        return super.toString() + "\nType: Refrigerator\n" + "Door Count: " + getDoorCount() 
               + "\nMax Cooling Capacity: " + getMaxOperatingLevel() + 
               "\nNeeds Commercial Recycling: " + needsCommercialRecycling() + "\n";
    }
}
