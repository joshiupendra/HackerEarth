package inputOutput;

import java.util.Scanner;

public class PalindromicString {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String str = s.nextLine();
		int i = 0;
		int j = str.length() - 1;
		boolean isPalindrom = true;
		
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				isPalindrom = false;
				break;
			}
			i++;
			j--;
		}
		
		String result = (isPalindrom)? "YES" : "NO";
		System.out.println(result);
		

	}

}
