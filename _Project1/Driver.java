/*-------------------------------------------------*/
/* Programmed by: Ethan Woycehoski                 */
/* Assignment: Project #1                          */
/* Purpose: This driver class is designed to       */
/* gather input from the user about their          */
/* households' energy usage. It then creates and   */
/* uses an EnergyAccount object with that          */
/* information.                                    */
/*-------------------------------------------------*/

import java.util.Scanner;

public class Driver {
    public static void main(String args[]) 
    {
        // initializes variables for use in program
        EnergyAccount energy;
        double startBal = -1;
        double renewableRate = -1;
        int months = -1;
        int energyConsumed = -1;
        int energyGen = -1;
        
        // creates a scanner object to read input from the keyboard 
        Scanner keyboard = new Scanner(System.in);
       
        // asks user to input a starting energy startBal
        System.out.print("Enter starting energy balance (kWh): ");
        startBal = keyboard.nextDouble();
       
        // while loop to validate the input
        while (startBal < 0) {
            System.out.println("You must enter a starting energy balance >= 0.");
            System.out.print("Enter starting energy balance (kWh): ");
            startBal = keyboard.nextDouble();
        }
       
        // asks user to input renewable rate
        System.out.print("Enter renewable rate (as decimal, e.g., 0.10 for 10%): ");
        renewableRate = keyboard.nextDouble();

        // while loop to validate the input
        while (renewableRate <= 0 || renewableRate >= 1) {
            System.out.println("You must enter a rate between 0 and 1.");
            System.out.print("Enter renewable rate (as decimal, e.g., 0.10 for 10%): ");
            renewableRate = keyboard.nextDouble();
        }

        // asks user to input the number of months they wish to simulate in the program
        System.out.print("Enter number of months to simulate: ");
        months = keyboard.nextInt();

        // while loop to validate their input
        while (months <= 0) {
            System.out.println("You must enter a number of months > 0.");
            System.out.print("Enter number of months to simulate: ");
            months = keyboard.nextInt();
        }
        
        /* creates a EnergyAccount object with the starting balance
        and renewable rate inputted from user */
        energy = new EnergyAccount(startBal, renewableRate);

        // for loop that helps to display and ask for the monthly energy consumed/generated
        for (int i = 1; i <= months; i++) {
            // prints each month the user asked to simulate
            System.out.printf("%n--- Month %d ---%n", i);

            // asks for input for energy consumed
            System.out.print("Energy consumed this month (kWh): ");
            energyConsumed = keyboard.nextInt();

            // while loop to validate the input
            while (energyConsumed < 0) {
            System.out.println("You must enter the amount of energy consumed that is >= 0.");
            System.out.print("Energy consumed this month (kWh): ");
            energyConsumed = keyboard.nextInt();
            }

            // calls the consume method and passes the energy consumed input from user
            energy.consume(energyConsumed);

            // asks for input for energy generated
            System.out.print("Energy generated this month (kWh): ");
            energyGen = keyboard.nextInt();

            // while loop to validate the input
            while (energyGen < 0) {
            System.out.println("You must enter the amount of energy generated that is >= 0.");
            System.out.print("Energy generated this month (kWh): ");
            energyGen = keyboard.nextInt();
            }
            
            // calls the generate method and passes the energy generated input from user
            energy.generate(energyGen);
            energy.addRenewableCredit();

            // displays the renewable credit and balance after the month was calculated
            System.out.printf("Renewable credit applied: %.2f kWh %n", energy.getLastCredit());
            System.out.printf("Balance after month %d: %.2f kWh %n", i, energy.getBalance());
            
        }
        // displays simulation complete and the final balance
        System.out.printf("%n=== Simulation Complete ===%n");
        System.out.printf("Final Balance: %.2f kWh %n", energy.getBalance());
        
        // closes the keyboard object
        keyboard.close();
    }
}
