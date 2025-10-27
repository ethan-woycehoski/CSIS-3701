/*-------------------------------------------------*/
/* Programmed by: Ethan Woycehoski                 */
/* Assignment: Project #2                          */
/* Purpose: Program is a class that reads          */
/* monthly sales data. Has methods to access and   */
/* change sales information.                       */
/*-------------------------------------------------*/

import java.util.ArrayList;

public class SalesRecord {
    // static string with month names inside
    private static final String[] monthNames = {"January", "February", 
        "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December"};

    // private variables for use during program
    private int month;
    private double amount;

    // constructor to initialize the SalesRecord object
    public SalesRecord(int month, double amount) {
        this.month = month;
        this.amount = amount;
    }

    /* 
       copy constructor to initialize the SalesRecord object with the 
       with the values of another SalesRecord object
    */
    public SalesRecord(SalesRecord obj) {
        this.month = obj.month;
        this.amount = obj.amount;
    }

    // method to get month
    public int getMonth() {
        return month;
    }

    // method to get month name from monthNames string array
    public String getMonthName() {
       return monthNames[month];
    }

    // static method to get the month name from monthNames
    public static String getMonthName(int month) {
        return monthNames[month]; 
    }

    // method to set private variable month
    public void setMonth(int month) {
        this.month = month;
    }

    // method to get private variable amount
    public double getAmount() {
        return amount;
    }

    // method to set private variable amount
    public void setAmount(double amt) {
        this.amount = amt;
    }

    // overriden method to string to return string of formatted month and amount
    @Override
    public String toString() {
        return getMonthName() + " : $" + String.format("%.2f", amount);
    }

    // method to display the lowest amount inside the array list
    public static void displayLowestAmount(ArrayList<SalesRecord> list) {
        double lowest = list.get(0).getAmount();
        int monthCount = 0;

        // for loop to run through array list and compare the lowest throughout
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getAmount() < lowest) {
                lowest = list.get(index).getAmount();
                monthCount = index;
            }
        }
        // display lowest amount
        System.out.printf("Lowest amount: $%.2f Month: %s\n", lowest, list.get(monthCount).getMonthName());
    }

    // method to display the highest amount in the array list
    public static void displayHighestAmount(ArrayList<SalesRecord> list) {
        double highest = list.get(0).getAmount();
        int monthCount = 0;

        // for loop to run through array to compare the highest throughout
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).getAmount() > highest) {
                highest = list.get(index).getAmount();
                monthCount = index;
            }
        }
        // display highest amount
        System.out.printf("Highest amount: $%.2f Month: %s\n", highest, list.get(monthCount).getMonthName());
    }

    // method to display the average amount of all amounts in array list
    public static void displayAverageAmount(ArrayList<SalesRecord> list) {
        double average = 0;

        // for loop to run through array list and sum all sales amount together
        for (int index = 0; index < list.size(); index++) {
            average += list.get(index).getAmount();
        }
        // divide the total by the size to get the average
        average /= list.size();

        // display the average sales
        System.out.printf("Average sales per month: $%.2f\n", average);
    }

    // method to sort the array list in a descending amount order
    public static void sortDescending(ArrayList<SalesRecord> list) {

        // outer loop runs through the array list
        for(int index = 0; index < list.size(); index++) {
            int maxIndex = index;

            // inner loop looks for a higher value in the list
            for(int jIndex = index + 1; jIndex < list.size(); jIndex++) {
                if(list.get(jIndex).getAmount() > list.get(maxIndex).getAmount()) {
                    maxIndex = jIndex;
                }
            }

            // temporary variable used to swap SalesRecord objects
            SalesRecord temp = list.get(index);
            list.set(index, list.get(maxIndex));
            list.set(maxIndex, temp);
        }

        // for loop displays each item in array list
        System.out.println("\nSales by month");
        for (int index = 0; index < list.size(); index++)
        {
            SalesRecord item = (SalesRecord)list.get(index);
            System.out.println(item);
        }     
    }
}