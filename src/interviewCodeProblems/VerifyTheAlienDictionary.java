package interviewCodeProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

/*
 * Verify the Alien Dictionary
You are given a string key that contains the 26 English alphabets, jumbled in some order.
You are also given n words stored in an array str.
Check if the words in str are sorted lexicographically according to string key.

Input:
key - A string that denotes the correct order
n - The number of words in str
str - An array of words that must follow the key string lexicograhically

Output:
1 if all the words in str are lexicographically sorted according to key, 0 if they are not

Constraints:
key.length = 26
2 <= n <= 100
1 <= str[i].length <= 100 (Length of each word)
key and str consist of only uppercase alphabets
key has all 26 uppercase alphabets, jumbled in some order

Sample Input:
HECABDFGIJKLMNOPQRSTUVWXYZ
3
HACKER
EARTHS
CODEXPLAINED

Sample Output:
1
 */

public class VerifyTheAlienDictionary {
	//Asked in FB, Amazon and Walmart Labs
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String key = br.readLine();
         int n = Integer.parseInt(br.readLine().trim());
         String[] str = new String[n];
         for(int i_str = 0; i_str < n; i_str++)
         {
         	str[i_str] = br.readLine();
         }

         int out_ = is_lexicographic(key, n, str);
         System.out.println(out_);

         wr.close();
         br.close();
    }
	
    static int is_lexicographic(String key, int n, String[] str){
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<key.length(); i++) {
        	map.put(key.charAt(i), i);
        }
        
        for (int i=0; i<n-1; i++) {
        	int j = 0;
        	while (j != str[i].length() && j != str[i+1].length() && str[i].charAt(j) == str[i+1].charAt(j)) {
        		j++;
        	}
        	if (j == str[i].length()) {
    			continue;
    		}
    		if (j == str[i+1].length() && j < str[i].length()) {
    			return 0;
    		}
    		if (map.get(str[i].charAt(j)) > map.get(str[i+1].charAt(j))) {
    			return 0;
    		}
        }

        return 1;
    
    }
}
