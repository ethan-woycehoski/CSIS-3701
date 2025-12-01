/*--------------------------------------------------*/
/* Programmed by: Ethan Woycehoski                  */
/* Assignment: Project #4                           */
/* Purpose: This class reads a file containing book */
/* records, creates BookItem objects for each line, */
/* and stores valid items in a list while tracking  */
/* the invalid items. All valid entries are         */
/* displayed and all error messages for malformed   */
/* records.                                         */
/*--------------------------------------------------*/

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;


public class BookDriver {
    public static void main (String[] args) throws FileNotFoundException {
        // Strings to hold the filename
        String filename = "";
        String line;

        // lists to store valid book items and errors
        ArrayList<RetailItem> bookList = new ArrayList<RetailItem>();
        ArrayList<Exception> errorList = new ArrayList<Exception>();

        // tracks which line a potential error occurs
        int lineCount = 0;

        // scanners to recieve input
        Scanner keyboard = new Scanner(System.in);
        Scanner fileScanner = null;

        // check if argument provided 
        if (args.length > 0) {
            filename = args[0];
        
        // loop until file is valid
        while(true) {
            // trys to open file
            try {
                fileScanner =  openFile(filename);
                // if successful breaks
                break;
            // if can't open it display error and prompt for another file
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.print("Enter another file name: ");
                filename = keyboard.nextLine();
            }
        }
        // else if argument was not provided prompt user for file name
        } else if (args.length <= 0) {
            System.out.print("Enter a file name: ");
            filename = keyboard.nextLine();

            // loops until file is valid
            while(true) {
                // trys to open file
                try {
                    fileScanner =  openFile(filename);
                    // if successful breaks
                    break;
                // if it cannot open file display error and prompt for another file
                } catch (FileNotFoundException e) {
                    System.out.println("ERROR: " + e.getMessage());
                    System.out.print("Enter another file name: ");
                    filename = keyboard.nextLine();
                }
            }
        }
    
        // try to read through the file and create BookItem objects
        try (Scanner inputFile = openFile(filename)) 
        {
            while (inputFile.hasNextLine()) {
                lineCount++;
                line = inputFile.nextLine();

                // try to create a book object from the line
                try {
                    BookItem bookInformation = new BookItem(line);
                    bookList.add(bookInformation);
                // if it can't, wrap the error with line number information
                } catch (InvalidRecordException e) {
                    errorList.add(new InvalidRecordException("Line #" + lineCount + ", Error: " + e.getMessage()));
                }
            }
            
            // checks to see if file is empty
            if(lineCount == 0) {
                errorList.add(new InvalidRecordException("File is empty."));
            }

            inputFile.close();
        }
        // catches any I/O exception that occurs when reading the file
        catch (IOException e) {
            System.out.println("Error: Incorrect I/O in file");
        }
        // display all valid items and errors
        displayItems(bookList);
        displayErrors(errorList);
        
        // closes scanners
        keyboard.close();
        fileScanner.close();
    }

    // method attempts to open the file and return a Scanner
    private static Scanner openFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        
        // validate the file
        if (!file.exists() || !file.isFile()) {
            throw new FileNotFoundException(filename + " does not exist.");
        }
        return new Scanner(file);
    }

    // method displays all valid RetailItem objects
    private static void displayItems(ArrayList<RetailItem> books) {
        System.out.println("-------------------");
        System.out.println("Items");
        System.out.println("-------------------");

        for (RetailItem item : books) {
            System.out.println(item);
            System.out.println("-------------------");
        }
    }

    // displays all errors found when processing file
    private static void displayErrors(ArrayList<Exception> errors) {
        System.out.println("-------------------");
        System.out.println("Line with problems");
        System.out.println("-------------------");

        for (Exception e : errors) {
            System.out.println("Invalid record: " + e.getMessage());
        }
    }
}
