//Caleb Barbee CIS406 Vacation Diary Part 2 Lab
package vacationDiaryPart2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class VacationDiaryPart2 {
	
	// Regular expressions can make my head spin, but they do their job really well
	private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
	public static boolean isNumeric(String strNum) {
		// If the string exists, see if it's numeric
	    if (strNum == null) {
	        return false; 
	    }
	    return pattern.matcher(strNum).matches();
	}
	
	public static String datePrompter(String prompt, Scanner userInput) {
		while (true) {
			System.out.print(prompt);
			try {
				String inputDate = userInput.nextLine();
				if (inputDate.equalsIgnoreCase("end")) {
					// This repeats on error as well because I wouldn't want to be stuck in an input
					// because I mistyped the exit word
					return "end";
				}
				if (!(isNumeric(inputDate))) throw new Exception();
				int month = Integer.valueOf(inputDate.substring(0, 2));
				int day = Integer.valueOf(inputDate.substring(2, 4));
				String year = inputDate.substring(4, 8);
				if (1 > month || month > 12 || 1 > day || day > 31 || year.length() != 4) {
					throw new Exception();
				}
				return inputDate.substring(0, 2) + "/" + inputDate.substring(2, 4) + "/" + year;
			} catch (Exception e) {
				System.out.println("Invalid data format. Please re-enter");
			}
		}
	}
	
	public static String placePrompter(String prompt, Scanner userInput) {
		while (true) {
			System.out.print(prompt);
			try {
				String input = userInput.nextLine();
				if (input.length() > 15) {
					return input.substring(0, 15);
				} else {
					while (input.length() < 15) {
						input += " ";
					}
					return input;
				}
			} catch (Exception e) {
				// Not really much that can go wrong, program-wise - this error message will likely never be seen
				System.out.println("Invalid entry. Please re-enter");
			}
		}
	}
	
	public static int daysPrompter(String prompt, Scanner userInput) {
		while (true) {
			System.out.print(prompt);
			try {
				int days = Integer.valueOf(userInput.nextLine());
				if (days < 1 || days > 30) {
					throw new Exception();
				}
				return days;
			} catch (Exception e) {
				System.out.println("Days must be between 1 and 30");
			}
		}
	}
	
	public static String modePrompter(String prompt, Scanner userInput) {
		List<String> modeList = new ArrayList<>() {{
			add("car");
			add("plane");
			add("ship");
			add("train");
			add("bus");
		}};
		while (true) {
			System.out.print(prompt);
			try {
				String mode = userInput.nextLine();
				if (!(modeList.contains(mode))) {
					throw new Exception();
				}
				return mode;
			} catch (Exception e) {
				System.out.println("Please enter a valid travel mode");
			}
		}
	}

	public static void main(String[] args) {
		
		try (Scanner userInput = new Scanner(System.in)) {
			
			// Declare input lists
			List<String> dateList = new ArrayList<>();
			List<String> cityList = new ArrayList<>();
			List<String> countryList = new ArrayList<>();
			List<String> daysList = new ArrayList<>();
			List<String> modeList = new ArrayList<>();
			
			while (true) {
				// Populate input lists
				String date = datePrompter("Enter date vacation started (mmddyyyy) or End to quit: ", userInput);
				if (date.equalsIgnoreCase("end")) {
					break;
				}
				dateList.add(date);
				cityList.add(placePrompter("Enter city visited: ", userInput));
				countryList.add(placePrompter("Enter country visited: ", userInput));
				String days = Integer.toString(daysPrompter("Enter number of days: ", userInput));
				if (days.length() == 1) {
					daysList.add(days + "    "); //four spaces
				} else {
					daysList.add(days + "   "); //three spaces
				}
				modeList.add(modePrompter("Enter mode of travel (car, plane, ship, train, bus): ", userInput));
			}

			// Print the header(s)
			String headers = "============================================================\n"
						   + "====================== Vacation Diary ======================\n"
						   + "Date        City             Country          Days    Mode  \n"
						   + "==========  ===============  ===============  =====   ======";
			System.out.println("\n" + headers);
			
			// Print the user's input
			for (int i = 0; i < cityList.size(); i++) {
				System.out.print(dateList.get(i) + "  ");
				System.out.print(cityList.get(i) + "  ");
				System.out.print(countryList.get(i) + "  ");
				System.out.print(daysList.get(i) + "   ");
				System.out.print(modeList.get(i) + "\n");
			}
			
			// Print a decorative lower line
			System.out.println("============================================================");
			
			// End of the try-with-resources, so the scanner close method is automatically called
		}
		
		System.out.println("\nHope you had fun!");

	}

}
