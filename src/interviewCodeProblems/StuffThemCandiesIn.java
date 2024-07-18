package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * Stuff Them Candies In!
You are given an array candies, where candies[i] defines how many candies the i-th kid has. 
You are also given an integer, extra_candies, which can be distributed among the kids.
For each kid, check if there is a way to distribute extra_candies such that that kid has the maximum number of candies. 
Multiple kids can have maximum candies.

Input:
n - The number of elements in the candies array
candies -The array itself
extra_candies - An integer containing the number of extra candies

Output:
An array of 1s and 0s, where 1 denotes that the kid can have the maximum number of candies, and 0 denotes that the kid cannot.

Constraints:
2 <= candies.length <= 100
1 <= candies[i] <= 100
1 <= extra_candies <= 50

Sample Input:
5
2 3 5 1 3
3

Sample Output:
1 1 1 0 1
 */

public class StuffThemCandiesIn {
	// Asked in Adobe
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         String[] arr_candies = br.readLine().split(" ");
         int[] candies = new int[n];
         for(int i_candies = 0; i_candies < arr_candies.length; i_candies++)
         {
         	candies[i_candies] = Integer.parseInt(arr_candies[i_candies]);
         }
         int extra_candies = Integer.parseInt(br.readLine().trim());

         int[] out_ = extra_candy(n, candies, extra_candies);
         System.out.print(out_[0]);
         for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
	
    static int[] extra_candy(int n, int[] candies, int extra_candies){
        int[] result = new int[n];
        int max = 0;
        
        for (int i=0; i<n; i++) {
        	max = (max > candies[i]) ? max : candies[i];
        }
        
        for (int i=0; i<n; i++) {
        	result[i] = (max-candies[i]) <= extra_candies ? 1 : 0;
        }

        return result;
    }
}
