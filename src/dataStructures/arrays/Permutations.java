package dataStructures.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import javax.sql.rowset.spi.SyncResolver;

public class Permutations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		solve(1, sc);

		sc.close();
	}
	
	// Using approach from Submission
	// Within Time Limit 
	public static void solve(int testNumber, Scanner sc) {
        int n = sc.nextInt();
        int q = sc.nextInt();
        int ar[] = new int[n];
        for (int i=0; i<n; i++) {
			ar[i] = sc.nextInt();
		}
        int prefixMax[] = new int[n + 1];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(ar[i - 1], prefixMax[i - 1]);
        }
        int suffMax[] = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffMax[i] = Math.max(ar[i], suffMax[i + 1]);
        }
        while (q > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int max = 0;
            max = Math.max(max, prefixMax[l - 1]);
            max = Math.max(max, suffMax[r]);
            System.out.println(max);
            q--;
        }
    }
	
	// Using Java 8 IntStream
	// Time limit exceeded.
	public static void solve(Scanner sc) {
		int N = sc.nextInt();
		int queries = sc.nextInt();
		sc.nextLine();
		List<Integer> array1 = new ArrayList<>(); 
		
		for (int i=0; i<N; i++) {
			array1.add(sc.nextInt());
		}
		
		while (queries > 0) {
			sc.nextLine();
			int l = sc.nextInt() - 1;
			int r = sc.nextInt() - 1;
			
			int max = IntStream.range(0, array1.size()).parallel().filter(i -> i < l || i > r).mapToObj(array1::get).max(Integer::compare).get();
		
			System.out.println(max);
			queries--;
		}
	}

}
