import java.util.Scanner;

public class Driver {
    public static void main(String args[]) 
    {
        EnergyAccount energy;
        double startBal = -1;
        double renewableRate = -1;
        int months = -1;
        int energyConsumed = -1;
        int energyGen = -1;

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

        System.out.print("Enter number of months to simulate: ");
        months = keyboard.nextInt();

        while (months <= 0) {
            System.out.println("You must enter a number of months > 0.");
            System.out.print("Enter number of months to simulate: ");
            months = keyboard.nextInt();
        }
        
        energy = new EnergyAccount(startBal, renewableRate);

        for (int i = 1; i <= months; i++) {
            System.out.printf("%n--- Month %d ---%n", i);
            System.out.print("Energy consumed this month (kWh): ");
            energyConsumed = keyboard.nextInt();

            while (energyConsumed < 0) {
            System.out.println("You must enter the amount of energy consumed that is >= 0.");
            System.out.print("Energy consumed this month (kWh): ");
            energyConsumed = keyboard.nextInt();
            }

            energy.consume(energyConsumed);
            System.out.print("Energy generated this month (kWh): ");
            energyGen = keyboard.nextInt();

            while (energyGen < 0) {
            System.out.println("You must enter the amount of energy generated that is >= 0.");
            System.out.print("Energy generated this month (kWh): ");
            energyGen = keyboard.nextInt();
            }
            
            energy.generate(energyGen);
            energy.addRenewableCredit();
            System.out.printf("Renewable credit applied: %.2f kWh %n", energy.getLastCredit());
            System.out.printf("Balance after month %d: %.2f kWh %n", i, energy.getBalance());
            
        }
        System.out.printf("%n=== Simulation Complete ===%n");
        System.out.printf("Final Balance: %.2f kWh %n", energy.getBalance());
        
        keyboard.close();
    }
}
