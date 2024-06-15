package dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TramRide {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         int start = Integer.parseInt(br.readLine().trim());
         int finish = Integer.parseInt(br.readLine().trim());
         String[] arr_Ticket_cost = br.readLine().split(" ");
         int[] Ticket_cost = new int[N];
         for(int i_Ticket_cost = 0; i_Ticket_cost < arr_Ticket_cost.length; i_Ticket_cost++)
         {
         	Ticket_cost[i_Ticket_cost] = Integer.parseInt(arr_Ticket_cost[i_Ticket_cost]);
         }

         long out_ = solve(N, start, finish, Ticket_cost);
         System.out.println(out_);

         wr.close();
         br.close();
    }
    static long solve(int N, int start, int finish, int[] Ticket_cost){
        long result = 0;

        long clockPath = 0, antiClockPath = 0;
        start -= 1;
        finish -= 1;
        
        // For Clock wise Path
        int k = start;
        while (k != finish) {
        	clockPath += Ticket_cost[k];
        	k++;
        }
        
        // For Anti Clock wise Path 
		k = finish;
		while (k != start) {
			antiClockPath += Ticket_cost[k];
			k++;
			if (k == N) {
				k = 0;
			}
		}
        
        result = (clockPath < antiClockPath)? clockPath : antiClockPath;
        
        return result;
    
    }
}
