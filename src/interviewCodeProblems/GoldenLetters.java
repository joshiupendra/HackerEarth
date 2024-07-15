package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

/*
 * Golden Letters
You are given a string key that contains a list of golden letters. You are also given another string str. Find out how many characters in str are golden letters.

Input:
key - a string of golden letters
str - the string to be checked

Output:
The number of golden letters in str

Constraints:
1 <= key.length <= 52
1 <= str.length <= 10000
key and str are made up of only upper-case and lower-case alphabets

Sample Input:
wxYZ
lmnoWwwxyZ

Sample Output:
4
 */

public class GoldenLetters {
	//Asked in Apple
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String key = br.readLine();
         String str = br.readLine();

         int out_ = golden_char(key, str);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static int golden_char(String key, String str){
        int count = 0;
        HashSet<Character> set = new HashSet<>();
 
        // First Loop to add all chars of key into Set
        for (int i=0; i<key.length(); i++) {
        	set.add(key.charAt(i));
        }

        // Second loop to check if chars in Str present in Set, if yes then increment counter
        for (int i=0; i<str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                count++;
            }
        }

        return count;
    }
}
