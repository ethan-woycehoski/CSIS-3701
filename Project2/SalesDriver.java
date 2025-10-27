/*--------------------------------------------------*/
/* Programmed by: Ethan Woycehoski                  */
/* Assignment: Project #2                           */
/* Purpose: Program is a driver class that reads    */
/* data in from a file and calls methods to display */
/* the lowest, highest, average, and sorted         */
/* sales data by month.                             */
/*--------------------------------------------------*/

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class SalesDriver {
    public static void main (String[] args) throws IOException {
        ArrayList<SalesRecord> record = getSalesAmount();
        
        // calls methods
        SalesRecord.displayLowestAmount(record);
        SalesRecord.displayHighestAmount(record);
        SalesRecord.displayAverageAmount(record);
        SalesRecord.sortDescending(record);

    }

    // private method to read in the file input
    private static ArrayList<SalesRecord> getSalesAmount() throws IOException {
    ArrayList<SalesRecord> record = new ArrayList<SalesRecord>();

    File file = new File("monthly_sales.txt");
    Scanner inputFile = new Scanner(file);
    
    int monthIndex = 0;
 
    // while loop validates the input and reads the file into the SalesRecord object
    while (inputFile.hasNextDouble()) {
        
        double amount = inputFile.nextDouble();

        // validates amount is greater than zero
        if(amount < 0) {
            System.out.println("Error: Sale amounts must be non-negative.");
            System.exit(0);
        }
        
        record.add(new SalesRecord(monthIndex, amount));
        monthIndex++;
    }    
    
    // validates there are 12 months of data read in
    if(monthIndex != 12) {
        System.out.println("Error: there must be exactly 12 records in the file.");
        System.exit(0);
    }

    // closes Scanner object
    inputFile.close();

    return record;
    }
}
