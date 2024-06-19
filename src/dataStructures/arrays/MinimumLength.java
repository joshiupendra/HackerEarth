package dataStructures.arrays;

import java.util.Scanner;

public class MinimumLength {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int testCases = s.nextInt();
		
		while (testCases > 0) {
			
			int N = s.nextInt();
			int[] array1 = new int[N];
			int[] array2 = new int[N];
			int k = 2;
			
			for (int i=0; i<N; i++) {
				array1[i] = s.nextInt();
			}
			s.nextLine();
			
			for (int i=0; i<N; i++) {
				array2[i] = s.nextInt();
			}
			
			int firstPosition = -1, secondPosition = -1;
			for (int i=0; i<N; i++) {
				if (array1[i] != array2[i]) {
					if (firstPosition == -1) {
						firstPosition = i;
					} else {
						secondPosition = i;
					}
				}
			}
			
			System.out.println(secondPosition - firstPosition + 1);
			
			testCases--;
		}
	}

}
