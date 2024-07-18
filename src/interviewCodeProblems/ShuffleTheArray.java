package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * Shuffle the Array!
You are given an array nums consisting if 2n elements in the form [x1,x2,x3...xn,y1,y2,y3...yn].
Return an array in the form [x1,y1,x2,y2,x3,y3...,xn,yn].

Input:
n -  Half the size of the array arr
arr - The array itself

Output:
An array of the form [x1,y1,x2,y2,x3,y3...,xn,yn]

Constraints:
1 <= n <= 500
nums.length = 2n
1 <= nums[i] <= 1000

Sample Input:
3
2 5 1 3 4 7

Sample Output:
2 3 5 4 1 7
 */

public class ShuffleTheArray {
	// Asked in Apple, Bloomberg
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         String[] arr_arr = br.readLine().split(" ");
         int[] arr = new int[2*n];
         for(int i_arr = 0; i_arr < arr_arr.length; i_arr++)
         {
         	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
         }

         int[] out_ = shuffle(n, arr);
         System.out.print(out_[0]);
         for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
	
    static int[] shuffle(int n, int[] arr){
        int[] result = new int[n*2];
        int j = 0;
        
        for (int i=0; i<n; i++) {
        	result[j] = arr[i];
        	j += 1;
        	result[j] = arr[i+n];
        	j += 1;
        }

        return result;
    }
}
