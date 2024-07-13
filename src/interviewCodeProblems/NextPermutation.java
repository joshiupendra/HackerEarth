package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * Next Permutation
You are given an array arr consisting of digits, for instance,
[1, 2, 3, 4]
This array represents the number 1234 (One Thousand Two Hundred and Thirty Four).
Find the next greatest number that can be formed using these digits. Update the array in-place.
In this case, the result will be
[1, 2, 4, 3] (One Thousand Two Hundred and Forty Three)
If the number is already at it's greatest possible value, return the least value instead.
Ex. For an input of
[4, 3, 2, 1]
the output must be
[1, 2, 3, 4] 

Input:
n - the size of the array
arr - the array itself

Output:
An array consisting the next greatest number.

Constraints:
1 <= n <= 100
0 <= arr[i] <= 9

Sample Input
4
1 2 3 4

Sample Output
1 2 4 3
*/

public class NextPermutation {
	// Asked in Apple, Amazon, Microsoft, Facebook, Bloomberg, Goldman Sachs Interviews
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

         int[] out_ = next_permutation(n, arr);
         System.out.print(out_[0]);
         for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
	
    static int[] next_permutation(int n, int[] arr){
        int pivot = -1;

        for (int i=n-1; i>0; i--) {
            if (arr[i] > arr[i-1]) {
                pivot = i-1;
                break;
            }
        }

        if (pivot != -1) {
            int max = 10000;
            int max_pos = -1;

            for (int i=pivot+1; i<n; i++) {
                if (arr[i] > arr[pivot] && arr[i] < max) {
                    max_pos = i;
                    max = arr[i];
                }
            }
            int temp = arr[pivot];
            arr[pivot] = arr[max_pos];
            arr[max_pos] = temp;

        }

        int i = pivot + 1;

        while (i < (pivot+1) + ((n-(pivot+1))/2) ) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - (i - (pivot+1))];
            arr[n - 1 - (i - (pivot+1))] = temp;
            i++;
        }

        return arr;   
    }
}
