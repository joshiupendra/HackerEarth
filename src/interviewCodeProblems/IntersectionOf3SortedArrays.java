package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * Intersection of 3 Sorted Arrays
You are given three sorted arrays arr1, arr2 and arr3. 
Your task is to return a sorted array of elements that are common to all three arrays.

Input:
n1, n2, n3 - The lengths of arr1, arr2 and arr3 respectively
arr1, arr2, arr3 - Three sorted arrays

Output:
A sorted array of numbers common to arr1, arr2 and arr3.

Constraints:
1 <=  arr1.length, arr2.length, arr3.length <= 1000
1<= arr1[i], arr2[i], arr3[i] <= 2000
There will be at least one element common in all three arrays. 

Sample Input:
5
5
5
1 2 3 4 5
1 3 4 5 8
1 2 5 7 9

Sample Output:
1 5
 */

public class IntersectionOf3SortedArrays {
	// Asked in Facebook
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n1 = Integer.parseInt(br.readLine().trim());
         int n2 = Integer.parseInt(br.readLine().trim());
         int n3 = Integer.parseInt(br.readLine().trim());
         String[] arr_arr1 = br.readLine().split(" ");
         int[] arr1 = new int[n1];
         for(int i_arr1 = 0; i_arr1 < arr_arr1.length; i_arr1++)
         {
         	arr1[i_arr1] = Integer.parseInt(arr_arr1[i_arr1]);
         }
         String[] arr_arr2 = br.readLine().split(" ");
         int[] arr2 = new int[n2];
         for(int i_arr2 = 0; i_arr2 < arr_arr2.length; i_arr2++)
         {
         	arr2[i_arr2] = Integer.parseInt(arr_arr2[i_arr2]);
         }
         String[] arr_arr3 = br.readLine().split(" ");
         int[] arr3 = new int[n3];
         for(int i_arr3 = 0; i_arr3 < arr_arr3.length; i_arr3++)
         {
         	arr3[i_arr3] = Integer.parseInt(arr_arr3[i_arr3]);
         }

         int[] out_ = array_intersection(n1, n2, n3, arr1, arr2, arr3);
         System.out.print(out_[0]);
         for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
	
    static int[] array_intersection(int n1, int n2, int n3, int[] arr1, int[] arr2, int[] arr3){
        ArrayList<Integer> res = new ArrayList<>();
        
        int xLoc = 0, yLoc = 0, zLoc = 0;
        
        while (xLoc < n1 && yLoc < n2 && zLoc < n3) {
        	int x = arr1[xLoc];
        	int y = arr2[yLoc];
        	int z = arr3[zLoc];
        	
        	if (x == y && y == z) {
        		res.add(x);
        		xLoc++;
        		yLoc++;
        		zLoc++;
        	} else if (x <= y && x <= z) {
        		xLoc++;
        	} else if (y <= x && y <= z) {
        		yLoc++;
        	} else {
        		zLoc++;
        	}
        }
        
        int[] result = res.stream().mapToInt(i -> i).toArray();

        return result;
    
    }
}
