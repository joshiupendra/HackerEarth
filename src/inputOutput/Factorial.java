package inputOutput;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
        long result = 1;
        for (int i=1; i<=N; i++) {
            result *= i;
        }

        System.out.println(result);
	}

}
