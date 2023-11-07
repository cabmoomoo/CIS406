//Caleb Barbee CIS406 Grade Converter Lab
package gradeConverter;

import java.util.*;

public class GradeConverter {

	public static void main(String[] args) {
		
		System.out.println("Letter Grade Converter\n");
		
		try (Scanner userInput = new Scanner(System.in)) {
			
			String userCont = "";
			do {
				System.out.print("Enter numerical grade: ");
				int numGrade = userInput.nextInt();
				switch (numGrade / 10) {
					case 10:
					case 9:
						System.out.println("Letter Grade: A");
						break;
					case 8:
						System.out.println("Letter grade: B");
						break;
					case 7:
						System.out.println("Letter grade: C");
						break;
					case 6:
						System.out.println("Letter grade: D");
						break;
					default:
						System.out.println("Letter grade: F");
				}
				System.out.print("Continue? (y/n): ");
				userCont = userInput.next();
			} while (userCont.equals("y"));
			
			System.out.println("Program concluded.");
		}
		

	}

}
