package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class RotateMatrix {
	// Asked in Google, Amazon, Facebook Interviews
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         int[][] arr = new int[n][n];
         for(int i_arr = 0; i_arr < n; i_arr++)
         {
         	String[] arr_arr = br.readLine().split(" ");
         	for(int j_arr = 0; j_arr < arr_arr.length; j_arr++)
         	{
         		arr[i_arr][j_arr] = Integer.parseInt(arr_arr[j_arr]);
         	}
         }

         int[][] out_ = rotate_matrix(n, arr);
         for(int i_out_ = 0; i_out_ < out_.length; i_out_++)
         {
         	System.out.print(out_[i_out_][0]);
         	for(int j_out_ = 1; j_out_ < out_[i_out_].length; j_out_++)
         	{
         		System.out.print(" " + out_[i_out_][j_out_]);
         	}
         	System.out.println("");
         }

         wr.close();
         br.close();
	}

	static int[][] rotate_matrix(int n, int[][] arr){
        for (int i=0; i<n/2; i++) {
            for (int j=i; j<n-i-1; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n-1-j][i];
                arr[n-1-j][i] = arr[n-1-i][n-1-j];
                arr[n-1-i][n-1-j] = arr[j][n-1-i];
                arr[j][n-1-i] = temp;
            }
        }

        return arr;
    }
}

/* 
Sample Input
3
1 2 3
4 5 6
7 8 9

Sample Output
7 4 1
8 5 2
9 6 3

*/