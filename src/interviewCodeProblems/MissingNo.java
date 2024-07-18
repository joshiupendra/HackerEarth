package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * Missing No!
You are given an integer n, along with an array of n-1 numbers in the range 1 to n, with no duplicates. 
One number is missing from the array. Find that number.

Input:
n - An integer
arr - An array of size n-1

Output:
The single missing number

Constraints:
1 <= n <= 1000
1 <= arr[i] <= n
All elements in arr are unique

Sample Input:
4
4 1 2

Sample Output:
3
 */

public class MissingNo {
	// Asked in Microsoft, Apple, Amazon, FB & Oracle
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         String[] arr_arr = br.readLine().split(" ");
         int[] arr = new int[n];
         for(int i_arr = 0; i_arr < arr_arr.length; i_arr++)
         {
         	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
         }

         int out_ = missing_no(n, arr);
         System.out.println(out_);

         wr.close();
         br.close();
    }
	
    static int missing_no(int n, int[] arr){
        int sum = n * (n+1) / 2;
        int arrSum = 0;
        
        for (int i=0; i<arr.length-1; i++) {
        	arrSum += arr[i];
        }
        
        return sum - arrSum;
    }
}
