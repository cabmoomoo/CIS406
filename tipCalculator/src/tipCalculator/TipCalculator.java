//Caleb Barbee CIS406 Tip Calculator Lab
package tipCalculator;

import java.text.NumberFormat;
import java.util.*;

public class TipCalculator {
	
	public static String fmt(float f) {
		// A "simple" function to preserve up to 2 decimal places while removing all trailing zeroes
	    if(f == (long) f)
	    	// If the float is already basically an integer, send back as an integer
	        return String.format("%d",(long)f);
	    else {
	    	// Format to 2 decimals
			String x = String.format("%.2f", f);
			float y = Float.parseFloat(x);
			if (y == (long) y) 
				// If the formatting made it .00, return as an integer
				return String.format("%d",(long)y);
			else
				// Otherwise, return with decimals minus trailing zeroes
				return String.format("%s",y);}
	}

	public static void main(String[] args) {
		
		System.out.println("Tip Calculator");
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
		try (Scanner userInput = new Scanner(System.in)) {
			
			String userCont = "";
			do {
				System.out.print("\nCost of meal: ");
				float mealCost = Float.valueOf(userInput.nextLine());
				
				for (float perc = 0.15f; perc < 0.3f; perc += 0.05) {
					System.out.println(fmt(perc*100) + "%");
					float tipAmount = perc * mealCost;
					System.out.println("Tip amount:\t" + formatter.format(tipAmount));
					System.out.println("Total amount:\t" + formatter.format(tipAmount + mealCost));
				}
				
				System.out.print("Continue? (y/n): ");
				userCont = userInput.nextLine();
			} while (userCont.equals("y"));
			
			System.out.println("\nThanks for eating");
			
		}

	}

}
