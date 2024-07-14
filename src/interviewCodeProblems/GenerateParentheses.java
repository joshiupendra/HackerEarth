package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * Generate Parentheses
You are given an integer n. Generate all possible balanced parentheses containing n opening and closing parentheses and return a sorted array.
A string of parentheses is considered well balanced if there are never more closing than opening parentheses at any point in the string.

Input:
n - an integer

Output:
A sorted array of all possible parentheses containing n opening and closing parentheses.

Constraints:
1 <= n <= 10

Sample Input:
3

Sample Output:
((()))
(()())
(())()
()(())
()()()
 */

public class GenerateParentheses {
	// Asked in Google, Apple, FB, Oracle, MS, Bloomberg Interviews
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());

         String[] out_ = gen_para(n);
         for (int i_out_ = 0; i_out_ < out_.length; i_out_++)
         {
         	System.out.println(out_[i_out_]);
         }

         wr.close();
         br.close();
    }
    static String[] gen_para(int n){
       // Write your code here
        String[] result = {""};
        ArrayList<String> list = new ArrayList<>();
        getResult(list, n, 0, 0, "");
        result = list.toArray(new String[0]);
        return result;
    
    }

    static void getResult(ArrayList<String> res, int n, int open, int close, String str) {
        if (open == close && close == n) {
            res.add(str);
            return;
        }

        if (open < n) {
            getResult(res, n, open+1, close, str+"(");
        }
        if (close < open) {
            getResult(res, n, open, close+1, str+")");
        }
    }

}
