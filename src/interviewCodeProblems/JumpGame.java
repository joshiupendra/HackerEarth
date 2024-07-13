package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * Jump Game
You are given an array arr. You start from index 0, and the element at each index denotes the maximum distance you can jump from that index. 
For instance, in the following example:
3 1 2 1 7
If you start from index 0, the element at arr[0], ie 3, indicates that the maximum index you can jump to is 3.
If it is possible to reach the last index, print 1. If not, print 0.

Input:
n - the size of arr
arr - the array itself

Output:
1 if it is possible to reach the end of the array, 0 if it is not.

Constraints:
1 <= arr.length <= 1000
0 <= arr[i] <= 1000

Sample Input
6
4 1 1 1 0 9

Sample Output
0
 * 
*/
public class JumpGame {

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

         int out_ = can_jump(n, arr);
         System.out.println(out_);

         wr.close();
         br.close();
    }
	
    static int can_jump(int n, int[] arr){
        int max = 0;

        for (int i=0; i<n; i++) {
            if (i > max) {
                return 0;
            }
            max = (max > (i + arr[i]))? max : (i + arr[i]);
        }

        return 1;   
    }
}
