import java.util.Scanner;
public class jfcCalculator{
    public static void main(String[] args) {
        //calculates total fuel needed from Nauticle miles, Cruising speed, Fuel consumption per hour, Average headwind
        //2024-02-25
        //Calculations based off https://www.simcoders.com/2018/09/07/how-to-calculate-the-fuel-required-for-your-flight/
        double NM = 0;
        double KTAS = 0;
        double USG = 0;
        double KTS = 0;

        Scanner nauticleMile = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Nauticle Miles: ");

        NM = nauticleMile.nextInt();

        Scanner cruisingSpeed = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Cruising Speed: ");
        //Cruising Speed
        KTAS = cruisingSpeed.nextInt();

        Scanner cruisingFuelConsumption = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Cruising Fuel Consumption (per hour): ");
        
        //Fuel consumption(cruising)
        USG = cruisingFuelConsumption.nextInt();

        Scanner headWind = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Average Headwind");
        
        //headwind in knots
        KTS = headWind.nextInt();


        double taxiFuel = 1.0;
        double groundSpeed = KTAS - KTS;
        double tripTime = NM / groundSpeed;
        double tripFuel = USG * tripTime;
        double contingency = tripFuel * 0.05; //5% contingency fuel
        double finalReserve = USG / 1.333; //1.333 is 0:45 of an our

        double total = taxiFuel + tripFuel + contingency + finalReserve;
        System.out.println(tripFuel);
        System.out.println(contingency);
        System.out.println(finalReserve);
        System.out.println(total);
        System.out.println("!!!WARNING!!!");
        System.out.println("This does NOT include extra fuel the commander decides to load in particular cases.");
    }
}