package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * Sort It Up

You are given an array arr, consisting of only zeroes, ones and twos.
Sort the same array in-place and return it. Do not create a new array.

Input:
n - the size of arr
arr - the array itself

Output:
A sorted array

Constraints:
1 <= n <= 100
0 <= arr[i] <= 2

Sample Input
5
2 0 1 0 2

Sample Output
0 0 1 2 2
 * 
 */

public class SortItIp {
	// Asked in Microsoft, Facebook Interviews
	
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

         int[] out_ = sort_it_up(n, arr);
         System.out.print(out_[0]);
         for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }

    static int[] sort_it_up(int n, int[] arr){
        int l_bound = 0;
        int r_bound = n-1;
        int i = 0;

        while (i <= r_bound) {
            if (arr[i] == 2) {
                arr[i] = arr[r_bound];
                arr[r_bound] = 2;
                r_bound--;
            } else if (arr[i] == 1) {
                i++;
            } else {
                arr[i] = arr[l_bound];
                arr[l_bound] = 0;
                l_bound++;
                i++;
            }
        }

        return arr;   
    }
}
