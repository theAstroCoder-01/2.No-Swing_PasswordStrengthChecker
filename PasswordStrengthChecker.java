package PasswordStrengthChecker;

import java.util.Scanner;

public class PasswordStrengthChecker {

	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);
		
		System.out.println("Input a password: ");
		String password = input.nextLine();
		input.close();
		
		String strengthFeedback = checkPasswordStrength(password);
		System.out.println(strengthFeedback);
		
	}
	
	public static String checkPasswordStrength(String password) {
		
		// Define criteria
		int lengthCriteria = 8;
		boolean hasUpperCase = false;
		boolean hasLowerCase = false;
		boolean hasDigit = false;
		boolean hasSpecial = false;
		String specialCharacters = "!@#$%^&*()_-+=<>?";
		
		//Check length
		if(password.length() >= lengthCriteria) {
			
			//Check other criteria
			for(char c : password.toCharArray()) {
				if(Character.isUpperCase(c)) {
					hasUpperCase = true;
				} else if (Character.isLowerCase(c)) {
					hasLowerCase = true;
				} else if (Character.isDigit(c)) {
					hasDigit = true;
				} else if (specialCharacters.contains(String.valueOf(c))) {
					hasSpecial = true;
				}
			}
			
			//Analyze password strength
			if(hasUpperCase & hasLowerCase & hasDigit & hasSpecial) {
				return "It is strong password!";
			} else {
				return "The password is weak. Include more characters in the password";
			}
			
		} else {
			return "Password length must be at least " + lengthCriteria + " characters!";
			
		}
	}
}
