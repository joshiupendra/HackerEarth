package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * Jump Game 2
You are given an array arr. You start from index 0, and the element at each index denotes the maximum distance you can jump from that index. 
For instance, in the following example:
3 1 2 1 7
If you start from index 0, the element at arr[0], ie 3, indicates that the maximum index you can jump to is 3.
Return the minimum number of jumps requires to reach the end of the array.

Input:
n - the size of arr
arr - the array itself

Output:
The minumum number of jumps required to reach the last element.

Constraints:
1 <= arr.length <= 1000
1 <= arr[i] <= 1000

SampleInput
5
1 2 5 6 7

Sample Output
3
*/

public class JumpGame2 {
	// Asked in Apple, Amazon, TCS Interviews
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

         int out_ = no_of_jumps(n, arr);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    
    static int no_of_jumps(int n, int[] arr){
        int target = n-1;
        int jumps = 0;

        while (target != 0) {
            for (int i=0; i<target; i++) {
                if ((i + arr[i]) >= target) {
                    target = i;
                    break;
                }
            }
            jumps++;
        }

        return jumps;    
    }
}
