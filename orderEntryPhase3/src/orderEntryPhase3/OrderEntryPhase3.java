//Caleb Barbee CIS406 Course Project Phase 3 Lab
package orderEntryPhase3;

import java.util.*;

public class OrderEntryPhase3 {

	private static List<String> ultimateStringTabber(List<String> stringList, boolean makeBars) {

		// Optional decorative bars
		if (makeBars) {
			for (int i = 0; i < stringList.size(); i++) {
				stringList.set(i, "| " + stringList.get(i));
			}
		}
		
		// The tab size in my console is 8 characters
		int tabSize = 8;
		int maxSize = 0;
		
		// Find the length of the longest string in the list
		for (String string : stringList) {
			if (string.length() > maxSize) {
				maxSize = string.length();
			}
		}
		// Find the number of tabs needed to reach that length
		int tabLength = maxSize / tabSize;
		for (int i = 0; i < stringList.size(); i++) {
			String currString = stringList.get(i);
			int tabDiff = tabLength - (currString.length() / tabSize);
			for (int x = 0; x < Math.max(0, tabDiff); x++) {
				// Tab string up to the block the longest one is in
				currString += "\t";
			}
			// Add one more tab so everything aligns
			currString += "\t";
			stringList.set(i, currString);
		}
		
		return stringList;
		
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

		System.out.println("Order Entry (phase 3)\n");
		
		try (Scanner userInput = new Scanner(System.in)) {
			
			// Declare all input lists and add headers
			List<String> itemNumList = new ArrayList<>() {{
				add("Item Number"); // Main Header
				add("-----------"); // Decorative header line
			}};
			List<String> itemDescList = new ArrayList<>() {{
				add("Item Description");
				add("----------------");
			}};
			List<String> itemPriceList = new ArrayList<>() {{
				add("Item Price");
				add("----------");
			}};
			List<String> itemQuantityList = new ArrayList<>() {{
				add("Quantity");
				add("--------");
			}};
			List<String> itemTaxPercentList = new ArrayList<>() {{
				add("Tax %");
				add("-----");
			}};
			List<String> itemDiscPercentList = new ArrayList<>() {{
				add("Discount %");
				add("----------");
			}};
			
			// Get all user input
			String userCont = "";
			do {
				// All values use nextLine for it's blocking feature
				// Refer to stackoverflow.com/questions/13102045 for why blocking becomes problematic with nextInt or similar
				System.out.print("Enter the item number: ");
				itemNumList.add(userInput.nextLine());
				System.out.print("Enter item description: ");
				itemDescList.add(userInput.nextLine());
				System.out.print("Enter item price: ");
				itemPriceList.add(userInput.nextLine());
				System.out.print("Enter quantity ordered: ");
				itemQuantityList.add(userInput.nextLine());
				System.out.print("Enter tax percentage: ");
				itemTaxPercentList.add(userInput.nextLine());
				System.out.print("Enter the discount percent: ");
				itemDiscPercentList.add(userInput.nextLine());
				
				System.out.print("\nMore items? (y/n): ");
				userCont = userInput.nextLine();
			} while (userCont.equals("y"));
			
			// Declare all calculated lists
			List<String> itemGrossList = new ArrayList<>() {{
				add("Gross Amt"); // Main Header
				add("-------"); // Decorative header line
			}};
			List<String> itemTaxAmtList = new ArrayList<>() {{
				add("Tax Amt");
				add("-------");
			}};
			List<String> itemDiscAmtList = new ArrayList<>() {{
				add("Discount Amt");
				add("------------");
			}};
			List<String> itemNetAmtList = new ArrayList<>() {{
				add("Net Amt");
				add("-------");
			}};
			
			// Init totals variables
			float totalGross = 0;
			float totalTax = 0;
			float totalDisc = 0;
			float totalNet = 0;
			
			// Calculate everything, round floats after we're done with them
			// Follows general pattern of:
				// Calculate variable
				// Add variable to total
				// Format input variable now that precision is no longer needed
				// Add variable to appropriate column list
			// Because we're using working variables, we can go ahead and format as we add to column list
			// without losing any precision
			for (int i = 2; i < itemNumList.size(); i++) {
				float currGross = Integer.valueOf(itemQuantityList.get(i)) * Float.valueOf(itemPriceList.get(i));
				totalGross += currGross;
				itemPriceList.set(i, "$" + fmt(Float.valueOf(itemPriceList.get(i))));
				itemGrossList.add("$" + fmt(currGross)); 
				float currTaxAmt = currGross * Float.valueOf(itemTaxPercentList.get(i)) / 100f;
				totalTax += currTaxAmt;
				itemTaxPercentList.set(i, fmt(Float.valueOf(itemTaxPercentList.get(i))));
				itemTaxAmtList.add("$" + fmt(currTaxAmt));
				float currDiscAmt = (currGross + currTaxAmt) * Float.valueOf(itemDiscPercentList.get(i)) / 100f;
				totalDisc += currDiscAmt;
				itemDiscPercentList.set(i, fmt(Float.valueOf(itemDiscPercentList.get(i))));
				itemDiscAmtList.add("$" + fmt(currDiscAmt));
				float currNetAmt = currGross + currTaxAmt - currDiscAmt;
				totalNet += currNetAmt;
				itemNetAmtList.add("$" + fmt(currNetAmt));
			}
			
			// Add the totals line
			itemNumList.add("Totals");
			itemDescList.add(
					// Using itemPriceList because it doesn't have a totals row yet, and all columns should have an equal number on entries (2 header / n input)
					"# items = " + String.valueOf(itemPriceList.size() - 2)
					);
			itemPriceList.add("");
			itemQuantityList.add("");
			itemGrossList.add("$" + fmt(totalGross));
			itemTaxPercentList.add("");
			itemTaxAmtList.add("$" + fmt(totalTax));
			itemDiscPercentList.add("");
			itemDiscAmtList.add("$" + fmt(totalDisc));
			itemNetAmtList.add("$" + fmt(totalNet));
			
			// allList will contain every list, tabbed
			List<List<String>> allList = new ArrayList<>() {{
				// Function yoinked from previous experimentation
				// Second argument is for adding a decorative bar at the start - not required for this project
				add(ultimateStringTabber(itemNumList,false));
				add(ultimateStringTabber(itemDescList,false));
				add(ultimateStringTabber(itemPriceList,false));
				add(ultimateStringTabber(itemQuantityList,false));
				add(ultimateStringTabber(itemGrossList,false));
				add(ultimateStringTabber(itemTaxPercentList,false));
				add(ultimateStringTabber(itemTaxAmtList,false));
				add(ultimateStringTabber(itemDiscPercentList,false));
				add(ultimateStringTabber(itemDiscAmtList,false));
				add(ultimateStringTabber(itemNetAmtList,false));
			}};
			
			// There are 10 columns and n number of rows to print
			// The totals row has a gap, so it will not be printed at the same time as everything else (hence the -1)
			for (int row = 0; row < itemNumList.size() - 1; row++) {
				// For every row
				for (int col = 0; col < allList.size(); col++) {
					// Print every column in that row
					System.out.print(allList.get(col).get(row));
				}
				// And head to the next row
				System.out.print("\n");
			}
			System.out.println(); // Totals row gap
			int finalRow = itemNumList.size() - 1;
			for (int col = 0; col < allList.size(); col++) {
				// This only works because of the manual process of adding an empty string to every column before auto-tabbing
				System.out.print(allList.get(col).get(finalRow));
			}
			
		}
		
	}

}
