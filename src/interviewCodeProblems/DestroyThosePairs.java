package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.stream.Collectors;

/*
 * Destroy Those Pairs!
You are given a string str of lower case letters. If this string has any adjacent pairs of the same characters, that pair must be removed. The new string must again be checked for adjacent pairs. Repeat these steps until no pairs exist.

Input:
str - the string

Output:
A string without adjacent pairs

Constraints:
1 <= str.length <= 10000
str consists of only lower case alphabets

Sample Input:
abcddce

Sample Output:
abe

Explanation:
First, the 2 'd's are deleted from the string "abcddce", to make it "abcce"
Then, the two adjacent 'c's are removed, to make it "abe"
Now, there are no longer any adjacent pairs. Hence, the result is "abe"
 */

public class DestroyThosePairs {
	// Asked in Amazon
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String str = br.readLine();

         String out_ = remove_pair(str);
         System.out.println(out_);

         wr.close();
         br.close();
    }
	
    static String remove_pair(String str){
        Stack<Character> stack = new Stack<>();
        stack.add(str.charAt(0));
        int top = 0;
        
        for (int i=1; i<str.length(); i++) {
        	char c = str.charAt(i);
        	if (top >= 0 && c == stack.peek()) {
        		top -= 1;
        		stack.pop();
        	} else {
        		top += 1;
        		stack.push(c);
        	}
        	
        }

        return stack.stream().map(Object::toString).collect(Collectors.joining(""));   
    }
}
