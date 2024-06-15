package inputOutput;

import java.util.Scanner;

public class AliAndInnocentPeople {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String tag = s.nextLine();
		String vowels = "AEIOUY";
		boolean isValid = true;
		
		for (int i=0; i<tag.length()-1; i++) {
			System.out.println(Character.isDigit(tag.charAt(i)) + " " + Character.isDigit(tag.charAt(i+1)) + " " + (Character.getNumericValue(tag.charAt(i)) + Character.getNumericValue(tag.charAt(i+1)))%2);
			if (Character.isDigit(tag.charAt(i)) && Character.isDigit(tag.charAt(i+1)) && (Character.getNumericValue(tag.charAt(i)) + Character.getNumericValue(tag.charAt(i+1)))%2 != 0) {
				isValid = false;
				break;
			}
			if (Character.isAlphabetic(tag.charAt(i)) && vowels.contains(String.valueOf(tag.charAt(i)))) {
				isValid = false;
				break;
			}
		}
		
		String result = (isValid)? "valid" : "invalid";
		
		System.out.println(result);
	}

}
