package dataStructures.hashTables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * Count Pairs
You are given an array A consisting of N non-negative integers. 
You are also given 2 integers p (a prime number) and k. 
You are required to count number of pairs (i, j) where, 1 <= i <= j <= N and satisfying:
((arr[i] * arr[i]) + (arr[j] * arr[j]) + (arr[i] * arr[j])) % p == k

Sample Input
2
4 1 2
3 2 1 0
8 0 3
9 2 1 8 4 5 9 10

Sample Output
5
7

 */
public class CountPairs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Long.parseLong(br.readLine());
        while(t-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken()); // Size of array
            long k = Long.parseLong(st.nextToken()); // Value of k
            long p = Long.parseLong(st.nextToken()); // Value of p
            long[] ar = new long[(int)n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i < n;i++)
            {
                ar[i] = Long.parseLong(st.nextToken()) % p;
            }
            HashMap<Long,Long> mp = new HashMap<>();
            for(long num : ar)
            {
                if(mp.containsKey(num))
                {
                    mp.put(num,mp.get(num)+1);
                }
                else
                {
                    mp.put(num,(long)1);
                }
            }
 
            HashMap<Long,Long> mmp = new HashMap<>();
            long ans = 0;
            for(long ele : mp.keySet())
            {
                long num = 0;
 
                if((3*ele%p)*ele%p == k)
                {
                    num = mp.get(ele);
                    ans += num*(num-1)/2 ;
                }
 
                num = (ele * ele  % p)* ele % p - k * ele % p;
                num = (num % p + p) % p;
 
                if(mmp.containsKey(num))
                {
                    ans += mmp.get(num) * mp.get(ele);
                    mmp.put(num,mmp.get(num)+mp.get(ele));
                }
                else
                {
                    mmp.put(num,mp.get(ele));
                }
            }
            System.out.println(ans);
        }
	}

}
