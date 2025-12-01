/*--------------------------------------------------*/
/* Programmed by: Ethan Woycehoski                  */
/* Assignment: Project #3                           */
/* Purpose: This is an interface class that         */
/* requires classes to define whether the item      */
/* needs to be commercially recycled.               */
/*--------------------------------------------------*/

public interface Recyclable {
    // boolean method that must be defined in implemented classes
    public boolean needsCommercialRecycling();
}
