/*-------------------------------------------------*/
/* Programmed by: Ethan Woycehoski                 */
/* Assignment: Project #1                          */
/* Purpose: This program is designed to calculate  */
/* a household's total energy balance. It does     */
/* this by storing and using the households'       */
/* monthly energy balance, renewable energy rate,  */
/* and the last credited renewable energy amount.  */
/*-------------------------------------------------*/


public class EnergyAccount {

    private double balance;
    private double renewableRates;
    private double lastCredit;

    public EnergyAccount(double bal, double rate)
    {
        balance = bal;
        renewableRates = rate;
    } 
   
    public void consume(double amount)
    {
        balance = balance - amount;
    }

    public void generate(double amount)
    {
        balance = balance + amount;
    }

    public void addRenewableCredit() 
    {
        lastCredit = (renewableRates * balance);
        balance = balance + (renewableRates * balance);
    }

    public double getBalance()
    {
        return balance;
    }

    public double getRenewableRate()
    {
        return renewableRates;
    }

    public double getLastCredit() 
    {
        return lastCredit;
    }
    

} 
