package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

/*
 * Max Points on a Line
You are given an array arr in which each element corresponds to a 2D coordinate, ie, arr[i] = [xi, yi]. 
What is the maximum number of points that lie on the same line?

Input:
n - the size of arr
arr - the array itself

Output:
The maximum number of points in arr that lie on the same line

Conditions:
1 <= n <= 100
-1000 <= arr[i][0] <= 1000 (X coordinate)
-1000 <= arr[i][1] <= 1000 (Y coordinate)

Sample Input
5
0 0
1 1
2 2
7 5
0 4

Sample Output
3
 */

public class MaxPoints {
	// Asked in Apple, Amazon, Microsoft, Google, LinkedIn Interviews
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         int[][] arr = new int[n][2];
         for(int i_arr = 0; i_arr < n; i_arr++)
         {
         	String[] arr_arr = br.readLine().split(" ");
         	for(int j_arr = 0; j_arr < arr_arr.length; j_arr++)
         	{
         		arr[i_arr][j_arr] = Integer.parseInt(arr_arr[j_arr]);
         	}
         }

         int out_ = max_points(n, arr);
         System.out.println(out_);

         wr.close();
         br.close();
    }
	
    static int max_points(int n, int[][] arr){
       // Write your code here
        int result = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        int max = 0;

        for (int i=0; i<(n-max-1); i++) {
            int i_max = 0;
            double slope = 0;
            for (int j=i+1; j<n; j++) {
                if (arr[i][0] - arr[j][0] == 0) {
                    slope = 100001;
                } else {
                    slope = (double) (arr[j][1] - arr[i][1]) / (double) (arr[j][0] - arr[i][0]);
                }

                if (map.containsKey(slope)) {
                    map.put(slope, map.get(slope)+1);
                } else {
                    map.put(slope, 1);
                }
                i_max = (i_max > map.get(slope)) ? i_max : map.get(slope);
            }
            map.clear();
            max = (max > i_max) ? max : i_max;
        }
        return max+1;   
    }
}
