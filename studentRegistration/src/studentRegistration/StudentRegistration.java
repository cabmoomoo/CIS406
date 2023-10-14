//Caleb Barbee CIS406 Student Registration Lab
package studentRegistration;

public class StudentRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Student Registration Form");
		
		System.out.println("\nEnter first name: " + args[0]);
		System.out.println("Enter last name: " + args[1]);
		System.out.println("Enter year of birth: " + args[2]);
		
		var fullName = args[0] + " " + args[1];
		System.out.println("\nWelcome " + fullName + "!");
		System.out.println("Your registration is complete.");
		var tempPassword = args[1] + "*" + args[2];
		System.out.println("Your temporary password is: " + tempPassword);
	}

}
