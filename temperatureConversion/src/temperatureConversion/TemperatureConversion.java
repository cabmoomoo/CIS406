//Caleb Barbee CIS406 Temperature Conversion Lab
package temperatureConversion;
import java.util.Scanner;

public class TemperatureConversion {

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Temperature Converter\n");
		
		Scanner userInput = new Scanner(System.in);
		System.out.print("Enter degrees in Fahrenheit: ");
		float inputFahren = userInput.nextFloat();
		float outputCels = (inputFahren - 32f) * (5f / 9f);
		System.out.println("Degrees in Celsius: " + String.format("%.2f", outputCels));
		
		System.out.print("Enter degrees in Celsius: ");
		float inputCels = userInput.nextFloat();
		float outputFahren = inputCels * (9f / 5f) + 32f;
		System.out.println("Degrees in Fahrenheit: " + String.format("%.2f", outputFahren));
		
		System.out.println("\nThanks for temperaturing.");
		
	}

}
