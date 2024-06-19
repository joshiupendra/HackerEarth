package dataStructures.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArrayQueries {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int M = Integer.parseInt(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
            	A[i_A] = Integer.parseInt(arr_A[i_A]);
            }
            String[] arr_B = br.readLine().split(" ");
            int[] B = new int[M];
            for(int i_B = 0; i_B < arr_B.length; i_B++)
            {
            	B[i_B] = Integer.parseInt(arr_B[i_B]);
            }
            int Q = Integer.parseInt(br.readLine().trim());
            int[][] queries = new int[Q][3];
            for(int i_queries = 0; i_queries < Q; i_queries++)
            {
            	String[] arr_queries = br.readLine().split(" ");
            	for(int j_queries = 0; j_queries < arr_queries.length; j_queries++)
            	{
            		queries[i_queries][j_queries] = Integer.parseInt(arr_queries[j_queries]);
            	}
            }

            int[] out_ = array_queries(N, M, A, B, Q, queries);
            System.out.print(out_[0]);
            for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
            {
            	System.out.print(" " + out_[i_out_]);
            }
            
            System.out.println();
            
         }

         wr.close();
         br.close();
    }
    static int[] array_queries(int N, int M, int[] A, int[] B, int Q, int[][] queries){
        int[] result = new int[Q+1];

        result[0] = calculateF(N, M, A, B);
        
        int k = 0, temp;
        while (Q > 0) {
        	int q = queries[k][0];
            int i = queries[k][1] - 1;
        	int j = queries[k][2] - 1;
        	if (q == 1) {
        		temp = A[i];
        		A[i] = B[j];
        		B[j] = temp;
        	} else if (q == 2) {
        		temp = A[i];
        		A[i] = A[j];
        		A[j] = temp;
        	} else if (q == 3) {
        		temp = B[i];
        		B[i] = B[j];
        		B[j] = temp;
        	}
        	
        	result[k+1] = calculateF(N, M, A, B);
        	k++;
        	Q--;
        }
        
        return result;
    }
    
    static int calculateF(int N, int M, int[] A, int[] B) {
    	int result = 0, k = N-1;
    	
    	for (int i=0; i<(N/2)+1; i++) {
    		if (k < i) {
    			break;
    		}
    		if (k == i) {
    			for (int j=0; j<M; j++) {
        			result += (A[i] * B[j] * ((i+1) + (j+1)));
        		}
    			break;
    		}
    		for (int j=0; j<M; j++) {
    			result += (A[i] * B[j] * ((i+1) + (j+1))) + (A[k] * B[j] * ((k+1) + (j+1)));
    		}
    		k--;
    	}
    	
    	return result;
    }
}
