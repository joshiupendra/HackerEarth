package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * Sort those Squares
You are given a sorted array arr. Your task is to sort the squares of each element of the array.

Input:
n - The length of arr
arr - The array itself

Output:
A sorted array of squares.

Conditions:
1 <= arr.length <= 1000
-1000 <= arr[i] <= 1000
arr is sorted in ascending order

Sample Input:
5
-4 -1 0 3 10

Sample Output:
0 1 9 16 100
 */

public class SortThoseSquares {
	// Asked in Uber
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

         int[] out_ = sort_square(n, arr);
         System.out.print(out_[0]);
         for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
	
    static int[] sort_square(int n, int[] arr){
        int[] result = new int[n];
        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();
        
        for (int j=0; j<n; j++) {
        	if (arr[j] < 0) {
        		negative.add(arr[j]);
        	} else {
        		positive.add(arr[j]);
        	}
        }
        
        int nCount = negative.size() - 1;
        int pCount = 0;
        
        for (int i=0; i<n; i++) {
        	if (nCount >= 0 && pCount < positive.size()) {
        		if (Math.abs(negative.get(nCount)) < Math.abs(positive.get(pCount))) {
        			result[i] = negative.get(nCount) * negative.get(nCount);
        			nCount--;
        		} else {
        			result[i] = positive.get(pCount) * positive.get(pCount);
        			pCount++;
        		}	
        	} else if (nCount < 0) {
        		result[i] = positive.get(pCount) * positive.get(pCount);
    			pCount++;
        	} else if (pCount >= positive.size()) {
        		result[i] = negative.get(nCount) * negative.get(nCount);
    			nCount--;
        	}
        }

        return result;   
    }
}
