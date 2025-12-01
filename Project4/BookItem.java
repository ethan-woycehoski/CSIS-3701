/*--------------------------------------------------*/
/* Programmed by: Ethan Woycehoski                  */
/* Assignment: Project #4                           */
/* Purpose: This class reads and validates book     */
/* data from a tab-delimited input string. This     */
/* class also throws errors to ensure the correct   */
/* format of title, page count, and cost. It also   */
/* calculates the retail price of the book.         */
/*--------------------------------------------------*/


public class BookItem implements RetailItem {
    // initialize variables for use during class
    public final double MARGIN = .15;
    
    private String description;
    private int pageCount;
    private double cost;

    // constructor to set up the variables
    public BookItem (String line) throws InvalidRecordException {
        // checks line
        if (line == null || line.trim().isEmpty()) {
            throw new InvalidRecordException("Invalid record: Line is empty");
        }

    // Split on tabs
    String[] info = line.split("\t", -1);
    
    // checks the length of the data, must have three fields
    if (info.length != 3) {
        throw new InvalidRecordException("Invalid record: Line must have 3 fields");
    }

    // calls setDescription and passes the book title
    setDescription(info[0]);

    // calls setPageCount and passes the page count 
    setPageCount(info[1]);

    // calls the setCost method and passes the cost
    setCost(info[2]);
}

    // method to set description of the book
    private void setDescription(String desc) throws InvalidRecordException {
        // checks to see if the string is empty will throw an error if so
        if (desc == null || desc.trim().isEmpty()) {
            throw new InvalidRecordException("Invalid record: Description is blank");
        }

        // sets description
        this.description = desc;
    }

    // method to parse the page count and set page count of the book
    private void setPageCount(String count) throws InvalidRecordException{
        // checks to see if the page count string is empty will throw an error
        if (count.trim().isEmpty()) {
            throw new InvalidRecordException("Invalid record: Page count is blank");
        }
        // try catch block will catch if it is invalid format
        try {
            // parses count string into an integer
            int pages = Integer.parseInt(count);
            // if statement to check that pages are positive, will throw error if not
            if (pages <= 0) {
                throw new InvalidRecordException("Invalid record: Page count must be > 0.");
            }
            // sets page count 
            this.pageCount = pages;
            } catch (NumberFormatException e) {
                throw new InvalidRecordException("Invalid record: Page count must be an integer.");
            }
    }

    // method to parse the string cost into a double and set the book's cost
    private void setCost(String cost) throws InvalidRecordException {
        // checks to see if cost string is empty, will throw an error if so
        if (cost.trim().isEmpty()) {
            throw new InvalidRecordException("Invalid record: Cost is blank");
        }

        // try catch block will catch if it is an invalid format
        try {
            // parses cost string into a double
            double bookCost = Double.parseDouble(cost);
            // checks that the cost is positive, will throw error if less than or equal to zero
            if (bookCost <= 0) {
                throw new InvalidRecordException("Invalid record: Cost must be greater than 0.");
            }
            // sets cost 
            this.cost = bookCost;
        } catch (NumberFormatException e) {
            throw new InvalidRecordException("Invalid record: Cost must be a number.");
        }
    }

    // method to get retail price
    public double getRetailPrice() {
        return cost + (cost * MARGIN);
    }

    // overriden toString method to format the output
    @Override
    public String toString() {
        return String.format("Title: %s\nPage Count: %d\nPrice: $%.2f", description,
        pageCount, getRetailPrice()); 
    }

}