//Caleb Barbee CIS406 Course Project Phase 1 Lab

package orderEntryPhase1;

public class OrderEntryPhase1 {

	public static void main(String[] args) {
		//Init user input variables
		int itemNum=0, itemQuantity=0;
		String itemDesc="";
		float itemPrice=0, totTax=0, totDisc=0;
		
		try {
			//Attempt to assign user input
			itemNum = Integer.valueOf(args[0]);
			itemDesc = args[1];
			itemPrice = Float.valueOf(args[2]);
			itemQuantity = Integer.valueOf(args[3]);
			totTax = Float.valueOf(args[4]);
			totDisc = Float.valueOf(args[5]);
		}
		catch(Exception e) {
			//Throw an error if anything fails
			System.out.println("Arguments do not match required format. Format is as follows:");
			System.out.println("Item Number - integer");
			System.out.println("Item Description - alphanumeric");
			System.out.println("Item Price - decimal (numbers only)");
			System.out.println("Item Quantity - integer");
			System.out.println("Total Tax - decimal (numbers only)");
			System.out.println("Total Discount - decimal (numbers only)");
			System.out.println("Please correct program arguments and re-run.");
		}
		finally {
			//Calculate and print all inputs and the net cost
			float netCost = 0;
			netCost = itemPrice * itemQuantity + totTax - totDisc;
			System.out.println("Item Number: " + itemNum);
			System.out.println("Item Description: " + itemDesc);
			System.out.println("Item Price: $" + itemPrice);
			System.out.println("Item Quantity: "+ itemQuantity);
			System.out.println("Total Tax: $" + totTax);
			System.out.println("Total Discount: $" + totDisc);
			System.out.println("Net Cost: $" + netCost);
		}
	}

}
