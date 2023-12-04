//Caleb Barbee CIS406 Interest Calculator Part 2 Lab
package interestCalculatorPart2;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.text.NumberFormat;

public class InterestCalculatorPart2 {
	
	// Regular expressions can make my head spin, but they do their job really well
	private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	public static boolean isNumeric(String strNum) {
		// If the string exists, see if it's numeric
	    if (strNum == null) {
	        return false; 
	    }
	    return pattern.matcher(strNum).matches();
	}
	
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
	
	public static String userPrompt(String prompt, Scanner userInput) {
		while (true) {
			System.out.print(prompt);
			try {
				// Loans can be rather large numbers, and floats start to display as
				// scientific notation after nine digits. Easier to let the caller
				// handle type casting, but we can still check to see if it is a number
				String userResponse = userInput.nextLine();
				if (isNumeric(userResponse)) {
					return userResponse;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				System.out.println("Error! Invalid numeric value. Try again.");
			}
		}
	}
	
	public static float interestCalc(int loanAmt, float interestRate) {
		return loanAmt * (interestRate / 100f);
	}

	public static void main(String[] args) {

		System.out.println("Interest Calculator");
		NumberFormat currFormatter = NumberFormat.getCurrencyInstance();
		
		try (Scanner userInput = new Scanner(System.in)) {

			String userCont = "";
			do {
				System.out.println();
				int loanAmt = Integer.valueOf(userPrompt("Enter loan amount:\t", userInput));
				float interestRate = Float.valueOf(userPrompt("Enter interest rate:\t", userInput));
				float interest = interestCalc(loanAmt, interestRate);
				System.out.println("Loan amount:\t\t" + currFormatter.format(loanAmt));
				System.out.println("Interest rate:\t\t" + fmt(interestRate) + "%");
				System.out.println("Interest:\t\t" + currFormatter.format(interest));
				
				System.out.print("\nContinue? (y/n): ");
				userCont = userInput.nextLine();
			} while (userCont.equals("y"));
			
		}
		
		System.out.println("\nThanks for showing interest");

	}

}
