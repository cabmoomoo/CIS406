//Caleb Barbee CIS406 Course Project Phase 4 Lab
package orderEntryPhase4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Turns out, I don't need to do complicated formatting myself...
import java.text.NumberFormat;

public class OrderEntryPhase4 {

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

	public static void main(String[] args) {

		System.out.println("Order Entry (phase 4)\n");
		// Addition of the built in java number formatting functions
		NumberFormat currFormatter = NumberFormat.getCurrencyInstance();
		NumberFormat percFormatter = NumberFormat.getPercentInstance();
		
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
			// Customer info lines
			List<String> custNameList = new ArrayList<>() {{
				add("Customer Name");
				add("-------------");
			}};
			List<String> custStreetList = new ArrayList<>() {{
				add("Customer Street");
				add("---------------");
			}};
			List<String> custCityList = new ArrayList<>() {{
				add("Customer City");
				add("-------------");
			}};
			List<String> custStateList = new ArrayList<>() {{
				add("Customer State");
				add("--------------");
			}};
			List<String> custZipList = new ArrayList<>() {{
				add("Customer Zip Code");
				add("-----------------");
			}};
			
			// Get all user input
			// All values use nextLine as nextInt/similar does not include the newline character
			// This because an issue when I do *need* to use nextLine, and it just finishes the same line as the last number
			// Credit to stackoverflow.com/questions/13102045
			System.out.print("Enter Invoice Date (MM/DD/YYYY): ");
			String invoiceDate = userInput.nextLine();
			System.out.print("Enter customer name: ");
			custNameList.add(userInput.nextLine());
			System.out.print("Enter customer street address: ");
			custStreetList.add(userInput.nextLine());
			System.out.print("Enter customer city: ");
			custCityList.add(userInput.nextLine());
			System.out.print("Enter customer state: ");
			custStateList.add(userInput.nextLine());
			System.out.print("Enter customer zip code (5 digits): ");
			custZipList.add(userInput.nextLine());
			System.out.println();
			// Repeating user input for item list
			String userCont = "";
			do {
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
				itemPriceList.set(i, currFormatter.format(Float.valueOf(itemPriceList.get(i))));
				itemGrossList.add(currFormatter.format(Float.valueOf(currGross))); 
				float currTaxAmt = currGross * Float.valueOf(itemTaxPercentList.get(i)) / 100f;
				totalTax += currTaxAmt;
				itemTaxPercentList.set(i, percFormatter.format(Float.valueOf(itemTaxPercentList.get(i)) / 100f));
				itemTaxAmtList.add(currFormatter.format(Float.valueOf(currTaxAmt)));
				float currDiscAmt = (currGross + currTaxAmt) * Float.valueOf(itemDiscPercentList.get(i)) / 100f;
				totalDisc += currDiscAmt;
				itemDiscPercentList.set(i, percFormatter.format(Float.valueOf(itemDiscPercentList.get(i)) / 100f));
				itemDiscAmtList.add(currFormatter.format(Float.valueOf(currDiscAmt)));
				float currNetAmt = currGross + currTaxAmt - currDiscAmt;
				totalNet += currNetAmt;
				itemNetAmtList.add(currFormatter.format(Float.valueOf(currNetAmt)));
			}
			
			// Add the totals line
			itemNumList.add("Totals");
			itemDescList.add(
					// Using itemPriceList because it doesn't have a totals row yet, and all columns should have an equal number on entries (2 header / n input)
					"# items = " + String.valueOf(itemPriceList.size() - 2)
					);
			itemPriceList.add("");
			itemQuantityList.add("");
			itemGrossList.add(currFormatter.format(totalGross));
			itemTaxPercentList.add("");
			itemTaxAmtList.add(currFormatter.format(totalTax));
			itemDiscPercentList.add("");
			itemDiscAmtList.add(currFormatter.format(totalDisc));
			itemNetAmtList.add(currFormatter.format(totalNet));
			
			// custList will contain all customer information, tabbed
			// Customer info and item info handled separately as these do not need to be
			// tab-aligned with each other - they're treated as separate tables
			List<List<String>> custList = new ArrayList<>() {{
				add(ultimateStringTabber(custNameList,false));
				add(ultimateStringTabber(custStreetList,false));
				add(ultimateStringTabber(custCityList,false));
				add(ultimateStringTabber(custStateList,false));
				add(ultimateStringTabber(custZipList,false));
			}};
			
			// itemList will contain all item information, tabbed
			List<List<String>> itemList = new ArrayList<>() {{
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
			
			// Simple input regurgitation
			System.out.println();
			System.out.println("Invoice Date: " + invoiceDate);
			System.out.println();
			
			// Customer table is only 5c*3r, but the easiest method to print all that
			// aligned is the same way we print n-length tables
			for (int row = 0; row < custNameList.size(); row++) {
				for (int col = 0; col < custList.size(); col++) {
					System.out.print(custList.get(col).get(row));
				}
				System.out.print("\n");
			}
			System.out.println(); // Gap between tables
			// Item table will be 10c*nr, making the only feasible method variable-capped loop
			for (int row = 0; row < itemNumList.size() - 1; row++) {
				for (int col = 0; col < itemList.size(); col++) {
					System.out.print(itemList.get(col).get(row));
				}
				System.out.print("\n");
			}
			System.out.println(); // Totals row gap
			// Totals row is tab-aligned with items table, but the gap and known row limit
			// means it's simpler to print separate
			int finalRow = itemNumList.size() - 1;
			for (int col = 0; col < itemList.size(); col++) {
				System.out.print(itemList.get(col).get(finalRow));
			}
			
		}

	}

}
