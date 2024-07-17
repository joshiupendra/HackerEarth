package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/*
 * Good Pairing
You are given an array arr in which a good pair is defined as a pair of numbers in the array which satisfy the following conditions:
arr[i] = arr[j] (The two numbers must be equal)
i<j
Find the number of good pairs in the array.

Input:
n - The number of elements in arr
arr - The array itself.

Output:
The number of good pairs.

Conditions:
1 <= arr.length <= 100
1 <= arr[i] <= 100

Sample Input
6
1 2 3 1 1 3

Sample Output
4
 */

public class GoodPairing {
	// Asked in Microsoft, Amazon
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

         int out_ = good_pairs(n, arr);
         System.out.println(out_);

         wr.close();
         br.close();
    }
	
    static int good_pairs(int n, int[] arr){
       // Write your code here
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<n; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > 1) {
                result += entry.getValue() * (entry.getValue()-1) /2;
            }
        }

        return result;
    
    }

}
