package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Letter Combinations Of a Phone Number
You are given a string str containing only digits from 2 to 9 (including 2 and 9). 
You are also given the following mapping of digits, such as they are on a telephone. 
Return all possible letter combinations that the number could represent. 
The resultant array must be in ascending order.

Input:
str - A string 

Output:
A string array containing all possible combinations, sorted in ascending order

Constraints:
1 <= str.length <= 10
str consists of only digits from 2 to 9

Sample Input:
68

Sample Output: 
mt
mu
mv
nt
nu
nv
ot
ou
ov
 */

public class LetterCombinationsOfPhoneNumber {
	// Asked in Google Interviews
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String str = br.readLine();

         String[] out_ = all_combos(str, true);
         for (int i_out_ = 0; i_out_ < out_.length; i_out_++)
         {
         	System.out.println(out_[i_out_]);
         }

         wr.close();
         br.close();
    }
	
    static String[] all_combos(String str, boolean recursiveSolution){
        Queue<String> res = new LinkedList<>();
        HashMap<String, String> map = new HashMap<>(){{
        	put("2", "abc");
        	put("3", "def");
        	put("4", "ghi");
        	put("5", "jkl");
        	put("6", "mno");
        	put("7", "pqrs");
        	put("8", "tuv");
        	put("9", "wxyz");
        }};
        
        if (recursiveSolution) {
	        recursiveSolution(str, map, res, 0, "");
	        return res.toArray(new String[0]); 
        } 
        else {        
	        for (int i=0; i<str.length(); i++) {
	        	while ((res.peek() != null ? res.peek().length() : 0) == i) {
	        		String temp = "";
	        		if (res.size() > 0) {
	        			temp = res.element();
	        			res.poll();
	        		}
	        		String letters = map.get(String.valueOf(str.charAt(i)));
	        		for (int j=0; j<letters.length(); j++) {
	        			res.add(temp+letters.charAt(j));
	        		}
	        	}
	        }

        return res.toArray(new String[0]); 
        }
    }
    
    static void recursiveSolution(String str, HashMap<String, String> map, Queue<String> result, int currentChar, String res) {
    	if (res.length() == str.length()) {
    		result.add(res);
    		return;
    	}
    	String currentString = map.get(String.valueOf(str.charAt(currentChar)));
    	for (int i=0; i<currentString.length(); i++) {
    		recursiveSolution(str, map, result, currentChar+1, res+String.valueOf(currentString.charAt(i)));
    	}
    }
}
