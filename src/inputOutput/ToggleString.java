package inputOutput;

import java.util.Scanner;

public class ToggleString {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		String result = "";
		
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				result += String.valueOf(str.charAt(i)).toLowerCase();
			} else {
				result += String.valueOf(str.charAt(i)).toUpperCase();
			}
		}
		
		System.out.println(result);
	}

}
