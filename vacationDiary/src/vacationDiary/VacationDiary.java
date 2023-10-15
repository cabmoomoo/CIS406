//Caleb Barbee CIS406 Vacation Diary Lab
package vacationDiary;

public class VacationDiary {

	public static void main(String[] args) {
		System.out.println("Vacation Diary\n");
		
		System.out.println("Enter Date Vaction Started (mm/dd/yyyy): " + args[0]);
		System.out.println("Enter City Visited: " + args[1]);
		System.out.println("Enter Country Visited: " + args[2]);
		System.out.println("Enter number of days: " + args[3]);
		System.out.println("Enter Mode of Travel (car, airplane, ship, train, bus): " + args[4]);
		System.out.println("");
		
		System.out.println("Details of your trip:");
		System.out.println("Date: " + args[0]);
		System.out.println("City: " + args[1]);
		System.out.println("Country: " + args[2]);
		System.out.println("Number of Days: " + args[3]);
		System.out.println("Traveled By: " + args[4]);
		System.out.println("Bye!!!");
	}

}
