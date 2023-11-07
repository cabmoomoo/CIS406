//Caleb Barbee CIS406 Powers Table Lab
package powersTable;

import java.util.*;

public class PowersTable {

	public static void main(String[] args) {
		
		System.out.println("Squares and Cubes Table");
		
		try (Scanner userInput = new Scanner(System.in)) {

			String userCont = "";
			do {
				String allString = "\nNumber\tSquared\tCubed\n";
				allString += "======\t=======\t=====\n";
				System.out.print("\nEnter an integer: ");
				int userNum = userInput.nextInt();
				for (int i = 1; i <= userNum; i++) {
					allString += String.valueOf(i) + "\t";
					allString += String.valueOf(i * i) + "\t";
					allString += String.valueOf(i * i * i) + "\n";
				}
				System.out.println(allString);
				
				System.out.print("Continue? (y/n): ");
				userCont = userInput.next();
			} while (userCont.equalsIgnoreCase("n") != true);
			
			System.out.println("\nAll numbers have been empowered.");
			
		}

	}

}
