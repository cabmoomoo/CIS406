//Caleb Barbee CIS406 Course Project Phase 2 Lab
package orderEntryPhase2;

import java.util.*;

public class OrderEntryPhase2 {
	
	private static List<String> stringTabber(String string1, String string2) {
		
		int tabSize = 8; // Tab spaces are 8 characters long (in my console, at the moment)
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
		string1 += "\t";
		string2 += "\t";
		
		// You can only return one value/object from a function, so a list or similar is required to effectively return multiple values
		List<String> finalList = new ArrayList<String>();
		finalList.add(string1);
		finalList.add(string2);
		return finalList;
		
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
			
			// Automatically add tabs based on lengths of the strings
			// Easier to pass two strings directly than put the strings into a list and pass that
			// Adding the vertical bar could be done cleaner in the function
			List<String> itemNumList = stringTabber("Item Number", itemNum);
			List<String> itemDescList = stringTabber("| Item Description", "| " + itemDesc);
			List<String> itemPriceList = stringTabber("| Item Price", "| " + String.format("%.2f", itemPrice));
			List<String> itemQuantList = stringTabber("| Quantity Ordered", "| " + String.valueOf(itemQuantity));
			List<String> itemGrossList = stringTabber("| Item Gross Amount", "| " + String.format("%.2f", itemGross));
			List<String> itemTaxPercList = stringTabber("| Tax Percent", "| " + String.format("%.2f", itemTaxPercent));
			List<String> itemTaxAmtList = stringTabber("| Tax Amount", "| " + String.format("%.2f", itemTaxAmt));
			List<String> itemDiscPercList = stringTabber("| Discount Percent", "| " + String.format("%.2f", itemDiscPercent));
			List<String> itemDiscAmtList = stringTabber("| Discount Amount", "| " + String.format("%.2f", itemDiscAmt));
			List<String> itemNetList = stringTabber("| Net Amount", "| " + String.format("%.2f", itemNetAmt));
			
			// The next best thing would be to put all of the lists into a list to generate this print statement automatically, but this works for now
			System.out.println(itemNumList.get(0)+itemDescList.get(0)+itemPriceList.get(0)+itemQuantList.get(0)+itemGrossList.get(0)+itemTaxPercList.get(0)+itemTaxAmtList.get(0)+itemDiscPercList.get(0)+itemDiscAmtList.get(0)+itemNetList.get(0));
			System.out.println(itemNumList.get(1)+itemDescList.get(1)+itemPriceList.get(1)+itemQuantList.get(1)+itemGrossList.get(1)+itemTaxPercList.get(1)+itemTaxAmtList.get(1)+itemDiscPercList.get(1)+itemDiscAmtList.get(1)+itemNetList.get(1));
		}

	}

}
