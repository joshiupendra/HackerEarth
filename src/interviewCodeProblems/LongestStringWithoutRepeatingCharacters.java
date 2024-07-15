package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

/*
 * Longest String Without Repeating Characters
You are given a string str. Find the length of the longest possible substring in str without ANY repeating characters.

Input:
str - A string

Output:
The length of the longest possible substring in str without repeating characters

Constraits:
1 <= str.length <= 10000

Sample Input:
abcbcde

Sample Output:
4
 */
public class LongestStringWithoutRepeatingCharacters {
	//Asked in Google, Oracle, MS, Amazon
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String str = br.readLine();

         int out_ = no_dups(str);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static int no_dups(String str){
       // Write your code here
       // Use str.length() to calculate the length of str 
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int len = 0;

        for (int i=0; i<str.length(); i++) {
            if (map.containsKey(str.charAt(i)) && map.get(str.charAt(i)) >= start) {
                start = map.get(str.charAt(i)) + 1;
            }
            end = i;
            map.put(str.charAt(i), i);
            len = end - start;
            max = (max > len)? max : len;
        }

        return max+1;    
    }
}
