/*-------------------------------------------------*/
/* Programmed by: Ethan Woycehoski                 */
/* Assignment: Project #1                          */
/* Purpose: This program is designed to calculate  */
/* a household's total energy balance. It does     */
/* this by using the households' monthly           */
/* energy balance, renewable energy rate,          */
/* and the last credited renewable energy amount.  */
/*-------------------------------------------------*/


public class EnergyAccount {

    // initializes private variables for use in the program
    private double balance;
    private double renewableRates;
    private double lastCredit;

    // constructor method to initalize the EnergyAccount object 
    public EnergyAccount(double bal, double rate)
    {
        balance = bal;
        renewableRates = rate;
    } 
   
    // method to subtract the energy consumed by the balance
    // based on user input
    public void consume(double amount)
    {
        balance = balance - amount;
    }

    // method to add the energy generated to the balance 
    // based on user input 
    public void generate(double amount)
    {
        balance = balance + amount;
    }

    // method to get the last credit that was added to the balance
    // and adds the renewable credit to the balance
    public void addRenewableCredit() 
    {
        lastCredit = (renewableRates * balance);
        balance = balance + lastCredit;
    }

    // method to return the balance
    public double getBalance()
    {
        return balance;
    }

    // method to return renewable rates
    public double getRenewableRate()
    {
        return renewableRates;
    }

    // method to get the last credit that was added 
    public double getLastCredit() 
    {
        return lastCredit;
    }
}
