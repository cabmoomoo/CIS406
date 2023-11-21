//Caleb Barbee CIS406 Interest Rate Calculator Part 1 Lab
package interestRateCalculatorPart1;

import java.text.NumberFormat;
import java.util.*;

public class InterestRateCalculatorPart1 {
	
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
	
	public static double interestCalculator(double loan, float interest) {
		return loan * interest;
	}

	public static void main(String[] args) {
		
		System.out.println("Interest Calculator (part 1)");
		NumberFormat currForm = NumberFormat.getCurrencyInstance();
		
		try (Scanner userInput = new Scanner(System.in)) {
			
			String userCont = "";
			do {
				System.out.print("\nEnter loan amount:\t");
				double loanQuant = Double.valueOf(userInput.nextLine());
				System.out.print("Enter interest rate:\t");
				float interestRate = Float.valueOf(userInput.nextLine());
				
				interestRate = interestRate / 100f;
				double totInterest = interestCalculator(loanQuant, interestRate);
				
				System.out.println("\nLoan amount:\t\t" + currForm.format(loanQuant));
				System.out.println("Interest rate:\t\t" + fmt(interestRate * 100) + "%");
				System.out.println("Interest:\t\t" + currForm.format(totInterest));
				
				System.out.print("\nContinue? (y/n): ");
				userCont = userInput.nextLine();
			} while (userCont.equals("y"));
			
			System.out.println("\nThanks for banking");
			
		}
		
	}

}
