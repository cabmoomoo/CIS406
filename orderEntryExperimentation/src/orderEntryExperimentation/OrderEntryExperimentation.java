//Caleb Barbee CIS406 Course Project Phase 2 Lab
package orderEntryExperimentation;

import java.util.*;

public class OrderEntryExperimentation {
	
	private static List<String> ultimateStringTabber(List<String> stringList, boolean makeBars) {

		if (makeBars) {
			for (int i = 0; i < stringList.size(); i++) {
				stringList.set(i, "| " + stringList.get(i));
			}
		}
		
		int tabSize = 8;
		int maxSize = 0;
		
		for (String string : stringList) {
			if (string.length() > maxSize) {
				maxSize = string.length();
			}
		}
		int tabLength = maxSize / tabSize;
		for (int i = 0; i < stringList.size(); i++) {
			String currString = stringList.get(i);
			int tabDiff = tabLength - (currString.length() / tabSize);
			for (int x = 0; x < Math.max(0, tabDiff); x++) {
				currString += "\t";
			}
			currString += "\t";
			stringList.set(i, currString);
		}
		
		return stringList;
		
	}
	
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

		System.out.println("Order Entry Experimentation\n");
		
		//Everything wrapped in the scanner try for *I think* memory safety
		try (Scanner userInput = new Scanner(System.in)) {
			
			Random rand = new Random();
			Dictionary<String,List<String>> columnDict = new Hashtable<>();
			
			List<String> itemList = new ArrayList<>() {{
				add("Pants");
				add("Shirts");
				add("Tables");
			}};
			List<String> quantList = new ArrayList<>() {{
				add("172898546556489456152");
				add("2568");
				add("129");
			}};
			List<String> locList = new ArrayList<>() {{
				add("NC");
				add("NY");
				add("DC");
			}};
			
			columnDict.put("Items", itemList);
			columnDict.put("Quantity", quantList);
			columnDict.put("Location", locList);
			
			// Add tabbed label/value pairs to the display list
			List<List<String>> allLists = new ArrayList<>();
			var columnDictKeys = columnDict.keys();
			for (int i = 0; i < columnDict.size(); i++) {
				String currKey = columnDictKeys.nextElement();
				List<String> currList = new ArrayList<>() {{add(currKey);}};
				List<String> columnDictList = columnDict.get(currKey);
				for (String string : columnDictList) {
					currList.add(string);
				}
				allLists.add(ultimateStringTabber(currList, true));
			}
			
			for (int i = 0; i < allLists.get(0).size(); i++) {
				for (List list : allLists) {
					System.out.print(list.get(i));
				}
				System.out.print("\n");
			}
			
		}

	}

}
