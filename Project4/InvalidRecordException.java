/*--------------------------------------------------*/
/* Programmed by: Ethan Woycehoski                  */
/* Assignment: Project #4                           */
/* Purpose: This class defines a default error      */
/* message and a custom error message. It is used   */
/* to signal when a record is invalid.              */
/*--------------------------------------------------*/

public class InvalidRecordException extends Exception {
    // constructor method no args with a default error message
    public InvalidRecordException() {
        super("Error: Invalid record");
    }

    // constructor method which uses a custom error message
    public InvalidRecordException(String err) {
        super(err);
    }
}