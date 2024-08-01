package dataStructures.hashTables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

/*
 * Valid Pairs
A famous Italian restaurant allows guests to enter only if they are present in pairs and the sum of the wealth of the people of the pair is a power of 3.
A group of people wants to eat at the restaurant. 
Mathematically, if there are two people of wealth a and b, it forms a valid pair if 
for some positive integer k. They want to know how many possible pairs would be allowed entry.   

Task
Given the individual wealth of the people, find the number of valid pairs.

Notes
One person can be in multiple valid pairs.
A pair of person X and Y is the same as a pair of person Y and X.

Sample Input
4
1 5 2 4

Sample Output
2

Approach
The pair of first and third person has a sum of wealth of 3 which is a power of 3.
The pair of second and fourth person has a sum of wealth of 9 which is a power of 3.
 */
public class ValidPairs {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         String[] arr_wealth = br.readLine().split(" ");
         long[] wealth = new long[N];
         for(int i_wealth = 0; i_wealth < arr_wealth.length; i_wealth++)
         {
         	wealth[i_wealth] = Long.parseLong(arr_wealth[i_wealth]);
         }

         int out_ = solve(N, wealth);
         System.out.println(out_);

         wr.close();
         br.close();
    }
	
    static int solve(int N, long[] wealth){
    	long[] power3 = new long[20];
        power3[0] = 3;
        
        for(int n=1; n<20; n++) {
        	power3[n] = power3[n-1]*3;
        }
 
        int result = 0;
        Arrays.sort(wealth);
        
        for(int i=0; i < N; i++) {
            if(N<=500) {
                for(int j=i+1; j < N; j++) {
                    if(Arrays.binarySearch(power3, wealth[i] + wealth[j]) >= 0) {
                        result++;
                    }
                }
            } else {
                for(int j=0; j < 20; j++) {
                    if(power3[j]-wealth[i] > 0 && 
                        Arrays.binarySearch(wealth, power3[j]-wealth[i]) >= i) {
                        result++; 
                    }
                }
            }
        }
        return result; 
    }
}
