//Caleb Barbee CIS406 Course Project Phase 2 Lab
package orderEntryPhase2;

import java.util.*;

public class OrderEntryPhase2 {
	
	private static List<String> stringTabber(String string1, String string2) {
		
		// Tab spaces are 8 characters long (in my console, at the moment)
		int tabSize = 8; 
		
		// Some quick beautification
		string1 = "| " + string1;
		string2 = "| " + string2;
		
		// Find the shorter one and bring it up to par
		if (string1.length() > string2.length()) {
			int tabLength = string1.length() / tabSize;
			int tabDiff = tabLength - (string2.length() / tabSize);
			for (int i = 0; i < Math.max(0, tabDiff); i++) {
				string2 += "\t";
			}
		} else {
			int tabLength = string2.length() / tabSize;
			int tabDiff = tabLength - (string1.length() / tabSize);
			for (int i = 0; i < Math.max(0, tabDiff); i++) {
				string1 += "\t";
			}
		}
		
		//Add the extra space that makes everything line up
		string1 += "\t";
		string2 += "\t";
		
		// You can only return one value/object from a function, so a list or similar is required to effectively return multiple values
		List<String> finalList = new ArrayList<String>();
		finalList.add(string1);
		finalList.add(string2);
		return finalList;
		
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

	public static void main(String[] args) {

		System.out.println("Order Entry (phase 2)\n");
		
		//Everything wrapped in the scanner try for *I think* memory safety
		try (Scanner userInput = new Scanner(System.in)) {
			
			// Get the user input
			System.out.print("Enter the item number: ");
			String itemNum = userInput.nextLine();
			System.out.print("Enter item description: ");
			String itemDesc = userInput.nextLine();
			System.out.print("Enter item price: ");
			float itemPrice = userInput.nextFloat();
			System.out.print("Enter quantity ordered: ");
			int itemQuantity = userInput.nextInt();
			System.out.print("Enter tax percentage: ");
			float itemTaxPercent = userInput.nextFloat();
			System.out.print("Enter the discount percent: ");
			float itemDiscPercent = userInput.nextFloat();
			
			// Make the calculations
			float itemGross = itemPrice * itemQuantity;
			float itemTaxAmt = itemGross * itemTaxPercent;
			float itemDiscAmt = itemGross * itemDiscPercent;
			float itemNetAmt = itemGross + itemTaxAmt - itemDiscAmt;
			
			// Add tabbed label/value pairs to the display list
			List<List<String>> allLists = new ArrayList<>();
			allLists.add(stringTabber("Item Number", itemNum));
			allLists.add(stringTabber("Item Description", itemDesc));
			allLists.add(stringTabber("Item Price", "$" + String.format("%.2f", itemPrice)));
			allLists.add(stringTabber("Quantity Ordered", String.valueOf(itemQuantity)));
			allLists.add(stringTabber("Item Gross Amount", "$" + String.format("%.2f", itemGross)));
			allLists.add(stringTabber("Tax Percent", fmt(itemTaxPercent*100f) + "%"));
			allLists.add(stringTabber("Tax Amount", "$" + String.format("%.2f", itemTaxAmt)));
			allLists.add(stringTabber("Discount Percent", fmt(itemDiscPercent*100f) + "%"));
			allLists.add(stringTabber("Discount Amount", "$" + String.format("%.2f", itemDiscAmt)));
			allLists.add(stringTabber("Net Amount", "$" + String.format("%.2f", itemNetAmt)));
			
			for (List list : allLists) {
				// Print all the labels
				System.out.print(list.get(0));
			}
			System.out.print("\n");
			for (List list : allLists) {
				// Print all the values
				System.out.print(list.get(1));
			}
			
		}

	}

}
