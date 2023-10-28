//Caleb Barbee CIS406 Travel Time Converter Lab
package travelTimeConverter;
import java.util.Scanner;

public class TravelTimeConverter {

	public static void main(String[] args) {

		System.out.println("Welcome to the Travel Time Calculator\n");
		Scanner userInput = new Scanner(System.in);
		
		System.out.print("Enter miles: ");
		float milesInput = userInput.nextFloat();
		System.out.print("Enter miles per hour: ");
		float mphInput = userInput.nextFloat();
		
		System.out.println("Estimated travel time");
		System.out.println("---------------------");
		
		float estHours = milesInput / mphInput;
		float estMinutes = (milesInput % mphInput) / mphInput * 60f;
		
		System.out.println("Hours: " + (int) estHours);
		System.out.println("Minutes: " + (int) estMinutes);
		
		System.out.println("\nSEE YOU SPACE COWBOY...");

	}

}
