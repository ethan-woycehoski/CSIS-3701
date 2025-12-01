/*--------------------------------------------------*/
/* Programmed by: Ethan Woycehoski                  */
/* Assignment: Project #3                           */
/* Purpose: This is a class that initializes and    */
/* returns Washer information to the driver class.  */
/*--------------------------------------------------*/

public class Washer extends Appliance implements Recyclable {
    // private variables for use during program
    private double drumSizeLbs;
    private final double MAX_SPIN_RPM = 1200.0;

    // public variables for use during program
    public static final double WASHER_MIN_LBS = 5.0;
    public static final double WASHER_MAX_LBS = 25.0;

    // constructor method to initialize the Washer object
    public Washer(String brand, int year, double drumSize) {
        super(brand, year);
        this.drumSizeLbs = drumSize;
    }

    // method to get drum size 
    public double getDrumSizeLbs() {
        return drumSizeLbs;
    } 

    // method to calculate and return the max operating level of the Washer
    public double getMaxOperatingLevel() {
        double maxOperatingLevel = 0.0;

        // if the drum size is above 15 pounds then it has a reduced operating level
        if (drumSizeLbs > 15) {
            maxOperatingLevel = .90 * MAX_SPIN_RPM;

        // else it is the max spin
        } else {
            maxOperatingLevel = MAX_SPIN_RPM;
        }
        return maxOperatingLevel;
    }

    // method to see if it needs to be commercially recycled
    public boolean needsCommercialRecycling() {
        return false;
    }

    // overriden to String method to return String of the desired format
    @Override
    public String toString() {
        return super.toString() + "\nType: Washer\n" + "Drum Size (lbs): " + getDrumSizeLbs()
               + "\nMax Spin RPM: " + getMaxOperatingLevel() + "\nNeeds Commercial Recycling: "
               + needsCommercialRecycling() + "\n";
    }
}
