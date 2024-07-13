package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * Valid Sudoku
 * 
You are given a 9*9 array arr.
It is split into nine 3*3 boxes, as shown.
Each digit in arr must appear only once in each row, each column and each box.
-1 is considered a 'blank' element. Only consider elements 1 to 9 while validating.

Input:
arr - the 9*9 array

Output:
1 if it is valid, 0 if it not.

Constraints:
arr[i] is a 9*9 array consisting of numbers from 1 to 9, and -1 to denote a 'blank' element.

Smaple Input
1 -1 -1 -1 2 -1 4 -1 9
3 -1 5 -1 -1 7 -1 -1 -1
-1 4 -1 1 -1 -1 5 -1 7
5 6 -1 8 -1 -1 -1 3 -1
-1 2 -1 -1 9 -1 -1 -1 -1
-1 -1 -1 -1 -1 -1 -1 2 -1
8 -1 6 -1 -1 -1 -1 -1 1
-1 -1 -1 9 -1 -1 3 -1 -1
4 -1 -1 -1 2 -1 -1 1 -1

Sample Output
0
 * 
*/
public class ValidSudoku {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int[][] arr = new int[9][9];
         for(int i_arr = 0; i_arr < 9; i_arr++)
         {
         	String[] arr_arr = br.readLine().split(" ");
         	for(int j_arr = 0; j_arr < arr_arr.length; j_arr++)
         	{
         		arr[i_arr][j_arr] = Integer.parseInt(arr_arr[j_arr]);
         	}
         }

         int out_ = is_valid(arr);
         System.out.println(out_);

         wr.close();
         br.close();
    }
	
    static int is_valid(int[][] arr){
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (arr[i][j] != -1) {
                    int value = arr[i][j] - 1;
                    int boxNo = 3 * (i/3) + (j/3);

                    if (row[i][value] == 1 || col[j][value] == 1 || box[boxNo][value] == 1) {
                        return 0;
                    }

                    row[i][value] = 1;
                    col[j][value] = 1;
                    box[boxNo][value] = 1;
                }
            }
        }

        return 1;    
    }
}
