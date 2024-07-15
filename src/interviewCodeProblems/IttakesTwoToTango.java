package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

/*
 * It takes Two to Tango
You're given an array arr, along with an integer named target. Calculate the number of pairs in arr that can be added together to form target.

Input:
n - the size of the array
arr - the array itself
target - an integer

Output:
The number of pairs in arr that add up to target

Constraints:
1 <= arr.length <= 100
1 <= arr[i] <= 100
1 <= target <= 10000

Sample Input:
6
1 2 3 2 9 10
4

Sample Output:
2
 */

public class IttakesTwoToTango {
	//(Asked in Google, Microsoft, Apple, FB, Amazon, Oracle
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
         int target = Integer.parseInt(br.readLine().trim());

         int out_ = two_sum(n, arr, target);
         System.out.println(out_);

         wr.close();
         br.close();
    }

    static int two_sum(int n, int[] arr, int target){
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<arr.length; i++) {
        	if (arr[i] < target) {
                if (map.containsKey(arr[i])) {
                    result += map.get(arr[i]);
                }
                
                if (map.containsKey(target-arr[i])) {
                    map.put(target-arr[i], map.get(target-arr[i]) + 1);
                } else {
                    map.put(target-arr[i], 1);
                }
            }
        }

        return result;  
    }
}
