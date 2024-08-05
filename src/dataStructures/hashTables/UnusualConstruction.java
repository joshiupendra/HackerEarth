package dataStructures.hashTables;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Unusual Construction
There are N cities in a country. 
There are M roads with parameters (L, R, W) denoting cities L and R that are connected and a road that was built between them for W$. 
Note that the roads are bidirectional in nature. 
Now, a new policy is introduced to act that states the following:

Let X be the maximum number of roads between any pair of cities. 
All the pairs of cities that have fewer than X roads between them will be reconstructed and the cost of building the roads will be the same as before.
Determine the amount of money that will be required for implementing the new policy?

Input format
The first line contains an integer T denoting the number of test cases.
The first line of each test case contains two space-separated integers N and M denoting the number of cities and number of roads.
Next M lines contain three space-separated integers representing (L, R, W)

Sample Input
2
5 5
1 2 4
1 2 5
1 3 4
3 4 7
1 2 5
3 3
1 2 4
1 2 5
1 2 4

Sample Output
11
0

Explanation
First test case: 
Maximum number of roads between any pair of towns is 3, which is between 1 and 2. 
So all the pairs of towns which have less than 3 roads will have their roads constructed. 
Towns 1 and 3 have a single road between them so it will be reconstructed and cost will be 4 and similarly 3 and 4 also have a single road between them and it will be reconstructed according to the new policy and cost will be 7.
Total cost: 4+7=11

Second test case:
This time cost is zero as maximum number of roads between any pair of town is 3, which is between 1 and 2. 
There are no roads other than that.
 */

public class UnusualConstruction {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		long T = s.nextInt();
		long[] costs = new long[(int) T];
		s.nextLine();
		
		for (long i=0; i<T; i++) {
			HashMap<String, Long> cityRoadMap = new HashMap<>();
			HashMap<String, Long> roadWMap = new HashMap<>();
			long maxRoads = 1;
			int N = s.nextInt();
			int M = s.nextInt();
			s.nextLine();
			
			for (int j=0 ;j<M; j++) {
				String[] road = s.nextLine().split(" ");
				String city = road[0] + "-" + road[1];
				Long W = Long.parseLong(road[2]);
				
				if (cityRoadMap.containsKey(city)) {
					cityRoadMap.put(city, cityRoadMap.get(city) + 1);
					roadWMap.put(city, roadWMap.get(city) + W);
					maxRoads = (cityRoadMap.get(city) > maxRoads) ? cityRoadMap.get(city) : maxRoads;
				} else {
					cityRoadMap.put(city, (long) 1);
					roadWMap.put(city, W);
				}		
			}
			
			long cost = 0;
			
			for (Map.Entry<String, Long> entry: cityRoadMap.entrySet()) {
				if (entry.getValue() < maxRoads) {
					cost += roadWMap.get(entry.getKey());
				}
			}
		
			costs[(int) i] = cost;	
		}
		
		for (long cost: costs) {
			System.out.println(cost);
		}
	}
}
